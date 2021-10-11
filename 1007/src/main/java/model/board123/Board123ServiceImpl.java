package model.board123;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("board123Service")
public class Board123ServiceImpl implements Board123Service{
	@Autowired
	private SpringBoard123DAO Board123DAO; // alt+shift+R -> 이름 한번에 변경 가능!
	
	@Override
	public void insertBoard(Board123VO vo) {
		/*if(vo.getId()==0) {
			throw new IllegalArgumentException("id PK : 0 불가능!");
			// 런타임 예외(실행시에 발생,체크되는 예외)
		}*/
		Board123DAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(Board123VO vo) {
		Board123DAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(Board123VO vo) {
		Board123DAO.deleteBoard(vo);
	}

	@Override
	public List<Board123VO> getBoardList(Board123VO vo) {
		return Board123DAO.getBoardList(vo);
	}

	@Override
	public Board123VO getBoard(Board123VO vo) {
		return Board123DAO.getBoard(vo);
	}
}
