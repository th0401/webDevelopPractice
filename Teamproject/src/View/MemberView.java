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

	// [�Һ���/���� ����]
	// View: ��ȯ�� (1:��), (2:����) ���Ϸ� ��ȯ �˴ϴ�.
	// ����� snum�߰� �Է°� �������� ����� ��ȣ�Բ�!!!
	public int memberChoice() {
		/*
		 * System.out.
		 * println("�ڡ١ڡ١�   ��   ��   ��   ��   ��   ��   ��   ��   ��   ��  ��   �� �١ڡ١�");
		 * System.out.
		 * println("�١ڡ١� ��   ��   ��  ����   ��   ��   ��   ��   ��  ��   ��   ��   ��ڡ١ڡ�");
		 * System.out.
		 * println("�ڡ١ڡ١�   ��   ��   ��   ��   ��   ��   ��   ��   ��   ��   ��   �� �١ڡ١�");
		 * System.out.println("�١ڡ١� ��      ��     ��   ��  ��ġ���̴�  ��      ��     ��   ��ڡ١ڡ�");
		 * System.out.
		 * println("�ڡ١ڡ� �� ��  ��   ��   ��   ��   ��   ��   ��   ��   ��   ��   ��   �� �١ڡ١�");
		 * System.out.
		 * println("�١ڡ١ڡ�   ��   ��   ��   ��   ��   ��   ��   ��  ��   ��   ��   ��ڡ١ڡ�");
		 * System.out.
		 * println("�ڡ١ڡ� ��   ��  ��   ��   ��   ��   ��   ��   ��   ��   ��   ��   �� �١ڡ١�\n");
		 */
		System.out.println("[ ȸ���� ���������� = 33 ]"); // ? ��..
		System.out.println("   1. ����  *^��^* \t2. �����  *^��^*");
		System.out.println("\n"); // ������

		int act = excep.numExcep(1, 2); // ��ȿ���˻� �Լ�ȣ�� �� 1~2���� �Է�
		return act;
	}

	// �ڷα��� ����
	// [ȸ������] ȸ��/��ȸ��/����ã��/����
	// View: ��ȯ�� 1~4��� �� ���Ϸ� int ��ȯ �˴ϴ�.
	public int memberMod() {
		System.out.println(
				"��   ��   ��   ��   ��   ��   ��   ��   ��   ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��  ����  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   �� ��   ��  ��   ��  ��   ��   ��  ��   ��  ��   ��  ��  ��   ��  ��   ��  ��   �� ");
		System.out.println(
				"��   ��   ��   ��   ��   ��   ��   ��   ��   ��  ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��  ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   �� ����   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��    ��  ��   ��  ��   �����  ��   ��  ��   ��  ��   ��  ");
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
				" ��   ��   ��   ��   ��   ��   ��   ��   ��   ��   ��  ��  ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��  �� ��  ��   ��  ��   ��  ��  ��  ��   ��  ��   ��    ��  ��   ��  ��   �� ��  ��   ��  ��   ��  ��  �� ");
		System.out.println(
				"��   ��   �� �� ��   ��   ��   ��   ��   ��   ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��  ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��   ��  ��  ��   ��  ��   ��  ��   ��  ��  ��   ����  ��   ��  ��   �� ");

		System.out.println("[          " + "ȸ�� ����" + "                      ]");
		System.out.println("1.ȸ��");
		System.out.println("2.��ȸ��");
		System.out.println("3.ID/PW ã��");
		System.out.println("4.ȸ������");

		int act = excep.numExcep(1, 4); // ��ȿ���˻� �Լ�ȣ�� �� 1~4���� �Է�
		return act;
	}

	// 1 [ȸ�� �α���]
	// View: ȸ���� �Է��� "membervo�� ��ȯ" �մϴ�. --> ���� ȸ������ �ʿ�
	// ����� ���� ���Խ� --> ��ȣ�Բ� ����Ȯ�� �޼��带 �̾ �߰�ȣ�����ֽø� �˴ϴ�.
	public memberVO memberLogin() {
		membervo = new memberVO();
		System.out.println("\n * * * * * �α��� * * * * * ");

		// ���̵� �Է� & vo id ����������
		System.out.print("ID: ");
		String id = excep.strExcep();
		membervo.setId(id); // vo id��.��.!

		// ��й�ȣ �Է� & vo pw ����������
		System.out.print("PW: ");
		String pw = excep.strExcep();
		membervo.setPw(pw); // vo pw��.��.!

		return membervo; // ����� vo ��ȯ
	}

	// 1-1 [�α��οϷ� or ���� ��¹���]
	// View: select���� vo�� �־��ֽø� �˴ϴ�!! (null�� �α��ν��з� ����)
	// boolean Ÿ������ ���޵Ǵ� ���ǹ� ����Ͻø� �� ��
	public boolean memberLogicApply(memberVO vo) {

		// �ε�ȿ��
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}

		// �α��� ���� ��
		// �α��� ����
		if (vo == null) {
			System.out.println("[�α��� ����] �ٽ� �Է����ּ���.");
			return false;
		}
		// �α��� ����
		System.out.println("����!! �α��� �Ǿ����ϴ�.\n");
		return true;
	}

	// 2 [��ȸ�� �α���]
	// View: ���ڸ��Ͼ��� ��¸� �ȳ��˴ϴ�.
	public void unmemberPrint() {
		System.out.println("=] �ݰ����ϴ�!! ��ȸ������ ���� �˴ϴ�.");
	}

