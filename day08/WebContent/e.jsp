<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="f.jsp" method="post" name="form1">
<table border ="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" placeholder="아이디를 입력하세요"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw" placeholder="비밀번호를 입력하세요"></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="로그인하기"></td>
	</tr>
</table>
</form>
</body>
</html>