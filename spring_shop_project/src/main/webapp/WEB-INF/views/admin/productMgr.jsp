<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/main.js"></script>
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
	<c:import url="adminTop.jsp" />

	<form action="/productIns" method="post" name="/productInsert">
		<c:choose>
			<c:when test="${list.size()==0}">
				<table>
					<tbody>
						<tr>
							<th><strong>상품이 없습니다.</strong></th>
						</tr>
					</tbody>
				</table>
			</c:when>
			<c:when test="${list.size()!=0}">
				<table>
					<thead>
						<tr>
							<th>이름</th>
							<th>가격</th>
							<th>날짜</th>
							<th>재고</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pvo" items="${list}">
							<tr>
								<td><c:out value="${pvo.name}" /></td>
								<td><c:out value="${pvo.price}" /></td>
								<td><c:out value="${pvo.pr_date}" /></td>
								<td><c:out value="${pvo.stock}" /></td>
								<td><a href="javascript:productDetail('${pvo.no}')">상품 수정</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td><a href="productInsert" >상품등록</a></td>
						</tr>
					</tbody>
				</table>
			</c:when>
		</c:choose>
	</form>
	<c:import url="adminBottom.jsp" />
</body>
</html>