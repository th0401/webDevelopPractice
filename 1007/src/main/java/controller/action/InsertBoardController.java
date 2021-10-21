package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board123.Board123DAO;
import model.board123.Board123VO;



public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board123VO bVO = new Board123VO();
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		bVO.setWriter(request.getParameter("writer"));
		
		Board123DAO dao = new Board123DAO();
		ModelAndView mav = new ModelAndView();
		if(dao.insertBoard(bVO)) {
			mav.setViewName("redirect:main.do");
			return mav;	
		
		}
		else {
			return null;
		}
	}

	

}
