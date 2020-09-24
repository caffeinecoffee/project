package com.pmjsmj.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PointDTO {
	private int point_no;
	private int point;
	private int point_spent;
	private int point_charged;
	private String point_date;
	private String point_content;
	private String mem_id;
}
