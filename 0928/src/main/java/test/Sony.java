package test;

public class Sony implements Camera{

	
	private VoiceRecording vr;
	private String name;
	
	public Sony() {
		System.out.println("�Ҵ� �⺻������ ȣ��");
	}
	
	
	public void setVr(VoiceRecording vr) {
		this.vr = vr;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void powerOn() {
		System.out.println("sony ����Ŵ");
		vr.turnOn();
	}

	@Override
	public void powerOff() {
		System.out.println("sony ������");
		vr.turnOff();
	}

	@Override
	public void zoomIn() {
		System.out.println("sony ����");
		vr.volumeUp();
	}

	@Override
	public void zoomout() {
		System.out.println("sony �ܾƿ�");
		vr.volumeDown();
	}

}
