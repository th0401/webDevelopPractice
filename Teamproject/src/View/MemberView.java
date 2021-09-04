package View;

import View.MyException;
import model.member.memberVO;
import model.store.storeVO;

public class MemberView {
	public MemberView() {
		excep = new MyException();
		;
	}

	private MyException excep;
	private memberVO membervo;
	private storeVO storevo;

	// [소비자/점주 선택]
	// View: 반환은 (1:고객), (2:점주) 택일로 반환 됩니다.
	// 사장님 snum추가 입력과 모드수행은 →→→→ 태호님꺼!!!
	public int memberChoice() {
		/*
		 * System.out.
		 * println("★☆★☆∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝슝  ∝   ∝ ☆★☆★");
		 * System.out.
		 * println("☆★☆★ ∝   ∝   ∝  슝∝   ∝   ∝   ∝   ∝   ∝  ∝   ∝   ∝   ∝★☆★☆");
		 * System.out.
		 * println("★☆★☆∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝ ☆★☆★");
		 * System.out.println("☆★☆★ ∝      ∝     ∝   ∝  참치라이더  ∝      ∝     ∝   ∝★☆★☆");
		 * System.out.
		 * println("★☆★☆ ∝ 슝  ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝ ☆★☆★");
		 * System.out.
		 * println("☆★☆★∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝슝  ∝   ∝   ∝   ∝★☆★☆");
		 * System.out.
		 * println("★☆★☆ ∝   ∝  ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝ ☆★☆★\n");
		 */
		System.out.println("[ 회원을 선택해주참 = 33 ]"); // ? ㅎ..
		System.out.println("   1. 고갱늼  *^▼^* \t2. 사장님  *^▽^*");
		System.out.println("\n"); // 줄정리

		int act = excep.numExcep(1, 2); // 유효성검사 함수호출 → 1~2사이 입력
		return act;
	}

	// ★로그인 관련
	// [회원관련] 회원/비회원/정보찾기/가입
	// View: 반환은 1~4모드 중 택일로 int 반환 됩니다.
	public int memberMod() {
		System.out.println(
				"∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝  슝∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝슝 ∝   ∝  ∝   ∝  ∝   ∝   ∝  ∝   ∝  ∝   ∝  ∝  ∝   ∝  ∝   ∝  ∝   ∝ ");
		System.out.println(
				"∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝슝  ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝  ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝ 슝∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝    ∝  ∝   ∝  ∝   ∝숑∝  ∝   ∝  ∝   ∝  ∝   ∝  ");
		System.out.println(
				"            ***        ***         ***      ***    ***********  ***          ****        ***     ***********     ***");
		System.out.println(
				"         **********    *****    **********   ***             **  *****     ***    ***     ***     ***             ***");
		System.out.println(
				"            * * *       *****      * * *      ***    **********   *****    ***      ***    ***     ***         *******");
		System.out.println(
				"            **   **      ***       **   **     ***   **            ***      ***      ***    ***     ***         *******");
		System.out.println(
				"             ****************      **      **   ***   ************  ***      ***     ***     ***     ***             ***");
		System.out.println(
				"             **            **      **        **  ***                 ***       ***   ***      ***     *************   ***");
		System.out.println(
				"              ****************                    ***                 ***         ****         ***                     ***");
		System.out.println(
				" ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝  ∝  ∝  ∝   ∝  ∝   ∝  ∝슝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝  슝 ∝  ∝   ∝  ∝   ∝  ∝  ∝  ∝   ∝  ∝   ∝    ∝  ∝   ∝  ∝   ∝ ∝  ∝   ∝  ∝   ∝  ∝  ∝ ");
		System.out.println(
				"∝   ∝   ∝ 슝 ∝   ∝   ∝   ∝   ∝   ∝   ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝슝  ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝  ∝   ∝  ∝   ∝  ∝   ∝  ∝  ∝   슝∝  ∝   ∝  ∝   ∝ ");

		System.out.println("[          " + "회원 선택" + "                      ]");
		System.out.println("1.회원");
		System.out.println("2.비회원");
		System.out.println("3.ID/PW 찾기");
		System.out.println("4.회원가입");

		int act = excep.numExcep(1, 4); // 유효성검사 함수호출 → 1~4사이 입력
		return act;
	}

