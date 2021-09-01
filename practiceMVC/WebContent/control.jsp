<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.message.*"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="messageDAO" class="model.message.MessageDAO" />    
<jsp:useBean id="messageVO" class="model.message.MessageVO" />
<jsp:setProperty property="*" name="messageVO"/>
<%
	String action=request.getParameter("action");
	

	if(action.equals("list")){
		ArrayList<MessageVO> datas = messageDAO.getDBList();
		request.setAttribute("datas", datas);
		pageContext.forward("list.jsp");
	}
	else if(action.equals("insert")){
		
	}
	else if(action.equals("update")){
		System.out.println(messageVO);
		}
	else if(action.equals("delete")){
	
	}
	else if(action.equals("edit")){
	MessageVO data = messageDAO.getDBData(messageVO);
	request.setAttribute("data", data);
	pageContext.forward("edit.jsp");
	}
	else{
	out.println("파라미터 확인!");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨트롤러</title>
</head>
<body>

</body>
</html>