package com.pmjsmj.DAO;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pmjsmj.DTO.ItemInquiry_QuestionDTO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.item_inquiryDTO;

@Mapper
public interface MyPageItemInquiryDAO {

	public int getAllCount(MemberDTO mdto);

	public List<ItemInquiry_QuestionDTO> getItemInquirys(HashMap<String, Object> hashParam);

}
	