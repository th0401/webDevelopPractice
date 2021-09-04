package View;

import java.util.ArrayList;

import View.MyException;
import model.menu.menuVO;
import model.store.storeVO;

public class MenuView {
	public MenuView() {
		excep = new MyException(); // ��ȿ�� �˻� ��ü����
	}

	private menuVO menuvo;
	private MyException excep;

	// �� C R U D �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��
	// �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��

	// [�޼���] �޴��� ��� //�����selectAll�� ���� ���ڷ� �־��ּ���!
	// View: �Һ��ڿ��� �޴���ȣ�� ���� �ȳ����ֱ� ���� AL<vo>�� ���ڸ� �޾ƾ��մϴ�. //��ȯ����
	public void menuPrint(ArrayList<menuVO> datas) {
		// ������ ũ�Ⱑ ���ٸ� ����
		if (datas.size() == 0) {
			System.out.println("\n�ش� ������ �޴��� �����ϴ�.");
			System.out.println("�ٸ� ������ �̿��� �ּ���!\n\n");
			return; // �����Ⱚ
		}
		// �����Ͱ� �ִٸ� �޴��� ��� // ����) 1. ������ 13000�� [5]

		System.out.println("\n=======================�޴���=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + ". " + datas.get(i).getMenuname() + " " + datas.get(i).getPrice() + "��\t" + "["
					+ datas.get(i).getMenucnt() + "]");
		}
		System.out.println("=================================================\n\n");
	}


	   public menuVO menuPickReturn(ArrayList<menuVO> datas, int act) { // ArrayList<menuVO> datas
	      menuVO data = new menuVO();
	      menuVO vo = new menuVO();
	      if (datas.size() == 0) {		        
		         return null; //�����Ͱ� ������ 0���� ��ȯ 
		      }
	      data = datas.get(act - 1);
	      vo.setMenunum(data.getMenunum());
	      vo.setSnum(data.getSnum());
	      vo.setPrice(data.getPrice());
	      vo.setMenucnt(data.getMenucnt());
	      vo.setMenuname(data.getMenuname());

	      return vo;
	   }
	      // �޴� ���ù�ȣ ��ȯ
	   public int menuPickNum(ArrayList<menuVO> datas) {
	      menuPrint(datas);
	      int act = 0;
	      if (datas.size() == 0) {
	         System.out.println("�ֹ��� �޴��� �����ϴ�!\n\n");
	         return act; //�����Ͱ� ������ 0���� ��ȯ 
	      }

	      System.out.println("���Ͻô� �޴��� ����ּ���!");
	      act = excep.numExcep(1, datas.size());

	      if (datas.get(act - 1).getMenucnt() <= 0) {// �߰�:��� 0�Ʒ��� �ֹ��Ұ�
	         System.out.println("�ش� �޴��� ǰ���Ǿ� �ֹ��� �Ұ��մϴ�. :-(\n");
	      }
	      return act;
	   }

	public boolean menuPick() { // �߰��ֹ� ���θ���
		System.out.println("�߰� �ֹ��޴� �����Ű���??");
		System.out.println("1. ��\t2.�ƴϿ�");
		int act = excep.numExcep(1, 2);
		if (act == 2) {
			return false;
		}
		return true;
	}

	// ----------------------------------------------------------------------------
	// ������� �Ϸ�
	// [�޼���] �޴��߰� //���� dao insert�ϸ� -> 66������ �ݿ��ϷṮ�� ȣ�����ּ���
	// View: "snum�� �ʿ�"�Ͽ� vo�� ���ڹް� // �Էµ� �޴������͸� ��ȯ �մϴ�.
	// storeVO�� ���ڸ� �޴� ���� ��Ʈ�ѿ��� ���ټ��� ���� �� ���Ƽ� �־����ϴ�.
	// menuVO�� �����Ͻø� �����ϼŵ� ����!!!
	public menuVO headPrint(ArrayList<menuVO> datas) {
		// ������ ũ�Ⱑ ���ٸ� ����
		if (datas.size()==0) {
			System.out.println("\n�ش� ������ �޴��� �����ϴ�.");
			return null; // �����Ⱚ
		}
		// �����Ͱ� �ִٸ� �޴��� ��� // ����) 1. ������ 13000�� [5]

		System.out.println("\n=======================�޴���=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + ". " + datas.get(i).getMenuname() + " " + datas.get(i).getPrice() + "��\t" + "["
					+ datas.get(i).getMenucnt() + "]");
		}
		System.out.println("===============================================\n\n");
		System.out.println("���Ͻô� �޴��� ����ּ���!");
		int act = excep.numExcep(1, datas.size());

		menuVO add = new menuVO();
		add.setMenunum(act);
		return add;
	}

