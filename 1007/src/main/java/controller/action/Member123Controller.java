package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.member123.Member123DAO;
import model.member123.Member123VO;

@Controller
public class Member123Controller {

	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,Member123VO vo,Member123DAO dao) {
		
		Member123VO data = dao.getMember(vo);
		
		if(data!=null) {
			
			System.out.println(data);
			HttpSession session=request.getSession();
			session.setAttribute("uVO", data);
			return "redirect:index.jsp";
			
		}
		else {						
			return"redirect:login.jsp";
			
			// DS -> HM -> C -> VR
		}
		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();		
		return "redirect:index.jsp";
		
	}
	
	@RequestMapping("/signUp.do")
	public String signUp(Member123VO vo,Member123DAO dao) {
		
		if(dao.insertMember(vo)) {	
				
			return "redirect:index.jsp";
		}
		else {
			
			return null;
		}
				
	}
	
	
	
}
