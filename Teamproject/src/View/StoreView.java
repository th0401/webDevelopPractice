package View;

import java.util.ArrayList;
import java.util.Scanner;

import model.menu.menuVO;
import model.store.storeVO;

// 태호님 부분
public class StoreView {
	private MyException excep;

	public StoreView() {
		excep = new MyException();
	}

	public int storeALLView(ArrayList<storeVO> datas) {
		System.out.println("\n======================주문가게 List!=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i+1) + ". " + datas.get(i).getSname());
		}
		System.out.println("======================================================\n\n");
		System.out.print("원하시는 가게 번호를 입력해주세요! : ");
		if(datas.size()==0) {
			System.out.println("아직 등록된 가게가 없습니다. 보다 나은 서비스로 다시 돌아오겠습니다.");
			return 0;
		}
		int act = excep.numExcep(1, datas.size());
		return act;
	}

	public int storePick() {
		System.out.println("환영합니다! 점주모드로 입장하셧습니다! 원하시는 번호를 입력해주세요!");
		System.out.println("1. 메뉴 정보 수정\n2. 점포 정보 수정\n3. 점포 등록\n4. 프로그램 종료");
		int act = excep.numExcep(1, 4);
		return act;
	}

	public int storeOption() {
		// 가게의 모든정보(가게명,가게전화번호)를 받을 객체설정
		System.out.println("점포 정보 옵션입니다!");
		System.out.println();
		System.out.println("1. 가게정보 보기\n2. 가게추가\n3. 가게정보 변경\n4. 가게삭제\n5. 종료 ");
		System.out.println("번호를 선택하세요.");
		int act = excep.numExcep(1, 5); // 예외처리 호출) 1~5 정상입력할 때까지 반복 -> "정상입력숫자 반환"

		return act;
	}

	public int menuOption() {

		System.out.println("점주 메뉴 옵션입니다!");
		System.out.println();
		System.out.println("1. 전체 메뉴보기\n2. 메뉴추가\n3. 메뉴정보 변경\n4. 메뉴삭제\n5. 종료");
		System.out.println("번호를 선택하세요.");
		int act = excep.numExcep(1, 5); // 예외처리 호출) 1~5 정상입력할 때까지 반복 -> "정상입력숫자 반환"

		return act;
	}

	// [메서드] 점주 가게목록
	public void storePrint(ArrayList<storeVO> vo) {
		if (vo.size() == 0) {
			System.out.println("가게가 하나도 없어요 사장님...가게를 먼저 추가해주세요!");
		} else {
			// 만약 ArrayList vo가 0 == 내용이 하나도 출력
			System.out.println("=====================가게정보=====================");
			for (int i = 0; i < vo.size(); i++) {
				System.out.println("가게번호 " + vo.get(i).getSnum() + "\t   " + "가게명 : " + vo.get(i).getSname() + "\t"
						+ "가게전화번호☎ : " + vo.get(i).getScall());
			}
			System.out.println("================================================");
		}

	}

	// [메서드] 점주 가게추가
	public storeVO storeInsert() {
		storeVO data = null; // 종료버튼구현을 위한 초기화

		System.out.println("가게추가 모드입니다!\t 종료0번");

		System.out.println("추가할 가게명 입력하세요.");
		String Sname = excep.strExcep(); // 예외처리 함수호출
		if (Sname.equals("0")) { // 중단종료조건 구현 0번
			System.out.println("0을 입력하였습니다 가게추가가 취소되었습니다.");
			return data;
		}
		data = new storeVO(); // 가게정보가 다 담겨있는 데이터 객체 만들기
		data.setSname(Sname);

		System.out.println("추가할 가게 전화번호를 입력하세요.");
		String Scall = excep.strExcep(); // 예외처리 함수호출
		data.setScall(Scall);

		if (Scall.equals("0")) { // 중단종료조건 구현 0번
			System.out.println("0을 입력하였습니다 가게추가가 취소되었습니다.");
			data = null;
			return data;
		}
		System.out.println("가게가 정상적으로 추가되었습니다! 환영합니다!! " + data.getSname() + "사장님∝∝∝");

		return data; // 가게추가 VO를 반환
	}

