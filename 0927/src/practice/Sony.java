package practice;

public class Sony implements Camera{

	@Override
	public void powerOn() {
		System.out.println("sony ����Ŵ");
		
	}

	@Override
	public void powerOff() {
		System.out.println("sony ������");
		
	}

	@Override
	public void zoomIn() {
		System.out.println("sony ����");
		
	}

	@Override
	public void zoomout() {
		System.out.println("sony �ܾƿ�");
		
	}

}
