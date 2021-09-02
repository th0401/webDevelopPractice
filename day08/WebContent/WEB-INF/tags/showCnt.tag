<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="name" %>

<jsp:useBean id="pBean" class="model.Prac1Bean" scope="session"/>
<select name="${name}">
	<% for(int i = 1; i<11; i++){
		%>
		<option><%=i %></option>
		<%
	}
	%>
	</select>		