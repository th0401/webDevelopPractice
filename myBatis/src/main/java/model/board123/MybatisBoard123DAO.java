package model.board123;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisBoard123DAO {
	
	// ÀÚ·áÇü(Data Type)
	@Autowired
	 private SqlSessionTemplate mybatis;
	   
	   public void insertBoard123(Board123VO vo) {
		   mybatis.insert("dao.insertBoard123",vo);
	   }
	   public void updateBoard123(Board123VO vo) {
		   mybatis.insert("dao.updateBoard123",vo);
	   }
	   public void deleteBoard123(Board123VO vo) {
		   mybatis.insert("dao.deleteBoard123",vo);
	   }
	   public Board123VO getBoard123(Board123VO vo) {
	      return (Board123VO)mybatis.selectOne("dao.getBoard123",vo);
	   }
	   public List<Board123VO> getBoard123List(Board123VO vo){
	      return mybatis.selectList("dao.getBoard123List",vo);
	   }
}
