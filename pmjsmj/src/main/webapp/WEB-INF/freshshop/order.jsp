<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>주문/결제 페이지</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="/resources/images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="/resources/images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="/resources/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="/resources/css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="/resources/css/custom.css">
<!-- Cart CSS -->
<link rel="stylesheet" href="/resources/css/cart.css">
<!-- font style -->
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@700&display=swap" rel="stylesheet">
<!-- ALL JS FILES -->
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<!-- ALL PLUGINS -->
<script src="/resources/js/jquery.superslides.min.js"></script>
<script src="/resources/js/bootstrap-select.js"></script>
<script src="/resources/js/inewsticker.js"></script>
<script src="/resources/js/bootsnav.js"></script>
<script src="/resources/js/images-loded.min.js"></script>
<script src="/resources/js/isotope.min.js"></script>
<script src="/resources/js/owl.carousel.min.js"></script>
<script src="/resources/js/baguetteBox.min.js"></script>
<script src="/resources/js/form-validator.min.js"></script>
<script src="/resources/js/contact-form-script.js"></script>
<script src="/resources/js/custom.js"></script>
<script src="/resources/js/product.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 숫자 콤마 넣어주는 역활 (myAccount.js)-->
<script src="/resources/js/myAccount.js"></script>
<script type="text/javascript">
	$(function(){
		$("#my-address").click(function(){
			$("#order_zipcode").val('${mdto.mem_zipcode}');
		});
		$("#my-address").click(function(){
			$("#order_to_address").val('${mdto.mem_address}');
		});
		$("#my-address").click(function(){
			$("#order_address_detail").val('${mdto.mem_address_detail}');
		});
		$("#my-address").click(function(){
			$(".order_to_name").val('${mdto.mem_name}');
		});
		$("#my-address").click(function(){
			$(".order_to_phone").val('${mdto.mem_mobile}');
		});
	});
