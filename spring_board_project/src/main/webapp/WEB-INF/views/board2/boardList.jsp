<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/boardScript.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
<script type="text/javascript">
function callContent(num){
	//alert(num);
	document.content.num.value=num;
	document.content.submit();
}
</script>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h3>게시글 목록</h3>
	<c:choose>
		<c:when test="${list.size()==0}">
			<table border="1" class="zero">
				<tbody class="class02">
					<tr>
						<th><strong>게시글이 없습니다.</strong></th>
					</tr>
				</tbody>
			</table>
		</c:when>
		<c:when test="${list.size()!=0}">
			<table border="1">
				<thead class="class01">
						<td colspan="5"><strong>전체 글 개수:<c:out value="${pvo.allCount} "> </c:out>건</strong></td>
					<tr>
						<th>글번호</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody class="class02">
					<c:forEach var="bvo" items="${list}">
						<tr>
							<td><c:out value="${bvo.rr}" /> <input type="hidden"
								value='<c:out value="${bvo.num}" />'></td>

							<c:if test="${bvo.re_level==1}">
								<td align="left"><a
									href='#' onclick="javascript:callContent('<c:out value="${bvo.num}"/>')"> <c:out
											value="${bvo.subject}" />
								</a></td>
							</c:if>
							<c:if test="${bvo.re_level>1}">
								<td align="left">
								<img src="/resources/images/level.gif" width="${bvo.re_level*5}">
								<img src="/resources/images/re.gif">
								<a href='#' onclick="javascript:callContent('<c:out value="${bvo.num}"/>')"> <c:out
											value="${bvo.subject}" />
								</a></td>
							</c:if>
							<td><a href='mailto:<c:out value="${bvo.email}"/>'> <c:out
										value="${bvo.writer}" />
							</a></td>
							<td><c:out value="${bvo.reg_date}" /></td>
							<td><c:out value="${bvo.readcnt}" /></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="right"><a href="writeForm.sp">
						<input type="button" value="글쓰기"></a></td>
					</tr>
				</tbody>
			</table>
			<table>
				<h1 style="text-align: center">
				<a href="/boardList.sp?currentPage=1"> [start] </a>
				<c:if test="${pvo.currentPage!=1}"><a href="/boardList.sp?currentPage=${pvo.currentPage-1}"> < </c:if></a>
				<c:forEach var="i" begin="${pvo.startPage}" end="${pvo.endPage}">
					<c:if test="${pvo.currentPage==i}"><a href="/boardList.sp?currentPage=${i}"><span style="color: red"><c:out value="[${i}]"/></span></a></c:if>
					<c:if test="${pvo.currentPage!=i}"><a href="/boardList.sp?currentPage=${i}"><c:out value="[${i}]"/></a></c:if>
				</c:forEach>
				<c:if test="${pvo.currentPage!=pvo.endPage}"><a href="/boardList.sp?currentPage=${pvo.currentPage+1}"> > </c:if></a>
				<a href="/boardList.sp?currentPage=${pvo.allPage}"> [end] </a>
				</h1>
			</table>
		</c:when>
	</c:choose>
	<!-- 해당 리스트를 출력 jstl 사용-->
	<form action="content.sp" name="content" method="post">
		<input type="hidden" name="num" value=''>
		<input type="hidden" name="currentPage" value='${pvo.currentPage}'>
	</form>
</body>
</html>