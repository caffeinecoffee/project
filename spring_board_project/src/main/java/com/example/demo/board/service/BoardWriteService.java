package com.example.demo.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.board.dto.BoardVO;
import com.example.demo.board.dto.PageVO;

public interface BoardWriteService {
	public PageVO writeArticle(PageVO pvo);
	public void writeProArticle(BoardVO bvo,MultipartHttpServletRequest mprequest);
	public PageVO updateProArticle(BoardVO bvo, PageVO pvo,MultipartHttpServletRequest mprequest);
	public PageVO deleteProArticle(PageVO pvo, int num);
}
