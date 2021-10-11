package model.board123;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class Board123RowMapper implements RowMapper<Board123VO>{

	@Override
	public Board123VO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Board123VO data = new Board123VO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		
		return data;
	}
	
}


// 1. extends 상속받아서 구현
// 2. JdbcTemplate을 <bean>등록, 의존성주입받아 사용
@Repository
public class SpringBoard123DAO{
	

	private final String insertSQL="insert into board123 (id,title,writer,content) values((select nvl(max(id),0)+1 from board123),?,?,?)";
	private final String updateSQL="update board123 set title=?,content=? where id=?";
	private final String deleteSQL="delete board123 where id=?";
	private final String getBoardSQL="select * from board123 where id=?";
	private final String getBoardListSQL="select * from board123 order by id desc";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void insertBoard(Board123VO vo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	public void updateBoard(Board123VO vo) {
	
		System.out.println("jdbcTemplate으로 update");
		jdbcTemplate.update(updateSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	public void deleteBoard(Board123VO vo) {
		
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL,vo.getId());
	}
	public List<Board123VO> getBoardList(Board123VO vo) {
		
		System.out.println("jdbcTemplate으로 getBoard123List");
		
		return jdbcTemplate.query(getBoardListSQL,new Board123RowMapper());
		
		
	}
	public Board123VO getBoard(Board123VO vo) {
		System.out.println("jdbcTemplate으로 getBoard123");
		Object[] args= {vo.getId()};
		
		return jdbcTemplate.queryForObject(getBoardSQL,args,new Board123RowMapper());
		
	}
	
	
	
	
}
