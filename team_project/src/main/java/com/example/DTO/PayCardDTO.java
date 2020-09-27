package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayCardDTO {
	private int order_no;
	private String pay_credit_num;
	private String pay_credit_name;
} 
