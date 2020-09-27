package com.example.ServiceImpl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.MyPageReviewDAO;
import com.example.DTO.MemberDTO;
import com.example.DTO.MyPageReviewDTO;
import com.example.DTO.PageDTO;
import com.example.Service.MyPageReviewService;

@Service
public class MyPageReviewServiceImpl implements MyPageReviewService{
	@Autowired
	private MyPageReviewDAO myPageReviewDAO;
	@Override
	public HashMap<String, Object> getReviews(HttpServletRequest request, PageDTO pdto) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		MemberDTO mdto =  (MemberDTO)request.getSession().getAttribute("mdto");
		
		if (pdto.getPresentPage() == 0) {
			pdto.setPresentPage(1);
		}
		int presentPage=pdto.getPresentPage();
		// 전체 레코드 수
		int allCount = myPageReviewDAO.getAllCount(mdto);
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
		
		System.out.println("mdto확인하기 : "+mdto.toString());
		HashMap<String, Object> hashParam = new HashMap<String, Object>();
		hashParam.put("start",start);
		hashParam.put("end", end);
		hashParam.put("mdto",mdto);
		
		List<MyPageReviewDTO> mprList =myPageReviewDAO.getReviewList(hashParam);
		
		hash.put("mprList", mprList);
		hash.put("pdto", pdto);
		return hash;
	}

}
