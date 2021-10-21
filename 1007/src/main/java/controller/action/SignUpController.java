package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.member123.Member123DAO;
import model.member123.Member123VO;

public class SignUpController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Member123VO uVO = new Member123VO();
		uVO.setName(request.getParameter("name"));
		uVO.setId(request.getParameter("id"));
		uVO.setPw(request.getParameter("pw"));
		uVO.setRole(request.getParameter("role"));
		Member123DAO dao = new Member123DAO();
		ModelAndView mav = new ModelAndView();
		
		if(dao.insertMember(uVO)) {
			
			out.println("<script>alert('ȸ������ �Ϸ�! �α����� �̿����ּ���!');</script>");	
			mav.setViewName("redirect:index.jsp");
		}
		else {
			out.println("<script>alert('ȸ������ ����! �ٽ� �ۼ��غ�����!');history.go(-1);</script>");
			return null;
		}
		
		
		return mav;
	}

	
}
