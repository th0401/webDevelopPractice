package test;

// 모델 테스트 페이지입니다.
// 어떤 방식으로 작동하는지, 작동은 잘 되는지 확인하시고
// 구현하실때는 main 함수 전체 주석처리 해주시면 됩니다!

// 사용시 주의사항
// * 제일 먼저 test.sql에 있는 create 문을 다 실행 --> 이미 있는이름일경우 drop

// DB 계속 확인하기 귀찮아서 만들었지만 유효성검사 같은건 없습니다 ☆

// MEMBER가  한 개라도 있어야 GIFT 만들수 있고 (외래키)
// STORE가 한 개라도 있어야 MENU 만들 수 있습니다.(외래키)

// 유지보수 문의는 ☆김혁재☆ 님에게...

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
      System.out.println("모델 테스트 페이지 입니다.");
      System.out.println("1.gift 2.member 3.menu 4.store");
      System.out.print("입력: ");
      act = sc.nextInt();
      
      // GIFT
      if(act == 1) {
         giftVO vo = new giftVO();
         giftDAO dao = new giftDAO();
         ArrayList<giftVO> al = new ArrayList();
         System.out.println("1.insert 2.delete 3.update 4.select 5.selectList");
         System.out.print("입력: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("mnum 입력: ");
            int mnum = sc.nextInt();
            System.out.print("gnum 입력: ");
            sc.nextLine();
            String gnum = sc.next();
            System.out.print("gprice 입력: ");
            int gprice = sc.nextInt();

            vo.setMnum(mnum);
            vo.setGnum(gnum);
            vo.setGprice(gprice);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("gnum 입력");
            String gnum = sc.next();
            vo.setGnum(gnum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("수정할 쿠폰의 gnum: ");
            String gnum = sc.next();
            System.out.print("잔액 변경: ");
            int gprice = sc.nextInt();
            
            vo.setGnum(gnum);
            vo.setGprice(gprice);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("검색할 gnum 입력: ");
            String gnum = sc.next();
            vo.setGnum(gnum);
            giftVO data = new giftVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("빈 테이블입니다.");
            }
            else {
               System.out.println(data);
            }
         }
         else if (act == 5) {
            // 밑에 출력문 구현해서 따로 구현 안함.
         }
         else {
            System.out.println("잘못된 입력!");
            return;
         }
         System.out.println("=====전체결과출력=====");
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
         System.out.print("입력: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("id 입력: ");
            sc.nextLine();
            String id = sc.next();
            System.out.print("pw 입력: ");
            String pw = sc.next();
            vo.setId(id);
            vo.setPw(pw);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("mnum 입력");
            int mnum = sc.nextInt();
            vo.setMnum(mnum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("수정할 멤버의 mnum: ");
            int mnum = sc.nextInt();
            System.out.print("id 변경: ");
            sc.nextLine();
            String id = sc.next();
            System.out.print("pw 변경: ");
            String pw = sc.next();

            vo.setMnum(mnum);
            vo.setId(id);
            vo.setPw(pw);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("검색할 mnum 입력: ");
            int mnum = sc.nextInt();
            vo.setMnum(mnum);
            memberVO data = new memberVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("빈 테이블입니다.");
            }
            else {
               System.out.println(data);
            }
            
            
         }
         else if (act == 5) {
            // 밑에 출력문 구현해서 따로 구현 안함.
         }
         else {
            System.out.println("잘못된 입력!");
            return;
         }
         System.out.println("=====전체결과출력=====");
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
         System.out.print("입력: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("snum 입력: ");
            int snum = sc.nextInt();
            System.out.print("menuname 입력: ");
            sc.nextLine();
            String menuname = sc.next();
            System.out.print("price 입력: ");
            int price = sc.nextInt();
            System.out.print("menucnt 입력: ");
            int menucnt = sc.nextInt();
            vo.setSnum(snum);
            vo.setMenuname(menuname);
            vo.setPrice(price);
            vo.setMenucnt(menucnt);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("menunum 입력");
            int menunum = sc.nextInt();
            vo.setMenunum(menunum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("수정할 메뉴의 menunum: ");
            int menunum = sc.nextInt();
            System.out.print("menuname 변경: ");
            sc.nextLine();
            String menuname = sc.next();
            System.out.print("price 변경: ");
            int price = sc.nextInt();
            System.out.println("menucnt 변경: ");
            int menucnt = sc.nextInt();
            
            vo.setMenunum(menunum);
            vo.setMenuname(menuname);
            vo.setPrice(price);
            vo.setMenucnt(menucnt);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("검색할 menunum 입력: ");
            int menunum = sc.nextInt();
            vo.setMenunum(menunum);
            menuVO data = new menuVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("빈 테이블입니다.");
            }
            else {
               System.out.println(data);
            }
         }
         else if (act == 5) {
            // 밑에 출력문 구현해서 따로 구현 안함.
         }
         else {
            System.out.println("잘못된 입력!");
            return;
         }
         System.out.println("=====전체결과출력=====");
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
         System.out.print("입력: ");
         act = sc.nextInt();

         if(act == 1) {
            System.out.print("sname 입력: ");
            sc.nextLine();
            String sname = sc.next();
            System.out.print("scall 입력: ");
            String scall = sc.next();

            vo.setSname(sname);
            vo.setScall(scall);
            dao.insert(vo);
         }
         else if(act == 2) {
            System.out.println("snum 입력");
            int snum = sc.nextInt();
            vo.setSnum(snum);
            dao.delete(vo);
         }
         else if(act == 3) {
            System.out.print("수정할 가게의 snum: ");
            int snum = sc.nextInt();
            System.out.print("sname 변경: ");
            sc.nextLine();
            String sname = sc.next();
            System.out.print("scall 변경: ");
            String scall = sc.next();

            vo.setSnum(snum);
            vo.setSname(sname);
            vo.setScall(scall);
            dao.update(vo);
         }
         else if(act == 4) {
            System.out.print("검색할 snum 입력: ");
            int snum = sc.nextInt();
            vo.setSnum(snum);
            storeVO data = new storeVO();
            data = dao.selectOne(vo);
            if(data == null) {
               System.out.println("빈 테이블입니다.");
            }
            else {
               System.out.println(data);
            }
         }
         else if (act == 5) {
            // 밑에 출력문 구현해서 따로 구현 안함.
         }
         else {
            System.out.println("잘못된 입력!");
            return;
         }
         System.out.println("=====전체결과출력=====");
         al = dao.selectList();
         for(storeVO v : al) {
            System.out.println(v);
         }
      }
   }
}