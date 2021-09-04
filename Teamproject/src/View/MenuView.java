package View;

import java.util.ArrayList;

import View.MyException;
import model.menu.menuVO;
import model.store.storeVO;

public class MenuView {
	public MenuView() {
		excep = new MyException(); // 유효성 검사 객체생성
	}

	private menuVO menuvo;
	private MyException excep;

	// ★ C R U D 관 련 ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★
	// ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★

	// [메서드] 메뉴판 출력 //스토어selectAll로 받은 인자로 넣어주세요!
	// View: 소비자에게 메뉴번호와 같이 안내해주기 위해 AL<vo>로 인자를 받아야합니다. //반환없음
	public void menuPrint(ArrayList<menuVO> datas) {
		// 데이터 크기가 없다면 종료
		if (datas.size() == 0) {
			System.out.println("\n해당 가게의 메뉴가 없습니다.");
			System.out.println("다른 지점을 이용해 주세요!\n\n");
			return; // 쓰레기값
		}
		// 데이터가 있다면 메뉴판 출력 // 예시) 1. 마라탕 13000원 [5]

		System.out.println("\n=======================메뉴판=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + ". " + datas.get(i).getMenuname() + " " + datas.get(i).getPrice() + "원\t" + "["
					+ datas.get(i).getMenucnt() + "]");
		}
		System.out.println("=================================================\n\n");
	}


	   public menuVO menuPickReturn(ArrayList<menuVO> datas, int act) { // ArrayList<menuVO> datas
	      menuVO data = new menuVO();
	      menuVO vo = new menuVO();
	      if (datas.size() == 0) {		        
		         return null; //데이터가 없으면 0으로 반환 
		      }
	      data = datas.get(act - 1);
	      vo.setMenunum(data.getMenunum());
	      vo.setSnum(data.getSnum());
	      vo.setPrice(data.getPrice());
	      vo.setMenucnt(data.getMenucnt());
	      vo.setMenuname(data.getMenuname());

	      return vo;
	   }
	      // 메뉴 선택번호 반환
	   public int menuPickNum(ArrayList<menuVO> datas) {
	      menuPrint(datas);
	      int act = 0;
	      if (datas.size() == 0) {
	         System.out.println("주문할 메뉴가 없습니다!\n\n");
	         return act; //데이터가 없으면 0으로 반환 
	      }

	      System.out.println("원하시는 메뉴를 골라주세요!");
	      act = excep.numExcep(1, datas.size());

	      if (datas.get(act - 1).getMenucnt() <= 0) {// 추가:재고 0아래면 주문불가
	         System.out.println("해당 메뉴는 품절되어 주문이 불가합니다. :-(\n");
	      }
	      return act;
	   }

	public boolean menuPick() { // 추가주문 여부리턴
		System.out.println("추가 주문메뉴 있으신가요??");
		System.out.println("1. 예\t2.아니요");
		int act = excep.numExcep(1, 2);
		if (act == 2) {
			return false;
		}
		return true;
	}

	// ----------------------------------------------------------------------------
	// 여기까지 완료
	// [메서드] 메뉴추가 //이후 dao insert하면 -> 66번라인 반영완료문구 호출해주세요
	// View: "snum가 필요"하여 vo를 인자받고 // 입력된 메뉴데이터를 반환 합니다.
	// storeVO로 인자를 받는 것이 컨트롤에서 접근성이 좋을 것 같아서 넣었습니다.
	// menuVO가 좋다하시면 변경하셔도 무관!!!
	public menuVO headPrint(ArrayList<menuVO> datas) {
		// 데이터 크기가 없다면 종료
		if (datas.size()==0) {
			System.out.println("\n해당 가게의 메뉴가 없습니다.");
			return null; // 쓰레기값
		}
		// 데이터가 있다면 메뉴판 출력 // 예시) 1. 마라탕 13000원 [5]

		System.out.println("\n=======================메뉴판=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + ". " + datas.get(i).getMenuname() + " " + datas.get(i).getPrice() + "원\t" + "["
					+ datas.get(i).getMenucnt() + "]");
		}
		System.out.println("===============================================\n\n");
		System.out.println("원하시는 메뉴를 골라주세요!");
		int act = excep.numExcep(1, datas.size());

		menuVO add = new menuVO();
		add.setMenunum(act);
		return add;
	}

	public void memPrint(ArrayList<menuVO> datas) {
		// 데이터 크기가 없다면 종료
		if (datas.size()==0) {
			System.out.println("\n해당 가게의 메뉴가 없습니다.");
			return;
		}
		ArrayList<menuVO> bucket = new ArrayList();
		// 데이터가 있다면 메뉴판 출력 // 예시) 1. 마라탕 13000원 [5]

		System.out.println("\n=======================메뉴판=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + ". " + datas.get(i).getMenuname() + " " + datas.get(i).getPrice() + "원\t" + "["
					+ datas.get(i).getMenucnt() + "]");
		}
		System.out.println("===============================================\n\n");
	}

