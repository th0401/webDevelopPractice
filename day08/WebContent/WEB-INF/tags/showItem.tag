<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="name" %>

<jsp:useBean id="pBean" class= "model.Prac1Bean" scope="session"/>
<select name="${name}">
	<%
	for(String v : pBean.getItem()){
	%>
		<option><%=v %></option>
	<%
	}
	
		%>	
	</select>