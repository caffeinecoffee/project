package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDTO {
	private String mem_id;
	private int item_no;
	private int cart_cnt;
}
