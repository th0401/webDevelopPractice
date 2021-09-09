<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.bank1.*,model.bank2.*"
    errorPage="error.jsp"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="bank1DAO" class="model.bank1.Bank1DAO"/>
    <jsp:useBean id="bank2DAO" class="model.bank2.Bank2DAO"/>
    <jsp:useBean id="bank1VO" class="model.bank1.Bank1VO" />
    <jsp:setProperty property="*" name="bank1VO"/>
    <jsp:useBean id="bank2VO" class="model.bank2.Bank2VO" />
    <jsp:setProperty property="*" name="bank2VO"/>
<%
	String action=request.getParameter("action");

if(action.equals("selectAll")){
	ArrayList<Bank1VO> datas1 = bank1DAO.getBank1List();
	request.setAttribute("datas1", datas1);
	ArrayList<Bank2VO> datas2 = bank2DAO.getBank2List();
	request.setAttribute("datas2", datas2);
		pageContext.forward("transPrac.jsp");
}
else if(action.equals("deposit1")){
	System.out.println(bank1VO);
	System.out.println(bank2VO);
	System.out.println(Integer.parseInt(request.getParameter("balance")));
	if(bank1DAO.trans(bank1VO,bank2VO,Integer.parseInt(request.getParameter("balance")))){
		out.println("<script>alert('가능!');document.location.href='ctrl.jsp?action=selectAll';</script>");
				
	}
	else{
		out.println("<script>alert('불가능!');document.location.href='ctrl.jsp?action=selectAll';</script>");
			
	}
}
else if(action.equals("deposit2")){
	if(bank2DAO.trans(bank2VO,bank1VO,Integer.parseInt(request.getParameter("balance")))){
		out.println("<script>alert('가능!');document.location.href='ctrl.jsp?action=selectAll';</script>");
				
	}
	else{
		out.println("<script>alert('불가능!');document.location.href='ctrl.jsp?action=selectAll';</script>");
		
	}
}
else{
	throw new Exception("파라미터 확인!");
}
%>