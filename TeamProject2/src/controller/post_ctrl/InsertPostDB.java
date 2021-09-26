package controller.post_ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.post.PostDAO;
import model.post.PostVO;
import model.userInfo.UserInfoVO;

public class InsertPostDB implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward action = new ActionForward();
		PostVO PVO = new PostVO();
		PostDAO PDAO = new PostDAO();
		UserInfoVO UVO = new UserInfoVO();
		HttpSession session = request.getSession();
		PVO.setCategory(request.getParameter("category"));
		PVO.setContent(request.getParameter("content"));
		UVO = (UserInfoVO) session.getAttribute("userInfoData"); // �̸��� ���ǿ��� VO�� ����� UserInfoVO ���!
		PVO.setWriter(UVO.getName()); // Name ���� ����� �� �Ʒ����� nullpointer�ߴµ� ������ �α����� �ȵǼ� ���ǿ� userInfo�� ����!
		PVO.setP_user(UVO.getId()); // ID
		PVO.setTitle(request.getParameter("title"));
		if (PDAO.InsertDB(PVO)) {
			action.setPath("main.ucdo");
			action.setRedirect(false);
		} else {
			try {
				throw new Exception("insertDB �����߻�!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return action;
	}

}
