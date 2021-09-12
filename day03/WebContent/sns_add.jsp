<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 등록 페이지</title>
</head>
<body>

<h3>상품목록창!</h3>

<%
	request.setCharacterEncoding("UTF-8"); // 한글로받기 가능하게함	
	String msg= request.getParameter("msg"); // 
	String username=(String)session.getAttribute("username");
	// 세션에
	ArrayList<String> msgs=(ArrayList<String>)application.getAttribute("msgs");
	if(msgs==null){
		//최초등록
		msgs=new ArrayList<String>();
		application.setAttribute("msgs", msgs);
	}
	msgs.add(username+"님이 ["+msg+"] 등록");
	
	
	response.sendRedirect("sns_login.jsp");
	
%>


</body>
</html>