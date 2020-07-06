package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	// ctrl shift y 소문자 변경
	// ctrl shift a 에디터 타일 변경
	private int pro_no;
	private String pro_name;
	private String pro_price;
	private String pro_detail;
	private String pro_pr_date;
	private String pro_stock;
	private String pro_image;
}
