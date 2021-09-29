package test;

public class Cannon implements Camera{
	
	VoiceRecording VR;
	String name;
	public Cannon() {
		System.out.println("케논 기본생성자 호출");
	}
	
	public Cannon(VoiceRecording VR,String name) {
		this.VR = VR;
		this.name=name;
		System.out.println("케논 생성자 호출 "+ name);
	}
	
	@Override
	public void powerOn() {
		System.out.println("cannon 전원 on");
		VR.turnOn();
	}

	@Override
	public void powerOff() {
		System.out.println("cannon 전원 down");
		VR.turnOff();
	}

	@Override
	public void zoomIn() {
		System.out.println("cannon 줌 in");
		VR.volumeUp();
	}

	@Override
	public void zoomout() {
		System.out.println("cannon 줌 out");
		VR.volumeDown();
	}

}
