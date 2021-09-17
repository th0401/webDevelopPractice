package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MessageVO;

public class LikeUp implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		MessageVO mVO = new MessageVO();
		mVO.setMeid(Integer.parseInt(request.getParameter("meid")));
		MessageDAO mDAO = new MessageDAO();
		mDAO.update(mVO);
		forward = new ActionForward();	
		forward.setRedirect(false);
		forward.setPath("main.do");
		
		return forward;
	}

}
