package controller.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.board123.Board123DAO;
import model.board123.Board123Service;
import model.board123.Board123VO;

@Controller
@SessionAttributes("data")
public class Board123Controller {

	@Autowired
	private Board123Service boardService;
	
	@ModelAttribute("sm")
	public Map<String,String> searchMap(){
		Map<String,String> sm = new HashMap<String,String>();
		sm.put("����", "title");
		sm.put("�ۼ���", "writer");
		return sm;
	}
	
	
	
	/*@RequestMapping("/main.do")
	public String getBoardList(@RequestParam(value="condition",defaultValue="title",required=false)String condition,@RequestParam(value="keyword",defaultValue="",required=false)String keyword,Board123VO vo,Board123DAO dao,Model model) {
		System.out.println(condition+": "+keyword);
		List<Board123VO> datas = dao.getBoardList(new Board123VO());
		System.out.println(datas);
		
		//request.setAttribute("datas", datas);
		model.addAttribute("datas", datas);
		
		return "main.jsp";
	}*/
	
	
	// mav�� main�� �����ѹ��
	/*@RequestMapping("/main.do")
	public ModelAndView getBoardList(@RequestParam(value="condition",defaultValue="title",required=false)String condition,@RequestParam(value="keyword",defaultValue="",required=false)String keyword,Board123VO vo,Board123DAO dao,ModelAndView mav) {
		System.out.println(condition+": "+keyword);
		List<Board123VO> datas = dao.getBoardList(new Board123VO());
		System.out.println(datas);
		
		//request.setAttribute("datas", datas);
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;
	}*/
	
	// VO�� ���� condition, keyword �־����� ��� 
	/*@RequestMapping("/main.do")
	public ModelAndView getBoardList(Board123VO vo,Board123DAO dao,ModelAndView mav) {
		System.out.println(vo.getCondition()+": "+vo.getKeyword());
		List<Board123VO> datas = dao.getBoardList(new Board123VO());
		System.out.println(datas);
		
		//request.setAttribute("datas", datas);
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;
	}*/
	// xml���� ���� �����Ҷ� ���� ����
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Board123DAO dao = new Board123DAO();
		List<Board123VO> datas = dao.getBoardList(new Board123VO());
		System.out.println(datas);
		//request.setAttribute("datas", datas);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;
	}*/
	
	
	@RequestMapping("/getBoard.do")
	public String getBoard(Model model, Board123VO vo, Board123DAO dao) {
		
		Board123VO data = dao.getBoard(vo);
		model.addAttribute("data", data);
		
		System.out.println(data);
		
		return "getBoard";
	}
		
		// 1. �Ϻ��� POJO Ŭ����
		// 2. ���xxx, �߻�޼����� ������xxx -> �Լ��� input output �Լ��� ���氡��!
		
		@RequestMapping("/insertBoard.do")
		public String insertBoard(HttpServletRequest request,Board123VO vo) throws IllegalStateException, IOException {
			
			
			MultipartFile fileUpload = vo.getFileUpload();
			if(!fileUpload.isEmpty()) {
				String fileName = fileUpload.getOriginalFilename();
				System.out.println("�����̸�: "+fileName);
				fileUpload.transferTo(new File("C:\\LEE_0622\\"+fileName));
			}
			
			
			boardService.insertBoard(vo);
				
				return "redirect:main.do";	
			
			
		}
	
		
		
}
