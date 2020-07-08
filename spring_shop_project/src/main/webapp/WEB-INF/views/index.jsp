<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
	<c:if test="${}">
		<c:import url="Top.jsp" />
		<br>
	</c:if>
	<c:if test="${message!=null}">
		<script type="text/javascript">
			alert('${message}');
		</script>
	</c:if>
	<c:import url="Bottom.jsp" />
</body>
</html>