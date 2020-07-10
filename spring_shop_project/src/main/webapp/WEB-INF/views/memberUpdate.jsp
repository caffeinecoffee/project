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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<c:if test="${mRole==null}">
	<c:import url="Top.jsp"/>
</c:if>
<c:if test="${mRole=='admin'}">
	<c:import url="./admin/adminTop.jsp" />
</c:if>
	<form action="memberUpdatePro" name="register" method="post">
		<table>
			<tr>
				<th colspan="2">회원가입</th>
				<!-- 첫번째 줄 시작 -->
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" placeholder="아이디를 입력하시오." name="mem_id" id="id" title="아이디" value="${mvo.mem_id}" readOnly />
				<font id="warning" size="2" color="red" ></font></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" placeholder="패스워드를 입력하시오." name="m_passwd" id="passwd1" title="패스워드" value="" class="chk" /></td>
			</tr>
			<tr>
				<td>패스워드 확인</td>
				<td><input type="password" placeholder="패스워드를 입력하시오." name="m_passwd2" id="passwd2" title="패스워드 확인" value="" class="chk" />
				<font name="check" color="red"></font></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" placeholder="이름를 입력하시오." name="m_name" id="name" title="이름" value="${mvo.m_name}" class="chk" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" placeholder="이메일를 입력하시오." name="m_email" id="e_mail" title="이메일" value="${mvo.m_email}" class="chk" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" placeholder="전화번호를 입력하시오." name="m_phone" id="phone" title="전화번호" value="${mvo.m_phone}" class="chk" /></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="zipcode" id="sample6_postcode" value="${mvo.zipcode}" readonly placeholder="우편번호를 검색하시오.">
				<input type="button" onclick="zipCheck()" class="chk" title="우편번호" value="우편번호 찾기">
				</td>
				
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" placeholder="주소를 입력하시오." name="address" id="sample6_address" title="주소" value="${mvo.address}" class="chk" size="40" />
				<input type="text" placeholder="주소를 입력하시오." name="address2" id="sample6_address2" title="주소" value="${mvo.address2}" class="chk" size="40" /></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><select name="m_job">
						<option value="선택안함">직업선택</option>
						<option value="회사원">회사원</option>
						<option value="연구전문직">연구전문직</option>
						<option value="교수">교수</option>
						<option value="자영업">자영업</option>
						<option value="공무원">공무원</option>
						<option value="의료인">의료인</option>
						<option value="법조인">법조인</option>
						<option value="종교,언론/예술인">종교,언론/예술인</option>
						<option value="농/축/수산/광업인">농/축/수산/광업인</option>
						<option value="주부">주부</option>
						<option value="학생">학생</option>
						<option value="무직">무직</option>
						<option value="기타">기타</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" id="register_submit" value="정보수정" class="" />
					<input type="submit" id="register_withdrawal_submit" value="탈퇴" class="" />
					<input type="reset" value="다시쓰기" class="" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><c:import url="Bottom.jsp" /></td>
			</tr>
		</table>
	</form>
</body>
</html>