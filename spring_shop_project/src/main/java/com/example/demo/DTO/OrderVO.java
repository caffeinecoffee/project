package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	// ctrl shift y 소문자 변경
	// ctrl shift a 에디터 타일 변경
	private String no; //주문번호
	private int product_no; //상품 번호			--
	private int price; //상품 가격			-- product 테이블
	private String pname; //상품 이름		--
	private int quantity = 0; //수량
	private String or_date; //주문일자
	private String state; //주문상태
	private String id;
	private String m_name; //회원명
}
