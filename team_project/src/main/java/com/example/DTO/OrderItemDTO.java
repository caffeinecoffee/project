package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemDTO {
	private int order_no;
	private int item_no;
	private int orders_item_money;
	private int orders_item_cnt;
}
