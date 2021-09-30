package test;

public class Sony implements Camera{

	
	private VoiceRecording vr;
	private String name;
	
	public Sony() {
		System.out.println("¼Ò´Ï ±âº»»ý¼ºÀÚ È£Ãâ");
	}
	
	
	public void setVr(VoiceRecording vr) {
		this.vr = vr;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void powerOn() {
		System.out.println("sony Àü¿øÅ´");
		vr.turnOn();
	}

	@Override
	public void powerOff() {
		System.out.println("sony Àü¿ø²û");
		vr.turnOff();
	}

	@Override
	public void zoomIn() {
		System.out.println("sony ÁÜÀÎ");
		vr.volumeUp();
	}

	@Override
	public void zoomout() {
		System.out.println("sony ÁÜ¾Æ¿ô");
		vr.volumeDown();
	}

}
