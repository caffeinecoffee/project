<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	<c:if test="${mRole==null}">
		<c:import url="Top.jsp" />
	</c:if>
	<c:if test="${mRole=='admin'}">
		<c:import url="./admin/adminTop.jsp" />
	</c:if>
	<c:choose>
		<c:when test="${list.size()==0}">
			<table>
				<tbody>
					<tr>
						<th><strong>장바구니가 비있습니다.</strong></th>
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:when test="${list.size()!=0}">
			<table>
				<thead>
					<tr>
						<th>제품</th>
						<th>수량</th>
						<th>가격</th>
						<th>수정/삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ovo" items="${list}">
						<input type="hidden" id="no" name='no' value="${ovo.no }">
						<tr>
							<td><c:out value="${ovo.name}" /></td>
							<td><c:out value="${ovo.QUANTITY}" /></td>
							<td><c:out value="${ovo.price}" /></td>
							<td><input type="hidden" name="no" id="no" /> <input
								type="hidden" name="no" id="no" /></td>
							<td><a href="javascript:productDetail('${pvo.no}')">상세보기</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td>총 금액 : <c:out value=""/>원</td>
						<td><a href="javascript:productDetail('${pvo.no}')">상세보기</a></td>
					</tr>
				</tbody>
			</table>
		</c:when>
	</c:choose>

	<form name="product" action="" method="post">
		<input type="hidden" name="no" id="no" />
	</form>

	<c:if test="${mRole==null}">
		<c:import url="Bottom.jsp" />
	</c:if>
	<c:if test="${mRole=='admin'}">
		<c:import url="admin/adminBottom.jsp" />
	</c:if>
</body>
</html>