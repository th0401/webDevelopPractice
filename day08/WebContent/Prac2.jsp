<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	선택한 제품은 ${param.item},희망갯수는 ${param.cnt}입니다.
	가격은 ${data.calc(param.item,param.cnt)}입니다.
	
	

</body>
</html>