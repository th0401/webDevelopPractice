package model.board1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



class Board1RowMapper implements RowMapper<Board1VO>{

	@Override
	public Board1VO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Board1VO data = new Board1VO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		
		return data;
	}
	
}


@Repository
public class SpringBoard1DAO{

	
	private static String selectAll = "select * from board1 where title like ? order by id desc";
	private static String insertSQL = "insert into board1 (id,title,writer,content) values((select nvl(max(id),0)+1 from board1),?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Board1VO> getBoard1List(Board1VO vo){
		System.out.println("jdbcTemplate으로 selectAll");
		Object[] args = {"%"+vo.getTitle()+"%"};
		return jdbcTemplate.query(selectAll,args,new Board1RowMapper());
		
	}
	public void insertBoard1(Board1VO vo) {
		System.out.println("jdbcTemplete Board1 insert수행");
		
		jdbcTemplate.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
	}
}
