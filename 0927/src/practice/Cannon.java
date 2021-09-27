package practice;

public class Cannon implements Camera{

	@Override
	public void powerOn() {
		System.out.println("cannon Àü¿ø on");
		
	}

	@Override
	public void powerOff() {
		System.out.println("cannon Àü¿ø down");
		
	}

	@Override
	public void zoomIn() {
		System.out.println("cannon ÁÜ in");
		
	}

	@Override
	public void zoomout() {
		System.out.println("cannon ÁÜ out");
		
	}

}
