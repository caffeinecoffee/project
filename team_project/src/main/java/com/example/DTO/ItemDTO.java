package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemDTO {
	private String item_no;
	private String item_name;
	private String item_descripttion;
	private int item_first_price;
	private int item_discount;
	private String item_thumbnail;
	private String item_sales_rate;
	private String item_stock;
	private int category_no;
	private String reg_date;
	private int option_be_or_not;
}
