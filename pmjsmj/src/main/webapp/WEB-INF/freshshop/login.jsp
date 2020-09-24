<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Login V8</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/resources/loginPage/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/css/util.css">
	<link rel="stylesheet" type="text/css" href="/resources/loginPage/css/main.css">
<!--===============================================================================================-->
<!--     Site Icons -->
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="/resources/images/apple-touch-icon.png">

<!--     Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!--     Site CSS -->
    <link rel="stylesheet" href="/resources/css/style.css">
<!--     Responsive CSS -->
    <link rel="stylesheet" href="/resources/css/responsive.css">
<!--     Custom CSS -->
    <link rel="stylesheet" href="/resources/css/custom.css">
</head>
<body>
	<c:import url="top.jsp"/>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178">
					<span class="login100-form-title">
						로그인
					</span>
					<div>
						<p id="errorMsg"></p>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate="아이디를 입력해주세요">
						<input class="input100" type="text" id="mem_id" name="mem_id" placeholder="아이디">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "비밀번호를 입력해주세요">
						<input class="input100" type="password" id="mem_password" name="mem_password" placeholder="비밀번호">
						<span class="focus-input100"></span>
					</div>

					<div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							Forgot
						</span>

						<a class="txt2" style="cursor: pointer;">
							Username / Password?
						</a>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>

					<div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							Do not have an account?
						</span>

						<a href="/SignUp" class="txt3">
							Sign up now
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"/>

<!-- js files -->

<!--===============================================================================================-->
	<script src="/resources/js/jquery.nicescroll.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/loginPage/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/loginPage/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/loginPage/vendor/bootstrap/js/popper.js"></script>
	<script src="/resources/loginPage/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/loginPage/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/loginPage/vendor/daterangepicker/moment.min.js"></script>
	<script src="/resources/loginPage/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/resources/loginPage/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/resources/loginPage/js/main.js"></script>
<!-- 	    ALL JS FILES -->
    <script src="/resources/js/popper.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
<!--     ALL PLUGINS -->
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
</body>
</html>