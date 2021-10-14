<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member123.*"%>
    
<%
	String id= request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Member123VO vo= new Member123VO();
	vo.setId(id);
	vo.setPw(pw);
	
	Member123DAO dao = new Member123DAO();
	Member123VO data = dao.getMember(vo);
	if(data!=null){
		response.sendRedirect("main.jsp");
	}
	else{
		response.sendRedirect("index.jsp");
	}
%>