package com.example.demo.memmgt.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.memmgt.dao.MemberDAO;
import com.example.demo.memmgt.dto.MemberVO;
import com.example.demo.memmgt.dto.PageVO;
import com.example.demo.memmgt.service.SignService;

@Service("signService")
public class SignServiceImpl implements SignService {

	private static final Logger logger = LoggerFactory.getLogger(SignServiceImpl.class);

	@Resource
	MemberDAO memmgtDAO;
	
	@Override
	public int DataSave(MemberVO mvo) {
		// TODO Auto-generated method stub
//		int memSeq = memmgtDAO.MemSeq();
//		mvo.setMemSeq(memSeq);
		return memmgtDAO.SaveData(mvo);
	}

	@Override
	public List<MemberVO> getMembers(PageVO pvo) {
		// TODO Auto-generated method stub
		int currentPage;
		if (pvo.getCurrentPage() == 0) {
			currentPage = 1;
		} else {
			currentPage = pvo.getCurrentPage();
		}
		pvo.setCurrentPage(currentPage);

		// ��ü ������ ����
		int allPage = pvo.getAllCount() / pvo.getLinePerPage() + 1;
		pvo.setAllPage(allPage);

		//
		int crb = 1;
		if (currentPage == 1) {
			pvo.setCurrentPageBlock(crb);
		} else {
			crb = currentPage % pvo.getPageBlock() == 0 ? currentPage / pvo.getPageBlock()
					: currentPage / pvo.getPageBlock() + 1;
			pvo.setCurrentPageBlock(crb);
		}

		int linePerPageNumber = 9;
		if (currentPage - linePerPageNumber / 2 <= 1) {
			pvo.setStartPage(1);
			if (linePerPageNumber >= allPage)
				pvo.setEndPage(allPage);
			else
				pvo.setEndPage(linePerPageNumber);
		} else if (currentPage + linePerPageNumber / 2 >= allPage) {
			pvo.setEndPage(allPage);
			if (allPage - linePerPageNumber + 1 <= 0)
				pvo.setStartPage(1);
			else
				pvo.setStartPage(allPage - linePerPageNumber + 1);
		} else {
			pvo.setStartPage(currentPage - linePerPageNumber / 2);
			pvo.setEndPage(currentPage + linePerPageNumber / 2);
		}
		int start = (currentPage - 1) * pvo.getLinePerPage() + 1;
		int end = currentPage * pvo.getLinePerPage();
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("start", start);
		hmap.put("end", end);
		List<MemberVO> list = memmgtDAO.getMembers(hmap);
		return list;
	}

	@Override
	public MemberVO getMember(MemberVO mvo) {
		// TODO Auto-generated method stub
		return memmgtDAO.getMember(mvo);
	}

	@Override
	public MemberVO modifyMember(MemberVO mvo) {
		// TODO Auto-generated method stub
		memmgtDAO.modifyMember(mvo);
		return memmgtDAO.getMember(mvo);
	}

	@Override
	public void memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		memmgtDAO.deleteMember(mvo);
	}

	@Override
	public int idcheck(String id) {
		// TODO Auto-generated method stub
		return memmgtDAO.idcheck(id);
	}
}
