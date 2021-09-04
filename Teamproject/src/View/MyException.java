package View;

import java.util.InputMismatchException;
import java.util.Scanner;

// 예외처리 클래스
public class MyException extends Exception {
   MyException(String msg){//하위생성자: 대조용도
      super(msg);
   }
   public MyException(){//기본생성자 : 타클래스 용도
   }


   MyException excep;
   // 정수 예외처리 메서드
   public int numExcep(int a, int b) {//범위: a~b
      Scanner sc = new Scanner(System.in);
      // 지정예외처리 객체화
      excep = new MyException("[입력오류] " +"잘못 입력하셨습니다!\n\t" +a + "~" + b + " 값을 다시 입력해주세요.  :D "); // 사용자 지정예외처리
      int num; // 사용자 입력저장
      while (true) {// 정상입력할 때까지 반복
         try {
            num = sc.nextInt(); //사용자 입력값
            if (num < a || b < num) { // a이상 b이하가 아니라면
               throw excep; // 지정예외처리 실행 -> MyException
            }
         } catch (InputMismatchException e) {// 타입이 다르다면(ex,str입력)
            sc.nextLine(); // 문자열 출력 후, 잔여버퍼정리
            System.err.println("[타입오류] 정수로 다시 입력해주세요. :D ");
            continue; // 재입력
         } catch (MyException e) { // 정의예외처리 (인자값 a이상 b이하로 입력안하면 오류발생)
            System.err.println(e.getMessage());
            continue;// 재입력
         } catch (Exception e) { // 외 모든오류
            System.err.println(e.getMessage());
            continue;// 재입력
         }
         break; // 종료 - 오류가 없었다면 종료실행
      }
      return num; // 정상입력값 반환
   }
   // [오버로딩]정수 예외처리 메서드 --> 범위없음
      public int numExcep() {
         Scanner sc = new Scanner(System.in);
         // 지정예외처리 객체화
         int num; // 사용자 입력저장
         while (true) {// 정상입력할 때까지 반복
            try {
               num = sc.nextInt(); //사용자 입력값
            } catch (InputMismatchException e) {// 타입이 다르다면(ex,str입력)
               sc.nextLine(); // 문자열 출력 후, 잔여버퍼정리
               System.err.println("[타입오류] 정수로 다시 입력해주세요. :D ");
               continue; // 재입력ㄴ
            }catch (Exception e) { // 외 모든오류
               System.err.println(e.getMessage());
               continue;// 재입력
            }
            break; // 종료 - 오류가 없었다면 종료실행
         }
         return num; // 정상입력값 반환
      }
   // 문자 예외처리 메서드
   public String strExcep() {
      Scanner sc = new Scanner(System.in);
      // 지정예외처리 객체화
      String str; // 사용자 입력저장
      while (true) {// 정상입력할 때까지 반복
         try {
            str = sc.nextLine(); //사용자 입력값
         } catch (InputMismatchException e) {// 타입이 다르다면(ex,str입력)
            sc.nextLine(); // 문자열 출력 후, 잔여버퍼정리
            System.err.println("[타입오류] 다시 입력해주세요. :D ");
            continue; // 재입력
         }catch (Exception e) { // 외 모든오류
            System.err.println(e.getMessage());
            continue;// 재입력
         }
         break; // 종료 - 오류가 없었다면 종료실행
      }
      return str; // 정상입력값 반환
   }
}