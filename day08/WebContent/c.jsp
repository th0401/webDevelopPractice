<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <%@ taglib tagdir= "/WEB-INF/tags" prefix= "showAllItems" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="d.jsp" method="post">

	<showAllItems:showItem name="item"/>
	<showAllItems:showCnt name="cnt"/>
	<input type="submit" value="주문하기">
	
</form>

</body>
</html>