package model.member123;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Member123Client {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Member123Service ms = (Member123Service)factory.getBean("member123Service");
		
		Member123VO vo = new Member123VO();
		vo.setId("ÆÈ¶û°¡Áö");
		vo.setPw("1234");
		vo.setName("ÄÚ·Á¿ö");
		vo.setRole("User");
		ms.insertmember123(vo);
		
		List<Member123VO> datas = new ArrayList<Member123VO>();
		datas = ms.getMember123List(vo);
		
		for(Member123VO data:datas) {
			System.out.println(data);
		}
		
	}

}
