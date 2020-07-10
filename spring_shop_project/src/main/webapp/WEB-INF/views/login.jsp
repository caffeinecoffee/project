<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/main.js"></script>
<!--autoload=false 파라미터를 이용하여 자동으로 로딩되는 것을 막습니다.-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<c:import url="Top.jsp"/>
	<form action="loginPro" name="login" method="post">
		<table>
			<tr>
				<th colspan="2">로그인</th>
				<!-- 첫번째 줄 시작 -->
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" placeholder="아이디를 입력하시오." name="mem_id" id="log_id" title="아이디" value="" class="chk" />
				<font id="warning" size="2" color="red" ></font></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" placeholder="패스워드를 입력하시오." name="m_passwd" id="log_passwd" title="패스워드" value="" class="chk" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" id="login_submit" value="login" class="" />
					<input type="reset" value="reset" class="" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><c:import url="Bottom.jsp" /></td>
			</tr>
		</table>
	</form>
</body>
</html>