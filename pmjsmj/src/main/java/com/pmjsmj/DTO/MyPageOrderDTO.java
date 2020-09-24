package com.pmjsmj.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyPageOrderDTO {
	private int order_no; // 주문번호
	private int item_no; // 제품번호
	private String item_name; //제품이름
    private int item_first_price;//제품원가
    private int item_discount; //제품 할인가
    private String item_thumbnail; // 제품 썸네일
    private String order_date;// 주문날짜
    private int option_be_or_not;// 옵션이 있는지 없는지
    private int orders_item_cnt;//제품 개수
    private String mem_id; //주문자 아이디
    private String order_status; // 주문상태
    private String order_request;// 배송 요청사항
    private String order_to_name; // 받는 사람 이름
    private int order_tracking_num; // 배송번호
    private String order_to_address; //받는 사람 주소
    private String mem_address_detail; //받는 사람 상세주소
      
}
