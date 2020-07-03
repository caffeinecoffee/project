<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery_member.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
</head>
<body>
	<h3>회원 목록</h3>
	<c:choose>
		<c:when test="${list.size()==0}">
			<table border="1" class="zero">
				<tbody class="class02">
					<tr>
						<th><strong>회원정보가 없습니다.</strong></th>
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:when test="${list.size()!=0}">
			<table border="1">
				<thead class="class01">
						<td colspan="7"><strong>회원수:<c:out value="${list.size()} "> </c:out>건</strong></td>
					<tr>
						<th>아이디</th>
						<th>회원이름</th>
						<th>회원 전화번호</th>
						<th>회원생일</th>
						<th>가입일</th>
						<th>이메일</th>
						<th>성별</th>
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
							<c:if test="${fn:contains(mvo.memGender, 'M')}"><c:out value='남성'/></c:if>
							<c:if test="${fn:contains(mvo.memGender, 'F')}"><c:out value='여성'/></c:if>
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
	<!-- 해당 리스트를 출력 jstl 사용-->
	<form action="memberInformation.sa" name="memberInformation" method="post">
		<input type="hidden" name="memSeq" value=''>
		<input type="hidden" name="currentPage" value='${pvo.currentPage}'>
	</form>
</body>
</html>