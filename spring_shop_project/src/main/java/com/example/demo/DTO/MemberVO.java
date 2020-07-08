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
	private String m_passwd;
	private String m_name;
	private String m_email;
	private String m_phone;
	private String zipcode;
	private String address;
	private String m_job;
	private String address2;
}
