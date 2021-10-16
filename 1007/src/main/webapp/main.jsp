<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.board123.*,java.util.List"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h3><a href="logout.do">로그아웃</a></h3>
<hr>
<h1>${uVO.name}님 안녕하세요!</h1>
<h1>글 목록</h1>
<hr>
	<table border="1">
		<tr>
			<td>글 번호</td><td>글 제목</td><td>글 작성자</td>
		</tr>
		<c:forEach var="v" items="${datas}">
		<tr>
			<td>${v.id}</td><td><a href="getBoard.do?id=${v.id}">${v.title}</a></td><td>${v.writer}</td>
			</tr>
		</c:forEach>
	</table>
<a href="insertBoard.jsp">글작성</a>
</body>
</html>