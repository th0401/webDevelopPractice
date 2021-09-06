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
<form action="ctrl.jsp?action=insertM" method="post" name="form1">
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userID" required placeholder="아이디를 입력하세요."></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="userPW" required placeholder="비밀번호를 입력하세요."></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="userName" required placeholder="이름을 입력하세요."></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type= "submit" value="회원가입하기"></td>
	</tr>
</table>
<a href="ctrl.jsp?action=main">게시판으로가기</a>

</form>
</body>
</html>