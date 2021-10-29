package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.body.BodyService;
import model.body.BodyVO;

@Controller
public class BodyController {

	@Autowired
	private BodyService bodyService;
	
	@RequestMapping("/insertBody.do")
	public String insertBody(BodyVO vo) {
		System.out.println("insertBody ÄÁÆ®·Ñ¿È!");
		
		bodyService.insertBody(vo);
		
		return "redirect:main.do";
	}
	
	@RequestMapping("/updateBody.do")
	public String updateBody(BodyVO vo,HttpServletResponse response) {
		System.out.println("updateBody ÄÁÆ®·Ñ¿È!");
		BodyVO newData = new BodyVO();
		bodyService.updateBody(vo);
		newData = bodyService.selectOne(vo);
		
		
		float weight = newData.getWeight();
		float height = newData.getHeight();
	    System.out.println(weight);
	  
	    String result = "[{\"weight\":\"" + weight+"\",\"height\":\"" + height + "\"}]";
	    System.out.println(result);
	    
	    PrintWriter out;
		try {
			out = response.getWriter();
			out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
		return null;
		
		
	}
	
	@RequestMapping("/deleteBody.do")
	public String deleteBody(BodyVO vo,HttpServletResponse response) {
		System.out.println("deleteBody ÄÁÆ®·Ñ¿È!");
		
		bodyService.deleteBody(vo);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/bodyList.do")
	public String myPage(BodyVO vo,Model model) {
		
		List<BodyVO> datas = bodyService.selectAll(vo);
		
		System.out.println(datas);
		
		//request.setAttribute("datas", datas);
		
		model.addAttribute("datas", datas);
		
		return "bodyList.jsp";
	}
}
