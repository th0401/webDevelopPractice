package practice;

public class Sony implements Camera{

	@Override
	public void powerOn() {
		System.out.println("sony Àü¿øÅ´");
		
	}

	@Override
	public void powerOff() {
		System.out.println("sony Àü¿ø²û");
		
	}

	@Override
	public void zoomIn() {
		System.out.println("sony ÁÜÀÎ");
		
	}

	@Override
	public void zoomout() {
		System.out.println("sony ÁÜ¾Æ¿ô");
		
	}

}
