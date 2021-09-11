<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홍길동님의 미니홈피</title>
</head>
<body>

<%
	// 캐스팅(형변환)
	int cnt=(Integer)application.getAttribute("cnt"); // 에플리케이션 객체에 저장된 값;
	cnt++;
	application.setAttribute("cnt",cnt);
%>

<h2>투데이 방문자 수: <%= cnt %></h2>
</body>
</html>