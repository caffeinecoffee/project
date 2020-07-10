<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/main.js"></script>
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<c:import url="adminTop.jsp" />
   <table>
      <thead>
         <tr>
            <th>회원아이디</th>
            <th>회원이름</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>주소</th>
            <th>수정</th>
         </tr>
      </thead>
      <tbody>
      <c:forEach var="member" items="${list}">
         <tr>
            <td><c:out value="${member.mem_id}"/></td>
            <td><c:out value="${member.m_name}"/></td>
            <td><c:out value="${member.m_phone}"/></td>
            <td><c:out value="${member.m_email}"/></td>
            <td><c:out value="(${member.zipcode})${member.address} ${member.address2}"/></td>
            <td><a href="javascript:Update('${member.mem_id}')">수정하기</a></td>
         </tr>
      </c:forEach>
      </tbody>
   </table>
   <form name="AdminMemberUpdate" action="memberUpdate" method="post">
   <input type="hidden" name="mem_id" id="mem_id"/>
   </form>
<c:import url="adminBottom.jsp" />
</body>
</html>