<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="login.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" required></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right"><input type="submit" value="로그인"></td>
			
			
		</tr>
	</table>
</form>
<a href="signUp.jsp">회원가입</a>
</body>
</html>