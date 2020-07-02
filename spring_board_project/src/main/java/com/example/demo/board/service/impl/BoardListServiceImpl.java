package com.example.demo.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.board.dao.BoardDAO;
import com.example.demo.board.dto.BoardVO;
import com.example.demo.board.dto.PageVO;
import com.example.demo.board.service.BoardListService;

@Service("boardListService")
public class BoardListServiceImpl implements BoardListService {

	private static final Logger logger = LoggerFactory.getLogger(BoardListServiceImpl.class);

	@Resource
	BoardDAO boardDao;

	@Override
	public int getAllcount() {
		return boardDao.getAllcount();
	}

	@Override
	public List<BoardVO> getArticles(PageVO pvo) {
		int currentPage;
		if (pvo.getCurrentPage() == 0) {
			currentPage = 1;
		} else {
			currentPage = pvo.getCurrentPage();
		}
		pvo.setCurrentPage(currentPage);

		int allPage = pvo.getAllCount() / pvo.getLinePerPage() + 1;
		pvo.setAllPage(allPage);

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
		List<BoardVO> list = boardDao.getArticles(hmap);
		return list;
	}

	public Map<String, Object> getArticle(BoardVO bvo, PageVO pvo) {
		if (pvo.getCurrentPage() == 0) {
			pvo.setCurrentPage(1);
		}
		BoardVO bvo2 = boardDao.getArticles(bvo);
		Map<String, Object> cmap = new HashMap<String, Object>();
		cmap.put("bvo", bvo);
		cmap.put("bvo", bvo2);
		return cmap;
	}

}
