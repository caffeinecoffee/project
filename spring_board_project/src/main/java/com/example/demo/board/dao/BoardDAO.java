package com.example.demo.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.dto.BoardVO;

@Mapper
public interface BoardDAO {
	public int getAllcount();
	public List<BoardVO> getArticles(Map<String, Integer> hmap);
	public BoardVO getArticles(BoardVO bvo);
	public void boardWrite(BoardVO bvo);
	public int getNewNum();
	public void boardUpdatePro(BoardVO bvo);
	public void boardDeletePro(BoardVO bvo);
}