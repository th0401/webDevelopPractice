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
<showAllItems:pickItem />,<showAllItems:pickCnt />입니다.<br>
<showAllItems:showResult />입니다.

</body>
</html>