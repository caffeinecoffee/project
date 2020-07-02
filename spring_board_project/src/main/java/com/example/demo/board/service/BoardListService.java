package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

import com.example.demo.board.dto.BoardVO;
import com.example.demo.board.dto.PageVO;

public interface BoardListService {
	public int getAllcount();
	public List<BoardVO> getArticles(PageVO pvo);
	public Map<String, Object> getArticle(BoardVO bvo, PageVO pvo);
}
