package com.example.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.MemberDTO;
import com.example.DTO.MyPageReviewDTO;

@Mapper
public interface MyPageReviewDAO {

	public List<MyPageReviewDTO> getReviewList(HashMap<String, Object> hashParam);

	public int getAllCount(MemberDTO mdto);

}
