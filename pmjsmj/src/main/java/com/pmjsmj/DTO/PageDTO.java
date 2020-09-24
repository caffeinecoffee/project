package com.pmjsmj.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	// 현재 페이지
	int presentPage;
	// 페이지당 라인 수
	int linePerPage = 5;
	// 전체 레코드 수
	int allCount;
	// 전체 페이지 수
	int allPage;
	// 페이지블럭 (하나의 화면에 나오는 페이지수)
	int pageBlockPerNumber = 7;
	// 몇번째 블럭인지
	int presentPageBlock;
	// 블럭에서 시작 페이지
	int startPage;
	// 불럭에서 마지막 페이지
	int endPage;
}
