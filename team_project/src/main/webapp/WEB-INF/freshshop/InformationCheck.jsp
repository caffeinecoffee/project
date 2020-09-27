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
<!-- my-account-interested CSS -->
<link rel="stylesheet" href="/resources/css/my-account-interested.css">

<link rel="stylesheet" href="/resources/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/InformationCheck.css">

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

<!--=============================================================================================== -->
	<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--=============================================================================================== -->
	<script src="/resources/vendor/animsition/js/animsition.min.js"></script>
<!--=============================================================================================== -->
	<script src="/resources/vendor/bootstrap/js/popper.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--=============================================================================================== -->
	<script src="/resources/vendor/select2/select2.min.js"></script>
<!--=============================================================================================== -->
	<script src="/resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--=============================================================================================== -->
	<script src="/resources/vendor/countdowntime/countdowntime.js"></script>
<!--=============================================================================================== -->
	<script src="/resources/js/infomationCheck.js"></script>
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
			<div style="width: 100%; height: 65px;">
				<p style="font-size: 35px; font-weight: bold; margin-left: 275px;">회원정보 확인</p>
			</div>
			<c:import url="my-account-left-nav.jsp"/>
			<div class="wrap-login100 p-b-160 p-t-50">
			<p class="message"></p>
				<form class="login100-form validate-form">
					<div class="wrap-input100 rs1 validate-input" data-validate="Username is required">
						<input class="input100" type="text" name="mem_id" id="id" value="${mdto.mem_id }" readonly="readonly">
						<span class="label-input100" id="idSpan"></span>
					</div>
					
					
					<div class="wrap-input100 rs2 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="mem_password" id="pwd">
						<span class="label-input100" id="pwdSpan">Password</span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- End My Account -->
	<c:import url="footer.jsp" />
</body>
</html>