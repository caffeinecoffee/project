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
						<th><strong>��ǰ�� �����ϴ�.</strong></th>
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:when test="${list.size()!=0}">
			<table>
				<thead>
					<tr>
						<th>�̸�</th>
						<th>����</th>
						<th>��¥</th>
						<th>���</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pvo" items="${list}">
						<input type="hidden" id="no" name='no' value="${pvo.no }">
						<tr>
							<td><c:out value="${pvo.name}" /></td>
							<td><c:out value="${pvo.price}" /></td>
							<td><c:out value="${pvo.pr_date}" /></td>
							<td><c:out value="${pvo.stock}" /></td>
							<c:if test="${mRole=='admin'}">
								<td><a href="javascript:productDetail('${pvo.no}')">��ǰ ����</a></td>
							</c:if>
							<c:if test="${mRole==null}">
								<td><a href="javascript:productBasket('${pvo.no}')">��ٱ���
										���</a></td>
							</c:if>
						</tr>
					</c:forEach>
					<tr>
						<td><a href="productInsert">��ǰ���</a></td>
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