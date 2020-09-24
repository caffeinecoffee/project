package com.pmjsmj.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyPageReviewDTO {
	private int review_no;
	private String review_title;
	private String review_date;
	private int item_no;
	private String mem_id;
}
