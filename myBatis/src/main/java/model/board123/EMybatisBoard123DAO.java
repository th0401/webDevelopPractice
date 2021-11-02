package model.board123;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class EMybatisBoard123DAO extends SqlSessionDaoSupport{
	@Autowired
	   public void setSqlSessionFacotory(SqlSessionFactory sqlSessionFactory) {
	      super.setSqlSessionFactory(sqlSessionFactory);
	   }
	   
	   public void insertBoard123(Board123VO vo) {
	      getSqlSession().insert("dao.insertBoard123",vo);
	   }
	   public void updateBoard123(Board123VO vo) {
	      getSqlSession().insert("dao.updateBoard123",vo);
	   }
	   public void deleteBoard123(Board123VO vo) {
	      getSqlSession().insert("dao.deleteBoard123",vo);
	   }
	   public Board123VO getBoard123(Board123VO vo) {
	      return (Board123VO)getSqlSession().selectOne("dao.getBoard123",vo);
	   }
	   public List<Board123VO> getBoard123List(Board123VO vo){
	      return getSqlSession().selectList("dao.getBoard123List",vo);
	   }

}
