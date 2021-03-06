package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.UserDAO;
import model.user.UserVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ActionForward forward = null;
		
		// 1. uVO를 만들수있는 인자들을 get()
		// 2. 로그인 성공,실패여부 판단
		// 3. 성공: 세션세팅 / 실패: 스크립트 출력
		
		UserDAO uDAO = new UserDAO();
		UserVO uVO = new UserVO();
		uVO.setUserID(request.getParameter("userID"));
		uVO.setUserPW(request.getParameter("userPW"));		
		
		if(uDAO.login(uVO)) {
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
