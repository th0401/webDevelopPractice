package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

import model.diet.DietPaging;
import model.diet.DietService;
import model.diet.DietVO;
import model.userInfo.UserInfoVO;

@Controller
public class DietController {

	@Autowired
	private DietService dietService;

	private HttpSession session;

	@RequestMapping("/insertDiet.do")
	public String insertDiet(DietVO vo, HttpServletRequest request) {

		System.out.println("insertDiet ��Ʈ�ѷ���!");
		// System.out.println(vo);

		// Date date = vo.getDdate();
		// System.out.println(vo.getDdate());

		// �Ϸ� �� Į�θ� ������
		vo.setDayCalorie(
				vo.getBreakfastCalorie() + vo.getLunchCalorie() + vo.getDinerCalorie() + vo.getAnotherCalorie());

		dietService.insertDiet(vo);

		return "redirect:main.do";
	}

	
	@RequestMapping("/updateDiet.do")
	public String updateDiet(DietVO vo) {
		System.out.println("updateDiet ��Ʈ�ѷ���!");
		
		vo.setDayCalorie(vo.getBreakfastCalorie()+vo.getLunchCalorie()+vo.getDinerCalorie()+vo.getAnotherCalorie());
		System.out.println(vo);
		dietService.updateDiet(vo);

		return "redirect:getDietData.do?dnum="+vo.getDnum();
	}

	@RequestMapping("/deleteDiet.do")
	public String deleteDiet(DietVO vo) {
		System.out.println("deleteDiet ��Ʈ�ѷ���!");

		dietService.deleteDiet(vo);

		return "redirect:dietList.do";
	}
	
	@RequestMapping("/updateDietMain.do")
	public String updateDietMain(DietVO vo,HttpServletResponse response) {
		System.out.println("updateDietMain ��Ʈ�ѷ���!");
		
		DietVO newData = new DietVO(); 
		vo.setDayCalorie(vo.getBreakfastCalorie()+vo.getLunchCalorie()+vo.getDinerCalorie()+vo.getAnotherCalorie());
		
		dietService.updateDiet(vo);
		newData = dietService.selectOne(vo);
		System.out.println(vo);
		
		
		Date ddate = newData.getDdate();
		String breakfast = newData.getBreakfast();
		String lunch = newData.getLunch();
		String diner = newData.getDiner();
		String another = newData.getAnother();
		int breakfastCalorie = newData.getBreakfastCalorie();;
		int lunchCalorie = newData.getLunchCalorie();
		int dinerCalorie = newData.getDinerCalorie();
		int anotherCalorie = newData.getAnotherCalorie();
		int dayCalorie = newData.getDayCalorie();
		
	   // System.out.println(ddate);
		
		
		String result = "[{\"ddate\":\"" + ddate+"\",\"breakfast\":\"" + breakfast + "\",\"lunch\":\""+lunch+"\",\"diner\":\""+diner+"\",\"another\":\""+another+"\",\"breakfastCalorie\":\""+breakfastCalorie+"\",\"lunchCalorie\":\""+lunchCalorie+"\",\"dinerCalorie\":\""+dinerCalorie+"\",\"anotherCalorie\":\""+anotherCalorie+"\",\"dayCalorie\":\""+dayCalorie+"\"}]";
		System.out.println("result�� : "+result);
		
		PrintWriter out;
		try {
			response.setContentType("text/html; charset=UTF-8"); 
			out = response.getWriter();
			out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@RequestMapping("/dietList.do")
	public String myDiet(UserInfoVO vo, Model model, HttpServletRequest request) {

		List<DietVO> datas = new ArrayList<DietVO>();
		session = request.getSession();
		vo = (UserInfoVO) session.getAttribute("uVO");

		datas = dietService.selectAll(vo);

		// ����¡ ó�� ����
		String url = "dietList.jsp";
		String indexx = request.getParameter("index");
		int index = 1;
		if (indexx != null) {
			index = Integer.parseInt(indexx);
		}
		url = url + "?index=" + index;

		// ���������� ���� �Խù� ��
		int pagingSize = 5;
		// ������ ������� int pageSize(�������� �Խù� ��), int thisPageNum(���� ������ ��ȣ), int
		// totalPostCnt(�� ����Ʈ ����)
		Paging paging = new Paging(pagingSize, index, datas.size());
		paging.makePaging();
		// ����¡ for������ ǥ�� �� �� �ֵ��� �ϱ�
		ArrayList<Integer> pagingIndex = new ArrayList<Integer>();// �信�� ��Ÿ���� ����¡ ���� ��ư���� ��ü
		int page = paging.getStartPageNum();
		// 1 5
		for (int i = paging.getStartPageNum(); i <= paging.getEndPageNum(); i++) {
			pagingIndex.add(page);
			page++;
		}
		// �ش��ϴ� �������� �����͸� �ֱ� ĸ��ȭ ����
		DietPaging dp = new DietPaging(datas, index);
		if (datas.size() != 0) {
			dp.excuteSlice();
		}
		model.addAttribute("isLast", paging.isLast());
		model.addAttribute("isFirst", paging.isFirst());
		model.addAttribute("pagingIndex", pagingIndex);
		model.addAttribute("index", index);
		// ������(����¡ó����) ���̾�Ʈ����Ʈ
		model.addAttribute("DietList", dp.getNewDatas());
		
		//model.addAttribute("datas", datas);

		return "dietList.jsp";

	}

	@RequestMapping("/getDietData.do")
	public String getDietData(DietVO vo, Model model) {
		System.out.println("getDietData ��Ʈ�ѷ���!");
		
		DietVO data = dietService.selectOne(vo);
		
		
		model.addAttribute("dietData", data);
		
		return "getDietPage.jsp";
				
	}
	
}
