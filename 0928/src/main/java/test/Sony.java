package test;

public class Sony implements Camera{

	
	VoiceRecording VR;
	
	public Sony() {
		System.out.println("�Ҵ� �⺻������ ȣ��");
	}
	
	public Sony(VoiceRecording VR) {
		this.VR = VR;
		System.out.println("�Ҵ� ������ ȣ��");
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("sony ����Ŵ");
		VR.turnOn();
	}

	@Override
	public void powerOff() {
		System.out.println("sony ������");
		VR.turnOff();
	}

	@Override
	public void zoomIn() {
		System.out.println("sony ����");
		VR.volumeUp();
	}

	@Override
	public void zoomout() {
		System.out.println("sony �ܾƿ�");
		VR.volumeDown();
	}

}
