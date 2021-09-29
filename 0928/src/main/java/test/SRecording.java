package test;

public class SRecording implements VoiceRecording{

	
	public SRecording() {
		System.out.println("»ï¼º³ìÀ½±â ±âº»»ı¼ºÀÚ È£Ãâ");
	}
	
	@Override
	public void turnOn() {
		System.out.println("»ï¼º³ìÀ½±â Àü¿øÅ´");
		
	}

	@Override
	public void turnOff() {
		System.out.println("»ï¼º³ìÀ½±â Àü¿ø²û");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("»ï¼º³ìÀ½±â º¼·ı¾÷");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("»ï¼º³ìÀ½±â º¼·ı´Ù¿î");
		
	}

}
