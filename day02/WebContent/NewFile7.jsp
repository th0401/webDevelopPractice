<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 내장객체</title>
</head>
<body>

<%

	if(session.isNew()){ // 세션이 새로운겁니까?
		out.println("<script>alert('세션을 설정함!')</script>");
	session.setAttribute("user", "coding_helper"); // 어떤 value를 이 name으로 저장하기
	session.setMaxInactiveInterval(10);
	// coding_helper라는 사람이
	// user라는 변수명(이름)으로 등록됨
	// 세션단위로 등록됨!
	// == 브라우저가 종료되지않는한, 사라지지 않는다!
	// == 시간개념, 30분(==1800초)
	}
%>


<%= session.getAttribute("user") %>님, 환영합니다! <br>
<%= session.getMaxInactiveInterval() %> 초동안 세션정보가 유지됩니다. <br>
</body>
</html>