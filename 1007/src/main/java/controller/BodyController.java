package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lee.app.common.Paging;

import model.body.BodyService;
import model.body.BodyVO;
import model.body.BodyPaging;
import model.userInfo.UserInfoVO;

@Controller
public class BodyController {

	@Autowired
	private BodyService bodyService;
	
	private HttpSession session;
	
	@RequestMapping("/insertBody.do")
	public String insertBody(BodyVO vo) {
		System.out.println("insertBody ��Ʈ�ѿ�!");
		
		bodyService.insertBody(vo);
		
		return "redirect:main.do";
	}
	
	@RequestMapping("/updateBody.do")
	public String updateBody(BodyVO vo,HttpServletResponse response) {
		System.out.println("updateBody ��Ʈ�ѿ�!");
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
		System.out.println("deleteBody ��Ʈ�ѿ�!");
		
		bodyService.deleteBody(vo);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/bodyList.do")
	public String myBodyPage(UserInfoVO uVO,Model model,HttpServletRequest request) {
		
		List<BodyVO> datas = new ArrayList<BodyVO>();
		session = request.getSession();
		uVO = (UserInfoVO)session.getAttribute("uVO");
		
		
			datas = bodyService.selectAll(uVO);
			
			// ����¡ ó�� ����
			String url="bodyList.jsp";	
			String indexx=request.getParameter("index");
			int index=1;
			if(indexx!=null){
				index=Integer.parseInt(indexx);
			}
			url= url+ "?index="+index;
			
			// ���������� ���� �Խù� ��
			int pagingSize = 6;
			// ������ ������� int pageSize(�������� �Խù� ��), int thisPageNum(���� ������ ��ȣ), int totalPostCnt(�� ����Ʈ ����)
			Paging paging = new Paging(pagingSize,index,datas.size());
			paging.makePaging();
			// ����¡ for������ ǥ�� �� �� �ֵ��� �ϱ�
			ArrayList<Integer> pagingIndex = new ArrayList<Integer>();// �信�� ��Ÿ���� ����¡ ���� ��ư���� ��ü
			int page = paging.getStartPageNum();
			//					1							5
			for(int i = paging.getStartPageNum();i<=paging.getEndPageNum();i++) {
				pagingIndex.add(page);
				page++;
			}
			// �ش��ϴ� �������� �����͸� �ֱ� ĸ��ȭ ����
			BodyPaging bp = new BodyPaging(datas, index);
			if(datas.size()!=0) {
				bp.excuteSlice();
			}
		
		
		//System.out.println(datas);
		
		//request.setAttribute("datas", datas);
			model.addAttribute("isLast", paging.isLast());
			model.addAttribute("isFirst", paging.isFirst());
			model.addAttribute("pagingIndex", pagingIndex);
			model.addAttribute("index", index);
			// ������(����¡ó����) �ٵ𸮽�Ʈ
			model.addAttribute("BodyList", bp.getNewDatas());
			//model.addAttribute("datas", datas);
		
		return "bodyList.jsp";
	}
	
	// myPage���� �ֽ� body������ �����ϴ� ���� spa Ȱ�����!
		@RequestMapping("/updateRecentBody.do")
		public String updateRecentBody(BodyVO vo,HttpServletResponse response) {
			System.out.println("updateRecentBody ��Ʈ�ѿ�!");
			
			bodyService.updateBody(vo);
			
			return "redirect:myPage.do";
		}
	
	// myPage���� �ֽ� body������ �����ϴ� ���� spa Ȱ�����!
	@RequestMapping("/deleteRecentBody.do")
	public String deleteRecentBody(BodyVO vo,HttpServletResponse response) {
		System.out.println("deleteRecentBody ��Ʈ�ѿ�!");
		
		bodyService.deleteBody(vo);
		
		return "redirect:myPage.do";
	}
	
	
}
