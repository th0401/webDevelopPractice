package day02;

public class Client {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		Phone phone = (Phone)factory.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		
	}

}
