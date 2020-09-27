package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO {
	private int review_no;
	private String review_title;
	private String review_content;
	private int review_star_rating;
	private String review_date;
	private int review_like;
	private int item_no;
	private String mem_id;
}
