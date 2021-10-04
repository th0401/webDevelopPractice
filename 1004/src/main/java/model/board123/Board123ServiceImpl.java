package model.board123;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("board123Service")
public class Board123ServiceImpl implements Board123Service{
	
	@Autowired
	private Board123DAO board123dao;
	
	@Override
	public void insertBoard123(Board123VO vo) {
		board123dao.insertBoard123(vo);
		
	}

	@Override
	public void updateBoard123(Board123VO vo) {
		board123dao.updateBoard123(vo);
		
	}

	@Override
	public void deleteBoard123(Board123VO vo) {
		board123dao.deleteBoard123(vo);
		
	}

	@Override
	public List<Board123VO> getBoard123List(Board123VO vo) {
		
		return board123dao.getBoard123List(vo);
	}

	@Override
	public Board123VO getBoard123(Board123VO vo) {

		return board123dao.getBoard123(vo);
	}

}
