<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/boardScript.js"></script>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
</head>
<body>
	<form action="updateForm.sp">
		<table>
			<tr>
				<td>비밀번호 입력</td>
				<td><input type="password" id="pwCheck"/></td>
			</tr>
			<tr>
				<td><input type="button" value="확인" onclick="setParentText();"></td>
				<td><input type="button" value="닫기" onclick="window.close();"></td>
			</tr>
		</table>
	</form>
</body>
</html>