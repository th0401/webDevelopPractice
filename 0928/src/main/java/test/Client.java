package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	
	public static void main(String[] args) {
		
		  // 1. ������ �����̳ʸ� ���۽��Ѻ���!~~
	      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
	      
	      // 2. ��ü�� ��û�ϸ�, �ش� ��ü�� �ش�.
	      //  == Look up
	      /*Test t=(Test)factory.getBean("test");
	      t.print();*/
	      Camera camera=(Camera)factory.getBean("camera");
	      camera.powerOn();
	      camera.powerOff();      
	      // 3. ������ �����̳� ����
	      factory.close();
	      
	      // => Console
	      // ���� <bean> ��ϵ� ��� Ŭ������ ���� ��ü�� �̸� ���������ϴ�!
	      // �⺻ ������ ȣ���!
	      
	      // => Console
	      // �⺻ ������ ȣ���!
	      // ���

		
		
	}
}
