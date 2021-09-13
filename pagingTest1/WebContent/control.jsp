<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.msg.*,model.user.*"%>
<jsp:useBean id="mDAO" class="model.msg.MessageDAO" />
<jsp:useBean id="rDAO" class="model.msg.ReplyDAO" />
<jsp:useBean id="uDAO" class="model.user.UserDAO" />
<jsp:useBean id="mVO" class="model.msg.MessageVO" />
<jsp:setProperty property="*" name="mVO"/>
<jsp:useBean id="rVO" class="model.msg.ReplyVO" />
<jsp:setProperty property="*" name="rVO"/>
<jsp:useBean id="uVO" class="model.user.UserVO" />
<jsp:setProperty property="*" name="uVO"/>
<%
	String action=request.getParameter("action");
	String url="control.jsp?action=main";	
	String mcntt=request.getParameter("mcnt");
	int mcnt=10;
	if(mcntt!=null){
		mcnt=Integer.parseInt(mcntt);
	}
	url= url+ "&mcnt="+mcnt;
	String selUser=request.getParameter("selUser");
	if(selUser!=null){
		url= url+ "&selUser="+selUser;
	}
			
	if(action.equals("main")){
		ArrayList<MsgSet> datas=mDAO.selectAll(selUser, mcnt);
		ArrayList<UserVO> newUsers=uDAO.selectAll();
		
		request.setAttribute("datas", datas);
		request.setAttribute("newUsers", newUsers);
		request.setAttribute("selUser", selUser);
		request.setAttribute("mcnt", mcnt);
		
		pageContext.forward("main.jsp");
	}
	else if(action.equals("insertMDB")){
		if(mDAO.insert(mVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("MDB 추가중 오류 발생!");
		}
	}
	else if(action.equals("insertRDB")){
		if(rDAO.insert(rVO)){
			response.sendRedirect("control.jsp?action=main");
		}
		else{
			throw new Exception("RDB 추가중 오류 발생!");
		}
	}
%>