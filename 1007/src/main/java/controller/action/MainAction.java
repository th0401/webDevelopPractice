package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board123.Board123DAO;
import model.board123.Board123VO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		Board123DAO dao = new Board123DAO();
		List<Board123VO> datas = dao.getBoardList(new Board123VO());
		System.out.println(datas);
		request.setAttribute("datas", datas);
		
		
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}
	
	
	
}
