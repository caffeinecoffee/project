package com.pmjsmj.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CancelDTO {
	private int order_no;
	private String cancel_receipt_date;
	private String cancel_complete_date;
	private int admin_approval_or_not;
	private String cancel_reason;
	private String detail_reason;
}
