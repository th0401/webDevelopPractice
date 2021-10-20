package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board123.Board123DAO;
import model.board123.Board123VO;

public class GetBoardController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Board123DAO dao = new Board123DAO();
		Board123VO bVO = new Board123VO();
		int id = Integer.parseInt(request.getParameter("id"));	
		bVO.setId(id);
		Board123VO data = dao.getBoard(bVO);
		request.setAttribute("data", data);
		
		System.out.println(data);
		
		
		return "getBoard";
	}

}
