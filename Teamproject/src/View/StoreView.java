package View;

import java.util.ArrayList;
import java.util.Scanner;

import model.menu.menuVO;
import model.store.storeVO;

// ��ȣ�� �κ�
public class StoreView {
	private MyException excep;

	public StoreView() {
		excep = new MyException();
	}

	public int storeALLView(ArrayList<storeVO> datas) {
		System.out.println("\n======================�ֹ����� List!=====================");
		for (int i = 0; i < datas.size(); i++) {
			System.out.println((i+1) + ". " + datas.get(i).getSname());
		}
		System.out.println("======================================================\n\n");
		System.out.print("���Ͻô� ���� ��ȣ�� �Է����ּ���! : ");
		if(datas.size()==0) {
			System.out.println("���� ��ϵ� ���԰� �����ϴ�. ���� ���� ���񽺷� �ٽ� ���ƿ��ڽ��ϴ�.");
			return 0;
		}
		int act = excep.numExcep(1, datas.size());
		return act;
	}

	public int storePick() {
		System.out.println("ȯ���մϴ�! ���ָ��� �����ϼ˽��ϴ�! ���Ͻô� ��ȣ�� �Է����ּ���!");
		System.out.println("1. �޴� ���� ����\n2. ���� ���� ����\n3. ���� ���\n4. ���α׷� ����");
		int act = excep.numExcep(1, 4);
		return act;
	}

	public int storeOption() {
		// ������ �������(���Ը�,������ȭ��ȣ)�� ���� ��ü����
		System.out.println("���� ���� �ɼ��Դϴ�!");
		System.out.println();
		System.out.println("1. �������� ����\n2. �����߰�\n3. �������� ����\n4. ���Ի���\n5. ���� ");
		System.out.println("��ȣ�� �����ϼ���.");
		int act = excep.numExcep(1, 5); // ����ó�� ȣ��) 1~5 �����Է��� ������ �ݺ� -> "�����Է¼��� ��ȯ"

		return act;
	}

	public int menuOption() {

		System.out.println("���� �޴� �ɼ��Դϴ�!");
		System.out.println();
		System.out.println("1. ��ü �޴�����\n2. �޴��߰�\n3. �޴����� ����\n4. �޴�����\n5. ����");
		System.out.println("��ȣ�� �����ϼ���.");
		int act = excep.numExcep(1, 5); // ����ó�� ȣ��) 1~5 �����Է��� ������ �ݺ� -> "�����Է¼��� ��ȯ"

		return act;
	}

	// [�޼���] ���� ���Ը��
	public void storePrint(ArrayList<storeVO> vo) {
		if (vo.size() == 0) {
			System.out.println("���԰� �ϳ��� ����� �����...���Ը� ���� �߰����ּ���!");
		} else {
			// ���� ArrayList vo�� 0 == ������ �ϳ��� ���
			System.out.println("=====================��������=====================");
			for (int i = 0; i < vo.size(); i++) {
				System.out.println("���Թ�ȣ " + vo.get(i).getSnum() + "\t   " + "���Ը� : " + vo.get(i).getSname() + "\t"
						+ "������ȭ��ȣ�� : " + vo.get(i).getScall());
			}
			System.out.println("================================================");
		}

	}

	// [�޼���] ���� �����߰�
	public storeVO storeInsert() {
		storeVO data = null; // �����ư������ ���� �ʱ�ȭ

		System.out.println("�����߰� ����Դϴ�!\t ����0��");

		System.out.println("�߰��� ���Ը� �Է��ϼ���.");
		String Sname = excep.strExcep(); // ����ó�� �Լ�ȣ��
		if (Sname.equals("0")) { // �ߴ��������� ���� 0��
			System.out.println("0�� �Է��Ͽ����ϴ� �����߰��� ��ҵǾ����ϴ�.");
			return data;
		}
		data = new storeVO(); // ���������� �� ����ִ� ������ ��ü �����
		data.setSname(Sname);

		System.out.println("�߰��� ���� ��ȭ��ȣ�� �Է��ϼ���.");
		String Scall = excep.strExcep(); // ����ó�� �Լ�ȣ��
		data.setScall(Scall);

		if (Scall.equals("0")) { // �ߴ��������� ���� 0��
			System.out.println("0�� �Է��Ͽ����ϴ� �����߰��� ��ҵǾ����ϴ�.");
			data = null;
			return data;
		}
		System.out.println("���԰� ���������� �߰��Ǿ����ϴ�! ȯ���մϴ�!! " + data.getSname() + "����ԡ���");

		return data; // �����߰� VO�� ��ȯ
	}

