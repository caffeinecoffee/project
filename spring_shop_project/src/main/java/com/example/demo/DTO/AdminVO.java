package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminVO {
	// ctrl shift y 소문자 변경
	// ctrl shift a 에디터 타일 변경
	private String admin_id;
	private String admin_passwd;
}
