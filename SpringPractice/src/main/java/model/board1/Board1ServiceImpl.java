package model.board1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("board1Service")
public class Board1ServiceImpl implements Board1Service{

	@Autowired
	private SpringBoard1DAO board1dao;
	
	

	@Override
	public void insertBoard1(Board1VO vo) {
		board1dao.insertBoard1(vo);
		
	}



	@Override
	public List<Board1VO> getBoard1List(Board1VO vo) {
		return board1dao.getBoard1List(vo);
	}
	
}