	// [�޼���] ���� > �������� ����
	public storeVO storeUpdate(ArrayList<storeVO> vo) {
		storeVO data=null; //�����ư ������ ���� �ʱ�ȭ
		if (vo.size() == 0) { // ���� ���԰� �ϳ��� ���ٸ� ����
			System.out.println("��ϵ� ���԰� �����ϴ�... ���Ը� ���� �߰����ּ���!");
			return data;
		}
		data = new storeVO(); // ���� ���� ���浥���͸� ���� ��ü����
		System.out.println("���� �������� ����Դϴ�.");
		data = storeSnumCheck(vo); // ��̸���Ʈ vo�� ���VO�� �����Ϳ� ����!
		if (data == null) { // ���� SnumCheck���� ����0�� ������ ��� => null�� ��ȯ!
			System.out.println("���Ժ��� ��带 �����մϴ�.");
			return data; // �����ʹ� null�Դϴ�.
		}

		while (true) {
			System.out.println("� ������ �����Ͻðھ��?");
			System.out.println("��ȣ�� �Է��ϼ���.");
			System.out.println("1. ���Ը� ����\n2. ������ȭ��ȣ ����\n3. ����");
			int act = excep.numExcep(1, 3); // ����ó�� ȣ��) 1~3 �����Է��� ������ �ݺ� -> "�����Է¼��� ��ȯ"
			if (act == 1) {
				// [���Ը� �Է�]
				System.out.println("������ ���Ը��� �Է����ּ���!\t����0��");
				String Sname = excep.strExcep(); // ����ó�� �Լ�ȣ��
				if (Sname.equals("0")) { // 0�� ������ �ٽ��Է�!
					continue;
				}
				data.setSname(Sname); // ���Ը� ����
				System.out.println("���Ը��� " + Sname + "(��)�� ����Ǿ����ϴ�!");
				continue;
			} else if (act == 2) {
				// [���� ��ȭ��ȣ �Է�]
				System.out.println("������ ���� ��ȭ��ȣ�� �Է����ּ���!\t����0��");
				String Scall = excep.strExcep(); // ����ó�� �Լ�ȣ��
				if (Scall.equals("0")) { // 0�� ������ �ٽ��Է�!
					continue;
				}
				data.setScall(Scall); // ���� ��ȭ��ȣ ����
				System.out.println("���� ��ȭ��ȣ�ϰ� " + Scall + "(��)�� ����Ǿ����ϴ�!");
				continue;
			} else {
				System.out.println("�������� ��带 �����մϴ�.");
				break;
			}
		}
		return data; // ����� VO�� ��ȯ
	}

	public storeVO storeDelete(ArrayList<storeVO> vo) { // ��̸���Ʈ�� ���ڸ� ����
		storeVO data = null; // ���� ���� ���浥���͸� ���� ��ü����
		// ��̸���Ʈ vo�� ���VO�� �����Ϳ� ����!
		if (vo.size() == 0) { // ���� ArrayList vo�� 0 == ������ �ϳ��� ���ٸ� �׳� null�� ��ȯ
			System.out.println("��ϵ� ���԰� �����ϴ�... ���Ը� ���� �߰����ּ���!");
			return data; // null�� ��Ҹ��ǹ��ؿ� ��Ʈ�ѷ���!
		}
		System.out.println("���Ը� ���� �����Ͻðڽ��ϱ�? ������ ����Ǹ� ������ �Ұ��մϴ�!!");
		System.out.println("����Ͻ÷��� 0��, ������ �����Ͻ÷��� �ƹ�Ű�� ��������!");

		while (true) {
			String choice = excep.strExcep();
			if (choice.equals("0")) {
				System.out.println("���� ������带 �����մϴ�.");
				return data; // null�� ��Ҹ��ǹ��ؿ� ��Ʈ�ѷ���!
			} else {
				data = new storeVO();
				storePrint(vo);
				System.out.println("���� ������尡 ����˴ϴ�.");
				System.out.println("������ ���� ��ȣ�� �Է����ּ���.\t ����0��");
				data = storeSnumCheck(vo);// VO�� ��ȯ
				if (data == null) {
					System.out.println("���� ������带 �����մϴ�.");
					return data;
				}
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				return data; // ������ VO�� �ѱ��
			}
		}

	}

	// [�޼���] ��ȿ���˻�� ���ÿ� vo�� �������� ��� ��ȯ�ϴ� �޼���
	public storeVO storeSnumCheck(ArrayList<storeVO> vo) {
		storeVO data = null;
		System.out.println("���� Ȯ���� ���ؼ� ���� ��ȣ�� �Է��� �ּ���!\t����0��");
		while (true) {
			int Snum = excep.numExcep(); // ����ó�� �Լ�ȣ��
			if (Snum == 0) {
				System.out.println("0�� �Է��ϼ̽��ϴ�."); // �η� ��ȯ�Ǵ°� ���� ��ҷ� ��Ÿ���� �ּ��� ��Ʈ�ѷ���!
				return data;
			}

			boolean flag = true;
			for (int i = 0; i < vo.size(); i++) {
				if (vo.get(i).getSnum() == Snum) {
					data = new storeVO(); // VO ��ȯ���ִ� ��ü�����
					data.setSnum(Snum); //
					data.setSname(vo.get(i).getSname());
					data.setScall(vo.get(i).getScall());
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("���� ���Թ�ȣ���� �ٽ� �Է����ּ���.");
				continue;
			}
			break;
		}
		return data; // VO ��ȯ
	}
}