	// 1 [회원 로그인]
	// View: 회원이 입력한 "membervo를 반환" 합니다. --> 이후 회원대조 필요
	// 사장님 모드로 진입시 --> 태호님꺼 가게확인 메서드를 이어서 추가호출해주시면 됩니다.
	public memberVO memberLogin() {
		membervo = new memberVO();
		System.out.println("\n * * * * * 로그인 * * * * * ");

		// 아이디 입력 & vo id 데이터저장
		System.out.print("ID: ");
		String id = excep.strExcep();
		membervo.setId(id); // vo id저.장.!

		// 비밀번호 입력 & vo pw 데이터저장
		System.out.print("PW: ");
		String pw = excep.strExcep();
		membervo.setPw(pw); // vo pw저.장.!

		return membervo; // 저장된 vo 반환
	}

	// 1-1 [로그인완료 or 실패 출력문구]
	// View: select받은 vo를 넣어주시면 됩니다!! (null은 로그인실패로 간주)
	// boolean 타입으로 전달되니 조건문 사용하시면 될 듯
	public boolean memberLogicApply(memberVO vo) {

		// 로딩효과
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}

		// 로그인 여부 비교
		// 로그인 실패
		if (vo == null) {
			System.out.println("[로그인 실패] 다시 입력해주세요.");
			return false;
		}
		// 로그인 성공
		System.out.println("성공!! 로그인 되었습니다.\n");
		return true;
	}

	// 2 [비회원 로그인]
	// View: 인자리턴없이 출력만 안내됩니다.
	public void unmemberPrint() {
		System.out.println("=] 반갑습니다!! 비회원으로 접속 됩니다.");
	}

