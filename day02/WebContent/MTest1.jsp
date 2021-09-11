<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습</title>
<style type="text/css">
p{
font-size: 32px;
}
.red{
color:red;
}
.blue{
color:blue;
}
</style>
</head>
<body>

<%
	for(int i = 1; i<11; i++){
		if(i%2==0){   // 짝수일때
			out.println("<p class = 'blue'>" + i + "</p>");
		}else{     // 홀수일때
			out.println("<p class = 'red'>" + i + "</p>");
		}
	}
%>
</body>
</html>