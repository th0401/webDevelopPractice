package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.MessageDAO;
import model.msg.MessageVO;


public class InsertMessage implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		
		MessageVO mVO = new MessageVO();
		mVO.setMsg(request.getParameter("msg"));
		mVO.setUserID(request.getParameter("userID"));
		
		MessageDAO mDAO = new MessageDAO();
		if(mDAO.insert(mVO)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			throw new IOException("MDB 추가중 오류 발생!");
		}
								
		return forward;
	}

}