	public boolean delPrint(ArrayList<menuVO> datas) {
		// 데이터 크기가 없다면 종료
		if (datas.size()==0) {
			System.out.println("\n해당 가게의 메뉴가 없습니다.");
			return false;
		}
		ArrayList<menuVO> bucket = new ArrayList();
		// 데이터가 있다면 메뉴판 출력 // 예시) 1. 마라탕 13000원 [5]

		System.out.println("\n=======================메뉴판=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println("메뉴 고유번호 : " + datas.get(i).getMenunum() + "\t 메뉴명 " + datas.get(i).getMenuname() + " "
					+ datas.get(i).getPrice() + "원\t" + "[" + datas.get(i).getMenucnt() + "]");
		}
		System.out.println("===============================================\n\n");
	return true;
	}

	public menuVO menuInsert(storeVO vo) {
		menuvo = new menuVO();

		// snum 저장
		menuvo.setSnum(vo.getSnum());

		System.out.println("\n메뉴추가 모드에 접속하셨습니다!\n");

		// 메뉴이름입력
		System.out.println("메뉴 이름을 기재해주세요 :D");
		menuvo.setMenuname(excep.strExcep());

		System.out.println(); // 줄정리

		// 가격입력
		System.out.println("메뉴 가격을 입력해주세요 ;O)");
		menuvo.setPrice(excep.numExcep(1, 100000000)); // 유효성 검사 함수호출 --> 1~1억까지

		System.out.println(); // 줄정리

		// 재고입력
		System.out.println("메뉴 재고 수를 입력해주세요 :-)");
		menuvo.setMenucnt(excep.numExcep(1, 100000000)); // 유효성 검사 함수호출(str형) --> 1~1억까지

		return menuvo;// 입력된 menuvo반환
	}

	public void menuInsertApply() {
		System.out.println("\n\n입력하신 메뉴가 정상 반영 되었습니다!!\n\n");
	}

	// [메서드] 메뉴삭제 //mnum번호대조 selectOne 실행 이후 → 82번라인 출력해주세요!
	// View: menunum(pk)만 저장된 vo가 반환됩니다.
	public menuVO menuDeleteData() {
		menuvo = new menuVO();
		System.out.println("\n메뉴 삭제모드에 접속하셨습니다!\n");
		System.out.println("삭제를 진행하기 위해 가게정보에 저장된 \"메뉴 고유번호\" 를 입력해주세요!");
		menuvo.setMenunum(excep.numExcep()); // 유효성검사 함수호출입력

		return menuvo; // 입력된 menuvo반환
	}

	// 메뉴삭제완료여부 출력 >> 대조를위해select한 vo를 인자로 넣어주세요! (null은 메뉴삭제실패로 간주)
	// boolean 타입으로 반환됩니다.
	public boolean menuDeleteApply(menuVO vo) {
		if (vo == null) {
			System.out.println("입력하신 메뉴번호가 맞지 않습니다!\n\n");
			return false;
		}
		System.out.println("메뉴삭제가 정상적으로 반영이 되었습니다.\n\n");
		return true;
	}

	// [메서드] 메뉴수정 //dao 반영이후 → 154번라인 출력해주세요!
	// View: 메뉴 선택지를모르니 스토어selectAll한 AL로 인자 넣어주세요 //업데이트할 AL가 반환됩니다.(인자에데이터가없으면
	// null로반환됨)
	public menuVO menuUpdateData(ArrayList<menuVO> vo) {
		// 반환객체 생성(인자 값 없을 경우를 대비해 null로 초기화)
		ArrayList<menuVO> datas = null;

		// 인자vo의 데이터가 없으면 null로 반환하며 함수종료
		if (vo.size() == 0) {
			System.out.println("\n저장된 메뉴 데이터가 없어 수정이 불가하여 수정모드가 종료됩니다.");
			return null;
		}

		// >> 데이터가 있으면 변경모드 진행 <<
		// 반환객체 데이터 저장
		datas = vo;

		System.out.println("\n메뉴 수정모드에 접속하셨습니다!\n");

		// 저장된 메뉴 전체 출력 1. 마라탕 이런식으로..
		System.out.println(" - - - - - - - - - - 현재 메뉴 목록 - - - - - - - - - - ");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + " " + datas.get(i).getMenuname());
		}
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - -\n");

		// 메뉴변경대상 선택
		System.out.println("수정할 메뉴의 번호를 입력해주세요!\n");
		int muIndex = excep.numExcep(1, datas.size()); // 유효성검사 호출 1~총데이터 까지
		menuVO data = datas.get(muIndex - 1);
		// [변경모드 선택] - 재고/이름/가격/전체
		System.out.println("변경할 항목을 선택해주세요!");
		System.out.println("1.메뉴재고\n2.메뉴명\n3.메뉴가격\n4.전체");
		int act = excep.numExcep(1, 4); // 모드선택

		// 메뉴재고 변경
		if (act == 1) {
			System.out.println("\n변경할 재고를 입력해주세요!");
			data.setMenucnt(excep.numExcep(1, 100000000)); // 유효성검사 호출 --> 1~1억까지
		}
		// 메뉴명 변경
		else if (act == 2) {
			System.out.println("\n변경할 메뉴이름을 입력해주세요!");
			data.setMenuname(excep.strExcep());
		}
		// 메뉴가격 변경
		else if (act == 3) {
			System.out.println("\n변경할 가격을 입력해주세요!");
			data.setPrice(excep.numExcep(1, 100000000)); // 유효성검사 호출 --> 1~1억까지
		}
		// 전체 변경
		else {
			System.out.println("\n변경할 메뉴이름을 입력해주세요!");
			data.setMenuname(excep.strExcep());

			System.out.println("\n변경할 가격을 입력해주세요!");
			data.setPrice(excep.numExcep(1, 100000000)); // 유효성검사 호출 --> 1~1억까지

			System.out.println("\n변경할 재고를 입력해주세요!");
			data.setMenucnt(excep.numExcep(1, 100000000)); // 유효성검사 호출 --> 1~1억까지
		}
		return data; // 입력한 데이터반환
	}

	public void menuyUpdateApply() {
		System.out.println("\n\n입력하신 메뉴가 정상적으로 변경이 완료 되었습니다!!\n\n");
	}

}