<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage= "error.jsp" import="java.util.*,model.board.*,model.member.*"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="boardDAO" class="model.board.BoardDAO" />
    <jsp:useBean id="boardVO" class= "model.board.BoardVO" />
    <jsp:setProperty property="*" name="boardVO"/>
<jsp:useBean id="memberDAO" class= "model.member.MemberDAO"/>
<jsp:useBean id="memberVO" class= "model.member.MemberVO"/>
<jsp:setProperty property="*" name="memberVO"/>

<%
System.out.println(boardVO);
	String action=request.getParameter("action");

	if(action.equals("list")){
		ArrayList<BoardVO> datas = boardDAO.getDBList();
		request.setAttribute("datas", datas);
		pageContext.forward("list.jsp");
	}
	else if(action.equals("insert")){
		System.out.println(memberVO.getBmem());
		boardVO.setBmem(memberVO.getBmem());
		if(boardDAO.insertDB(boardVO)){
			response.sendRedirect("ctrl.jsp?action=list");
		}
		else{
			throw new Exception("DB 추가중 오류 발생!");
		}
	}
	else if(action.equals("update")){
		if(boardDAO.updateDB(boardVO)){
			response.sendRedirect("ctrl.jsp?action=list");
		}
		else{
			throw new Exception("DB 변경중 오류 발생!");
		}
	}

	else if(action.equals("delete")){
		if(boardDAO.deleteDB(boardVO)){
			response.sendRedirect("ctrl.jsp?action=list");
		}
		else{
			throw new Exception("DB 삭제중 오류 발생!");
		}
	}
	else if(action.equals("edit")){
		if(request.getParameter("writer").equals("root")){
			BoardVO data=boardDAO.getDBData(boardVO);			
			request.setAttribute("data", data);
			pageContext.forward("edit.jsp");
			// 사용자가 잘못된 mnum를 건네는 경우는 없다!
			// -> 오류페이지로 처리!
		}		
		else{
			out.println("<script>alert('관리자가 아닙니다!');history.go(-1)</script>");
		}
	}
	else if(action.equals("login")){
		memberVO=memberDAO.selectOne(memberVO);
		if(memberVO==null){
			out.println("<script>alert('로그인 실패');history.go(-1)</script>");
		}else{
			session.setAttribute("memberVO", memberVO);
			response.sendRedirect("ctrl.jsp?action=list");
		}
			
		
		
	}
	else if(action.equals("logout")){
		session.invalidate();
		response.sendRedirect("ctrl.jsp?action=list");
	}
	else if(action.equals("insertMember")){
		if(memberDAO.insertMember(memberVO)){
			response.sendRedirect("ctrl.jsp?action=list");
		}
		else{
			throw new Exception("memberDB 추가중 오류 발생!");
		}
	}
	else if(action.equals("updateMember")){
		if(memberDAO.updateMember(memberVO)){
			response.sendRedirect("ctrl.jsp?action=list");
		}
		else{
			throw new Exception("memberDB 변경중 오류 발생!");
		}
	}
	else if(action.equals("deleteMember")){
		if(memberDAO.deleteMember(memberVO)){
			response.sendRedirect("ctrl.jsp?action=list");
		}
		else{
			throw new Exception("memberDB 삭제중 오류 발생!");
		}
	}
//	else if(action.equals("showMyPage")){
		
//		ArrayList<MemberVO> datas = memberDAO.showMyPage(session.getAttribute("memberVO"));
//		request.setAttribute("datas", datas);
//		pageContext.forward("list.jsp");
//	}
	else{
		throw new Exception("파라미터 확인!");
	}

%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 컨트롤러창</title>
</head>
<body>

</body>
</html>