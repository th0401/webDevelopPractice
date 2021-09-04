package View;

import java.util.ArrayList;
import java.util.Random;

import model.gift.giftDAO;
import model.gift.giftVO;
import model.member.memberDAO;
import model.member.memberVO;

public class GiftView {
	public GiftView(){
		excep = new MyException(); // 예외처리 클래스
	}
	private MyException excep;
	public int giftMenuSelect() {

		System.out.println("쿠폰 페이지에 들어오셨습니다!");
		System.out.println("원하시는 서비스 번호를 눌러주세요!");
		System.out.println("1.쿠폰 확인  2.쿠폰 구매  3.쿠폰 선물하기  4.종료하기");
		int act = excep.numExcep(1, 4);
		return act;
	}

	//   [메서드] 쿠폰등록완료 맨트
	public void giftSuccessApply() {  
		// 쿠폰 등록할 때 쿠폰번호 넣으신후에 쿠폰 dao로 인설트하시고 그 아래에 넣어주세요
		System.out.println("\n\n정상적으로 쿠폰 구입이 완료되었습니다. 이용해 주셔서 감사합니다. ;P\n\n");
	}
	// [메서드] 쿠폰선물완료 맨트
	public void presentSuccesstApply() {   
		// 쿠폰 선물할 때 쿠폰번호 넣으신 후에 쿠폰 dao로 인설트 하시고 그 아래에 넣으세요!
		System.out.println("\n\n정상적으로 쿠폰 선물이 완료되었습니다. 이용해 주셔서 감사합니다. :D\n\n");
	}
	// 쿠폰등록,선물실패 또는 종료맨트는 이미 메서드 giftBuy,giftPresent안에 구현돼있습니다

