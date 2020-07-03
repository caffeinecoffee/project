<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery_member.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
</head>
<body>
	<h3>ȸ�� ���</h3>
	<c:choose>
		<c:when test="${list.size()==0}">
			<table border="1" class="zero">
				<tbody class="class02">
					<tr>
						<th><strong>ȸ�������� �����ϴ�.</strong></th>
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:when test="${list.size()!=0}">
			<table border="1">
				<thead class="class01">
						<td colspan="7"><strong>ȸ����:<c:out value="${list.size()} "> </c:out>��</strong></td>
					<tr>
						<th>���̵�</th>
						<th>ȸ���̸�</th>
						<th>ȸ�� ��ȭ��ȣ</th>
						<th>ȸ������</th>
						<th>������</th>
						<th>�̸���</th>
						<th>����</th>
					</tr>
				</thead>
				<tbody class="class02">
					<c:forEach var="mvo" items="${list}"> <!-- varStatus="" -->
						<tr>
							<td><c:out value="${mvo.memId}" />
							<input type="hidden" value='<c:out value="${mvo.memSeq}"/>'>
							</td>

								<td align="left">
								<a href='#' onclick="javascript:callMember('<c:out value="${mvo.memSeq}"/>')">
								<c:out value="${mvo.memName}"/>
								</a>
								</td>
							<td><c:out value="${mvo.memTel}" /></td>
							<td><c:out value="${mvo.memBirth}" /></td>
							<td><c:out value="${mvo.regDate}" /></td>
							<td><a href='mailto:<c:out value="${mvo.memEmail}"/> '>
							<c:out value="${mvo.memEmail}" /></a></td>
							<td>
							<c:if test="${fn:contains(mvo.memGender, 'M')}"><c:out value='����'/></c:if>
							<c:if test="${fn:contains(mvo.memGender, 'F')}"><c:out value='����'/></c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table>
				<h1 style="text-align: center">
				<a href="/JspEx/memberList.sa?currentPage=1"> [start] </a>
				<c:if test="${pvo.currentPage!=1}"><a href="/JspEx/memberList.sa?currentPage=${pvo.currentPage-1}"> < </c:if></a>
				<c:forEach var="i" begin="${pvo.startPage}" end="${pvo.endPage}">
					<c:if test="${pvo.currentPage==i}"><a href="/JspEx/memberList.sa?currentPage=${i}"><span style="color: red"><c:out value="[${i}]"/></span></a></c:if>
					<c:if test="${pvo.currentPage!=i}"><a href="/JspEx/memberList.sa?currentPage=${i}"><c:out value="[${i}]"/></a></c:if>
				</c:forEach>
				<c:if test="${pvo.currentPage!=pvo.endPage}"><a href="/JspEx/memberList.sa?currentPage=${pvo.currentPage+1}"> > </c:if></a>
				<a href="/JspEx/memberList.sa?currentPage=${pvo.allPage}"> [end] </a>
				</h1>
			</table>
		</c:when>
	</c:choose>
	<!-- �ش� ����Ʈ�� ��� jstl ���-->
	<form action="memberInformation.sa" name="memberInformation" method="post">
		<input type="hidden" name="memSeq" value=''>
		<input type="hidden" name="currentPage" value='${pvo.currentPage}'>
	</form>
</body>
</html>