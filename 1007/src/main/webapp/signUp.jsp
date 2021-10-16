<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
</head>
<body>
<h2>회원가입창</h2>
<hr>
<br>
<form action="signUp.do" method="post">
	<table border="1">
	<input type="hidden" name="role" value="USER">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" required></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원가입하기"></td>
			
		</tr>
	</table>
</form>
<a href="index.jsp">돌아가기</a>
</body>
</html>