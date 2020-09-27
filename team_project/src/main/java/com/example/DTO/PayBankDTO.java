package com.example.DTO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayBankDTO {
	private int order_no;
	private String pay_bank_depositor; 
	private String pay_bank_info;

}
