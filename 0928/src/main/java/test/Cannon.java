package test;

public class Cannon implements Camera{
	
	VoiceRecording VR;
	String name;
	public Cannon() {
		System.out.println("�ɳ� �⺻������ ȣ��");
	}
	
	public Cannon(VoiceRecording VR,String name) {
		this.VR = VR;
		this.name=name;
		System.out.println("�ɳ� ������ ȣ�� "+ name);
	}
	
	@Override
	public void powerOn() {
		System.out.println("cannon ���� on");
		VR.turnOn();
	}

	@Override
	public void powerOff() {
		System.out.println("cannon ���� down");
		VR.turnOff();
	}

	@Override
	public void zoomIn() {
		System.out.println("cannon �� in");
		VR.volumeUp();
	}

	@Override
	public void zoomout() {
		System.out.println("cannon �� out");
		VR.volumeDown();
	}

}
