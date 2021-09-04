package test;

// �� �׽�Ʈ �������Դϴ�.
// � ������� �۵��ϴ���, �۵��� �� �Ǵ��� Ȯ���Ͻð�
// �����ϽǶ��� main �Լ� ��ü �ּ�ó�� ���ֽø� �˴ϴ�!

// ���� ���ǻ���
// * ���� ���� test.sql�� �ִ� create ���� �� ���� --> �̹� �ִ��̸��ϰ�� drop

// DB ��� Ȯ���ϱ� �����Ƽ� ��������� ��ȿ���˻� ������ �����ϴ� ��

// MEMBER��  �� ���� �־�� GIFT ����� �ְ� (�ܷ�Ű)
// STORE�� �� ���� �־�� MENU ���� �� �ֽ��ϴ�.(�ܷ�Ű)

// �������� ���Ǵ� �ٱ������ �Կ���...

import java.util.ArrayList;
import java.util.Scanner;

import model.gift.giftDAO;
import model.gift.giftVO;
import model.member.memberDAO;
import model.member.memberVO;
import model.menu.menuDAO;
import model.menu.menuVO;
import model.store.storeDAO;
import model.store.storeVO;

public class Test {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int act;
      System.out.println("�� �׽�Ʈ ������ �Դϴ�.");
      System.out.println("1.gift 2.member 3.menu 4.store");
      System.out.print("�Է�: ");
      act = sc.nextInt();
      
      // GIFT
      if(act == 1) {
         giftVO vo = new giftVO();
         giftDAO dao = new giftDAO();
         ArrayList<giftVO> al = new ArrayList();
         System.out.println("1.insert 2.delete 3.update 4.select 5.selectList");
         System.out.print("�Է�: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("mnum �Է�: ");
            int mnum = sc.nextInt();
            System.out.print("gnum �Է�: ");
            sc.nextLine();
            String gnum = sc.next();
            System.out.print("gprice �Է�: ");
            int gprice = sc.nextInt();

            vo.setMnum(mnum);
            vo.setGnum(gnum);
            vo.setGprice(gprice);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("gnum �Է�");
            String gnum = sc.next();
            vo.setGnum(gnum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("������ ������ gnum: ");
            String gnum = sc.next();
            System.out.print("�ܾ� ����: ");
            int gprice = sc.nextInt();
            
            vo.setGnum(gnum);
            vo.setGprice(gprice);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("�˻��� gnum �Է�: ");
            String gnum = sc.next();
            vo.setGnum(gnum);
            giftVO data = new giftVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("�� ���̺��Դϴ�.");
            }
            else {
               System.out.println(data);
            }
         }
         else if (act == 5) {
            // �ؿ� ��¹� �����ؼ� ���� ���� ����.
         }
         else {
            System.out.println("�߸��� �Է�!");
            return;
         }
         System.out.println("=====��ü������=====");
         al = dao.selectList();
         for(giftVO v : al) {
            System.out.println(v);
         }
      }
      
      
      // MEMBER
      else if(act == 2) {
         memberVO vo = new memberVO();
         memberDAO dao = new memberDAO();
         ArrayList<memberVO> al = new ArrayList();
         System.out.println("1.insert 2.delete 3.update 4.select 5.selectList");
         System.out.print("�Է�: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("id �Է�: ");
            sc.nextLine();
            String id = sc.next();
            System.out.print("pw �Է�: ");
            String pw = sc.next();
            vo.setId(id);
            vo.setPw(pw);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("mnum �Է�");
            int mnum = sc.nextInt();
            vo.setMnum(mnum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("������ ����� mnum: ");
            int mnum = sc.nextInt();
            System.out.print("id ����: ");
            sc.nextLine();
            String id = sc.next();
            System.out.print("pw ����: ");
            String pw = sc.next();

            vo.setMnum(mnum);
            vo.setId(id);
            vo.setPw(pw);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("�˻��� mnum �Է�: ");
            int mnum = sc.nextInt();
            vo.setMnum(mnum);
            memberVO data = new memberVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("�� ���̺��Դϴ�.");
            }
            else {
               System.out.println(data);
            }
            
            
         }
         else if (act == 5) {
            // �ؿ� ��¹� �����ؼ� ���� ���� ����.
         }
         else {
            System.out.println("�߸��� �Է�!");
            return;
         }
         System.out.println("=====��ü������=====");
         al = dao.selectList();
         for(memberVO v : al) {
            System.out.println(v);
         }
      }
      
