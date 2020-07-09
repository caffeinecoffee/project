<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/../resources/js/main.js"></script>
</head>
<body>
<!-- <c:import url="Top.jsp"/> -->
	<form action="/admin/loginpro" name="admin_login" method="post">
		<table>
			<tr>
				<th colspan="2">로그인</th>
				<!-- 첫번째 줄 시작 -->
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" placeholder="아이디를 입력하시오." name="admin_id" id="log_id" title="아이디" value="" class="chk" />
				<font id="warning" size="2" color="red" ></font></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" placeholder="패스워드를 입력하시오." name="admin_passwd" id="log_passwd" title="패스워드" value="" class="chk" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" id="admin_login_submit" value="login" class="" />
					<input type="reset" value="reset" class="" />
				</td>
			</tr>
			<tr>
<!-- 				<td colspan="2"><c:import url="Bottom.jsp" /></td> -->
			</tr>
		</table>
	</form>
</body>
</html>