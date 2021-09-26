package controller.userComment_Ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.userInfo.UserInfoDAO;
import model.userInfo.UserInfoVO;

public class U_UpdateUser_Action implements Action{

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
		userInfoVO.setName(request.getParameter("name"));
		
		// DAO����
		  // �������� �Ϸ� -> mypage �̵�
		if(userInfoDAO.UpdateDB(userInfoVO)) {
			
			// ���� ���� - ���� ������ ������Ʈ(session set)
			HttpSession session = request.getSession();
			session.setAttribute("userInfoData", 
					userInfoDAO.SelectOne((UserInfoVO) session.getAttribute("userInfoData")));
			
		}
		  // ���н� - ���� ����
		else {
			try {
				throw new Exception("UpdateUser_Action DB ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		// ������ ���ۼ���
		forward.setRedirect(true); // forward
		forward.setPath("MyPage.jsp");


		return forward;
	}

}
