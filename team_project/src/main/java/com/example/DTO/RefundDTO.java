package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RefundDTO {
	private String item_name;
	private String order_pay_option;
	private int item_first_price;
	private int item_discount;
	private int orders_item_cnt;
}
