package View;

import java.util.ArrayList;
import java.util.Random;

import model.gift.giftDAO;
import model.gift.giftVO;
import model.member.memberDAO;
import model.member.memberVO;

public class GiftView {
	public GiftView(){
		excep = new MyException(); // ����ó�� Ŭ����
	}
	private MyException excep;
	public int giftMenuSelect() {

		System.out.println("���� �������� �����̽��ϴ�!");
		System.out.println("���Ͻô� ���� ��ȣ�� �����ּ���!");
		System.out.println("1.���� Ȯ��  2.���� ����  3.���� �����ϱ�  4.�����ϱ�");
		int act = excep.numExcep(1, 4);
		return act;
	}

	//   [�޼���] ������ϿϷ� ��Ʈ
	public void giftSuccessApply() {  
		// ���� ����� �� ������ȣ �������Ŀ� ���� dao�� �μ�Ʈ�Ͻð� �� �Ʒ��� �־��ּ���
		System.out.println("\n\n���������� ���� ������ �Ϸ�Ǿ����ϴ�. �̿��� �ּż� �����մϴ�. ;P\n\n");
	}
	// [�޼���] ���������Ϸ� ��Ʈ
	public void presentSuccesstApply() {   
		// ���� ������ �� ������ȣ ������ �Ŀ� ���� dao�� �μ�Ʈ �Ͻð� �� �Ʒ��� ��������!
		System.out.println("\n\n���������� ���� ������ �Ϸ�Ǿ����ϴ�. �̿��� �ּż� �����մϴ�. :D\n\n");
	}
	// �������,�������� �Ǵ� �����Ʈ�� �̹� �޼��� giftBuy,giftPresent�ȿ� �������ֽ��ϴ�

