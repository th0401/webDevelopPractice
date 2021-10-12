package model.board1;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Board1Client {
public static void main(String[] args) {
		
	
	AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
	
	Board1Service bs=(Board1Service)factory.getBean("board1Service");
	
	Board1VO vo=new Board1VO();
	vo.setContent("PointcutClass로 실행중");
	vo.setTitle("스프링억까금지123");
	vo.setWriter("사용자");
	bs.insertBoard1(vo);
	Board1VO vo2=new Board1VO();
	vo2.setTitle("금지1");
	List<Board1VO> datas=bs.getBoard1List(vo2);
	for(Board1VO data:datas) {
		System.out.println(data);
	}
	
	factory.close();
	
	
}			
}
