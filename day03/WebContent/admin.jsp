<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
<%
	// 캐스팅(형변환)
	int cnt=(Integer)application.getAttribute("cnt"); // 에플리케이션 객체에 저장된 값;
	application.setAttribute("cnt",cnt);
	
%>

<h2>총 결제수: <%= cnt %></h2>
<hr>
<a href="index.jsp">처음으로 돌아가기</a>
</body>
</html>