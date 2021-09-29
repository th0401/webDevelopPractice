package test;

public class LRecording implements VoiceRecording{

	public LRecording() {
		System.out.println("LG녹음기 기본생성자 호출");
	}
	
	@Override
	public void turnOn() {
		System.out.println("LG녹음기 전원킴");
		
	}

	@Override
	public void turnOff() {
		System.out.println("LG녹음기 전원끔");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("LG녹음기 소리++");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LG녹음기 소리--");
		
	}

}
