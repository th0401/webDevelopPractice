package test;

public class LRecording implements VoiceRecording{

	public LRecording() {
		System.out.println("LG������ �⺻������ ȣ��");
	}
	
	@Override
	public void turnOn() {
		System.out.println("LG������ ����Ŵ");
		
	}

	@Override
	public void turnOff() {
		System.out.println("LG������ ������");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("LG������ �Ҹ�++");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LG������ �Ҹ�--");
		
	}

}
