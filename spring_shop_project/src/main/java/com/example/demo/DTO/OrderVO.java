package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	// ctrl shift y 소문자 변경
	// ctrl shift a 에디터 타일 변경
	private int or_no;
	private String or_quantity;
	private String or_date;
	private String or_state;
	private String or_id;
}
