<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워딩방식</title>
</head>
<body>

<jsp:forward page="result.jsp">
	<jsp:param value="coding_helper@naver.com" name="email"/>
</jsp:forward>

</body>
</html>