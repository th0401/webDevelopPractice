package model.member123;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Member123Client {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		Member123Service ms=(Member123Service)factory.getBean("member123Service");

		Member123VO vo=new Member123VO();
		vo.setId("admin");
		vo.setPw("1234");
		Member123VO data=ms.getMember(vo);

		if(data!=null) {
			// 로그인 성공
			System.out.println("로그인 성공!");
		}
		else {
			// 로그인 실패
			System.out.println("로그인 실패!");
		}

		factory.close();
	}

}
