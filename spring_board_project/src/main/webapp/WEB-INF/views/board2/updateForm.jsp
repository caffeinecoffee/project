<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/boardScript.js"></script>
<script type="text/javascript" src="/resources/js/jquery_board.js"></script>
<link href="/resources/css/board.css" rel="stylesheet">
</head>
<body>
   <form action="updatePro.sp" method="post" name="writeForm" enctype="multipart/form-data" onsubmit="return sendData()">
      <table>
         <thead>
            <tr>
               <th colspan="2"><h4>글수정</h4></th>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" placeholder="제목을 입력하세요" name="subject" value='${bvo.subject}'/></td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea type="text" cols="100" rows="20"
                     placeholder="내용을 입력하세요" name="content"><c:out value='${bvo.content}'/></textarea></td>
            </tr>
            <tr>
               <th>첨부파일</th>
               <td><input type="file" name="afile" value='<c:out value="${bvo.attachNm}"/>'/></td>
            </tr>
            <tr>
               <th>작성자</th>
               <td><input type="text" placeholder="작성자를 입력하세요" name="writer" value="${bvo.writer}"/></td>
            </tr>
            <tr>
               <th>이메일</th>
               <td><input type="email" placeholder="이메일 입력" name="email" value='<c:out value="${bvo.email}"/>'/></td>
            </tr>
            <tr>
               <th>비밀번호</th>
               <td><input type="password" placeholder="비빌번호 입력" name="passwd" /></td>
               <td><input type="hidden" name="num" value="<c:out value='${bvo.num}'/>" /></td>
               <td><input type="hidden" name="currentPage" value="<c:out value='${pvo.currentPage}'/>" /></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
               <input id="submit_article" type="submit" value="글 수정" />
               <input type="button" value="글목록으로..." onclick="javascript:location.href='boardList.sp'" />
            </tr>
         </thead>
      </table>
   </form>
</body>
</html>