//--------------------------------------------------------------
	// 3 [정보찾기 모드선택] ~189Line
	// View: 1.아이디 2.비밀번호 중 택일의 번호를 반환합니다! --> 목록에 따라 3-1~2 호출해주세욤
	// 아이디/비밀번호 →→ 멤버번호만 입력된 vo 반환, 멤버번호 →→ 아이디만 입력된 vo 반환
	public int memberDataSearchMod() {

		System.out.println("찾고자하는 목록을 선택해주세요!");
		System.out.println("1.아이디\t2.비밀번호");

		int act = excep.numExcep(1, 2); // 유효성검사 호출 > 1~3입력

		return act;
	}

	// 3-1.[아이디 찾기] // 3-2이랑 동일 --> 출력문구만 다름
	// View : mnum만 들어간 vo가 반환됩니다. dao select 후 >>104라인<< 출력을 해주시면 됩니다.
	public memberVO memberDataIDSearch() {
		membervo = new memberVO();
		System.out.println("\n아이디 찾기를 클릭하셨습니다.");
		membervo = mnumScan(); // 멤버번호를 받는 메서드 호출

		return membervo;
	}

	// 3-1에서 아이디 찾으면 출력할 문구
	// select받은 vo를 넣어주시면 됩니다!! (null은 로그인실패로 간주)
	// boolean 타입으로 전달되니 조건문 사용하시면 될 듯
	public boolean memberIDReturn(memberVO vo) {
		// 찾기 실패
		if (vo == null) {
			System.out.println("존재하지 않는 멤버번호입니다!\n\n");
			return false;
		}
		// 찾기 성공
		System.out.println("고객님의 아이디는 《" + vo.getId() + "》 입니다.\n\n");
		return true;

	}

	// 3-2.[비밀번호 찾기] // 3-1이랑 동일 --> 출력문구만 다름
	// View : mnum만 들어간 vo가 반환됩니다. dao select 후 >>116라인<< 출력을 해주시면 됩니다.
	public memberVO memberDataPWSearch() {
		membervo = new memberVO();
		membervo = mnumScan(); // 멤버번호를 받는 메서드 호출
		System.out.println("\n비밀번호 찾기를 클릭하셨습니다.");

		return membervo;
	}

	// 3-2에서 비밀번호 찾으면 출력할 문구
	// select받은 vo를 넣어주시면 됩니다!! (null은 로그인실패로 간주)
	// boolean 타입으로 전달되니 조건문 사용하시면 될 듯
	public boolean memberPWReturn(memberVO vo) {
		// 찾기 실패
		if (vo == null) {
			System.out.println("존재하지 않는 멤버번호입니다!\n\n");
			return false;
		}
		// 찾기 성공
		System.out.println("고객님의 패스워드는 《" + vo.getPw() + "》 입니다.\n\n");
		return true;
	}

	// 멤버번호 찾기 구현은 해놨으나.. select에서 id찾기 기능이없어서 빼놓음 //3-3.[멤버번호 찾기]
	// View : ID/PW만 들어간 vo가 반환됩니다. dao select 후 >>141라인<< 출력을 해주시면 됩니다.
	/*
	 * public memberVO memberDataSearchMNUM() {
	 * System.out.println("\n멤버번호 찾기를 클릭하셨습니다.");
	 * System.out.println("본인 확인을 위해 멤버번호를 입력해주세요!");
	 * 
	 * // id입력 System.out.print("ID: "); String id = excep.strExcep();
	 * 
	 * System.out.print("PW: "); String pw = excep.strExcep();
	 * 
	 * // 사용자 입력데이터 저장 membervo.setId(id); membervo.setPw(pw);
	 * 
	 * return membervo; //반환 } // 3-3에서 비밀번호 찾으면 출력할 문구 public void
	 * memberMNUMReturn(memberVO vo) {
	 * System.out.println("고객님의 멤버번호는 《"+vo.getMnum()+"》 입니다.\n\n"); }
	 */

	// 4 [회원가입]
	// View: 회원이 입력한 "membervo를 반환" 합니다. --> 이후 dao에서 id 중복값 확인 필요
	public memberVO signUp() {
		membervo = new memberVO();
		System.out.println("\n * * * * * 회원가입  * * * * * ");
		System.out.println("가입에 필요한 정보들을 입력해주세요! 8-)");

		// 아이디 입력 & vo id 데이터저장
		System.out.print("ID: ");
		String id = excep.strExcep();
		membervo.setId(id); // 저.장.!

		// 비밀번호 입력 & vo pw 데이터저장
		System.out.print("PW: ");
		String pw = excep.strExcep();
		membervo.setPw(pw); // 저.장.!

		return membervo;
	}

	// [가입완료 출력문구]
	// View: 대조시 selectOne로 반환받았던 인자로 넣어주세요! (null은 회원가입성공!)
	// boolean 타입으로 전달되니 조건문 사용하시면 될 듯
	public boolean signUpApply(memberVO vo) {
		if (vo != null) {
			System.out.println("\n♡ XD 참치 라이더 :D 가입을 환영합니다! ♡");
			System.out.println("회원 가입은 정상적으로 완료되었으며,");
			//System.out.println("고객님의 mnum는 " + vo.getMnum() + "입니다.");
			System.out.println("즉시 참치 라이더를 즐기실 수 있습니다~!!! 고고씽  ;0)\n\n");
			return true;
		}
		System.out.println("이미 존재하는 ID입니다.");
		System.out.println("다시 입력하여 주세요!!\n\n");
		return false;
	}

	// [회원 로그인 후--> 모드선택] 주문/정보변경/쿠폰/종료
	// View: 반환은 (1주문/2정보변경/3쿠폰/4종료) 택일로 반환 됩니다.
	public int memberModPick() {
		System.out.println("\n▶              " + "이동 번호 Pick!!" + "     ◀");
		System.out.println("1. 군침이 싸악.. 돋는 #주문#:P\n2. 소중한 #정보변경#\n3. 서프라이즈 #쿠폰구매#\n4. 퇴장");
		int act = excep.numExcep(1, 4); // 유효성검사 함수호출 → 1~2사이 입력
		return act;
	}
	// 1. 주문 --> 메뉴view / 3.쿠폰 --> 쿠폰view로 참고!

	// ★ CRUD 관련
	// 1 [정보변경모드 선택]
	// View: 반환은 (1:패스워드), (2:탈퇴) 택일로 반환 됩니다.
	public int memChangeMod() {
		System.out.println("\n[      " + "정보변경" + "                  ]");
		System.out.println("1. 패스워드 변경 \n2. 회원탈퇴 :| ");
		int act = excep.numExcep(1, 2); // 유효성검사 함수호출 → 1~2사이 입력
		return act; // 입력한 모드 반환
	}

	// 1-1 [패스워드변경]
	// View: 인자는 login에서 받은 인자, 회원이 변경한 "membervo를 반환" 합니다. --> 이후 중복데이터가(id) 없는지 확인
	// 필요
	public memberVO memberUpdateData(memberVO vo) {
		membervo = new memberVO();
		membervo = vo; // 인자 데이터 저장

		// 변경사항 적용
		System.out.println("변경 패스워드를 입력해주세요!! :-D");
		String pw = excep.strExcep();
		vo.setPw(pw);

		System.out.println("패스워드 변경이 완료 되었습니다!");
		return vo; // 변경한 vo 반환
	}

	// 1-2 [업데이트 완료 문구]
	public void memberUpdateApply() {
		System.out.println("입력하신 패스워드가 정상적으로 반영되었습니다!!\n");
	}

	// 2[회원탈퇴]
	// View: mnum만 들어간vo가 반환. "회원탈퇴취소를 하면 vo=null이 반환됩니다"
	// 반환받은vo가 dao에서 멤버번호가 일치하면 -->290번 라인 수행
	public memberVO memberDeleteData() {
		membervo = null;

		// 탈퇴 적용
		System.out.println("회원탈퇴를 진행하기 위한 본인확인을 아래 입력해주세요.");
		System.out.print("비밀번호 확인 : ");
		String pw = excep.strExcep();
		System.out.println("정말로 회원탈퇴를 진행하시겠습니까??");
		System.out.println("1. 예\t2. 아니오");
		int act = excep.numExcep(1, 2); // 유효성검사 호출 --> 1~2입력
		if (act == 1) {
			membervo = new memberVO();
			membervo.setPw(pw);
		}
		return membervo;
	}

	// 모드2-1. [탈퇴 완료 문구]
	// View: selectOne로 반환받았던 인자로 넣어주세요! (null은 로그인실패로 간주)
	// boolean 타입으로 전달되니 조건문 사용하시면 될 듯
	public boolean memberDeleteApply(memberVO vo) {
		if (vo == null) {
			System.out.println("입력하신 회원번호가 맞지 않습니다!");
			return false;
		}
		System.out.println("회원탈퇴가 정상적으로 반영되었습니다.");
		System.out.println("지금까지 참치라이더를 이용하여 주셔서 감사드립니다.");
		System.out.println("다시 이용해주시길 언제든 기다리겠습니다 :D");
		return true;
	}

	// (view 내 사용)멤버번호를 받는 메서드 호출
	public memberVO mnumScan() {
		membervo = new memberVO();
		System.out.println("본인 확인을 위해 멤버번호를 입력해주세요!");
		int mnum = excep.numExcep();

		membervo.setMnum(mnum);
		return membervo;
	}
	   // 사용자 총 결제
	   public boolean pay(int totalPrice) {
	      System.out.println("\n고객님:-] 지금까지 주문하신 금액은 총 "+totalPrice+"원 입니다.");
	      System.out.println("결제를 진행하시겠습니까??");
	      System.out.println("1.결제\t2.취소");

	      int act = excep.numExcep(1, 2); //유효성검사호출 - 1~2입력

	      // 결제 취소(2)하면 false 반환
	      if(act==2) {
	         System.out.println("결제 취소되었습니다....");
	         return false;
	      }

	      System.out.println("\n결제 버튼을 클릭하셨습니다. 카드 결제가 진행됩니다!!\n");
	      System.out.print("카드결제 진행 중");
	      try {
	         for(int i = 0; i < 5; i++) {
	            Thread.sleep(500); // 로딩 효과
	            System.out.print(".");
	         }
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	      
	      System.out.println(); //줄정리
	      
	      System.out.println("결제가 완료 되었습니다!!");
	      System.out.println("이용해 주심에 감사합니다. ♡ ♡ ♡ ♡ ♡ ♡ 맛있는 식사하세요 고객님 ｏ>▼<ｏ♡ ♡ ♡  ♡  ♡ ♡\n\n");
	      
	      return true; // 결제완료>true반환
	   }

}