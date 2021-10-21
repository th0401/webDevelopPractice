package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.board123.Board123DAO;
import model.board123.Board123VO;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board123DAO dao = new Board123DAO();
		List<Board123VO> datas = dao.getBoardList(new Board123VO());
		System.out.println(datas);
		//request.setAttribute("datas", datas);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;
	}

	
	
	
	
}
