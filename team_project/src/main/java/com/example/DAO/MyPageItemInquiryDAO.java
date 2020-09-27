package com.example.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.DTO.ItemInquiry_QuestionDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.item_inquiryDTO;

@Mapper
public interface MyPageItemInquiryDAO {

	public int getAllCount(MemberDTO mdto);

	public List<ItemInquiry_QuestionDTO> getItemInquirys(HashMap<String, Object> hashParam);

}
	