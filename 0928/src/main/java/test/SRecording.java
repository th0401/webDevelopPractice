package test;

public class SRecording implements VoiceRecording{

	
	public SRecording() {
		System.out.println("�Ｚ������ �⺻������ ȣ��");
	}
	
	@Override
	public void turnOn() {
		System.out.println("�Ｚ������ ����Ŵ");
		
	}

	@Override
	public void turnOff() {
		System.out.println("�Ｚ������ ������");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("�Ｚ������ ������");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("�Ｚ������ �����ٿ�");
		
	}

}
