package controller.post_ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import controller.ActionForward;
import model.likeInfo.LikeInfoDAO;
import model.likeInfo.LikeInfoVO;
import model.post.PostDAO;
import model.post.PostVO;
import model.userInfo.UserInfoVO;

public class SelectOneAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward action = new ActionForward();
		PostDAO PDAO = new PostDAO();
		PostVO PVO = new PostVO();
		UserInfoVO UVO = new UserInfoVO();
		LikeInfoVO LVO = new LikeInfoVO();
		LikeInfoDAO LDAO = new LikeInfoDAO();
		if(request.getParameter("pnum")!=null) {
			PVO.setPnum(Integer.parseInt(request.getParameter("pnum"))); // pnum������ ã�°Ŵ� Pnum�� ���� �� �Ѱ���
		}
		/*if (PDAO.ViewsUp(PVO)) { // ����Ʈ�� ���� view �� -> Model Ʈ����� ó��
			request.setAttribute("singlePost", PDAO.SelectOne(PVO));
		} else {
			throw new Exception("ViewUp ���� �߻�!");
		}*/
		request.setAttribute("singlePost", PDAO.SelectOne(PVO));
		request.setAttribute("likeInfo", false); // ����ڰ� ���� ���±ۿ� ���ƿ並 �������� Ȯ���ϴ� �� ����Ʈ false
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfoData") != null) {
			UVO = (UserInfoVO) session.getAttribute("userInfoData"); // �α��� ���� ������ ���ƿ並 �������� üũ
			String ID = UVO.getId();
			int pnum = Integer.parseInt(request.getParameter("pnum"));
			LVO.setL_post(pnum);
			LVO.setL_user(ID);
			request.setAttribute("likeInfo", LDAO.SelectOne(LVO)); // ���ƿ� ����
		}
		action.setPath("selectOne.ucdo");
		action.setRedirect(false);
		return action;
	}

}
