package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAO;
import model.user.UserVO;

public class SignUpAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		UserVO uVO = new UserVO();
		uVO.setName(request.getParameter("name"));
		uVO.setUserID(request.getParameter("userID"));
		uVO.setUserPW(request.getParameter("userPW"));
		
		UserDAO uDAO = new UserDAO();
		if(uDAO.insert(uVO)) {
			
			out.println("<script>alert('회원가입 완료! 로그인후 이용해주세요!');window.close();</script>");			
		}
		else {
			out.println("<script>alert('회원가입 실패! 다시 작성해보세요!');history.go(-1);</script>");
		}
		
		return null;
	}

}
