package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member123.Member123DAO;
import model.member123.Member123VO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ActionForward forward = null;
		
				
		
		String id= request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member123VO uVO= new Member123VO();
		Member123DAO dao = new Member123DAO();
		uVO.setId(id);
		uVO.setPw(pw);
		
		
		if(dao.getMember(uVO)!=null) {
			uVO = dao.getMember(uVO);
			System.out.println(uVO);
			HttpSession session=request.getSession();
			session.setAttribute("uVO", uVO);
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('로그인 실패');history.go(-1);</script>");
			return null;
		}
		
		return forward;
	}

}
