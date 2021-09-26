package controller.userComment_Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_JoinUs_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		
		// VO DAO �ν��Ͻ�ȭ
		UserInfoVO userInfoVO = new UserInfoVO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		
		// DAO���� �ʿ䵥���� SET
		userInfoVO.setId(request.getParameter("id"));
		userInfoVO.setPw(request.getParameter("pw"));
		
		// �������� �޾ƿ���
	    UserInfoVO userInfoData = userInfoDAO.SelectOne(userInfoVO);
		
	    // �α��� ���� - ��ũ��Ʈ ����(�ȳ�â ��� �� �ڷΰ���)
	    if(userInfoData == null) {
	    	response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�α��ο� �����ϼ̽��ϴ�. ���̵� Ȥ�� ��й�ȣ�� Ȯ�����ּ���.');  history.go(-1); </script>");
			return null; // ������������ �����Ƿ�, nulló��
	    }
	    
	    // �α��� ���� - session ���
	    HttpSession session = request.getSession();
		session.setAttribute("userInfoData", userInfoData);
	    // ������ ���ۼ���
	    forward.setRedirect(false); // forward
	    forward.setPath("Index.jsp"); // post Control���� ����
		
		
		return forward;
	}

}
