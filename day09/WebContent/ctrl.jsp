<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.login.*"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="loginDAO" class="model.login.LoginDAO"/>
    <jsp:useBean id="loginVO" class="model.login.LoginVO" />
    <jsp:setProperty property="*" name="loginVO"/>
<%
	
	String action=request.getParameter("action");

	if(action.equals("main")){		
		pageContext.forward("main.jsp");
	}
	else if(action.equals("login")){
		loginVO =loginDAO.selectOne(loginVO);
		System.out.println(loginVO);
		if(loginVO==null){
			out.println("<script>alert('로그인 실패');history.go(-1)</script>");
		}else{
			session.setAttribute("loginVO", loginVO);
			response.sendRedirect("ctrl.jsp?action=main");
		}
	}
		else if(action.equals("logout")){
			session.invalidate();
			response.sendRedirect("ctrl.jsp?action=main");
		}
			
		
		
	
	%>