package model.board123;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("board123Service")
public class Board123ServiceImpl implements Board123Service{
	@Autowired
	private JPABoard123DAO Board123DAO; // alt+shift+R -> �̸� �ѹ��� ���� ����!
	
	@Override
	public void insertBoard123(Board123JPAVO vo) {
		/*if(vo.getId()==0) {
			throw new IllegalArgumentException("id PK : 0 �Ұ���!");
			// ��Ÿ�� ����(����ÿ� �߻�,üũ�Ǵ� ����)
		}*/
		Board123DAO.insertBoard123(vo);
	}

	@Override
	public void updateBoard123(Board123JPAVO vo) {
		Board123DAO.updateBoard123(vo);
	}

	@Override
	public void deleteBoard123(Board123JPAVO vo) {
		Board123DAO.deleteBoard123(vo);
	}

	@Override
	public List<Board123JPAVO> getBoard123List(Board123JPAVO vo) {
		return Board123DAO.getBoard123List(vo);
	}

	@Override
	public Board123JPAVO getBoard123(Board123JPAVO vo) {
		return Board123DAO.getBoard123(vo);
	}
}
