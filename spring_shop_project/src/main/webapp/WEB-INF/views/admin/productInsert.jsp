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
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<c:import url="adminTop.jsp"/>
	<form action="productInsertPro" name="productInsert" method="post">
		<table>
			<tr>
				<th colspan="2">상품 등록</th>
			</tr>
			<tr>
				<td>상품 이름</td>
				<td><input type="text" name="name" id="name" title="아이디" value="" class="chk" />
				<font id="warning" size="2" color="red" ></font></td>
			</tr>
			<tr>
				<td>상품 설명</td>
				<td><textarea type="password" name="detail" id="detail" title="설명" value="" class="chk" ></textarea></td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td><input type="text" name="price" id="price" title="가격" value="" class="chk" />
				<font name="check" color="red"></font></td>
			</tr>
			<tr>
				<td>상품 수량</td>
				<td><input type="text" name="stock" id="stock" title="수량" value="" class="chk" /></td>
			</tr>
			<tr>
				<td>이미지 첨부</td>
				<td><input type="file" name="image" id="image" title="이미지" value=""/></td>
			</tr>
			<tr>
				<td><input type="submit" name="productInsertPro" value="등록"/></td>
			</tr>
			<tr>
				<c:import url="adminBottom.jsp" />
			</tr>
		</table>
	</form>
</body>
</html>