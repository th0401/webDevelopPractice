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

<form action="Prac2.jsp" method="post">
<jsp:useBean id="data" class ="model.Prac1Bean" scope="session"/>
	<select name="item">
	<%
	for(String v : data.getItem()){
	%>
		<option><%=v %></option>
	<%
	}
	
		%>	
	</select>
	<select name="cnt">
	<% for(int i = 1; i<11; i++){
		%>
		<option><%=i %></option>
		<%
	}
	%>
	</select>		
	<input type="submit" value="주문하기">
	
</form>

</body>
</html>