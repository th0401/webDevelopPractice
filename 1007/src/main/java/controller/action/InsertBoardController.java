package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board123.Board123DAO;
import model.board123.Board123VO;



public class InsertBoardController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		Board123VO bVO = new Board123VO();
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		bVO.setWriter(request.getParameter("writer"));
		
		Board123DAO dao = new Board123DAO();
		if(dao.insertBoard(bVO)) {
			
			return "main.do";	
		
		}
		else {
			return null;
		}
		
	}

}
