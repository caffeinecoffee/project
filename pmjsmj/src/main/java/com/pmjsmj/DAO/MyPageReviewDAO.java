package com.pmjsmj.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.MyPageReviewDTO;

@Mapper
public interface MyPageReviewDAO {

	public List<MyPageReviewDTO> getReviewList(HashMap<String, Object> hashParam);

	public int getAllCount(MemberDTO mdto);

}