	// [���� ���α���] --> insert
	// ��ȯ:������ ���� �ݾ׸� ��ȯ
	public giftVO giftBuy(memberVO vo){//����: �����ȸ��

		giftVO data = null; // ��ȯ�� ����      

		System.out.println("�����Ͻ� �����ݾ��� �Է����ּ���!!  =)");
		ArrayList<Integer> giftPrice = new ArrayList(); // �����ݾ� ����
		giftPrice.add(5000);
		giftPrice.add(10000);
		giftPrice.add(30000);
		giftPrice.add(50000);
		giftPrice.add(100000);

		System.out.println("(1) 5,000��\n(2) 10,000��\n(3) 30,000��\n(4) 50,000��\n(5) 100,000��");
		int act = excep.numExcep(1, 5); // ��ȿ���˻� �޼��� ȣ��)1~5 ���� �Է�
		System.out.println(giftPrice.get(act-1)+" ��  �����ϼ̽��ϴ�!\n������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.����\t2.���"); // �������� �ȳ�
		int mod = excep.numExcep(1, 2); // ��ȿ���˻� ȣ��) 1,2�Է�

		//�ߵ� ���ᱸ��
		if(mod==2) {
			System.out.println("������ ��� �Ǿ����ϴ�.");
			return data; // ����
		}
		data=new giftVO();
		//�������� �ε�
		System.out.print("ī����� ���� ��");
		try {
			for(int i = 0; i < 5; i++) {
				Thread.sleep(500); // �ε� ȿ��
				System.out.print(".");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}      
		

		// ���� ������ ���� (������ ������ �����Ͱ� �ѹ��� ����Ǵ� ���� ����)
		
		//������
			System.out.println(); //������
			System.out.println("�����Ϸ�!!");

			// ������ ���� �ݾ�����
			data.setGprice(giftPrice.get(act-1));
			data.setMnum(vo.getMnum());      
			return data;
		
	}
	// [���� ����]
	// ������ ���� �ݾ׸� ��ȯ
	public giftVO giftPresent(ArrayList<memberVO> vo){
		giftVO data = null; // ��ȯ�� ����

		System.out.println("�����Ͻ� �����ݾ��� �Է����ּ���!!  =)");
		ArrayList<Integer> giftPrice = new ArrayList(); // �����ݾ� ����
		giftPrice.add(5000);
		giftPrice.add(10000);
		giftPrice.add(30000);
		giftPrice.add(50000);
		giftPrice.add(100000);

		// �������
		System.out.println("(1) 5,000��\n(2) 10,000��\n(3) 30,000��\n(4) 50,000��\n(5) 100,000��");

		// ��ȿ���˻� �޼��� ȣ��)1~5 ���� �Է�
		int act = excep.numExcep(1, 5);

		// �����ǻ� Ȯ��
		System.out.println(giftPrice.get(act-1)+" ��  �����ϼ̽��ϴ�!\n������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.��������\t2.���"); // �������� �ȳ�
		// ��ȿ���˻� ȣ��) 1,2�Է�
		int mod = excep.numExcep(1, 2); 

		//���� �� ��ȣ�� �������(�Լ�����) -->data:null��ȯ
		if(mod==2) {
			System.out.println("������ ��� �Ǿ����ϴ�.");
			return data;// data(null)��ȯ
		}

		//-->112���������� ��ü
		//while(true){// ȸ����ȣ ����  
		System.out.println("��������� ȸ����ȣ�� �Է����ּ���.\t���� 0");

		// ��ȿ���˻� ȣ��>> 0���� �������������� mnum���� �Է�
		// ������� mnum�Է�
		int mnum = excep.numExcep(0, vo.get(vo.size()-1).getMnum());

		//�����ư(0 �Է½�)
		if(mnum==0) {
			System.out.println("�����ϱ⸦ �����մϴ�");
			return data; // data(null)��ȯ
		}
		//member - mnum ������ �� 
		//            ArrayList<memberVO> arrMemberVo = new ArrayList();  => �����ٶ�      

		//-->112���������� ��ü
		/*         boolean flag = true;
            for(int i = 0; i<vo.size();i++) {
               if(vo.get(i).getMnum()==mnum) {               
                  flag = false;
                  break;
               }   
            }
            if(flag) {
               System.out.println("���� ȸ����ȣ���� �ٽ� �Է����ּ���.");
               continue;
            }
		 */         //ȸ����ȣ�� �����ϸ� ����
		data = new giftVO();  // ���⼭���� ��ü����!
		data.setMnum(mnum);
		//break;
		//}//

		//ȸ����ȣ�� ��ġ�ϸ� ��������
		System.out.print("ī����� ���� ��");
		try {
			for(int i = 0; i < 5; i++) {
				Thread.sleep(500); // �ε� ȿ��
				System.out.print(".");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ���� ������ ���� (������ ������ �����Ͱ� �ѹ��� ����Ǵ� ���� ����)
		{//������
			System.out.println(); //������
			System.out.println("�����Ϸ�!!");

			data.setGprice(giftPrice.get(act-1));   
		}      
		return data;

	}

	// [����� ���� ���� ���]
	public void giftPrint(ArrayList<giftVO> vo) {
		// ������ ������
		if(vo.size()==0) {
			System.out.println("���� ����� ������ϴ�!");
		}
		else {
			// ������ ���� ���
			System.out.println("===================��������===================");
			for(int i = 0; i<vo.size();i++) {
				System.out.println((i+1)+" ������ȣ : "+vo.get(i).getGnum()+"\t ���� ���ΰ��� : "+vo.get(i).getGprice());
			}         
			System.out.println("============================================");
		}
	}
	public giftVO giftPay(ArrayList<giftVO> datas) {   // data�� �ش��ϴ� mnum�� ���� AL��������

	      System.out.println("������ ����Ͻðڽ��ϱ�?");
	      System.out.println("1. ��\t2. �ƴϿ�");
	      int act = excep.numExcep(1, 2);
	      if(act == 2) {
	         return null;
	      }   
	      if (datas.size()== 0) {
	         System.out.println("����Ҽ� �ִ� ������ �����ϴ�.");
	         return null;
	      }
	      giftPrint(datas);
	      act = excep.numExcep(1, datas.size());
	      giftVO data = datas.get(act-1);   // ����� ����
	      return data;
	   }
	   public int giftUsePay(giftVO data) {
	      System.out.println("�󸶸� ����Ͻðڽ��ϱ�?");
	      int couUsePrice = excep.numExcep(0,data.getGprice());
	      return couUsePrice;
	   }
	}