</script>
</head>
<body>
	<c:import url="top.jsp" />
	<div id="order-wrap">
	
		<div class="order-box">
			<div class="order-title">
	<!-- 이전이름	<div class="ordermoney-title"> -->
				<h3>주문/결제</h3>
			</div>
			<table border="1" class="order-boardlist">
				<thead>
					<tr>
						<th>상품</th>
						<th>상품정보</th>
						<th>수량</th>
						<th>상품금액</th>
						<th>할인</th>
						<th>합계</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${orderlist}" var="cldto" varStatus="status">
					<tr>
					<td><img alt="" src="/resources/images/product1.jpg"/></td>
					<td style="vertical-align: middle">
						<p class="">${cldto.item_name}</p>
					</td>
					<td style="vertical-align: middle">
						<button type="button" class="plus${status.count}" onclick="javascript:plus(${status.count},${cldto.item_no},${cldto.item_first_price},${cldto.item_discount},${sum })">+</button>
	 						<input style="width: 50px; text-align: center;"  type="number" class="numBox${status.count}" min="1" max="${view.gdsStock}" value="${cldto.cart_cnt }" readonly="readonly"/>
	 						<button type="button" class="minus${status.count}" onclick="javascript:minus(${status.count},${cldto.item_no},${cldto.item_first_price},${cldto.item_discount},${sum })">-</button>
					</td>
					<td style="vertical-align: middle"><p class="item_first_price${status.count}"><script type="text/javascript">numberWithCommas(${cldto.item_first_price})</script></p></td>
					<td style="vertical-align: middle"><p class="item_discount${status.count}"><script type="text/javascript">numberWithCommas(${cldto.item_first_price - cldto.item_discount})</script></p></td>
					<td style="vertical-align: middle"><p class="sumPrice${status.count}"><script type="text/javascript">numberWithCommas(${(cldto.item_first_price -(cldto.item_first_price-cldto.item_discount))*cldto.cart_cnt})</script></p></td>				
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="order-area">
	<!-- 	<div class="order-info"> -->
		<table class="order-boardwite">
	<!-- 	<table id="input"> -->
		<tr>
			<td></td>
		</tr>
		<tr  height="100" bgcolor="#EDEDE8">
			<td style="text-align:right; vertical-align: middle;" >
				<font size="3pt">상품구매금액</font>&nbsp;&nbsp;<font class="sum" style="font-weight: bold; font-size: 18pt"><script type="text/javascript">numberWithCommas(${sum})</script></font>원 &nbsp;&nbsp;&nbsp;
				<font size="3pt">배송비</font>&nbsp;&nbsp;<font class="shippingFee" style="font-weight: bold; font-size: 18pt">+<script type="text/javascript">numberWithCommas(2500)</script></font>원 &nbsp;&nbsp;&nbsp;
				<font size="3pt">&nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size: 30px; font-weight: bold;">=</font>&nbsp;&nbsp;&nbsp;&nbsp;총구매금액</font>&nbsp;&nbsp;<font class="allSum" style="font-weight: bold; font-size: 18pt"><script type="text/javascript">numberWithCommas(${sum+2500})</script></font>원 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		</table>
	
		<table class="order-boardwite">
	<!-- 	<table id="input"> -->
			<thead>
				<tr>
					<th>주문자정보</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="font-weight: bold;">이름</td>
					<td style="text-align: center" >
						<font>${mdto.mem_name}</font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">핸드폰</td>
					<td style="text-align: center" >
						<font>${mdto.mem_mobile}</font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">이메일</td>
					<td style="text-align: center" >
						<font>${mdto.mem_email}</font>		
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<form action="orderCompleteProc" method="post" id="orderCompleteProcForm">
		<table class="order-boardwite">
			<thead>
				<tr>
					<th>주문배송</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="font-weight: bold;">배송주소</td>
					<td  style="text-align: left" colspan="2">
						<form>
	  						<input type="radio" id="my-address" name="address" checked="checked" value="${mdto.mem_address}" /> 회원정보주소
	  						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  						<input type="radio" id="new-address"  name="address" /> 새로운 배송지
						</form>
					</td>
				</tr>
				<tr>
					<td style="font-weight: bold;">주소록</td>
					<td style="text-align: left" colspan="2">
						<input type="text" class="order_zipcode" name="order_zipcode" id="order_zipcode" value="${mdto.mem_zipcode }"  style="text-align: center" />&nbsp;&nbsp;&nbsp;
						<button type="button" class="address-btn" onclick="zipCheck()">주소찾기</button>&nbsp;&nbsp;&nbsp;&nbsp;
						<font id="order_zipcode_msg" class="order_zipcode_msg" style="color: red; 9pt;"></font>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="text-align: left" colspan="2">
						<input type="text" class="order_to_address" name="order_to_address" id="order_to_address" value="${mdto.mem_address }" style="text-align: center" size=60 maxlength=50 />
						&nbsp;
						<input type="text" class="order_address_detail" name="order_address_detail" id="order_address_detail" value="${mdto.mem_address_detail }" style="text-align: center" size=40 maxlength=42 />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font class="order_address_detail_msg" style="color: red;font-size: 9pt;"></font>
					</td>
				</tr>
				<tr>
					<td style="font-weight: bold;">받는분</td>
					<td style="text-align: left">
						<input type="text" class="order_to_name" name="order_to_name" class="order_to_name" value="${mdto.mem_name }" style="text-align: center" />
						<font class="order_to_name_msg" style="color: red;font-size: 9pt;"></font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td style="font-weight: bold;">받는분 연락처</td>
					<td style="text-align: left">
						<input type="text" class="order_to_phone" name="order_to_phone" class="order_to_phone" value="${mdto.mem_mobile }" style="text-align: center" />
						<font class="order_to_phone_msg" style="color: red;font-size: 9pt;"></font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td style="vertical-align: middle; font-weight: bold;">요청사항</td>
					<td style="text-align: left">
						<textarea class="order_request" name="order_request" style="resize: none;" rows="4" cols="60" placeholder="택배기사님이 확인하는 메시지입니다."></textarea>
						<font class="order_request_msg" style="color: red;font-size: 9pt;"></font>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	
		<table class="order-boardwite" id="order-boardwite">
			<thead>
				<tr>
					<th>결제정보입력</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="font-weight: bold;">결제수단</td>
					<td style="text-align: left">
	  					<input type="radio" id="order_pay_option" name="order_pay_option" class="pay-bank" checked="checked" value="무통장입금" /> 무통장입금
	  					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  					<input type="radio" id="order_pay_option" name="order_pay_option" class="pay-card"  value="신용카드"/> 신용카드 						
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td style="text-align: left">
						<div class="depositor_name">
							입금자명
							&nbsp;&nbsp;
							<input type="text" name="pay_bank_depositor" class="pay_bank_depositor" style="text-align: center;" />
						</div>
						<font class="pay_bank_depositor_msg" style="color: red;font-size: 9pt;"></font>
						<div class="cardNum">카드번호
							&nbsp;&nbsp;
							<input type="text" id="pay_credit_num" value="" name="pay_credit_num" class="pay_credit_num" style="text-align: center;" />
						</div>
						<font class="pay_credit_num_msg" style="color: red;font-size: 9pt;"></font>
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td style="text-align: left" colspan="3">
					<div class="shopBank">입금은행	
						&nbsp;&nbsp;
						<select id="pay_bank_info" name="pay_bank_info" class="pay_bank_info" style="width: 300px; height: 28px;">
								<option  value="none" style="widows: 300px;"> ::  선택하세요</option>
								<option value="우리은행 1002-34887-3245 주식회사PMJSMJ">우리은행 1002-34887-3245 주식회사PMJSMJ</option>
						</select>
						<font class="pay_bank_info_msg" style="color: red; font-size: 9pt;"></font>
					</div>
						<div class="cardChoice">
							카드선택
							&nbsp;&nbsp;
							<select id="pay_credit_name" name="pay_credit_name" class="pay_credit_name" style="width: 300px; height: 28px;">
									<option value="none"> :: 카드선택</option>
									<option value="우리카드"> 우리카드</option>
									<option value="신한카드"> 신한카드</option>
									<option value="KB국민카드"> KB국민카드</option>
									<option value="하나카드"> 하나카드</option>
									<option value="롯데카드"> 롯데카드</option>
									<option value="삼성카드"> 삼성카드</option>
									<option value="농협카드"> NH농협카드</option>
									<option value="현대카드"> 현대카드</option>
							</select>
							<font class="pay_credit_name_msg" style="color: red; font-size: 9pt;"></font>
						</div>
					</td>
				</tr>
				</tbody>
			</table>
			</form>
		</div>
		<div class="order-shopping-btn-box">
			<button class="order-btn">주문하기</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="index-btn" onclick="location.href='cartDetail'">장바구니</button>
		</div>
		
	</div>
	<c:import url="footer.jsp" />
</body>
</html>