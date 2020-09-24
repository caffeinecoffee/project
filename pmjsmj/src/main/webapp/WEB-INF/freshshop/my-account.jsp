<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
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
<!-- my-account.css -->
<link rel="stylesheet" href="/resources/css/my-account.css">
<!-- paging CSS -->
<link rel="stylesheet" href="/resources/css/paging.css">
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
<script src="/resources/js/myAccount.js"></script>
<script src="/resources/js/paging.js"></script>
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
			<div class="topContain">
				<!-- 				<div class="pointContain"> -->
				<!--    					<span class="pointText">포인트</span> -->
				<!--    					<span class="pointMoney"><script type="text/javascript">numberWithCommas(${pointDTO.point})</script>원</span> -->
				<!--         		</div> -->
				<div class="deliveryCountContain">
					<p class="deliveryCountText"
						style="font-size: 40px; margin-left: 20px; font-weight: bold; float: left; margin-top: 17px;">배송중</p>
					<p class="deliveryCount">
						<script type="text/javascript">numberWithCommas(${hash.deliveringCnt})</script>
						개
					</p>
					<!-- 					<font><script type="text/javascript">numberWithCommas(${hash.deliveringCnt})</script>개</font> -->
				</div>
			</div>
			<c:import url="my-account-left-nav.jsp" />
			<c:if test="${fn:length(hash.mpoList) != 0}">
				<c:forEach items="${hash.mpoList}" var="mpoDTO">
					<div class="deliveryContain">
						<div class="deliveryContainLeft">
							<div class="imgContain">
								<img class="deliveryContainImg"
									src="/resources/images/thumb.jpg">
							</div>
							<p class="deliveryContainLeftText">
								<a
									href="deliveryTracking?order_no=${mpoDTO.order_no}&&item_no=${mpoDTO.item_no}">${mpoDTO.item_name }</a><br />
								<script type="text/javascript">numberWithCommas(${mpoDTO.item_first_price})</script>
								원 /
								<script type="text/javascript">numberWithCommas(${mpoDTO.orders_item_cnt})</script>
								개
							</p>
						</div>
						<p class="deliveryContainRight" style="margin-right: 39px;">
							<font class="deliveryStatus">${mpoDTO.order_status}</font><br />
							<font class="deliveryDate">${mpoDTO.order_date}</font>
						</p>
						<c:if test="${mpoDTO.order_status != '취소신청' and mpoDTO.order_status != '취소승인' and mpoDTO.order_status != '완료'}">
						<p class="productBtn" style="background-color: #b0b435;margin-top: 15px;margin-left: 62px;float: left;text-align: center;width: 75px; border-radius: 9px">
							<a class="productBtnText" id="deleteBtn" onclick="location.href='orderRefund?order_no=${mpoDTO.order_no}&presentPage=${hash.pdto.presentPage}'" style="cursor: pointer;font-weight: bold; color: white;">주문취소</a>
						</p>
						</c:if>
					</div>
				</c:forEach>
				<div class="paging">
					<c:if test="${hash.pdto.presentPage!=1}">
						<a href="/myAccount?presentPage=1" class="btn_arr prev">&lt;</a>
					</c:if>

					<!-- D : 활성화페이지일 경우 : on 처리 -->
					<c:forEach var="i" begin="${hash.pdto.startPage}"
						end="${hash.pdto.endPage}">
						<c:if test="${i == hash.pdto.presentPage }">
							<a href="/myAccount?presentPage=${i}" id="page${i }" class="on">${i }</a>
						</c:if>
						<c:if test="${i != hash.pdto.presentPage }">
							<a href="/myAccount?presentPage=${i}" id="page${i }">${i }</a>
						</c:if>
					</c:forEach>
					<c:if test="${hash.pdto.presentPage!=hash.pdto.endPage}">
						<a href="/myAccount?presentPage=${hash.pdto.allPage}"
							class="btn_arr next">&gt;</a>
					</c:if>
				</div>
			</c:if>
			<c:if test="${fn:length(hash.mpoList) == 0}">
				<div class="productContainNull">
						<p class="productContainNullText">
							등록된 관심상품이 없습니다.<br>관심상품을 등록해주세요.
						</p>
					</div>
			</c:if>

		</div>
	</div>
	<!-- End My Account -->
	<c:import url="footer.jsp" />
</body>

</html>