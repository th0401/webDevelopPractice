<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,model.test.TestVO"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="testDAO" class="model.test.TestDAO" />
<jsp:useBean id="testVO" class="model.test.TestVO" />
<jsp:setProperty property="*" name="testVO" />
<%

String action=request.getParameter("action");

if(action.equals("selectAll")){
	ArrayList<TestVO> datas = testDAO.selectAll();
	request.setAttribute("datas", datas);
		pageContext.forward("practice1.jsp");
}
else if(action.equals("selectOne")){
	ArrayList<TestVO> datas = testDAO.selectOne(testVO);
	request.setAttribute("datas", datas);
		pageContext.forward("practice1.jsp");
		
}
else if(action.equals("insert")){
	if(testDAO.insertDB(testVO)){
		response.sendRedirect("ctrl.jsp?action=selectAll");
	}
	else{
		throw new Exception("DB 추가중 오류 발생!");
	}
}
else if(action.equals("update")){
	if(testDAO.updateDB(testVO)){
		response.sendRedirect("ctrl.jsp?action=selectAll");		
	}
	else{
		throw new Exception("DB 변경중 오류 발생!");
	}
}
else if(action.equals("delete")){
	if(testDAO.deleteDB(testVO)){
		response.sendRedirect("ctrl.jsp?action=selectAll");		
	}
	else{
		throw new Exception("DB 삭제중 오류 발생!");
	}
}
%>