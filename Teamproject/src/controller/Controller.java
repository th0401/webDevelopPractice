package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import View.GiftView;
import View.MemberView;
import View.MenuView;
import View.StoreView;
import model.gift.giftDAO;
import model.gift.giftVO;
import model.member.memberDAO;
import model.member.memberVO;
import model.menu.menuDAO;
import model.menu.menuVO;
import model.store.storeDAO;
import model.store.storeVO;

public class Controller {
	Scanner sc = new Scanner(System.in);
	memberVO mvo = null; // 최초 모든 테이블 불러옴
	memberDAO mdao = null;
	MemberView mv = null;
	storeVO svo = null;
	storeDAO sdao = null;
	StoreView sview = null;
	StoreView sv = null;
	menuVO menuvo = null;
	menuDAO menudao = null;
	MenuView menuv = null;
	giftVO gvo = null;
	giftDAO gdao = null;
	GiftView gv = null;

	public void Start() {
		boolean login;
		// 로그인 -> 소비자, 점주, 회원가입, 회원 정보 찾기 선택
		while (true) {
			mvo = new memberVO();
			mdao = new memberDAO();
			mv = new MemberView();

			int act = mv.memberMod();
			if (act == 1) { // 회원
				while (true) {
					mvo = new memberVO();
					mdao = new memberDAO();
					mv = new MemberView();
					ArrayList<memberVO> loginCheck = mdao.selectList();
					mvo = mv.memberLogin();
					boolean idpwChe = true;
					for (int i = 0; i < loginCheck.size(); i++) { // id,pw 체크
						if ((loginCheck.get(i).getId().equals(mvo.getId()))
								&& (loginCheck.get(i).getPw().equals(mvo.getPw()))) { // 로그인 성공
							mvo = loginCheck.get(i);
							idpwChe = false;
							break;
						}

					}
					if (idpwChe) {
						mvo = null; //
					}
					login = mv.memberLogicApply(mvo);
					if (login) {
						break;
					}
					System.out.println("다시 로그인 하시겠습니까?");
					System.out.println("1. 예\t2. 아니오(비회원으로 로그인됩니다.)");
					act = sc.nextInt();
					if (act == 1) {
						continue;
					}
					mv.unmemberPrint(); // 로그인 안할시
					login = false; // 로그인 false
					break; // 종료
				}
				break;
			} else if (act == 2) { // 비회원
				mv.unmemberPrint(); // 비회원 로그인
				login = false; // 로그인 false
				break;
			} else if (act == 4) { // 회원가입
				while (true) {
					mvo = mv.signUp();
					ArrayList<memberVO> IDCheck = mdao.selectList();
					boolean flag = false;
					for (int i = 0; i < IDCheck.size(); i++) {
						if (IDCheck.get(i).getId().equals(mvo.getId())) {
							flag = true;
							break;
						}
					}
					if (flag) { // 설정 ID가 있을때
						mvo = null; // null 입력
					}

					boolean IDcheck = mv.signUpApply(mvo);
					if (IDcheck) {
						break;
					}
				}
				mdao.insert(mvo); // DB업데이트
				ArrayList<memberVO> loginCheck = mdao.selectList();
				for (int i = 0; i < loginCheck.size(); i++) { // id,pw 체크
					if ((loginCheck.get(i).getId().equals(mvo.getId()))
							&& (loginCheck.get(i).getPw().equals(mvo.getPw()))) { // 로그인 성공
						mvo = loginCheck.get(i);
						break;
					}
				}
				continue;
			} else if (act == 3) { // 회원정보찾기
				act = mv.memberDataSearchMod();
				if (act == 1) { // ID찾기
					mvo = mv.memberDataIDSearch();
					ArrayList<memberVO> IDSearch = mdao.selectList();
					boolean flag = true;
					for (int i = 0; i < IDSearch.size(); i++) {
						if (IDSearch.get(i).getMnum() == mvo.getMnum()) {
							mvo = IDSearch.get(i);
							flag = false;
							break;
						}
					}
					if (flag) { // 찾는 ID가 없을때
						mvo = null; // null 입력
					}
					mv.memberIDReturn(mvo); // ID가 있으면 ID값, 없으면 null값 줌
					continue;
				} else { // 비밀번호 찾기
					mvo = mv.memberDataPWSearch();
					ArrayList<memberVO> PWSearch = mdao.selectList();
					boolean flag = true;
					for (int i = 0; i < PWSearch.size(); i++) {
						if (PWSearch.get(i).getMnum() == mvo.getMnum()) {
							mvo = PWSearch.get(i);
							flag = false;
							break;
						}
					}
					if (flag) { // 찾는 데이터가 없을때
						mvo = null; // null 입력
					}
					mv.memberPWReturn(mvo);
					continue;

				}
			}
		}

		int act = mv.memberChoice();
		if (act == 1) { // 주문자 모드
			while (true) {
				act = mv.memberModPick();
				if (act == 1) { // 주문
					menudao = new menuDAO();
					menuv = new MenuView();
					sdao = new storeDAO();
					svo = new storeVO();
					sv = new StoreView();
					menuvo = new menuVO();
					ArrayList<storeVO> getStoreList = sdao.selectList();
					act = sv.storeALLView(getStoreList);
					if(act==0) {  // 가게가 0개인데 무엇을 실행시킨단 말이오...
						return;
					}
					svo.setSnum(act);
					svo = sdao.selectOne(svo); // 가게선택 완료

					for(int i = 0; i < getStoreList.size(); i++) {
						if(getStoreList.get(i).getSnum() == svo.getSnum()) {
							svo = getStoreList.get(i);
						}
					}

					menuvo.setSnum(svo.getSnum());
					// System.out.println(menuvo);
					// menuvo = menudao.selectOne(menuvo); // 가게 - 메뉴 동기화
					// System.out.println(menuvo);

					//이예나 수정 → 메뉴재선택: 주문량만큼 재고수가 반영안되어있는 부분 수정 and 품절된 메뉴 주문불가 
					int totalPrice = 0;
					ArrayList<menuVO> getMenuList; 
					menuVO vo = null;
					while(true) {
						
						getMenuList=menudao.StoreMenu_List(menuvo);
						act=menuv.menuPickNum(getMenuList);
						
						vo = menuv.menuPickReturn(getMenuList, act);
						if (vo == null) {
							break;
						}
						vo.setMenucnt(vo.getMenucnt()-1); //재고차감
						getMenuList.get(act-1).setMenucnt(vo.getMenucnt());//재고차감
					
						for (int i = 0; i < getMenuList.size(); i++) {
							if(i==(act-1)) {
								totalPrice += getMenuList.get(i).getPrice();	
							}
						}
						if(!menuv.menuPick()) {//추가주문안하면 반복문 종료
							break;
						}

					}
					if (vo != null && login) {
						gv = new GiftView();
						gvo = new giftVO();
						gdao = new giftDAO();
						gvo.setMnum(mvo.getMnum());
						ArrayList<giftVO> getHasGift = gdao.MemberGiftList(gvo);
						gvo = gv.giftPay(getHasGift);
						int giftUse=0;
		                  if(gvo != null) {
		                     while(true) {
		                        giftUse = gv.giftUsePay(gvo);
		                        if (totalPrice<giftUse) {
		                           System.out.println("금액만큼 사용할 수 있습니다");
		                           continue;
		                        }
		                        else {
		                           totalPrice -= giftUse;
		                           gvo.setGprice(gvo.getGprice()-giftUse);
		                           // System.out.println(gvo);
		                           gdao.update(gvo);
		                           break;
		                        }
		                     }
		                  }
					}
						boolean payCheck = mv.pay(totalPrice);

						if (payCheck) {
							for (int i = 0; i < getMenuList.size(); i++) {
								menuvo = getMenuList.get(i);
								menudao.update(menuvo); // 주문처리 재고 DB마이너스 완료

							}
						}
					
					
				} else if (act == 2) { // 정보변경
					act = mv.memChangeMod();
					if (act == 1) { // pw변경
						mvo = mv.memberUpdateData(mvo);
						mdao.update(mvo);
						mv.memberUpdateApply();
					} else { // 회원탈퇴
						while (true) {
							memberVO delCh = new memberVO();
							delCh = mv.memberDeleteData();
							if (!mvo.getPw().equals(delCh.getPw())) {
								delCh = null;
							}
							if (mv.memberDeleteApply(delCh)) {
								mdao.delete(mvo);
								break;
							}
						}
						break;
					}
				} else if (act == 3) { // 쿠폰구매
					if(login == false) {
                        System.out.println("비회원은 쿠폰을 구매할 수 없습니다.");
                        continue;
                     }
					while (true) {
						gv = new GiftView();
						act = gv.giftMenuSelect();
						gvo = new giftVO();
						gdao = new giftDAO();
						gvo.setMnum(mvo.getMnum());
						if (act == 1) { // 쿠폰확인
							ArrayList<giftVO> couponList = gdao.MemberGiftList(gvo);
							gv.giftPrint(couponList);
						} else if (act == 2) { // 쿠폰구매						     
							gvo = gv.giftBuy(mvo);
							if(gvo == null) {
								continue;
							}
							String gnum = numRandom();
							gvo.setGnum(gnum);
							// System.out.println(gvo);
							gdao.insert(gvo); // db에 넣기
						} else if (act == 3) { // 쿠폰선물하기
							ArrayList<memberVO> presentList = mdao.selectList();
							gvo = gv.giftPresent(presentList);
							if(gvo == null) {
								continue;
							}
							String gnum = numRandom();
							gvo.setGnum(gnum);
							gdao.insert(gvo);

						} else { // 종료하기
							System.out.println("쿠폰 모드를 종료합니다.");
							break;
						}
					}
				} else { // 종료
					System.out.println("\n지금까지 참치라이더 이용해 주셔서 감사합니다!! :-3");
					break;
				}
			} // 사용자 모드 끝
		} else if (act == 2) { // 사장님모드
			if(login == false) {
				System.out.println("사장님모드는 회원가입을 진행하셔야 합니다. 프로그램을 종료합니다.");
				return;
			}
			while (true) {
				svo = new storeVO();
				sdao = new storeDAO();
				sv = new StoreView();
				menuv = new MenuView();
				act = sv.storePick();
				svo.setMnum(mvo.getMnum()); // ID에 부여되어 있는 mnum을 store에 있는 mnum과 연동
				// System.out.println(mvo);
				if (act == 1) { // 메뉴정보 수정
					while(true) {
						svo = new storeVO();
						sdao = new storeDAO();
						sv = new StoreView();
						menuv = new MenuView();
						svo.setMnum(mvo.getMnum());
						act = sv.menuOption();
						if (act == 1) { // 메뉴 보기
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // 여기까지 가지고 있는 store보여줌
							svo = sv.storeSnumCheck(MemStore); // store중에서 1개 선택
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO();
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store에 부여되어있는 snum을 menu에 있는 snum과 연동
							ArrayList<menuVO> menu = menudao.StoreMenu_List(menuvo);
							menuv.memPrint(menu);
						} else if (act == 2) { // 메뉴 추가
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // 여기까지 가지고 있는 store보여줌
							svo = sv.storeSnumCheck(MemStore); // store중에서 1개 선택
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO(); // 초기화
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store에 부여되어있는 snum을 menu에 있는 snum과 연동
							menuvo = menuv.menuInsert(svo);
							menudao.insert(menuvo);
						} else if (act == 3) { // 메뉴 변경
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // 여기까지 가지고 있는 store보여줌
							svo = sv.storeSnumCheck(MemStore); // store중에서 1개 선택
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO();
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store에 부여되어있는 snum을 menu에 있는 snum과 연동
							ArrayList<menuVO> menu = menudao.StoreMenu_List(menuvo);
							menuvo = menuv.menuUpdateData(menu);
							if (menuvo == null) {
								continue;
							}
							menuv.menuyUpdateApply();
							menudao.update(menuvo);
						} else if (act == 4) { // 메뉴 삭제
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // 여기까지 가지고 있는 store보여줌
							svo = sv.storeSnumCheck(MemStore); // store중에서 1개 선택
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO();
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store에 부여되어있는 snum을 menu에 있는 snum과 연동
							ArrayList<menuVO> menu = menudao.StoreMenu_List(menuvo);
							boolean delm = menuv.delPrint(menu);
							if(delm) {
								menuvo = menuv.menuDeleteData();
								boolean flag = true;
								for (int i = 0; i < menu.size(); i++) {
									if (menu.get(i).getMenunum() == menuvo.getMenunum()) {
										menuvo = menu.get(i);
										flag = false;
									}
								}
								if (flag) {
									menuvo = null;
								}
								boolean menuVlaueCheck = menuv.menuDeleteApply(menuvo);
								if (menuVlaueCheck) {
									menudao.delete(menuvo);
								}
							}
							
						} else { // 종료
							System.out.println("이용해주셔서 감사합니다!");
							break;
						}
					}
				} else if (act == 2) { // 점포 정보 수정
					while(true) {
						act = sv.storeOption();
						if (act == 1) { // 가게정보보기
							svo.setMnum(mvo.getMnum());
							ArrayList<storeVO> store = sdao.StoreMember_List(svo); // 해당하는 mnum으로된 AL
							sv.storePrint(store);
						} else if (act == 2) { // 가게 추가
							svo = sv.storeInsert();
							if (svo == null) {
								svo= new storeVO();
								continue;
							}
							svo.setMnum(mvo.getMnum());
							sdao.insert(svo);
						} else if (act == 3) { // 가게 정보 변경
							svo.setMnum(mvo.getMnum());
							ArrayList<storeVO> store = sdao.StoreMember_List(svo);							
							sv.storePrint(store);
							svo = sv.storeUpdate(store);
							if (svo == null) {
								svo= new storeVO();
								continue;
							}
							sdao.update(svo);
						} else if (act == 4) { // 가게 삭제
							svo.setMnum(mvo.getMnum());
							ArrayList<storeVO> store = sdao.StoreMember_List(svo);
							svo = sv.storeDelete(store);
							if (svo == null) {
								svo= new storeVO();
								continue;
							}
							sdao.delete(svo);
						} else { // 종료
							break;
						}
					}
				} else if (act == 3){ // 점포 추가
					svo = sv.storeInsert();
					if (svo == null) {						
						continue;
					}
					svo.setMnum(mvo.getMnum());
					// System.out.println("mvo : " + mvo);
					// System.out.println("svo : " + svo);
					sdao.insert(svo);
				}
				else { // 종료
					System.out.println("이용해주셔서 감사합니다.");
					return;
				} // 점포 정보 수정 끝
			} // 사장님 모드 while 끝
		} // 사장님 모드 끝
	} // Start 함수끝

	public String numRandom() { // gift번호 랜덤 함수
		Random rand = new Random();
		gdao = new giftDAO();
		String gnum;
		while (true) {
			int anum, bnum, cnum; // 쿠폰번호 1열 2열 3열
			anum = (rand.nextInt(5) + 1) * 10000 + rand.nextInt(10000); // 10000~59999
			bnum = (rand.nextInt(9) + 1) * 100 + rand.nextInt(100); // 100~999
			cnum = (rand.nextInt(9) + 1) * 10 + rand.nextInt(10); // 10~99
			gnum = anum + "-" + bnum + "-" + cnum; // ex) 10000-100-10
			giftVO gvo = new giftVO(); // 임시저장(gnum비교)
			ArrayList<giftVO> gnumCheck = gdao.selectList();
			boolean numCheck = true;
			for (int i = 0; i < gnumCheck.size(); i++) {
				if (gnumCheck.get(i).getGnum().equals(gnum)) {
					numCheck = false;
				}
			}
			if (numCheck) {
				break; // 이상없다면 반복문종료
			}
		}
		return gnum;
	}

} // class끝
