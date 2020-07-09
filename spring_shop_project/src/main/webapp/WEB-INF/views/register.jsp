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
<script>
    function zipCheck() {
        new daum.Postcode(
                {
                    oncomplete : function(data) {
                        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                        var fullAddr = ''; // 최종 주소 변수
                        var extraAddr = ''; // 조합형 주소 변수
 
                        // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                            fullAddr = data.roadAddress;
 
                        } else { // 사용자가 지번 주소를 선택했을 경우(J)
                            fullAddr = data.jibunAddress;
                        }
 
                        // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                        if (data.userSelectedType === 'R') {
                            //법정동명이 있을 경우 추가한다.
                            if (data.bname !== '') {
                                extraAddr += data.bname;
                            }
                            // 건물명이 있을 경우 추가한다.
                            if (data.buildingName !== '') {
                                extraAddr += (extraAddr !== '' ? ', '
                                        + data.buildingName : data.buildingName);
                            }
                            // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                            fullAddr += (extraAddr !== '' ? ' (' + extraAddr
                                    + ')' : '');
                        }
 
                        // 우편번호와 주소 정보를 해당 필드에 넣는다.
                        document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                        document.getElementById('sample6_address').value = fullAddr;
 
                        // 커서를 상세주소 필드로 이동한다.
                        document.getElementById('sample6_address2').focus();
                    }
                }).open();
    }
</script>
<link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<c:import url="Top.jsp"/>
	<form action="registerPro" name="register" method="post">
		<table>
			<tr>
				<th colspan="2">회원가입</th>
				<!-- 첫번째 줄 시작 -->
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" placeholder="아이디를 입력하시오." name="mem_id" id="re_id" title="아이디" value="" class="chk" />
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
				<td><input type="text" placeholder="이름를 입력하시오." name="m_name" id="name" title="이름" value="" class="chk" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" placeholder="이메일를 입력하시오." name="m_email" id="e_mail" title="이메일" value="" class="chk" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" placeholder="전화번호를 입력하시오." name="m_phone" id="phone" title="전화번호" value="" class="chk" /></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="zipcode" id="sample6_postcode" readonly placeholder="우편번호를 검색하시오.">
				<input type="button" onclick="zipCheck()" class="chk" title="우편번호" value="우편번호 찾기">
				</td>
				
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" placeholder="주소를 입력하시오." name="address" id="sample6_address" title="주소" value="" class="chk" size="40" />
				<input type="text" placeholder="주소를 입력하시오." name="address2" id="sample6_address2" title="주소" value="" class="chk" size="40" /></td>
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
					<input type="submit" id="register_submit" value="회원가입" class="" />
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