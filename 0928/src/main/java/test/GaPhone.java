package test;

public class GaPhone implements Phone{
	
	@Override
	public void volumeUp() {
		System.out.println("�Ҹ� +=10");
		
	}
	@Override
	public void volumeDown() {
		System.out.println("�Ҹ� -=10");
		
	}
	@Override
	public void powerOn() {
		System.out.println("���� ����");
		
	}
	@Override
	public void powerOff() {
		System.out.println("���� ����");
		
	}
	
	
	
}
