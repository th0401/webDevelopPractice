package test;

import java.util.ArrayList;
import java.util.Scanner;

import View.GiftView;
import View.MemberView;
import model.gift.giftDAO;
import model.gift.giftVO;
import model.member.memberDAO;
import model.member.memberVO;

public class MMMTest {

	public static void main(String[] args) {
		// 유효성모두 정상작동

		giftVO gv = new giftVO();
		giftDAO  gdao = new giftDAO();
		GiftView mv = new GiftView();

		Scanner sc = new Scanner(System.in);

		MemberView memv = new MemberView();
		memberDAO mdao = new memberDAO();	      
		memberVO my = new memberVO();

		ArrayList<giftVO> datas = new ArrayList();
		ArrayList<memberVO> memdatas = new ArrayList();

		memdatas=mdao.selectList();
		for(memberVO v: memdatas) {
			System.out.println(v);
		}
		my.setMnum(1);
		my=mdao.selectOne(my);
		
		
		gv=mv.giftPresent(memdatas);
		gv.setGnum("3333333");
		gdao.insert(gv);
		
		datas = gdao.MemberGiftList(gv);
		mv.giftPrint(datas);
		
		
		
		




	}

}
