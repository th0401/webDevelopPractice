<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실습!</title>
</head>
<body>
<%
	session.invalidate(); // 세션 정보 해제
	if(application.getAttribute("cnt")==null){
		application.setAttribute("cnt", 0);
	}
	
%>

<h2> store 로그인실습창</h2>

<form action="check.jsp" method="post" name= "form1">
	<input type="text" name="userID" required placeholder="아이디를 입력하세요.">
	<input type="submit" value="로그인 하기">
</form>

</body>
</html>