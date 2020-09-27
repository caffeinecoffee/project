package com.example.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderListDTO {
	private int order_no; //주문번호
	private String order_date; //주문날짜
	private String order_status;//주문 상태 (배송중,배송완료)
	private String order_pay_option;//결제 방법
	private int order_money;//결제 금액
	private String order_tracking_num;//송장번호
	private String order_to_name;// 받는사람 이름
	private String order_to_phone;// 받는사람 연락처
	private String order_zipcode; // 받는사람 우편번호
	private String order_to_address;// 받는사람 주소
	private String order_address_detail;// 받는사람 상세주소
	private String order_request;// 요청사항
	private String mem_id;// 주문회원
}
