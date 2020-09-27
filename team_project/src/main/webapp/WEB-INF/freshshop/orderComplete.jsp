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
    <title>주문완료 페이지</title>
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
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">
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
    <!-- 숫자 콤마 넣어주는 역활 (myAccount.js)-->
    <script src="/resources/js/myAccount.js"></script>
</head>
<body>
	<c:import url="top.jsp"/>
	<div class="orderComplete-wrap">
		<div class="orderComplete-title">
			<h3>주문완료</h3>
		</div>
		<div id="line-box"></div>
		<div id="cartimg-box">
			<img src="/resources/images/cart.png" alt="" id="cartimg">
		</div>
	</div>
	<div id="orderComplete-box">
		<table border="1">
			<thead>
				<tr>
					<th scope="col">송장번호</th>
					<th scope="col">총 금액</th>	
				</tr>
			</thead>
			<tbody class="orderComplete-input">
				<tr>
					<td style="vertical-align: middle;color: #ff0000;font-weight: bold;font-size: 20pt;">${resultOlDTO.order_tracking_num}</td>
					<td style="vertical-align: middle;font-weight: bold; font-size: 15pt;"><script type="text/javascript">numberWithCommas(${resultOlDTO.order_money})</script>원</td>
					<!-- numberWithCommas : 3자리수 콤마 찍기 -->
				</tr>
			</tbody>	
		</table>
	</div>
	<div class="shopping-btn-box">
		<a href="myAccount"><button style="font-family: 'Roboto Condensed', sans-serif; font-weight: bold;">My Account</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="index"><button>쇼핑계속하기</button></a>
	</div>	
	
	<c:import url="footer.jsp"/>
</body>
</html>