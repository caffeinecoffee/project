<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emailCheck</title>
<link rel="stylesheet" href="/resources/css/emailCheck.css">
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/emailCheck.js"></script>
</head>
<body>
<c:if test="${mdto == null }">
	<script type="text/javascript">
		location.href="loginPage";
	</script>
</c:if>
	<div>
		<img src="/resources/images/logo.jpg">
		<p class="check_P">
			<input id="checkData" type="text" placeholder="인증번호를 입력하세요">&nbsp;
			<button id="Btn">인증</button>
			<br> <font id="msg"></font>
		</p>
	</div>
</body>
</html>