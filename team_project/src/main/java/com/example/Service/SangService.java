package com.example.Service;

import java.util.HashMap;
import java.util.List;

import com.example.DTO.Interested_ItemDTO;
import com.example.DTO.ItemDTO;
import com.example.DTO.MemberDTO;
import com.example.DTO.PageDTO;
import com.example.DTO.ReviewDTO;
import com.example.DTO.item_inquiryDTO;

public interface SangService {

	HashMap<String, Object> getItems(PageDTO pdto, String orderOption, String category_no, String search);

	ItemDTO getItem(String item_no);

	HashMap<String, Object> getReviews(PageDTO pdto, String item_no);

	List<ReviewDTO> getReviews(String start, String end, String item_no);

	HashMap<String, Object> getItemInquirys(PageDTO pdto, String item_no);

	List<item_inquiryDTO> getItemInquirys(String start, String end, String item_no);

	List<ItemDTO> getLikingItems(String item_no);

	void SignUpProc(MemberDTO mdto);

	int IDDuplicatecheck(String mem_id);

	void reviewWriteProc(ReviewDTO rdto);

	List<ItemDTO> popularItem();

	List<ItemDTO> weekPopularItem();

	void itemInquiryWriteProc(item_inquiryDTO indto);

	item_inquiryDTO itemInquiryDescribe(item_inquiryDTO indto);

	ReviewDTO ReviewDescribe(ReviewDTO rdto);

	void itemInquiryUpdateProc(item_inquiryDTO indto);
	
	void revieUpdateProc(ReviewDTO rdto);

	List<ItemDTO> MDItem();

	int writeQualify(String item_no, String mem_id);

	boolean getInterestedItem(Interested_ItemDTO interDTO);

	void addInterestedItem(Interested_ItemDTO interDTO);
}
