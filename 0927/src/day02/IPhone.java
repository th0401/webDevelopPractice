package day02;

public class IPhone implements Phone{
	
		public void volumeUp() {
	      System.out.println("소리++");
	   }
	   public void volumeDown() {
	      System.out.println("소리--");
	   }
	   public void powerOn() {
	      System.out.println("전원 ON");
	   }
	   public void powerOff() {
	      System.out.println("전원 OFF");
	   }
}
