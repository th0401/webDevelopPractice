<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="day04.*"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="memberDAO" class="day04.MemberDAO" scope= "application"/>
    <jsp:setProperty property="*" name="memberDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원리스트</h2>
<hr>

	<table border="1">
		<tr>
			<td>아이디</td><td>비밀번호</td><td>이름</td>
			</tr>
			<%
			for(MemberVO vo : memberDAO.getDatas()){
							
			%>
		<tr>
			<td><%=vo.getUserID() %></td>
			<td><%=vo.getUserPW() %></td>
			<td><%=vo.getUserName() %></td>
		</tr>
		<%
		} 
		%>
	</table>
<a href="NewFile.html">로그인창가기</a>
</body>
</html>