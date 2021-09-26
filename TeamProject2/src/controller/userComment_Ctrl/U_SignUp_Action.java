package controller.userComment_Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_SignUp_Action implements Action {
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		// VO DAO �ν��Ͻ�ȭ
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoVO userInfoVO = new UserInfoVO();
		
		// DAO���� �ʿ䵥���� SET
		userInfoVO.setId(request.getParameter("id"));
		userInfoVO.setPw(request.getParameter("pw"));
		userInfoVO.setName(request.getParameter("name"));
		
		// DAO����		
	     // ���� ���� - ��ũ��Ʈ ����(�ȳ�â ��� �� ������ �̵�)
		if(userInfoDAO.InsertDB(userInfoVO)) {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			// �ڹٽ�ũ��Ʈ�� �̿��Ͽ� �˸�â ��, Login.jsp ������ �̵�
			out.println("<script>alert('ȸ�������� ���������� �ݿ��Ǿ����ϴ�.');  location.href='Login.jsp'; </script>");
		}
		 // ���� ���н� - ���� ����
		else {
			try {
				throw new Exception("SignUp_Action DB ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
	    
	    // ������������ �����Ƿ�, null��ȯ ó��
		return null;
	}
	

	
	
	
}