//--------------------------------------------------------------
	// 3 [����ã�� ��弱��] ~189Line
	// View: 1.���̵� 2.��й�ȣ �� ������ ��ȣ�� ��ȯ�մϴ�! --> ��Ͽ� ���� 3-1~2 ȣ�����ּ���
	// ���̵�/��й�ȣ ��� �����ȣ�� �Էµ� vo ��ȯ, �����ȣ ��� ���̵� �Էµ� vo ��ȯ
	public int memberDataSearchMod() {

		System.out.println("ã�����ϴ� ����� �������ּ���!");
		System.out.println("1.���̵�\t2.��й�ȣ");

		int act = excep.numExcep(1, 2); // ��ȿ���˻� ȣ�� > 1~3�Է�

		return act;
	}

	// 3-1.[���̵� ã��] // 3-2�̶� ���� --> ��¹����� �ٸ�
	// View : mnum�� �� vo�� ��ȯ�˴ϴ�. dao select �� >>104����<< ����� ���ֽø� �˴ϴ�.
	public memberVO memberDataIDSearch() {
		membervo = new memberVO();
		System.out.println("\n���̵� ã�⸦ Ŭ���ϼ̽��ϴ�.");
		membervo = mnumScan(); // �����ȣ�� �޴� �޼��� ȣ��

		return membervo;
	}

	// 3-1���� ���̵� ã���� ����� ����
	// select���� vo�� �־��ֽø� �˴ϴ�!! (null�� �α��ν��з� ����)
	// boolean Ÿ������ ���޵Ǵ� ���ǹ� ����Ͻø� �� ��
	public boolean memberIDReturn(memberVO vo) {
		// ã�� ����
		if (vo == null) {
			System.out.println("�������� �ʴ� �����ȣ�Դϴ�!\n\n");
			return false;
		}
		// ã�� ����
		System.out.println("������ ���̵�� ��" + vo.getId() + "�� �Դϴ�.\n\n");
		return true;

	}

	// 3-2.[��й�ȣ ã��] // 3-1�̶� ���� --> ��¹����� �ٸ�
	// View : mnum�� �� vo�� ��ȯ�˴ϴ�. dao select �� >>116����<< ����� ���ֽø� �˴ϴ�.
	public memberVO memberDataPWSearch() {
		membervo = new memberVO();
		membervo = mnumScan(); // �����ȣ�� �޴� �޼��� ȣ��
		System.out.println("\n��й�ȣ ã�⸦ Ŭ���ϼ̽��ϴ�.");

		return membervo;
	}

	// 3-2���� ��й�ȣ ã���� ����� ����
	// select���� vo�� �־��ֽø� �˴ϴ�!! (null�� �α��ν��з� ����)
	// boolean Ÿ������ ���޵Ǵ� ���ǹ� ����Ͻø� �� ��
	public boolean memberPWReturn(memberVO vo) {
		// ã�� ����
		if (vo == null) {
			System.out.println("�������� �ʴ� �����ȣ�Դϴ�!\n\n");
			return false;
		}
		// ã�� ����
		System.out.println("������ �н������ ��" + vo.getPw() + "�� �Դϴ�.\n\n");
		return true;
	}

	// �����ȣ ã�� ������ �س�����.. select���� idã�� ����̾�� ������ //3-3.[�����ȣ ã��]
	// View : ID/PW�� �� vo�� ��ȯ�˴ϴ�. dao select �� >>141����<< ����� ���ֽø� �˴ϴ�.
	/*
	 * public memberVO memberDataSearchMNUM() {
	 * System.out.println("\n�����ȣ ã�⸦ Ŭ���ϼ̽��ϴ�.");
	 * System.out.println("���� Ȯ���� ���� �����ȣ�� �Է����ּ���!");
	 * 
	 * // id�Է� System.out.print("ID: "); String id = excep.strExcep();
	 * 
	 * System.out.print("PW: "); String pw = excep.strExcep();
	 * 
	 * // ����� �Էµ����� ���� membervo.setId(id); membervo.setPw(pw);
	 * 
	 * return membervo; //��ȯ } // 3-3���� ��й�ȣ ã���� ����� ���� public void
	 * memberMNUMReturn(memberVO vo) {
	 * System.out.println("������ �����ȣ�� ��"+vo.getMnum()+"�� �Դϴ�.\n\n"); }
	 */

	// 4 [ȸ������]
	// View: ȸ���� �Է��� "membervo�� ��ȯ" �մϴ�. --> ���� dao���� id �ߺ��� Ȯ�� �ʿ�
	public memberVO signUp() {
		membervo = new memberVO();
		System.out.println("\n * * * * * ȸ������  * * * * * ");
		System.out.println("���Կ� �ʿ��� �������� �Է����ּ���! 8-)");

		// ���̵� �Է� & vo id ����������
		System.out.print("ID: ");
		String id = excep.strExcep();
		membervo.setId(id); // ��.��.!

		// ��й�ȣ �Է� & vo pw ����������
		System.out.print("PW: ");
		String pw = excep.strExcep();
		membervo.setPw(pw); // ��.��.!

		return membervo;
	}

	// [���ԿϷ� ��¹���]
	// View: ������ selectOne�� ��ȯ�޾Ҵ� ���ڷ� �־��ּ���! (null�� ȸ�����Լ���!)
	// boolean Ÿ������ ���޵Ǵ� ���ǹ� ����Ͻø� �� ��
	public boolean signUpApply(memberVO vo) {
		if (vo != null) {
			System.out.println("\n�� XD ��ġ ���̴� :D ������ ȯ���մϴ�! ��");
			System.out.println("ȸ�� ������ ���������� �Ϸ�Ǿ�����,");
			//System.out.println("������ mnum�� " + vo.getMnum() + "�Դϴ�.");
			System.out.println("��� ��ġ ���̴��� ���� �� �ֽ��ϴ�~!!! ����  ;0)\n\n");
			return true;
		}
		System.out.println("�̹� �����ϴ� ID�Դϴ�.");
		System.out.println("�ٽ� �Է��Ͽ� �ּ���!!\n\n");
		return false;
	}

	// [ȸ�� �α��� ��--> ��弱��] �ֹ�/��������/����/����
	// View: ��ȯ�� (1�ֹ�/2��������/3����/4����) ���Ϸ� ��ȯ �˴ϴ�.
	public int memberModPick() {
		System.out.println("\n��              " + "�̵� ��ȣ Pick!!" + "     ��");
		System.out.println("1. ��ħ�� �ξ�.. ���� #�ֹ�#:P\n2. ������ #��������#\n3. ���������� #��������#\n4. ����");
		int act = excep.numExcep(1, 4); // ��ȿ���˻� �Լ�ȣ�� �� 1~2���� �Է�
		return act;
	}
	// 1. �ֹ� --> �޴�view / 3.���� --> ����view�� ����!

	// �� CRUD ����
	// 1 [���������� ����]
	// View: ��ȯ�� (1:�н�����), (2:Ż��) ���Ϸ� ��ȯ �˴ϴ�.
	public int memChangeMod() {
		System.out.println("\n[      " + "��������" + "                  ]");
		System.out.println("1. �н����� ���� \n2. ȸ��Ż�� :| ");
		int act = excep.numExcep(1, 2); // ��ȿ���˻� �Լ�ȣ�� �� 1~2���� �Է�
		return act; // �Է��� ��� ��ȯ
	}

	// 1-1 [�н����庯��]
	// View: ���ڴ� login���� ���� ����, ȸ���� ������ "membervo�� ��ȯ" �մϴ�. --> ���� �ߺ������Ͱ�(id) ������ Ȯ��
	// �ʿ�
	public memberVO memberUpdateData(memberVO vo) {
		membervo = new memberVO();
		membervo = vo; // ���� ������ ����

		// ������� ����
		System.out.println("���� �н����带 �Է����ּ���!! :-D");
		String pw = excep.strExcep();
		vo.setPw(pw);

		System.out.println("�н����� ������ �Ϸ� �Ǿ����ϴ�!");
		return vo; // ������ vo ��ȯ
	}

	// 1-2 [������Ʈ �Ϸ� ����]
	public void memberUpdateApply() {
		System.out.println("�Է��Ͻ� �н����尡 ���������� �ݿ��Ǿ����ϴ�!!\n");
	}

	// 2[ȸ��Ż��]
	// View: mnum�� ��vo�� ��ȯ. "ȸ��Ż����Ҹ� �ϸ� vo=null�� ��ȯ�˴ϴ�"
	// ��ȯ����vo�� dao���� �����ȣ�� ��ġ�ϸ� -->290�� ���� ����
	public memberVO memberDeleteData() {
		membervo = null;

		// Ż�� ����
		System.out.println("ȸ��Ż�� �����ϱ� ���� ����Ȯ���� �Ʒ� �Է����ּ���.");
		System.out.print("��й�ȣ Ȯ�� : ");
		String pw = excep.strExcep();
		System.out.println("������ ȸ��Ż�� �����Ͻðڽ��ϱ�??");
		System.out.println("1. ��\t2. �ƴϿ�");
		int act = excep.numExcep(1, 2); // ��ȿ���˻� ȣ�� --> 1~2�Է�
		if (act == 1) {
			membervo = new memberVO();
			membervo.setPw(pw);
		}
		return membervo;
	}

	// ���2-1. [Ż�� �Ϸ� ����]
	// View: selectOne�� ��ȯ�޾Ҵ� ���ڷ� �־��ּ���! (null�� �α��ν��з� ����)
	// boolean Ÿ������ ���޵Ǵ� ���ǹ� ����Ͻø� �� ��
	public boolean memberDeleteApply(memberVO vo) {
		if (vo == null) {
			System.out.println("�Է��Ͻ� ȸ����ȣ�� ���� �ʽ��ϴ�!");
			return false;
		}
		System.out.println("ȸ��Ż�� ���������� �ݿ��Ǿ����ϴ�.");
		System.out.println("���ݱ��� ��ġ���̴��� �̿��Ͽ� �ּż� ����帳�ϴ�.");
		System.out.println("�ٽ� �̿����ֽñ� ������ ��ٸ��ڽ��ϴ� :D");
		return true;
	}

	// (view �� ���)�����ȣ�� �޴� �޼��� ȣ��
	public memberVO mnumScan() {
		membervo = new memberVO();
		System.out.println("���� Ȯ���� ���� �����ȣ�� �Է����ּ���!");
		int mnum = excep.numExcep();

		membervo.setMnum(mnum);
		return membervo;
	}
	   // ����� �� ����
	   public boolean pay(int totalPrice) {
	      System.out.println("\n����:-] ���ݱ��� �ֹ��Ͻ� �ݾ��� �� "+totalPrice+"�� �Դϴ�.");
	      System.out.println("������ �����Ͻðڽ��ϱ�??");
	      System.out.println("1.����\t2.���");

	      int act = excep.numExcep(1, 2); //��ȿ���˻�ȣ�� - 1~2�Է�

	      // ���� ���(2)�ϸ� false ��ȯ
	      if(act==2) {
	         System.out.println("���� ��ҵǾ����ϴ�....");
	         return false;
	      }

	      System.out.println("\n���� ��ư�� Ŭ���ϼ̽��ϴ�. ī�� ������ ����˴ϴ�!!\n");
	      System.out.print("ī����� ���� ��");
	      try {
	         for(int i = 0; i < 5; i++) {
	            Thread.sleep(500); // �ε� ȿ��
	            System.out.print(".");
	         }
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	      
	      System.out.println(); //������
	      
	      System.out.println("������ �Ϸ� �Ǿ����ϴ�!!");
	      System.out.println("�̿��� �ֽɿ� �����մϴ�. �� �� �� �� �� �� ���ִ� �Ļ��ϼ��� ���� ��>��<� �� ��  ��  �� ��\n\n");
	      
	      return true; // �����Ϸ�>true��ȯ
	   }

}