package com.example.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.ItemDAO;
import com.example.DAO.OrderDAO;
import com.example.DTO.ItemDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.MyPageOrderDTO;
import com.example.DTO.OrderItemDTO;
import com.example.DTO.OrderListDTO;
import com.example.DTO.PageDTO;
import com.example.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public HashMap<String, Object> getOrderList(HttpServletRequest request, PageDTO pdto) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		pdto.setLinePerPage(5);
		pdto.setPageBlockPerNumber(5);
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		if (mdto != null) {
			if (pdto.getPresentPage() == 0) {
				pdto.setPresentPage(1);
			}
			int presentPage = pdto.getPresentPage();

			// 전체 레코드 수
			int allCount = orderDAO.getAllCount(mdto);
			pdto.setAllCount(allCount);
			int allPage;
			// 전체 페이지 개수
			if ((allCount % pdto.getLinePerPage()) > 0) {
				allPage = allCount / pdto.getLinePerPage() + 1;
			} else {
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

			System.out.println(pdto.toString());
			hash.put("start", start);
			hash.put("end", end);
			hash.put("mdto", mdto);
			List<MyPageOrderDTO> mpoList = orderDAO.getList(hash);
			int deliveringCnt = orderDAO.deliveringCnt(mdto);
			if(mpoList.isEmpty()) {
				hash.put("mpoList", null);
			}else {
				hash.put("mpoList", mpoList);
			}
			hash.put("deliveringCnt", deliveringCnt);
			hash.put("pdto", pdto);
		}
		return hash;
	}

	@Override
	public MyPageOrderDTO getOrderItem(MyPageOrderDTO mpoDTO, HttpServletRequest request) {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("mdto");
		mpoDTO.setMem_id(mdto.getMem_id());
		MyPageOrderDTO result = orderDAO.getItem(mpoDTO);
		if (result == null) {
			return null;
		}
		return result;
	}

}
