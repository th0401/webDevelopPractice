package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board123.Board123DAO;
import model.board123.Board123VO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board123DAO dao = new Board123DAO();
		Board123VO bVO = new Board123VO();
		int id = Integer.parseInt(request.getParameter("id"));	
		bVO.setId(id);
		Board123VO data = dao.getBoard(bVO);
		request.setAttribute("data", data);
		
		System.out.println(data);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard");
		return mav;
	}

	

}