      // MENU
      else if(act == 3) {
         menuVO vo = new menuVO();
         menuDAO dao = new menuDAO();
         ArrayList<menuVO> al = new ArrayList();
         System.out.println("1.insert 2.delete 3.update 4.select 5.selectList");
         System.out.print("�Է�: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("snum �Է�: ");
            int snum = sc.nextInt();
            System.out.print("menuname �Է�: ");
            sc.nextLine();
            String menuname = sc.next();
            System.out.print("price �Է�: ");
            int price = sc.nextInt();
            System.out.print("menucnt �Է�: ");
            int menucnt = sc.nextInt();
            vo.setSnum(snum);
            vo.setMenuname(menuname);
            vo.setPrice(price);
            vo.setMenucnt(menucnt);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("menunum �Է�");
            int menunum = sc.nextInt();
            vo.setMenunum(menunum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("������ �޴��� menunum: ");
            int menunum = sc.nextInt();
            System.out.print("menuname ����: ");
            sc.nextLine();
            String menuname = sc.next();
            System.out.print("price ����: ");
            int price = sc.nextInt();
            System.out.println("menucnt ����: ");
            int menucnt = sc.nextInt();
            
            vo.setMenunum(menunum);
            vo.setMenuname(menuname);
            vo.setPrice(price);
            vo.setMenucnt(menucnt);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("�˻��� menunum �Է�: ");
            int menunum = sc.nextInt();
            vo.setMenunum(menunum);
            menuVO data = new menuVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("�� ���̺��Դϴ�.");
            }
            else {
               System.out.println(data);
            }
         }
         else if (act == 5) {
            // �ؿ� ��¹� �����ؼ� ���� ���� ����.
         }
         else {
            System.out.println("�߸��� �Է�!");
            return;
         }
         System.out.println("=====��ü������=====");
         al = dao.selectList();
         for(menuVO v : al) {
            System.out.println(v);
         }
      }
      
      // STORE
      else if(act == 4) {
         storeVO vo = new storeVO();
         storeDAO dao = new storeDAO();
         ArrayList<storeVO> al = new ArrayList();
         System.out.println("1.insert 2.delete 3.update 4.select 5.selectList");
         System.out.print("�Է�: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("sname �Է�: ");
            sc.nextLine();
            String sname = sc.next();
            System.out.print("scall �Է�: ");
            String scall = sc.next();

            vo.setSname(sname);
            vo.setScall(scall);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("snum �Է�");
            int snum = sc.nextInt();
            vo.setSnum(snum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("������ ������ snum: ");
            int snum = sc.nextInt();
            System.out.print("sname ����: ");
            sc.nextLine();
            String sname = sc.next();
            System.out.print("scall ����: ");
            String scall = sc.next();

            vo.setSnum(snum);
            vo.setSname(sname);
            vo.setScall(scall);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("�˻��� snum �Է�: ");
            int snum = sc.nextInt();
            vo.setSnum(snum);
            storeVO data = new storeVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("�� ���̺��Դϴ�.");
            }
            else {
               System.out.println(data);
            }
         }
         else if (act == 5) {
            // �ؿ� ��¹� �����ؼ� ���� ���� ����.
         }
         else {
            System.out.println("�߸��� �Է�!");
            return;
         }
         System.out.println("=====��ü������=====");
         al = dao.selectList();
         for(storeVO v : al) {
            System.out.println(v);
         }
      }
   }
}