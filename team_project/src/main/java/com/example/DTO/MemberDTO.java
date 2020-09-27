package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private String mem_id;
	private String mem_password;
	private String mem_name;
	private String mem_address;
	private String mem_address_detail;
	private String mem_zipcode;
	private String mem_mobile;
	private String mem_email;
	private String mem_email_reception;
	private String mem_reg_date;
	private int role;
	private String mem_last_date;
	private int gender;
	private String birth_date;
}
