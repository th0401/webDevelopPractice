package test;

public class Sony implements Camera{

	
	VoiceRecording VR;
	
	public Sony() {
		System.out.println("소니 기본생성자 호출");
	}
	
	public Sony(VoiceRecording VR) {
		this.VR = VR;
		System.out.println("소니 생성자 호출");
	}
	
	
	@Override
	public void powerOn() {
		System.out.println("sony 전원킴");
		VR.turnOn();
	}

	@Override
	public void powerOff() {
		System.out.println("sony 전원끔");
		VR.turnOff();
	}

	@Override
	public void zoomIn() {
		System.out.println("sony 줌인");
		VR.volumeUp();
	}

	@Override
	public void zoomout() {
		System.out.println("sony 줌아웃");
		VR.volumeDown();
	}

}
