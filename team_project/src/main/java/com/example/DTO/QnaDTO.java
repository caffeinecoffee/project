package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnaDTO {
	private int qna_no;
	private String qna_title;
	private String qna_email;
	private String qna_message;
	private String qna_content;
	private String qna_secret;
	private int qna_ref;
	private int question_no;
	private int order_no;
	private String qna_reg_date;
	private String mem_id;
}
