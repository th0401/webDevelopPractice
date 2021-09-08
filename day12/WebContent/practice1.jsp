<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>testList</h2>
	<br>
	<table border="1">
		<c:forEach var="v" items="${datas}">
			<tr>
				<td>이름</td>
				<td>${v.name}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${v.email}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="ctrl.jsp?action=selectAll">전체글보기</a>
	
	<hr>
	<h2>insert</h2>
	<br>

	<form action="ctrl.jsp?action=insert" method="post" name="form1">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="정보넣기"></td>
			</tr>
		</table>
	</form>
	<hr>
	<h2>update</h2>
	<br>
	<form action="ctrl.jsp?action=update" method="post" name="form1">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="정보변경"></td>
			</tr>
		</table>
	</form>
	<hr>
	<h2>delete</h2>
	<br>
	<form action="ctrl.jsp?action=delete" method="post" name="form1">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="정보삭제"></td>
			</tr>
		</table>
	</form>
	<hr>
	<h2>한명의 정보만보기</h2>
	<br>
	<form action="ctrl.jsp?action=selectOne" method="post" name="form1">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="submit" value="정보보기"></td>
			</tr>
		</table>
	</form>
</body>
</html>