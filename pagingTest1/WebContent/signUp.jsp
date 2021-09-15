<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</script>
</head>
<body>
<div style="text-align:center;">
<h2>회원가입하기</h2>
<br>
<form style="display:inline-block;" action="control.jsp?action=signUp" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userID" placeholder="아이디를 입력하세요." required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPW" placeholder="비밀번호를 입력하세요." required></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" placeholder="이름을 입력하세요." required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>