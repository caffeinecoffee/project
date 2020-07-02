package com.example.demo.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	// ctrl shift y 소문자 변경
	// ctrl shift a 에디터 타일 변경
	private int rr;
	private int num;
	private int readcnt;
	private int ref;
	private int re_step;
	private int re_level;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String passwd;
	private String reg_date;
	private String attachNm;
	private int fileNo;
	private long fileSize;
	private String orgFileNm;
}