	public void memPrint(ArrayList<menuVO> datas) {
		// ������ ũ�Ⱑ ���ٸ� ����
		if (datas.size()==0) {
			System.out.println("\n�ش� ������ �޴��� �����ϴ�.");
			return;
		}
		ArrayList<menuVO> bucket = new ArrayList();
		// �����Ͱ� �ִٸ� �޴��� ��� // ����) 1. ������ 13000�� [5]

		System.out.println("\n=======================�޴���=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + ". " + datas.get(i).getMenuname() + " " + datas.get(i).getPrice() + "��\t" + "["
					+ datas.get(i).getMenucnt() + "]");
		}
		System.out.println("===============================================\n\n");
	}

	public boolean delPrint(ArrayList<menuVO> datas) {
		// ������ ũ�Ⱑ ���ٸ� ����
		if (datas.size()==0) {
			System.out.println("\n�ش� ������ �޴��� �����ϴ�.");
			return false;
		}
		ArrayList<menuVO> bucket = new ArrayList();
		// �����Ͱ� �ִٸ� �޴��� ��� // ����) 1. ������ 13000�� [5]

		System.out.println("\n=======================�޴���=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println("�޴� ������ȣ : " + datas.get(i).getMenunum() + "\t �޴��� " + datas.get(i).getMenuname() + " "
					+ datas.get(i).getPrice() + "��\t" + "[" + datas.get(i).getMenucnt() + "]");
		}
		System.out.println("===============================================\n\n");
	return true;
	}

	public menuVO menuInsert(storeVO vo) {
		menuvo = new menuVO();

		// snum ����
		menuvo.setSnum(vo.getSnum());

		System.out.println("\n�޴��߰� ��忡 �����ϼ̽��ϴ�!\n");

		// �޴��̸��Է�
		System.out.println("�޴� �̸��� �������ּ��� :D");
		menuvo.setMenuname(excep.strExcep());

		System.out.println(); // ������

		// �����Է�
		System.out.println("�޴� ������ �Է����ּ��� ;O)");
		menuvo.setPrice(excep.numExcep(1, 100000000)); // ��ȿ�� �˻� �Լ�ȣ�� --> 1~1�����

		System.out.println(); // ������

		// ����Է�
		System.out.println("�޴� ��� ���� �Է����ּ��� :-)");
		menuvo.setMenucnt(excep.numExcep(1, 100000000)); // ��ȿ�� �˻� �Լ�ȣ��(str��) --> 1~1�����

		return menuvo;// �Էµ� menuvo��ȯ
	}

	public void menuInsertApply() {
		System.out.println("\n\n�Է��Ͻ� �޴��� ���� �ݿ� �Ǿ����ϴ�!!\n\n");
	}

	// [�޼���] �޴����� //mnum��ȣ���� selectOne ���� ���� �� 82������ ������ּ���!
	// View: menunum(pk)�� ����� vo�� ��ȯ�˴ϴ�.
	public menuVO menuDeleteData() {
		menuvo = new menuVO();
		System.out.println("\n�޴� ������忡 �����ϼ̽��ϴ�!\n");
		System.out.println("������ �����ϱ� ���� ���������� ����� \"�޴� ������ȣ\" �� �Է����ּ���!");
		menuvo.setMenunum(excep.numExcep()); // ��ȿ���˻� �Լ�ȣ���Է�

		return menuvo; // �Էµ� menuvo��ȯ
	}

	// �޴������ϷῩ�� ��� >> ����������select�� vo�� ���ڷ� �־��ּ���! (null�� �޴��������з� ����)
	// boolean Ÿ������ ��ȯ�˴ϴ�.
	public boolean menuDeleteApply(menuVO vo) {
		if (vo == null) {
			System.out.println("�Է��Ͻ� �޴���ȣ�� ���� �ʽ��ϴ�!\n\n");
			return false;
		}
		System.out.println("�޴������� ���������� �ݿ��� �Ǿ����ϴ�.\n\n");
		return true;
	}

	// [�޼���] �޴����� //dao �ݿ����� �� 154������ ������ּ���!
	// View: �޴� ���������𸣴� �����selectAll�� AL�� ���� �־��ּ��� //������Ʈ�� AL�� ��ȯ�˴ϴ�.(���ڿ������Ͱ�������
	// null�ι�ȯ��)
	public menuVO menuUpdateData(ArrayList<menuVO> vo) {
		// ��ȯ��ü ����(���� �� ���� ��츦 ����� null�� �ʱ�ȭ)
		ArrayList<menuVO> datas = null;

		// ����vo�� �����Ͱ� ������ null�� ��ȯ�ϸ� �Լ�����
		if (vo.size() == 0) {
			System.out.println("\n����� �޴� �����Ͱ� ���� ������ �Ұ��Ͽ� ������尡 ����˴ϴ�.");
			return null;
		}

		// >> �����Ͱ� ������ ������ ���� <<
		// ��ȯ��ü ������ ����
		datas = vo;

		System.out.println("\n�޴� ������忡 �����ϼ̽��ϴ�!\n");

		// ����� �޴� ��ü ��� 1. ������ �̷�������..
		System.out.println(" - - - - - - - - - - ���� �޴� ��� - - - - - - - - - - ");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i + 1) + " " + datas.get(i).getMenuname());
		}
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - -\n");

		// �޴������� ����
		System.out.println("������ �޴��� ��ȣ�� �Է����ּ���!\n");
		int muIndex = excep.numExcep(1, datas.size()); // ��ȿ���˻� ȣ�� 1~�ѵ����� ����
		menuVO data = datas.get(muIndex - 1);
		// [������ ����] - ���/�̸�/����/��ü
		System.out.println("������ �׸��� �������ּ���!");
		System.out.println("1.�޴����\n2.�޴���\n3.�޴�����\n4.��ü");
		int act = excep.numExcep(1, 4); // ��弱��

		// �޴���� ����
		if (act == 1) {
			System.out.println("\n������ ��� �Է����ּ���!");
			data.setMenucnt(excep.numExcep(1, 100000000)); // ��ȿ���˻� ȣ�� --> 1~1�����
		}
		// �޴��� ����
		else if (act == 2) {
			System.out.println("\n������ �޴��̸��� �Է����ּ���!");
			data.setMenuname(excep.strExcep());
		}
		// �޴����� ����
		else if (act == 3) {
			System.out.println("\n������ ������ �Է����ּ���!");
			data.setPrice(excep.numExcep(1, 100000000)); // ��ȿ���˻� ȣ�� --> 1~1�����
		}
		// ��ü ����
		else {
			System.out.println("\n������ �޴��̸��� �Է����ּ���!");
			data.setMenuname(excep.strExcep());

			System.out.println("\n������ ������ �Է����ּ���!");
			data.setPrice(excep.numExcep(1, 100000000)); // ��ȿ���˻� ȣ�� --> 1~1�����

			System.out.println("\n������ ��� �Է����ּ���!");
			data.setMenucnt(excep.numExcep(1, 100000000)); // ��ȿ���˻� ȣ�� --> 1~1�����
		}
		return data; // �Է��� �����͹�ȯ
	}

	public void menuyUpdateApply() {
		System.out.println("\n\n�Է��Ͻ� �޴��� ���������� ������ �Ϸ� �Ǿ����ϴ�!!\n\n");
	}

}