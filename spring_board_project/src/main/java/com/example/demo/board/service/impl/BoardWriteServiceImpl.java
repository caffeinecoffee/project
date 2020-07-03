package com.example.demo.board.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.board.dao.BoardDAO;
import com.example.demo.board.dto.BoardVO;
import com.example.demo.board.dto.PageVO;
import com.example.demo.board.service.BoardWriteService;
import com.example.demo.common.ServletUpload;

@Service("BoardWriteService")
public class BoardWriteServiceImpl implements BoardWriteService {

	@Resource
	BoardDAO boardDao;

	@Resource(name = "fileUtils")
	private ServletUpload fileUtils;

	@Override
	public PageVO writeArticle(PageVO pvo) {
		if (pvo.getCurrentPage() == 0) {
			pvo.setCurrentPage(1);
		}
		return pvo;
	}

	@Override
	public void writeProArticle(BoardVO bvo, MultipartHttpServletRequest mprequest) {

		if (bvo.getNum() == 0) {
//			bvo.setNum(boardDao.getNewNum() + 1);
//			bvo.setRef(bvo.getNum());
			bvo.setRe_step(1);
			bvo.setRe_level(1);
		} else {
//			bvo.setNum(boardDao.getNewNum() + 1);
			bvo.setRe_step(bvo.getRe_step() + 1);
			bvo.setRe_level(bvo.getRe_level() + 1);
		}
		Map<String, Object> fileMap = null;
		try {
			fileMap = fileUtils.parseInsertFileInfo(bvo, mprequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (fileMap != null) {
			bvo.setFileNo((int) fileMap.get("fileNo"));
			bvo.setFileSize((long) fileMap.get("fileSize"));
			bvo.setOrgFileNm((String) fileMap.get("org_file_name"));
			bvo.setAttachNm((String) fileMap.get("stored_file_name"));
		}
		boardDao.boardWrite(bvo);
	}

	@Override
	public PageVO updateProArticle(BoardVO bvo, PageVO pvo, MultipartHttpServletRequest mprequest) {
		// TODO Auto-generated method stub
		if (pvo.getCurrentPage() == 0) {
			pvo.setCurrentPage(1);
		}
		Map<String, Object> fileMap = null;
		try {
			fileMap = fileUtils.parseInsertFileInfo(bvo, mprequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (fileMap != null) {
			bvo.setFileNo((int) fileMap.get("fileNo"));
			bvo.setFileSize((long) fileMap.get("fileSize"));
			bvo.setOrgFileNm((String) fileMap.get("org_file_name"));
			bvo.setAttachNm((String) fileMap.get("stored_file_name"));
		}
		boardDao.boardUpdatePro(bvo);
		return pvo;
	}

	@Override
	public PageVO deleteProArticle(PageVO pvo, int num) {
		if (pvo.getCurrentPage() == 0) {
			pvo.setCurrentPage(1);
		}
		boardDao.boardDeletePro(num);
		return pvo;
	}

}
