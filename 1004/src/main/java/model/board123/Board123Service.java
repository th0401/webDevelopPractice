package model.board123;

import java.util.List;

import model.common.JDBC;

public interface Board123Service {
	
	void insertBoard123(Board123VO vo);
	void updateBoard123(Board123VO vo);
	void deleteBoard123(Board123VO vo);
	List<Board123VO> getBoard123List(Board123VO vo);
	Board123VO getBoard123(Board123VO vo);
}
