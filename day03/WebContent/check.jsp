<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
session.setAttribute("userID", request.getParameter("userID"));
if(request.getParameter("userID").equals("관리자")||request.getParameter("userID").equals("admin")){
	response.sendRedirect("admin.jsp");
}else{	
	response.sendRedirect("user.jsp");
}


%>