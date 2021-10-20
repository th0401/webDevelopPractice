package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.member123.Member123DAO;
import model.member123.Member123VO;

public class SignUpController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Member123VO uVO = new Member123VO();
		uVO.setName(request.getParameter("name"));
		uVO.setId(request.getParameter("id"));
		uVO.setPw(request.getParameter("pw"));
		uVO.setRole(request.getParameter("role"));
		Member123DAO dao = new Member123DAO();
		if(dao.insertMember(uVO)) {
			
			out.println("<script>alert('ȸ������ �Ϸ�! �α����� �̿����ּ���!');</script>");	
			
		}
		else {
			out.println("<script>alert('ȸ������ ����! �ٽ� �ۼ��غ�����!');history.go(-1);</script>");
			return null;
		}
		
		
		return "index";
		
		
	}

}