	// [쿠폰 본인구매] --> insert
	// 반환:구매한 쿠폰 금액만 반환
	public giftVO giftBuy(memberVO vo){//인자: 사용자회원

		giftVO data = null; // 반환할 쿠폰      

		System.out.println("구매하실 쿠폰금액을 입력해주세요!!  =)");
		ArrayList<Integer> giftPrice = new ArrayList(); // 쿠폰금액 저장
		giftPrice.add(5000);
		giftPrice.add(10000);
		giftPrice.add(30000);
		giftPrice.add(50000);
		giftPrice.add(100000);

		System.out.println("(1) 5,000원\n(2) 10,000원\n(3) 30,000원\n(4) 50,000원\n(5) 100,000원");
		int act = excep.numExcep(1, 5); // 유효성검사 메서드 호출)1~5 범위 입력
		System.out.println(giftPrice.get(act-1)+" 원  선택하셨습니다!\n결제를 진행하시겠습니까?");
		System.out.println("1.결제\t2.취소"); // 결제여부 안내
		int mod = excep.numExcep(1, 2); // 유효성검사 호출) 1,2입력

		//중도 종료구현
		if(mod==2) {
			System.out.println("결제가 취소 되었습니다.");
			return data; // 종료
		}
		data=new giftVO();
		//결제진행 로딩
		System.out.print("카드결제 진행 중");
		try {
			for(int i = 0; i < 5; i++) {
				Thread.sleep(500); // 로딩 효과
				System.out.print(".");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}      
		

		// 쿠폰 데이터 저장 (실제로 결제후 데이터가 한번에 저장되는 것을 구현)
		
		//스코프
			System.out.println(); //줄정리
			System.out.println("결제완료!!");

			// 구매한 쿠폰 금액저장
			data.setGprice(giftPrice.get(act-1));
			data.setMnum(vo.getMnum());      
			return data;
		
	}
	// [쿠폰 선물]
	// 구매한 쿠폰 금액만 반환
	public giftVO giftPresent(ArrayList<memberVO> vo){
		giftVO data = null; // 반환할 쿠폰

		System.out.println("구매하실 쿠폰금액을 입력해주세요!!  =)");
		ArrayList<Integer> giftPrice = new ArrayList(); // 쿠폰금액 저장
		giftPrice.add(5000);
		giftPrice.add(10000);
		giftPrice.add(30000);
		giftPrice.add(50000);
		giftPrice.add(100000);

		// 쿠폰목록
		System.out.println("(1) 5,000원\n(2) 10,000원\n(3) 30,000원\n(4) 50,000원\n(5) 100,000원");

		// 유효성검사 메서드 호출)1~5 범위 입력
		int act = excep.numExcep(1, 5);

		// 결제의사 확인
		System.out.println(giftPrice.get(act-1)+" 원  선택하셨습니다!\n결제를 진행하시겠습니까?");
		System.out.println("1.결제진행\t2.취소"); // 결제여부 안내
		// 유효성검사 호출) 1,2입력
		int mod = excep.numExcep(1, 2); 

		//결제 외 번호는 결제취소(함수종료) -->data:null반환
		if(mod==2) {
			System.out.println("결제가 취소 되었습니다.");
			return data;// data(null)반환
		}

		//-->112번라인으로 대체
		//while(true){// 회원번호 대조  
		System.out.println("선물대상의 회원번호를 입력해주세요.\t종료 0");

		// 유효성검사 호출>> 0부터 마지막데이터의 mnum까지 입력
		// 선물대상 mnum입력
		int mnum = excep.numExcep(0, vo.get(vo.size()-1).getMnum());

		//종료버튼(0 입력시)
		if(mnum==0) {
			System.out.println("선물하기를 종료합니다");
			return data; // data(null)반환
		}
		//member - mnum 데이터 비교 
		//            ArrayList<memberVO> arrMemberVo = new ArrayList();  => 삭제바람      

		//-->112번라인으로 대체
		/*         boolean flag = true;
            for(int i = 0; i<vo.size();i++) {
               if(vo.get(i).getMnum()==mnum) {               
                  flag = false;
                  break;
               }   
            }
            if(flag) {
               System.out.println("없는 회원번호에요 다시 입력해주세요.");
               continue;
            }
		 */         //회원번호가 존재하면 저장
		data = new giftVO();  // 여기서부터 객체생성!
		data.setMnum(mnum);
		//break;
		//}//

		//회원번호가 일치하면 결제진행
		System.out.print("카드결제 진행 중");
		try {
			for(int i = 0; i < 5; i++) {
				Thread.sleep(500); // 로딩 효과
				System.out.print(".");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 쿠폰 데이터 저장 (실제로 결제후 데이터가 한번에 저장되는 것을 구현)
		{//스코프
			System.out.println(); //줄정리
			System.out.println("결제완료!!");

			data.setGprice(giftPrice.get(act-1));   
		}      
		return data;

	}

	// [사용자 쿠폰 내역 출력]
	public void giftPrint(ArrayList<giftVO> vo) {
		// 쿠폰이 없으면
		if(vo.size()==0) {
			System.out.println("쿠폰 목록이 비었습니다!");
		}
		else {
			// 있으면 내역 출력
			System.out.println("===================쿠폰내역===================");
			for(int i = 0; i<vo.size();i++) {
				System.out.println((i+1)+" 쿠폰번호 : "+vo.get(i).getGnum()+"\t 쿠폰 할인가격 : "+vo.get(i).getGprice());
			}         
			System.out.println("============================================");
		}
	}
	public giftVO giftPay(ArrayList<giftVO> datas) {   // data에 해당하는 mnum을 가진 AL만들어야함

	      System.out.println("쿠폰을 사용하시겠습니까?");
	      System.out.println("1. 예\t2. 아니요");
	      int act = excep.numExcep(1, 2);
	      if(act == 2) {
	         return null;
	      }   
	      if (datas.size()== 0) {
	         System.out.println("사용할수 있는 쿠폰이 없습니다.");
	         return null;
	      }
	      giftPrint(datas);
	      act = excep.numExcep(1, datas.size());
	      giftVO data = datas.get(act-1);   // 사용할 쿠폰
	      return data;
	   }
	   public int giftUsePay(giftVO data) {
	      System.out.println("얼마를 사용하시겠습니까?");
	      int couUsePrice = excep.numExcep(0,data.getGprice());
	      return couUsePrice;
	   }
	}
