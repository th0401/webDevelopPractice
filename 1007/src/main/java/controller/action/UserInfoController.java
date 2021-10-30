package controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.body.BodyService;
import model.body.BodyVO;
import model.userInfo.UserInfoService;
import model.userInfo.UserInfoVO;

@Controller
public class UserInfoController {

	
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private BodyService bodyService;
	
	@RequestMapping("/main.do")
	public String getAllList(@RequestParam(value="condition",defaultValue="title",required=false)String condition,@RequestParam(value="keyword",defaultValue="",required=false)String keyword,BodyVO vo,Model model) {
		
		List<BodyVO> datas = new ArrayList<BodyVO>();
		
		if(vo != null) {
			datas = bodyService.selectAll(vo);
		}
		
		System.out.println(datas);
		
		BodyVO lastBodyVO = new BodyVO(); 
		if(!datas.isEmpty()) {
			lastBodyVO = datas.get(0);
		}
		
		System.out.println(lastBodyVO);
		//request.setAttribute("datas", datas);
		model.addAttribute("lastBodyVO", lastBodyVO);
		model.addAttribute("datas", datas);
		
		return "main.jsp";
	}
	
	@RequestMapping("/myPage.do")
	public String myPage(BodyVO vo,Model model) {
		
		List<BodyVO> datas = bodyService.selectAll(vo);
		
		System.out.println(datas);
		
		BodyVO lastBodyVO = new BodyVO(); 
		if(!datas.isEmpty()) {
			System.out.println("데이터 0번째 : "+datas.get(0));
			lastBodyVO = datas.get(0);
		}
		
		System.out.println("라스트바디VO는 : "+lastBodyVO);
		//request.setAttribute("datas", datas);
		model.addAttribute("lastBodyVO", lastBodyVO);
		model.addAttribute("datas", datas);
		
		return "myPage.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,UserInfoVO vo) {
		System.out.println("id: "+request.getParameter("id")+", pw: "+request.getParameter("pw"));
		UserInfoVO data = userInfoService.login(vo);
		
		if(data!=null) {
			
			System.out.println(data);
			HttpSession session=request.getSession();
			session.setAttribute("uVO", data);
			return "redirect:main.do?id="+data.getId();
			
		}
		else {
			System.out.println(data);
			return"login.jsp";
			
			// DS -> HM -> C -> VR
		}
		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();		
		return "redirect:main.do";
		
	}
	@RequestMapping(value="/loginPage.do",method=RequestMethod.GET)
	public String loginPage() {
		return "login.jsp";	
	}
	
	
	@RequestMapping("/signUp.do")
	public String signUp(UserInfoVO vo) {
		//System.out.println("회원가입 왔음!!!");
		userInfoService.insertUser(vo); 
	
			return "login.jsp";
		
	}
	
	@RequestMapping(value="/signUpPage.do",method=RequestMethod.GET)
	public String signUpPage() {
		return "signUp.jsp";	
	}
	
	@RequestMapping("/deleteUser.do")
	public String deleteUserInfo(HttpSession session,UserInfoVO vo) {
		session.invalidate();
		userInfoService.deleteUser(vo);
		
			System.out.println("뭐임??? 여기오나?");
			
			return "redirect:main.do";
		
		
	}
	
	
}
