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
<title>ThewayShop - Ecommerce Bootstrap 4 HTML Template</title>
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

<link rel="stylesheet" href="/resources/css/delevery_tracking.css">

<!-- ALL JS FILES -->
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<!-- ALL PLUGINS -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
	<div class="my-account-box-main">
		<div class="container">
			<div class="stateDelivery">
				<p class="delevery_tracking">
					${mpoDTO.order_date } ${mpoDTO.order_status }<br>
					<c:choose>
						<c:when test="${mpoDTO.order_status eq '결제대기'}">
							고객님의 무통장 입금 대기 중입니다.
						</c:when>
						<c:when test="${mpoDTO.order_status eq '결제확인'}">
							고객님의 결제가 확인되었습니다.
						</c:when>
						<c:when test="${mpoDTO.order_status eq '배송준비'}">
							고객님의 제품이 배송 준비 중입니다.
						</c:when>
						<c:when test="${mpoDTO.order_status eq '배송중'}">
							고객님의 택배가 현재 배송 중입니다.
						</c:when>
						<c:when test="${mpoDTO.order_status eq '완료'}">
							고객님의 제품 배송이 완료되었습니다.
						</c:when>
						<c:when test="${mpoDTO.order_status eq '취소신청'}">
							고객님의 주문이 취소 대기 중입니다.
						</c:when>
						<c:when test="${mpoDTO.order_status eq '취소완료'}">
							고객님의 주문이 취소가 완료되었습니다.
						</c:when>
					</c:choose>
				</p>
			</div>
			<c:import url="my-account-left-nav.jsp"/>
			<div class="delivery_tracking_contain">
				<div style="float: left">
					<img src="/resources/images/thumb.jpg" class="productImg">
				</div>
				<div class="textContain">
					<p class="textContainLeft">
						<a>${mpoDTO.item_name }</a><br/>
						<font><script type="text/javascript">numberWithCommas(${mpoDTO.item_first_price })</script>원 / <script type="text/javascript">numberWithCommas(${mpoDTO.orders_item_cnt })</script>개</font>
					</p>
				</div>
				<p class="textContainRight">
						<font class="state">${mpoDTO.order_status }</font><br>
						<font class="day">${mpoDTO.order_date }</font><br>
<!-- 						<font class="scheduled">도착</font> -->
				</p>
			</div>
			<div class="stateContain">
				<div class="stateContainLeft">
					<p class="invoiceNumberTitle">송장번호</p>
					<p class="invoiceNumber">${mpoDTO.order_tracking_num}</p>
				</div>
				<div class="stateContainRight">
					<ul>
						<li><font class="title">받는사람</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font class="text">${mpoDTO.order_to_name}</font></li>
						<li><font class="title">받는주소</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font class="text">${mpoDTO.order_to_address} ${mpoDTO.mem_address_detail }</font></li>
						<li><font class="title">배송 요청사항</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font class="text">${mpoDTO.order_request}</font></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End My Account -->
	<c:import url="footer.jsp" />
</body>
</html>