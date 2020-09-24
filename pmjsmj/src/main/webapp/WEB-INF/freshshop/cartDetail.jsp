<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html> 
<html lang="ko">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>카트 상세 페이지</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="/resources/images/apple-touch-icon.png">

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
	<link href="https://fonts.googleapis.com/css2?family=Slabo+27px&display=swap" rel="stylesheet">
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
    <!-- 숫자 콤마 넣어주는 역활 (myAccount.js)-->
    <script src="/resources/js/myAccount.js"></script>
    <script>
    	function order_btn_click(){
    		if(${fn:length(cldtoList)} == 0){
    			alert("장바구니가 비어있습니다.");
    		}else{
    			location.href='orderProc';
    		}
    	}
    </script>
</head>
<body>
	<c:import url="top.jsp"/>
	<div class="cartdetailList-wrap">
		<div class="cartdetailList-title">
			<h3>상품정보</h3>
		</div>
		<table border="1" class="cartdetailList" >
			<thead>
				<tr>					
					<th>상품</th>
					<th>상품정보</th>
					<th>수량</th>
					<th>상품금액</th>
					<th>할인</th>
					<th>합계</th>
					<th>선택</th>
					
				</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${fn:length(cldtoList) != 0}">
					<c:forEach items="${cldtoList }" var="cldto" varStatus="status">
					<tr>
						<td style="vertical-align: middle">
							<img alt="" src="/resources/images/product1.jpg"/>
						</td>
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
						<td style="vertical-align: middle">
							<a href="addInterestedItem?item_no=${cldto.item_no }"><button class="interest" >관심상품</button></a> 	
							<div id="space-div"></div>				
							<button class="delete" onclick="location.href='deleteProc?item_no=${cldto.item_no}'">삭제하기</button>			
						</td>				
					</tr>
					</c:forEach>
				</c:when>
				
				<c:otherwise>
					<tr>
						<td colspan="7" style="padding: 10px; vertical-align: middle; border-bottom: 1px solid #ccc;">장바구니가 비어있습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div>
	<c:if test="${fn:length(cldtoList) != 0}">
		<div class="">
			<table border="1" class="cartDetail-totalsummary">
				<thead>
					<tr>
						<th scope="col">총 상품금액</th>
						<th scope="col">배송비</th>
						<th scope="col">결제 예정 금액</th>			
					</tr>
				</thead>
				<tbody class="cartDetail-input">
					<tr>
						<td style="vertical-align: middle;"><font class="sum"><script type="text/javascript">numberWithCommas(${sum})</script></font>원</td>
						<td style="vertical-align: middle;"><font class="shippingFee">+<script type="text/javascript">numberWithCommas(2500)</script></font>원</td>
						<td style="vertical-align: middle;"><font class="allSum"><script type="text/javascript">numberWithCommas(${sum+2500})</script></font>원</td>
					</tr>
				</tbody>	
			</table>
		</div>
	</c:if>
	<div class="cartDetail-shopping-btn-box">
		<button class="order-btn" onclick="javascript:order_btn_click()">상품주문</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="index-btn" onclick="location.href='index'">쇼핑계속하기</button>
	</div>		
	<c:import url="footer.jsp"/>	
</body>
</html>