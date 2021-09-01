<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.MessageVO, java.util.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시글 목록</h2>
<hr>
<a href="form.jsp">글 등록</a>
<hr>
<table border ="1">
	<tr>
		<td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td>		
	</tr>
	
	<%
	for(MessageVO vo:(ArrayList<MessageVO>)datas){
	
	
	%>
	<tr>
		<td><a href="control.jsp?action=edit&mnum=<%=vo.getMnum() %>"><%=vo.getMnum() %></a></td>
		<td><%=vo.getTitle() %></td>
		<td><%=vo.getWriter() %></td>
		<td><%=vo.getWdate() %></td>
	</tr>	
	<%
	}
	%>			
	
</table>
</body>
</html>