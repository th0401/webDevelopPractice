package model.board123;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Board123Client {

	public static void main(String[] args) {
		
AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Board123Service bs=(Board123Service)factory.getBean("board123Service");
		
		Board123VO vo=new Board123VO();
		vo.setContent("내용 작성중~~");
		vo.setTitle("제목입니다!");
		vo.setWriter("관리자");
		bs.insertBoard(vo);
		
		List<Board123VO> datas=bs.getBoardList(vo);
		for(Board123VO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}

	
}

