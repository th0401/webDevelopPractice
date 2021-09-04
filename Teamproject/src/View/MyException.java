package View;

import java.util.InputMismatchException;
import java.util.Scanner;

// ����ó�� Ŭ����
public class MyException extends Exception {
   MyException(String msg){//����������: �����뵵
      super(msg);
   }
   public MyException(){//�⺻������ : ŸŬ���� �뵵
   }


   MyException excep;
   // ���� ����ó�� �޼���
   public int numExcep(int a, int b) {//����: a~b
      Scanner sc = new Scanner(System.in);
      // ��������ó�� ��üȭ
      excep = new MyException("[�Է¿���] " +"�߸� �Է��ϼ̽��ϴ�!\n\t" +a + "~" + b + " ���� �ٽ� �Է����ּ���.  :D "); // ����� ��������ó��
      int num; // ����� �Է�����
      while (true) {// �����Է��� ������ �ݺ�
         try {
            num = sc.nextInt(); //����� �Է°�
            if (num < a || b < num) { // a�̻� b���ϰ� �ƴ϶��
               throw excep; // ��������ó�� ���� -> MyException
            }
         } catch (InputMismatchException e) {// Ÿ���� �ٸ��ٸ�(ex,str�Է�)
            sc.nextLine(); // ���ڿ� ��� ��, �ܿ���������
            System.err.println("[Ÿ�Կ���] ������ �ٽ� �Է����ּ���. :D ");
            continue; // ���Է�
         } catch (MyException e) { // ���ǿ���ó�� (���ڰ� a�̻� b���Ϸ� �Է¾��ϸ� �����߻�)
            System.err.println(e.getMessage());
            continue;// ���Է�
         } catch (Exception e) { // �� ������
            System.err.println(e.getMessage());
            continue;// ���Է�
         }
         break; // ���� - ������ �����ٸ� �������
      }
      return num; // �����Է°� ��ȯ
   }
   // [�����ε�]���� ����ó�� �޼��� --> ��������
      public int numExcep() {
         Scanner sc = new Scanner(System.in);
         // ��������ó�� ��üȭ
         int num; // ����� �Է�����
         while (true) {// �����Է��� ������ �ݺ�
            try {
               num = sc.nextInt(); //����� �Է°�
            } catch (InputMismatchException e) {// Ÿ���� �ٸ��ٸ�(ex,str�Է�)
               sc.nextLine(); // ���ڿ� ��� ��, �ܿ���������
               System.err.println("[Ÿ�Կ���] ������ �ٽ� �Է����ּ���. :D ");
               continue; // ���Է¤�
            }catch (Exception e) { // �� ������
               System.err.println(e.getMessage());
               continue;// ���Է�
            }
            break; // ���� - ������ �����ٸ� �������
         }
         return num; // �����Է°� ��ȯ
      }
   // ���� ����ó�� �޼���
   public String strExcep() {
      Scanner sc = new Scanner(System.in);
      // ��������ó�� ��üȭ
      String str; // ����� �Է�����
      while (true) {// �����Է��� ������ �ݺ�
         try {
            str = sc.nextLine(); //����� �Է°�
         } catch (InputMismatchException e) {// Ÿ���� �ٸ��ٸ�(ex,str�Է�)
            sc.nextLine(); // ���ڿ� ��� ��, �ܿ���������
            System.err.println("[Ÿ�Կ���] �ٽ� �Է����ּ���. :D ");
            continue; // ���Է�
         }catch (Exception e) { // �� ������
            System.err.println(e.getMessage());
            continue;// ���Է�
         }
         break; // ���� - ������ �����ٸ� �������
      }
      return str; // �����Է°� ��ȯ
   }
}