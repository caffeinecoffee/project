package com.pmjsmj.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmjsmj.DAO.SangDAO;
import com.pmjsmj.DTO.Interested_ItemDTO;
import com.pmjsmj.DTO.ItemDTO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.PageDTO;
import com.pmjsmj.DTO.ReviewDTO;
import com.pmjsmj.DTO.item_inquiryDTO;
import com.pmjsmj.Service.SangService;

@Service
public class SangServiceImpl implements SangService {

	@Autowired
	SangDAO sangDAO;

	@Override
	public HashMap<String, Object> getItems(PageDTO pdto, String orderOption, String category_no, String search) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		// 페이징 처리
		// 한 페이지에 출력 할 article 개수
		pdto.setLinePerPage(16);
		if (pdto.getPresentPage() == 0) {
			pdto.setPresentPage(1);
		}
		int presentPage = pdto.getPresentPage();

		// 전체 레코드 수
		int allCount = sangDAO.getItemCount(category_no, search);
		pdto.setAllCount(allCount);

		// 전체 페이지 개수
		int allPage = allCount / pdto.getLinePerPage() + 1;
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
		int linePerPageNumber = 7;
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
		List<ItemDTO> list = sangDAO.getItems(start, end, orderOption, category_no, search);
		// 페이징 처리 끝
		hash.put("pdto", pdto);
		hash.put("list", list);
		return hash;
	}

	@Override
	public ItemDTO getItem(String item_no) {
		// TODO Auto-generated method stub
		return sangDAO.getItem(item_no);
	}

	@Override
	public HashMap<String, Object> getReviews(PageDTO pdto, String item_no) {
		// TODO Auto-generated method stub
		// 한 페이지에 출력 할 article 개수
		pdto.setLinePerPage(20);
		if (pdto.getPresentPage() == 0) {
			pdto.setPresentPage(1);
		}
		int presentPage = pdto.getPresentPage();

		// 전체 레코드 수
		int allCount = sangDAO.getReviewCount();
		pdto.setAllCount(allCount);

		// 전체 페이지 개수
		int allPage = allCount / pdto.getLinePerPage() + 1;
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
		int linePerPageNumber = 7;
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

		String start = ((presentPage - 1) * pdto.getLinePerPage() + 1) + "";
		String end = (presentPage * pdto.getLinePerPage()) + "";
		List<ReviewDTO> list = sangDAO.getReviews(start, end, item_no);

		for (int i = 0; i < list.size(); i++) {
			ReviewDTO rdto = list.get(i);
			if (rdto.getReview_content().length() >= 40) {
				rdto.setReview_content(rdto.getReview_content().substring(0, 40));
			}
			// 아이디 **처리
			rdto.setMem_id(rdto.getMem_id().substring(0, 2) + "**"
					+ rdto.getMem_id().substring(4, rdto.getMem_id().length()));
		}

		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("list", list);
		hash.put("pdto", pdto);
		return hash;
	}

	@Override
	public List<ReviewDTO> getReviews(String start, String end, String item_no) {
		// TODO Auto-generated method stub
		List<ReviewDTO> list = sangDAO.getReviews(start, end, item_no);
		for (int i = 0; i < list.size(); i++) {
			ReviewDTO rdto = list.get(i);
			if (rdto.getReview_content().length() >= 40) {
				rdto.setReview_content(rdto.getReview_content().substring(0, 40));
			}
			// 아이디 **처리
			rdto.setMem_id(rdto.getMem_id().substring(0, 2) + "**"
					+ rdto.getMem_id().substring(4, rdto.getMem_id().length()));
		}
		return list;
	}

	@Override
	public HashMap<String, Object> getItemInquirys(PageDTO pdto, String item_no) {
		// TODO Auto-generated method stub
		// 한 페이지에 출력 할 article 개수
		pdto.setLinePerPage(20);
		if (pdto.getPresentPage() == 0) {
			pdto.setPresentPage(1);
		}
		int presentPage = pdto.getPresentPage();

		// 전체 레코드 수
		int allCount = sangDAO.getItemInquiryCount();
		pdto.setAllCount(allCount);

		// 전체 페이지 개수
		int allPage = allCount / pdto.getLinePerPage() + 1;
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
		int linePerPageNumber = 7;
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

		String start = ((presentPage - 1) * pdto.getLinePerPage() + 1) + "";
		String end = (presentPage * pdto.getLinePerPage()) + "";
		List<item_inquiryDTO> list = sangDAO.getItemInquirys(start, end, item_no);

		for (int i = 0; i < list.size(); i++) {
			item_inquiryDTO indto = list.get(i);
			// 아이디 **처리
			indto.setMem_id(indto.getMem_id().substring(0, 2) + "**"
					+ indto.getMem_id().substring(4, indto.getMem_id().length()));
		}

		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("list", list);
		hash.put("pdto", pdto);
		return hash;
	}

	@Override
	public List<item_inquiryDTO> getItemInquirys(String start, String end, String item_no) {
		// TODO Auto-generated method stub
		List<item_inquiryDTO> list = sangDAO.getItemInquirys(start, end, item_no);
		for (int i = 0; i < list.size(); i++) {
			item_inquiryDTO indto = list.get(i);
			// 아이디 **처리
			indto.setMem_id(indto.getMem_id().substring(0, 2) + "**"
					+ indto.getMem_id().substring(4, indto.getMem_id().length()));
		}
		return list;
	}

	@Override
	public List<ItemDTO> getLikingItems(String item_no) {
		// TODO Auto-generated method stub
		return sangDAO.getLikingItems(item_no);
	}

	@Override
	public void SignUpProc(MemberDTO mdto) {
		// TODO Auto-generated method stub
		sangDAO.SignUpProc(mdto);
	}

	@Override
	public int IDDuplicatecheck(String mem_id) {
		// TODO Auto-generated method stub
		return sangDAO.IDDuplicatecheck(mem_id);
	}

	@Override
	public void reviewWriteProc(ReviewDTO rdto) {
		sangDAO.reviewWriteProc(rdto);
		
	}

	@Override
	public List<ItemDTO> popularItem() {
		// TODO Auto-generated method stub
		return sangDAO.popularItem();
	}

	@Override
	public List<ItemDTO> weekPopularItem() {
		// TODO Auto-generated method stub
		return sangDAO.weekPopularItem();
	}

	@Override
	public void itemInquiryWriteProc(item_inquiryDTO indto) {
		// TODO Auto-generated method stub
		sangDAO.itemInquiryWriteProc(indto);
	}

	@Override
	public item_inquiryDTO itemInquiryDescribe(item_inquiryDTO indto) {
		// TODO Auto-generated method stub
		return sangDAO.itemInquiryDescribe(indto);
	}

	@Override
	public ReviewDTO ReviewDescribe(ReviewDTO rdto) {
		// TODO Auto-generated method stub
		return sangDAO.ReviewDescribe(rdto);
	}

	@Override
	public void itemInquiryUpdateProc(item_inquiryDTO indto) {
		// TODO Auto-generated method stub
		sangDAO.itemInquiryUpdateProc(indto);
	}

	@Override
	public void revieUpdateProc(ReviewDTO rdto) {
		// TODO Auto-generated method stub
		sangDAO.revieUpdateProc(rdto);
	}

	@Override
	public List<ItemDTO> MDItem() {
		// TODO Auto-generated method stub
		return sangDAO.MDItem();
	}

	@Override
	public int writeQualify(String item_no, String mem_id) {
		// TODO Auto-generated method stub
		return sangDAO.writeQualify(item_no, mem_id);
	}

	@Override
	public boolean getInterestedItem(Interested_ItemDTO interDTO) {
		// TODO Auto-generated method stub
		return sangDAO.getInterestedItem(interDTO);
	}
	
	@Override
	public void addInterestedItem(Interested_ItemDTO interDTO) {
		// TODO Auto-generated method stub
		sangDAO.addInterestedItem(interDTO);
	}
}
