package model.board123;

import java.util.List;

public interface Board123Service {
	void insertBoard123(Board123VO vo); // �޼��� �ñ״�ó
	void updateBoard123(Board123VO vo);
	void deleteBoard123(Board123VO vo);
	List<Board123VO> getBoard123List(Board123VO vo);
	Board123VO getBoard123(Board123VO vo);
}
