package model.member1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Member1Client {
public static void main(String[] args) {
	
	
	AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
	
	Member1Service ms=(Member1Service)factory.getBean("member1Service");
	
	Member1VO vo=new Member1VO();
	vo.setId("admin");
	vo.setPassword("12345");
	Member1VO data=ms.getMember(vo);
	System.out.println();
	if(data!=null) {
		// �α��� ����
		System.out.println("�α��� ����!");
	}
	else {
		// �α��� ����
		System.out.println("�α��� ����!");
	}
	
	factory.close();
}
}
