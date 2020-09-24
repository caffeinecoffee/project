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
<link rel="stylesheet" href="/resources/css/myQandACheck.css">
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
				<p style="font-size: 37px; font-weight: bold; margin-left: 275px;">Q&amp;A확인</p>
			</div>
			<c:import url="my-account-left-nav.jsp"/>
			<div class="QandA_Contain">
				<div class="reviewDiv">
					<p>
						<font class="reviewTitle">REVIEW</font>&nbsp; <font>내가 작성한 리뷰</font>
					</p>
					<div class="line">
					</div>
					<table class="reviewTable">
						<tr>
							<th>번호</th>
							<th>분류</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회</th>
						</tr>
						<tr>
							<td>1</td>
							<td>리뷰</td>
							<td>으아아악</td>
							<td>정xx</td>
							<td>2020/08/03</td>
							<td>5</td>
						</tr>
						<tr>
							<td>3</td>
							<td>리뷰</td>
							<td>으아아악</td>
							<td>정xx</td>
							<td>2020/08/03</td>
							<td>5</td>
						</tr>
					</table>
				</div>
				
				<div class="QandADiv">
					<p>
						<font class="reviewTitle">Q&amp;A</font>&nbsp; <font>내가 작성한 Q&amp;A</font>
					</p>
					<div class="line">
					</div>
					<table class="reviewTable">
						<tr>
							<th>번호</th>
							<th>분류</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회</th>
						</tr>
						<tr>
							<td>1</td>
							<td>리뷰</td>
							<td>으아아악</td>
							<td>정xx</td>
							<td>2020/08/03</td>
							<td>5</td>
						</tr>
						<tr>
							<td>3</td>
							<td>리뷰</td>
							<td>으아아악</td>
							<td>정xx</td>
							<td>2020/08/03</td>
							<td>5</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- End My Account -->
	<c:import url="footer.jsp" />
</body>
</html>