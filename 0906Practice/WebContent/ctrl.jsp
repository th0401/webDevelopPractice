<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.member.MemberVO,java.util.ArrayList,model.post.*"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="memberDAO" class="model.member.MemberDAO"/>
    <jsp:useBean id="memberVO" class="model.member.MemberVO"/>
    <jsp:setProperty property="*" name="memberVO"/>
    <jsp:useBean id="postDAO" class="model.post.PostDAO" />
    <jsp:useBean id="postVO" class="model.post.PostVO" />
    <jsp:setProperty property="*" name="postVO"/>
<%
String action=request.getParameter("action");

if(action.equals("main")){
	ArrayList<PostVO> datas = postDAO.getDBList();
	request.setAttribute("datas", datas);
		pageContext.forward("main.jsp");
}
else if(action.equals("insertP")){
	if(postDAO.insertDB(postVO)){
		response.sendRedirect("ctrl.jsp?action=main");
	}
	else{
		throw new Exception("DB 추가중 오류 발생!");
	}
}
else if(action.equals("updateP")){
	if(postDAO.updateDB(postVO)){
		PostVO data=postDAO.getDBData(postVO);
		request.setAttribute("data", data);
		pageContext.forward("post.jsp");
	}
	else{
		throw new Exception("DB 추가중 오류 발생!");
	}
}

else if(action.equals("deleteP")){
	if(postDAO.deleteDB(postVO)){
		response.sendRedirect("ctrl.jsp?action=main");
	}
	else{
		throw new Exception("DB 추가중 오류 발생!");
	}
}
else if(action.equals("editP")){
	PostVO data=postDAO.getDBData(postVO);
	request.setAttribute("data", data);
	pageContext.forward("editP.jsp");
}
else if(action.equals("post")){
	
		PostVO data=postDAO.getDBData(postVO);
		
		request.setAttribute("data", data);
		pageContext.forward("post.jsp");
}
else if(action.equals("myPost")){
	memberVO=memberDAO.selectOne((MemberVO)session.getAttribute("memberVO"));
	postVO.setUserID(memberVO.getUserID());
	ArrayList<PostVO> datas = postDAO.getMyPost(postVO);
	request.setAttribute("datas", datas);
	pageContext.forward("main.jsp");
}
else if(action.equals("login")){
	memberVO=memberDAO.selectOne(memberVO);
	if(memberVO==null){
		out.println("<script>alert('로그인 실패');history.go(-1)</script>");
	}else{
		session.setAttribute("memberVO", memberVO);
		response.sendRedirect("ctrl.jsp?action=main");
		
	}				
}
else if(action.equals("logout")){
	session.invalidate();
	response.sendRedirect("ctrl.jsp?action=main");
}
else if(action.equals("insertM")){
	if(memberDAO.insertM(memberVO)){
		session.setAttribute("memberVO", memberVO);
		response.sendRedirect("ctrl.jsp?action=main");
	}
	else{
		throw new Exception("memberDB 추가중 오류 발생!");
	}
}
else if(action.equals("updateM")){
	if(memberDAO.updateM(memberVO)){
		session.setAttribute("memberVO", memberVO);
		response.sendRedirect("ctrl.jsp?action=myPage");
	}
	else{
		throw new Exception("memberDB 변경중 오류 발생!");
	}
}
else if(action.equals("deleteM")){
	memberVO=memberDAO.selectOne((MemberVO)session.getAttribute("memberVO"));
	System.out.println(memberVO);
	if(memberDAO.deleteM(memberVO)){
		session.invalidate();
		response.sendRedirect("ctrl.jsp?action=main");
	}
	else{
		throw new Exception("memberDB 변경중 오류 발생!");
	}
}
else if(action.equals("editM")){
	pageContext.forward("editM.jsp");
}
else if(action.equals("myPage")){
	pageContext.forward("myPage.jsp");
}
else if(action.equals("search")){
	String col=request.getParameter("col");
	String word=request.getParameter("word");
	ArrayList<PostVO> datas=postDAO.serchingList(col, word);	
	request.setAttribute("datas", datas);
	pageContext.forward("main.jsp");
}
else{
	throw new Exception("파라미터 확인!");
}
%>