package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ZipcodeVO {
	// ctrl shift y 소문자 변경
	// ctrl shift a 에디터 타일 변경
	private String zip_zipcode;
	private String zip_area1;
	private String zip_area2;
	private String zip_area3;
	private String zip_area4;
}
