package practice;

public class Cannon implements Camera{

	@Override
	public void powerOn() {
		System.out.println("cannon ���� on");
		
	}

	@Override
	public void powerOff() {
		System.out.println("cannon ���� down");
		
	}

	@Override
	public void zoomIn() {
		System.out.println("cannon �� in");
		
	}

	@Override
	public void zoomout() {
		System.out.println("cannon �� out");
		
	}

}
