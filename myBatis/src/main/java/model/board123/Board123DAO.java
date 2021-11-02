package model.board123;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Board123DAO {

	private SqlSession mybatis;
	Board123DAO(){
		mybatis=SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard123(Board123VO vo) {
		mybatis.insert("dao.insertBoard123", vo);
		mybatis.commit();
	}
	
	public void updateBoard123(Board123VO vo) {
		mybatis.update("dao.updateBoard123", vo);
		mybatis.commit();
	}
	
	public void deleteBoard123(Board123VO vo) {
		mybatis.delete("dao.deleteBoard123", vo);
		mybatis.commit();
	}
	
	public Board123VO getBoard123(Board123VO vo) {
		return (Board123VO) mybatis.selectOne("dao.getBoard123",vo);
	}
	
	public List<Board123VO> getBoard123List(Board123VO vo) {
		return mybatis.selectList("dao.getBoard123List",vo);
	}
}
