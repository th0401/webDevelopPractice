package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.msg.ReplyDAO;
import model.msg.ReplyVO;



public class InsertReply implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = null;
		
		ReplyVO rVO = new ReplyVO();
		rVO.setUserID(request.getParameter("userID"));
		rVO.setMeid(Integer.parseInt(request.getParameter("meid")));
		rVO.setRmsg(request.getParameter("rmsg"));
		
		ReplyDAO rDAO = new ReplyDAO();
		if(rDAO.insert(rVO)) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
		}
		else {
			throw new IOException("RDB 추가중 오류 발생!");
		}
								
		return forward;
	}

}
