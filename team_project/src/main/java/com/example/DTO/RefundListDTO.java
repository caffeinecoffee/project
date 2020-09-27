package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RefundListDTO {
	private int order_no;
	private String item_name;
	private int item_first_price;
	private int item_discount;
	private int refund_money;
	private String cancel_receipt_date;
	private String cancel_complete_date;
	private int admin_approval_or_not;
	private int orders_item_cnt;
}
