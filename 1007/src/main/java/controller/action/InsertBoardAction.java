package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board123.Board123DAO;
import model.board123.Board123VO;



public class InsertBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
ActionForward forward = null;
		
		
		Board123VO bVO = new Board123VO();
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		bVO.setWriter(request.getParameter("writer"));
		
		Board123DAO dao = new Board123DAO();
		if(dao.insertBoard(bVO)) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("main.do");
			
			return forward;	
		
		}
		else {
			return null;
		}
		
	}

}
