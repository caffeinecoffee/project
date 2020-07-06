package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	// ctrl shift y 소문자 변경
	// ctrl shift a 에디터 타일 변경
	private String mem_id;
	private String mem_passwd;
	private String mem_name;
	private String mem_num1;
	private String mem_num2;
	private String mem_e_mail;
	private String mem_phone;
	private String mem_zipcode;
	private String mem_address;
	private String mem_job;
}
