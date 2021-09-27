package practice;

public class Client2 {

	public static void main(String[] args) {
		
		MyBeanFactory beanFactory = new MyBeanFactory();
		Camera camera = (Camera)beanFactory.getBean(args[0]);
		
		camera.powerOn();
		camera.powerOff();
		camera.zoomIn();
		camera.zoomout();
	}

}
