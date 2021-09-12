<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="lb" class="day04.LoginBean" />
    <jsp:setProperty property="*" name="lb" />
    <%
    
    	if(lb.check()){
    		// 로그인성공
    		out.println("<h1>로그인 성공!</h1>");
    	}else{
    		//로그인 실패
    		out.println("<h1>로그인 실패ㅠ</h1>");
    	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

입력한 아이디: <jsp:getProperty property="userID" name="lb"/><br>
<!-- 나중가면 getProperty는 잘 안씀 이유는 tostring으로 대신 쓰기때문 즉 표현식으로 하는편 -->
입력한 패스워드 : <jsp:getProperty property="userPW" name="lb"/>



</body>
</html>