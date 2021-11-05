package controller.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.diet.DietService;
import model.diet.DietVO;
import model.userInfo.UserInfoVO;

@Controller
public class DietController {

	@Autowired
	private DietService dietService;
	
	private HttpSession session;
	
	
	@RequestMapping("/insertDiet.do")
	public String insertDiet(DietVO vo,HttpServletRequest request) {
		
		System.out.println("insertDiet ÄÁÆ®·Ñ·¯¿È!");
		//System.out.println(vo);
		
		//Date date = vo.getDdate();
		System.out.println(vo.getDdate());
		
		dietService.insertDiet(vo);
		
		return "redirect:main.do";
	}
	
	@RequestMapping("/updateDiet.do")
	public String updateDiet(DietVO vo) {
		System.out.println("updateDiet ÄÁÆ®·Ñ·¯¿È!");
		
		dietService.updateDiet(vo);
		
		return null;
	}
	
	@RequestMapping("/deleteDiet.do")
	public String deleteDiet(DietVO vo) {
		System.out.println("deleteDiet ÄÁÆ®·Ñ·¯¿È!");
		
		dietService.deleteDiet(vo);
		
		return null;
	}
	
	@RequestMapping("/dietList.do")
	public String myDiet(UserInfoVO vo,Model model,HttpServletRequest request) {
		
		List<DietVO> datas = new ArrayList<DietVO>();
		session= request.getSession();
		vo = (UserInfoVO)session.getAttribute("uVO");
		
		if(vo != null) {
			datas = dietService.selectAll(vo);
		}
		
		System.out.println(datas);
		
		model.addAttribute("datas", datas);
		
		return "dietList.jsp";
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
