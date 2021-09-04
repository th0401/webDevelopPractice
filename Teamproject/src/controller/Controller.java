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
	memberVO mvo = null; // ���� ��� ���̺� �ҷ���
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
		// �α��� -> �Һ���, ����, ȸ������, ȸ�� ���� ã�� ����
		while (true) {
			mvo = new memberVO();
			mdao = new memberDAO();
			mv = new MemberView();

			int act = mv.memberMod();
			if (act == 1) { // ȸ��
				while (true) {
					mvo = new memberVO();
					mdao = new memberDAO();
					mv = new MemberView();
					ArrayList<memberVO> loginCheck = mdao.selectList();
					mvo = mv.memberLogin();
					boolean idpwChe = true;
					for (int i = 0; i < loginCheck.size(); i++) { // id,pw üũ
						if ((loginCheck.get(i).getId().equals(mvo.getId()))
								&& (loginCheck.get(i).getPw().equals(mvo.getPw()))) { // �α��� ����
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
					System.out.println("�ٽ� �α��� �Ͻðڽ��ϱ�?");
					System.out.println("1. ��\t2. �ƴϿ�(��ȸ������ �α��ε˴ϴ�.)");
					act = sc.nextInt();
					if (act == 1) {
						continue;
					}
					mv.unmemberPrint(); // �α��� ���ҽ�
					login = false; // �α��� false
					break; // ����
				}
				break;
			} else if (act == 2) { // ��ȸ��
				mv.unmemberPrint(); // ��ȸ�� �α���
				login = false; // �α��� false
				break;
			} else if (act == 4) { // ȸ������
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
					if (flag) { // ���� ID�� ������
						mvo = null; // null �Է�
					}

					boolean IDcheck = mv.signUpApply(mvo);
					if (IDcheck) {
						break;
					}
				}
				mdao.insert(mvo); // DB������Ʈ
				ArrayList<memberVO> loginCheck = mdao.selectList();
				for (int i = 0; i < loginCheck.size(); i++) { // id,pw üũ
					if ((loginCheck.get(i).getId().equals(mvo.getId()))
							&& (loginCheck.get(i).getPw().equals(mvo.getPw()))) { // �α��� ����
						mvo = loginCheck.get(i);
						break;
					}
				}
				continue;
			} else if (act == 3) { // ȸ������ã��
				act = mv.memberDataSearchMod();
				if (act == 1) { // IDã��
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
					if (flag) { // ã�� ID�� ������
						mvo = null; // null �Է�
					}
					mv.memberIDReturn(mvo); // ID�� ������ ID��, ������ null�� ��
					continue;
				} else { // ��й�ȣ ã��
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
					if (flag) { // ã�� �����Ͱ� ������
						mvo = null; // null �Է�
					}
					mv.memberPWReturn(mvo);
					continue;

				}
			}
		}

		int act = mv.memberChoice();
		if (act == 1) { // �ֹ��� ���
			while (true) {
				act = mv.memberModPick();
				if (act == 1) { // �ֹ�
					menudao = new menuDAO();
					menuv = new MenuView();
					sdao = new storeDAO();
					svo = new storeVO();
					sv = new StoreView();
					menuvo = new menuVO();
					ArrayList<storeVO> getStoreList = sdao.selectList();
					act = sv.storeALLView(getStoreList);
					if(act==0) {  // ���԰� 0���ε� ������ �����Ų�� ���̿�...
						return;
					}
					svo.setSnum(act);
					svo = sdao.selectOne(svo); // ���Լ��� �Ϸ�

					for(int i = 0; i < getStoreList.size(); i++) {
						if(getStoreList.get(i).getSnum() == svo.getSnum()) {
							svo = getStoreList.get(i);
						}
					}

					menuvo.setSnum(svo.getSnum());
					// System.out.println(menuvo);
					// menuvo = menudao.selectOne(menuvo); // ���� - �޴� ����ȭ
					// System.out.println(menuvo);

					//�̿��� ���� �� �޴��缱��: �ֹ�����ŭ ������ �ݿ��ȵǾ��ִ� �κ� ���� and ǰ���� �޴� �ֹ��Ұ� 
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
						vo.setMenucnt(vo.getMenucnt()-1); //�������
						getMenuList.get(act-1).setMenucnt(vo.getMenucnt());//�������
					
						for (int i = 0; i < getMenuList.size(); i++) {
							if(i==(act-1)) {
								totalPrice += getMenuList.get(i).getPrice();	
							}
						}
						if(!menuv.menuPick()) {//�߰��ֹ����ϸ� �ݺ��� ����
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
		                           System.out.println("�ݾ׸�ŭ ����� �� �ֽ��ϴ�");
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
								menudao.update(menuvo); // �ֹ�ó�� ��� DB���̳ʽ� �Ϸ�

							}
						}
					
					
				} else if (act == 2) { // ��������
					act = mv.memChangeMod();
					if (act == 1) { // pw����
						mvo = mv.memberUpdateData(mvo);
						mdao.update(mvo);
						mv.memberUpdateApply();
					} else { // ȸ��Ż��
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
				} else if (act == 3) { // ��������
					if(login == false) {
                        System.out.println("��ȸ���� ������ ������ �� �����ϴ�.");
                        continue;
                     }
					while (true) {
						gv = new GiftView();
						act = gv.giftMenuSelect();
						gvo = new giftVO();
						gdao = new giftDAO();
						gvo.setMnum(mvo.getMnum());
						if (act == 1) { // ����Ȯ��
							ArrayList<giftVO> couponList = gdao.MemberGiftList(gvo);
							gv.giftPrint(couponList);
						} else if (act == 2) { // ��������						     
							gvo = gv.giftBuy(mvo);
							if(gvo == null) {
								continue;
							}
							String gnum = numRandom();
							gvo.setGnum(gnum);
							// System.out.println(gvo);
							gdao.insert(gvo); // db�� �ֱ�
						} else if (act == 3) { // ���������ϱ�
							ArrayList<memberVO> presentList = mdao.selectList();
							gvo = gv.giftPresent(presentList);
							if(gvo == null) {
								continue;
							}
							String gnum = numRandom();
							gvo.setGnum(gnum);
							gdao.insert(gvo);

						} else { // �����ϱ�
							System.out.println("���� ��带 �����մϴ�.");
							break;
						}
					}
				} else { // ����
					System.out.println("\n���ݱ��� ��ġ���̴� �̿��� �ּż� �����մϴ�!! :-3");
					break;
				}
			} // ����� ��� ��
		} else if (act == 2) { // ����Ը��
			if(login == false) {
				System.out.println("����Ը��� ȸ�������� �����ϼž� �մϴ�. ���α׷��� �����մϴ�.");
				return;
			}
			while (true) {
				svo = new storeVO();
				sdao = new storeDAO();
				sv = new StoreView();
				menuv = new MenuView();
				act = sv.storePick();
				svo.setMnum(mvo.getMnum()); // ID�� �ο��Ǿ� �ִ� mnum�� store�� �ִ� mnum�� ����
				// System.out.println(mvo);
				if (act == 1) { // �޴����� ����
					while(true) {
						svo = new storeVO();
						sdao = new storeDAO();
						sv = new StoreView();
						menuv = new MenuView();
						svo.setMnum(mvo.getMnum());
						act = sv.menuOption();
						if (act == 1) { // �޴� ����
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // ������� ������ �ִ� store������
							svo = sv.storeSnumCheck(MemStore); // store�߿��� 1�� ����
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO();
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store�� �ο��Ǿ��ִ� snum�� menu�� �ִ� snum�� ����
							ArrayList<menuVO> menu = menudao.StoreMenu_List(menuvo);
							menuv.memPrint(menu);
						} else if (act == 2) { // �޴� �߰�
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // ������� ������ �ִ� store������
							svo = sv.storeSnumCheck(MemStore); // store�߿��� 1�� ����
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO(); // �ʱ�ȭ
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store�� �ο��Ǿ��ִ� snum�� menu�� �ִ� snum�� ����
							menuvo = menuv.menuInsert(svo);
							menudao.insert(menuvo);
						} else if (act == 3) { // �޴� ����
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // ������� ������ �ִ� store������
							svo = sv.storeSnumCheck(MemStore); // store�߿��� 1�� ����
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO();
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store�� �ο��Ǿ��ִ� snum�� menu�� �ִ� snum�� ����
							ArrayList<menuVO> menu = menudao.StoreMenu_List(menuvo);
							menuvo = menuv.menuUpdateData(menu);
							if (menuvo == null) {
								continue;
							}
							menuv.menuyUpdateApply();
							menudao.update(menuvo);
						} else if (act == 4) { // �޴� ����
							ArrayList<storeVO> MemStore = sdao.StoreMember_List(svo);
							sv.storePrint(MemStore); // ������� ������ �ִ� store������
							svo = sv.storeSnumCheck(MemStore); // store�߿��� 1�� ����
							if(svo==null) {
								svo=new storeVO();
								svo.setMnum(mvo.getMnum());
								continue;
							}
							svo.setMnum(mvo.getMnum());
							menuvo = new menuVO();
							menudao = new menuDAO();
							menuvo.setSnum(svo.getSnum()); // store�� �ο��Ǿ��ִ� snum�� menu�� �ִ� snum�� ����
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
							
						} else { // ����
							System.out.println("�̿����ּż� �����մϴ�!");
							break;
						}
					}
				} else if (act == 2) { // ���� ���� ����
					while(true) {
						act = sv.storeOption();
						if (act == 1) { // ������������
							svo.setMnum(mvo.getMnum());
							ArrayList<storeVO> store = sdao.StoreMember_List(svo); // �ش��ϴ� mnum���ε� AL
							sv.storePrint(store);
						} else if (act == 2) { // ���� �߰�
							svo = sv.storeInsert();
							if (svo == null) {
								svo= new storeVO();
								continue;
							}
							svo.setMnum(mvo.getMnum());
							sdao.insert(svo);
						} else if (act == 3) { // ���� ���� ����
							svo.setMnum(mvo.getMnum());
							ArrayList<storeVO> store = sdao.StoreMember_List(svo);							
							sv.storePrint(store);
							svo = sv.storeUpdate(store);
							if (svo == null) {
								svo= new storeVO();
								continue;
							}
							sdao.update(svo);
						} else if (act == 4) { // ���� ����
							svo.setMnum(mvo.getMnum());
							ArrayList<storeVO> store = sdao.StoreMember_List(svo);
							svo = sv.storeDelete(store);
							if (svo == null) {
								svo= new storeVO();
								continue;
							}
							sdao.delete(svo);
						} else { // ����
							break;
						}
					}
				} else if (act == 3){ // ���� �߰�
					svo = sv.storeInsert();
					if (svo == null) {						
						continue;
					}
					svo.setMnum(mvo.getMnum());
					// System.out.println("mvo : " + mvo);
					// System.out.println("svo : " + svo);
					sdao.insert(svo);
				}
				else { // ����
					System.out.println("�̿����ּż� �����մϴ�.");
					return;
				} // ���� ���� ���� ��
			} // ����� ��� while ��
		} // ����� ��� ��
	} // Start �Լ���

	public String numRandom() { // gift��ȣ ���� �Լ�
		Random rand = new Random();
		gdao = new giftDAO();
		String gnum;
		while (true) {
			int anum, bnum, cnum; // ������ȣ 1�� 2�� 3��
			anum = (rand.nextInt(5) + 1) * 10000 + rand.nextInt(10000); // 10000~59999
			bnum = (rand.nextInt(9) + 1) * 100 + rand.nextInt(100); // 100~999
			cnum = (rand.nextInt(9) + 1) * 10 + rand.nextInt(10); // 10~99
			gnum = anum + "-" + bnum + "-" + cnum; // ex) 10000-100-10
			giftVO gvo = new giftVO(); // �ӽ�����(gnum��)
			ArrayList<giftVO> gnumCheck = gdao.selectList();
			boolean numCheck = true;
			for (int i = 0; i < gnumCheck.size(); i++) {
				if (gnumCheck.get(i).getGnum().equals(gnum)) {
					numCheck = false;
				}
			}
			if (numCheck) {
				break; // �̻���ٸ� �ݺ�������
			}
		}
		return gnum;
	}

} // class��
