<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
		<c:when test="${uVO==null}">
			<form action="control.jsp?action=login" method="post">	
			<input type="hidden" name="mcnt" value="${mcnt}">		
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userID"
							placeholder="아이디를 입력하세요."></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userPW"
							placeholder="비밀번호를 입력하세요."></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit"
							value="로그인하기"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><button onclick="signUp()">회원가입</button></td>
					</tr>
				</table>
			</form>
		</c:when>
	</c:choose>