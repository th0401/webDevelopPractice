<%@ tag language="java" pageEncoding="UTF-8"%>
<form action="ctrl.jsp?action=login" method="post" name="form1">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userID" required
					placeholder="아이디를 입력하세요."></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPW" required
					placeholder="비밀번호를 입력하세요."></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="로그인하기"></td>
			</tr>
		</table>
	</form>
	<a href="signUp.jsp">회원가입하기</a>