	// [메서드] 점주 > 가게정보 변경
	public storeVO storeUpdate(ArrayList<storeVO> vo) {
		storeVO data=null; //종료버튼 구현을 위한 초기화
		if (vo.size() == 0) { // 만약 가게가 하나도 없다면 종료
			System.out.println("등록된 가게가 없습니다... 가게를 먼저 추가해주세요!");
			return data;
		}
		data = new storeVO(); // 가게 정보 변경데이터를 넣을 객체설정
		System.out.println("가게 정보변경 모드입니다.");
		data = storeSnumCheck(vo); // 어레이리스트 vo의 모든VO를 데이터에 저장!
		if (data == null) { // 만약 SnumCheck에서 종료0을 누르면 취소 => null값 반환!
			System.out.println("가게변경 모드를 종료합니다.");
			return data; // 데이터는 null입니다.
		}

		while (true) {
			System.out.println("어떤 정보를 변경하시겠어요?");
			System.out.println("번호를 입력하세요.");
			System.out.println("1. 가게명 변경\n2. 가게전화번호 변경\n3. 종료");
			int act = excep.numExcep(1, 3); // 예외처리 호출) 1~3 정상입력할 때까지 반복 -> "정상입력숫자 반환"
			if (act == 1) {
				// [가게명 입력]
				System.out.println("변경할 가게명을 입력해주세요!\t종료0번");
				String Sname = excep.strExcep(); // 예외처리 함수호출
				if (Sname.equals("0")) { // 0을 누르면 다시입력!
					continue;
				}
				data.setSname(Sname); // 가게명 삽입
				System.out.println("가게명이 " + Sname + "(으)로 변경되었습니다!");
				continue;
			} else if (act == 2) {
				// [가게 전화번호 입력]
				System.out.println("변경할 가게 전화번호를 입력해주세요!\t종료0번");
				String Scall = excep.strExcep(); // 예외처리 함수호출
				if (Scall.equals("0")) { // 0을 누르면 다시입력!
					continue;
				}
				data.setScall(Scall); // 가게 전화번호 삽입
				System.out.println("가게 전화번호☎가 " + Scall + "(으)로 변경되었습니다!");
				continue;
			} else {
				System.out.println("정보변경 모드를 종료합니다.");
				break;
			}
		}
		return data; // 변경된 VO를 반환
	}

	public storeVO storeDelete(ArrayList<storeVO> vo) { // 어레이리스트로 인자를 받음
		storeVO data = null; // 가게 정보 변경데이터를 넣을 객체설정
		// 어레이리스트 vo의 모든VO를 데이터에 저장!
		if (vo.size() == 0) { // 만약 ArrayList vo가 0 == 내용이 하나도 없다면 그냥 null로 반환
			System.out.println("등록된 가게가 없습니다... 가게를 먼저 추가해주세요!");
			return data; // null은 취소를의미해요 컨트롤러님!
		}
		System.out.println("가게를 정말 삭제하시겠습니까? 삭제가 진행되면 복구가 불가합니다!!");
		System.out.println("취소하시려면 0번, 삭제를 진행하시려면 아무키나 누르세요!");

		while (true) {
			String choice = excep.strExcep();
			if (choice.equals("0")) {
				System.out.println("가게 삭제모드를 종료합니다.");
				return data; // null은 취소를의미해요 컨트롤러님!
			} else {
				data = new storeVO();
				storePrint(vo);
				System.out.println("가게 삭제모드가 진행됩니다.");
				System.out.println("삭제할 가게 번호를 입력해주세요.\t 종료0번");
				data = storeSnumCheck(vo);// VO를 반환
				if (data == null) {
					System.out.println("가게 삭제모드를 종료합니다.");
					return data;
				}
				System.out.println("삭제가 완료되었습니다.");
				return data; // 삭제할 VO를 넘긴다
			}
		}

	}

	// [메서드] 유효성검사와 동시에 vo의 정보들을 모두 반환하는 메서드
	public storeVO storeSnumCheck(ArrayList<storeVO> vo) {
		storeVO data = null;
		System.out.println("점포 확인을 위해서 가게 번호를 입력해 주세요!\t종료0번");
		while (true) {
			int Snum = excep.numExcep(); // 예외처리 함수호출
			if (Snum == 0) {
				System.out.println("0을 입력하셨습니다."); // 널로 반환되는건 전부 취소로 나타내어 주세요 컨트롤러님!
				return data;
			}

			boolean flag = true;
			for (int i = 0; i < vo.size(); i++) {
				if (vo.get(i).getSnum() == Snum) {
					data = new storeVO(); // VO 반환해주는 객체만들기
					data.setSnum(Snum); //
					data.setSname(vo.get(i).getSname());
					data.setScall(vo.get(i).getScall());
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("없는 가게번호에요 다시 입력해주세요.");
				continue;
			}
			break;
		}
		return data; // VO 반환
	}
}