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
<link rel="stylesheet" href="/resources/css/InformationUpdate.css">

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
<script src="/resources/js/infomationUpdate.js"></script>

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
			<div style="width: 100%; height: 65px; margin-bottom: 30px;">
				<p style="font-size: 35px; font-weight: bold; margin-left: 275px;">회원정보
					수정</p>
			</div>
			<c:import url="my-account-left-nav.jsp"/>
			<div class="informationUpdateTableContain">
				<table class="informationUpdateTable">
					<tr>
						<th>이름</th>
						<td colspan="2">${mdto.mem_name}</td>
					</tr>
					<tr>
						<th>아이디</th>
						<td colspan="2">${mdto.mem_id }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td colspan="2"><font id="mem_email">${mdto.mem_email }</font>
						<p class="updateBtn">
							<a class="updateBtnText" id="emailUpdateBtnText">이메일 변경</a>
						</p>
						
						<div class="emailChangeDiv">
								<form class="emailChangeForm">
									<input type="text" size="7" class="email" id="email_id"> @ <input type="text" size="10" id="email_address" class="email"> 
									<p class="emailUpdateBtn">
										<a class="emailUpdateBtnText" id="emailChange">변경</a>
									</p>
									<p id="emailMsg"></p>
								</form>
						</div>
						</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td><font id="mobileNum">${mdto.mem_mobile }</font>
							<p class="updateBtn">
								<a class="updateBtnText" id="telUpdateBtnText">번호 변경</a>
							</p>
							<div class="phoneChangeDiv">
								<form class="phoneChangeForm">
								<input type="text" size="5" class="tel" id="tel1"> - <input type="text" size="5" class="tel" id="tel2"> - <input type="text" size="5" class="tel" id="tel3"> 
								<p class="telUpdateBtn">
									<a class="telUpdateBtnText" id="telUpdateBtn">변경</a>
								</p>
								<p id="telMsg"></p>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" placeholder="현재 비밀번호" class="pwd" id="currentPw"><br>
							<input type="password" placeholder="변경할 비밀번호" class="pwd" id="changePw1"><br> <input
							type="password" placeholder="변경할 비밀번호 확인" class="pwd" id="changePw2">
							<p class="pwdUpdateBtn">
								<a class="updateBtnText" id="udatePwdBtn">비밀번호 변경</a>
							</p>
							<p id="pwMsg"></p>
							</td>
					</tr>
					<tr>
						<th>배송지</th>
						<td>
							<p class="addressP"><input type="text" value="${mdto.mem_zipcode }" id="zipcode"class="adress" readonly="readonly"></p>
							<p class="zipCheckUpdateBtn">
								<a class="zipCheckBtnText" onclick="zipCheck()">우편번호 변경</a>
							</p>
							<p class="addressP"><input type="text" value="${mdto.mem_address }" id="address1"class="address" readonly="readonly" style="width: 300px;"></p>
							<p class="addressP"><input type="text" value="${mdto.mem_address_detail }" id="address2" class="address" placeholder="상세주소를 입력해주세요." style="width: 220px;"></p>
							<p class="addressUpdateBtn">
								<a class="addressUpdateBtnText">주소 변경</a>
							</p>
							<p class="addressMsg">
							
							</p>
						</td>
					</tr>
				</table>
				<p class="updateCancelBtn">
					<a href="InformationCheck" class="updateCancelText">변경 취소</a>
				</p>
				</div>
		</div>
	</div>
	<!-- End My Account -->
	<c:import url="footer.jsp" />
</body>
</html>