package model.board123;

import java.util.List;

public interface Board123Service {
	void insertBoard(Board123VO vo); // �޼��� �ñ״�ó
	void updateBoard(Board123VO vo);
	void deleteBoard(Board123VO vo);
	List<Board123VO> getBoardList(Board123VO vo);
	Board123VO getBoard(Board123VO vo);
}
