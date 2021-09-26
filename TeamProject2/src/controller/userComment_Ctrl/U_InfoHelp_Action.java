package controller.userComment_Ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_InfoHelp_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();

		// VO DAO �ν��Ͻ�ȭ
		UserInfoVO userInfoVO = new UserInfoVO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();


		// IDã�� --> view ��ȯ -> ��ü userInfo
		if(request.getParameter("type").equals("id")) {
			// DAO���� �ʿ䵥���� SET
			userInfoVO.setPw(request.getParameter("pw"));
			userInfoVO.setName(request.getParameter("name"));
			
			// DAO����
			userInfoVO = userInfoDAO.FindID(userInfoVO);
			
			// informID ������ ����
			forward.setPath("informID.jsp");
		}
		// PWã�� --> view ��ȯ == ��ü userInfo
		else if (request.getParameter("type").equals("pw")) {
			// DAO���� �ʿ䵥���� SET
			userInfoVO.setId(request.getParameter("id"));
			
			// DAO����
			userInfoVO = userInfoDAO.FindPW(userInfoVO);
			
			// informPW ������ ����
			forward.setPath("informPW.jsp");
		}
		
		
		// view ��ü���� --- findUser
		request.setAttribute("findUser", userInfoVO);

		
		// ������ ���ۼ���
		forward.setRedirect(false); // forward



		return forward;
	}

}
