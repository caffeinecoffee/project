package com.pmjsmj.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmjsmj.DAO.Interested_ItemDAO;
import com.pmjsmj.DAO.ItemDAO;
import com.pmjsmj.DTO.Interested_ItemDTO;
import com.pmjsmj.DTO.ItemDTO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.PageDTO;
import com.pmjsmj.Service.Interested_ItemService;

@Service
public class Interested_ItemServiceImpl implements Interested_ItemService {
	@Autowired
	private Interested_ItemDAO interestedDAO;

	@Autowired
	private ItemDAO itemDAO;

	@Override
	public HashMap<String, Object> getItems(HttpServletRequest request, PageDTO pdto) {
		pdto.setLinePerPage(5);
		pdto.setPageBlockPerNumber(5);
		List<ItemDTO> itemList = null;
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		HashMap<String, Object> resultHash = new HashMap<String, Object>();
		if (mdto != null) {
			if (pdto.getPresentPage() == 0) {
				pdto.setPresentPage(1);
			}
			int presentPage=pdto.getPresentPage();
			
			// 전체 레코드 수
			int allCount = interestedDAO.getAllCount(mdto);
			if(allCount == 0) {
				return null;
			}
			pdto.setAllCount(allCount);
			int allPage;
			// 전체 페이지 개수
			if((allCount % pdto.getLinePerPage()) >0) {
				allPage = allCount / pdto.getLinePerPage() + 1;
			}else {
				allPage = allCount / pdto.getLinePerPage();
			}
			pdto.setAllPage(allPage);

			int crb = 1;
			if (presentPage == 1) {
				pdto.setPresentPageBlock(crb);
			} else {
				crb = presentPage % pdto.getPageBlockPerNumber() == 0 ? presentPage / pdto.getPageBlockPerNumber()
						: presentPage / pdto.getPageBlockPerNumber() + 1;
				pdto.setPresentPageBlock(crb);
			}
			// 페이지 블럭 하나에 포함 될 페이지 수
			int linePerPageNumber = 5;
			if (presentPage - linePerPageNumber / 2 <= 1) {
				pdto.setStartPage(1);
				if (linePerPageNumber >= allPage)
					pdto.setEndPage(allPage);
				else
					pdto.setEndPage(linePerPageNumber);
			} else if (presentPage + linePerPageNumber / 2 >= allPage) {
				pdto.setEndPage(allPage);
				if (allPage - linePerPageNumber + 1 <= 0)
					pdto.setStartPage(1);
				else
					pdto.setStartPage(allPage - linePerPageNumber + 1);
			} else {
				pdto.setStartPage(presentPage - linePerPageNumber / 2);
				pdto.setEndPage(presentPage + linePerPageNumber / 2);
			}
			
			int start = (presentPage - 1) * pdto.getLinePerPage() + 1;
			int end = presentPage * pdto.getLinePerPage();
			
			HashMap<String, Object> hash = new HashMap<String, Object>();
			hash.put("start",start);
			hash.put("end", end);
			
			hash.put("mdto", mdto);
			List<Interested_ItemDTO> interestedList = interestedDAO.getItems(hash);
			System.out.println("intinterestedList size check : "+interestedList.size());
			itemList = itemDAO.getItems(interestedList);
			resultHash.put("iList", itemList);
			resultHash.put("pdto", pdto);
		}
		
		return resultHash;
	}

	@Override
	public void deleteInterItem(Interested_ItemDTO interDTO, HttpServletRequest request) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		interDTO.setMem_id(mdto.getMem_id());
		interestedDAO.deleteInterItem(interDTO);
	}

	@Override
	public void selectDeleteInterItem(int[] selectDelete, HttpServletRequest request) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		List<Interested_ItemDTO> list = new ArrayList<Interested_ItemDTO>();

		for (int i = 0; i < selectDelete.length; i++) {
			Interested_ItemDTO idto = new Interested_ItemDTO();
			idto.setMem_id(mdto.getMem_id());
			idto.setItem_no(selectDelete[i]);
			list.add(i, idto);
		}
		int r = interestedDAO.selectDeleteInterItem(list);
	}

}
