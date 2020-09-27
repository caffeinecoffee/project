package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartListDTO {
	private int item_no;
	private String item_name;
	private int item_first_price;
	private int item_discount;
	private String item_thumbnail;
	private int cart_cnt;
}
