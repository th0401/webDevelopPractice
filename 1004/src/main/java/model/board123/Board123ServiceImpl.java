package model.board123;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.app.common.LogAdvice;

// 기존의 OOP 언어체계에서 AOP가 가지는 한계
@Service("board123Service")
public class Board123ServiceImpl implements Board123Service{
	
	@Autowired
	private Board123DAO board123dao;
	private LogAdvice logAdvice;
	
	public Board123ServiceImpl() {
		this.logAdvice=new LogAdvice();
	}
	
	@Override
	public void insertBoard123(Board123VO vo) {
		logAdvice.printlog();
		board123dao.insertBoard123(vo);
		
	}

	@Override
	public void updateBoard123(Board123VO vo) {
		logAdvice.printlog();
		board123dao.updateBoard123(vo);
		
	}

	@Override
	public void deleteBoard123(Board123VO vo) {
		logAdvice.printlog();
		board123dao.deleteBoard123(vo);
		
	}

	@Override
	public List<Board123VO> getBoard123List(Board123VO vo) {
		logAdvice.printlog();
		return board123dao.getBoard123List(vo);
	}

	@Override
	public Board123VO getBoard123(Board123VO vo) {
		logAdvice.printlog();
		return board123dao.getBoard123(vo);
	}

}
