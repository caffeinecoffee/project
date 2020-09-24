package com.pmjsmj.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pmjsmj.DTO.Interested_ItemDTO;
import com.pmjsmj.DTO.ItemDTO;
import com.pmjsmj.DTO.MemberDTO;
import com.pmjsmj.DTO.ReviewDTO;
import com.pmjsmj.DTO.item_inquiryDTO;

@Mapper
public interface SangDAO {

	List<ItemDTO> getItems(@Param("start") int start, @Param("end") int end, @Param("orderOption") String orderOption, @Param("category_no") String category_no, @Param("search") String search);

	ItemDTO getItem(@Param("item_no") String item_no);

	List<ReviewDTO> getReviews(@Param("start") String start, @Param("end") String end, @Param("item_no") String item_no);

	List<item_inquiryDTO> getItemInquirys(@Param("start") String start, @Param("end") String end, @Param("item_no") String item_no);

	List<ItemDTO> getLikingItems(@Param("item_no") String item_no);

	int getItemCount(@Param("category_no") String category_no, @Param("search") String search);

	int getReviewCount();

	int getItemInquiryCount();

	void SignUpProc(MemberDTO mdto);

	int IDDuplicatecheck(@Param("mem_id") String mem_id);

	void reviewWriteProc(ReviewDTO rdto);

	List<ItemDTO> popularItem();

	List<ItemDTO> weekPopularItem();

	void itemInquiryWriteProc(item_inquiryDTO indto);

	item_inquiryDTO itemInquiryDescribe(item_inquiryDTO indto);

	ReviewDTO ReviewDescribe(ReviewDTO rdto);

	void revieUpdateProc(ReviewDTO rdto);

	void itemInquiryUpdateProc(item_inquiryDTO indto);

	List<ItemDTO> MDItem();

	int writeQualify(@Param("item_no") String item_no, @Param("mem_id") String mem_id);

	boolean getInterestedItem(Interested_ItemDTO interDTO);
	
	void addInterestedItem(Interested_ItemDTO interDTO);
}
