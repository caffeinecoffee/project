package com.example.demo.memmgt.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String memId;
	private String memPasswd;
	private int memSeq;
	private String memName;
	private String memTel;
	private String memBirth;
	private String regDate;
	private String memEmail;
	private String memGender;
}
