package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemInquiry_QuestionDTO {
	private int inq_no;
	private String inq_title;
	private String mem_id;
	private String inq_content;
	private String inq_ref;
	private String inq_reg_date;
	private String item_no;
	private int question_no; 
	private String question_content;
}
