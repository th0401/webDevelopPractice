<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.MemberVO"%>
     <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보변경창</title>
</head>
<body>
<h2>회원정보변경</h2>
<hr>

<form action="ctrl.jsp?action=updateM" method="post" name="form1">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="hidden" name="userID" value="${memberVO.userID}">${memberVO.userID}</td> 
		<!-- 아이디는 pk라 못바꿈 그냥 받아온값보여줌 -->
		
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="userPW" required placeholder="비밀번호를 입력하세요." value="${memberVO.userPW}"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="userName" required placeholder="이름을 입력하세요." value="${memberVO.userName}"></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type= "submit" value="회원정보변경"></td>
	</tr>
</table>
</form>

<a href="ctrl.jsp?action=main">게시판으로가기</a>
</body>
</html>