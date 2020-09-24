<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>주문결제취소</title>
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
</head>

<body>
<c:if test="${mdto == null }">
	<script type="text/javascript">
		location.href="loginPage";
	</script>
</c:if>
	<c:import url="top.jsp" />
	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>My Account</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Shop</a></li>
						<li class="breadcrumb-item active">My Account</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start My Account  -->
	<form action="orderCancel" method="post" id="orderCancelForm">
	<div class="my-account-box-main">
		<!-- start 주문결제취소에 대한 상품정보 -->
		<div class="container">
		<div style="width: 100%; height: 65px;">
				<p style="font-size: 35px; font-weight: bold; margin-left: 275px;">주문결제취소</p>
		</div>
			<c:import url="my-account-left-nav.jsp" />
			<div class="orderRefund-all-box">
				<div class="orderRefund-table-box">
					<table border="1" class="orderRefund-boardlist">
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
							<c:forEach items="${orderRefund}" var="rfdto">
							<tr>
								<td><img alt="" src="/resources/images/product1.jpg" /></td>
								<td style="vertical-align: middle">
									<font>${rfdto.item_name}</font>
								</td>
								<td style="vertical-align: middle">
									<font>${rfdto.orders_item_cnt }</font>
								</td>
								<td style="vertical-align: middle">
									<font><script type="text/javascript">numberWithCommas(${rfdto.item_first_price})</script></font>
								</td>
								<td style="vertical-align: middle">
									<font><script type="text/javascript">numberWithCommas(${rfdto.item_discount})</script></font>
								</td>
								<td style="vertical-align: middle">
									<font><script type="text/javascript">numberWithCommas(${(rfdto.item_first_price-rfdto.item_discount)*rfdto.orders_item_cnt})</script></font>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="orderRefund-info-box">
					<table id="refund-info">
						<thead>
							<tr>
								<th>환불정보</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>결제금액환불(배송비포함)</td>
								<td style="text-align: left"><script type="text/javascript">numberWithCommas(${refundSum})</script>원</td>
								<td id="order-line" style="text-align: left">환불수단 : ${pay_option}</td>
							</tr>
						</tbody>
					</table>
					
					<table class="orderCancel">
					<thead>
						<tr>
							<th>취소사유</th>
							<th>상세내용</th>
						</tr>
					</thead>
					<tbody>				
						<tr>
							<td style="vertical-align: middle; font-weight: bold;">
								<input type="text" class="cancel_reason" name="cancel_reason" style="text-align: center" />
								<p class="cancel_reason_msg" style="color: red;font-size: 9pt;"></p>
							</td>
							<td style="text-align: left">
								<textarea class="detail_reason" name="detail_reason" style="resize: none;" rows="4" cols="60" placeholder=" 상세내용을 입력해주세요."></textarea>
								<p class="detail_reason_msg" style="color: red;font-size: 9pt;"></p>
<!-- 							<font class="order_request_msg" style="color: red;font-size: 9pt;"></font> -->
							</td>
						</tr>
					</tbody>
					</table>
				</div>
				<!-- 여기까지 -->
			</div>
		</div>
	<div class="refund-btn-box">
		<button class="refund-btn">   주문취소신청    </button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="index"><button>   쇼핑계속하기   </button></a>
		<input type="hidden" name="order_no"  value="${order_no}" >
		<input type="hidden" name="presentPage" value="${pdto.presentPage }">
	</div>
	</div>
	</form>
	<!-- End My Account -->


	<c:import url="footer.jsp" />
</body>

</html>