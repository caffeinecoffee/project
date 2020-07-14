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
	private int no;
	private String name;
	private String price;
	private String detail;
	private String pr_date;
	private String stock;
	private String image="";
	private final String path = "C:/Users/cabs0/Downloads";
}
