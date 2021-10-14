package model.member123;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.common.JDBC;


class Member123RowMapper implements RowMapper<Member123VO>{

	@Override
	public Member123VO mapRow(ResultSet rs, int rowNum) throws SQLException {

		Member123VO data = new Member123VO();
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setPw(rs.getString("pw"));
		data.setRole(rs.getString("role"));

		return data;
	}
}

@Repository
public class SpringMember123DAO {

	private final String getMember123SQL="select * from member123 where id=? and pw=?";
	private final String insertSQL="insert into member123 (id,pw,name,role) values(?,?,?,?)";
	private final String updateSQL="update member123 set pw=?,name=? where id=?";
	private final String deleteSQL="delete member123 where id=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Member123VO getMember(Member123VO vo) {
		System.out.println("jdbcTemplate으로 getMember123");
		Object[] args= {vo.getId(),vo.getPw()};

		return jdbcTemplate.queryForObject(getMember123SQL,args,new Member123RowMapper());

	}
	
	public void insertMember(Member123VO vo) {
		System.out.println("jdbcTemplate로 insertMember");
		
		Object[] args= {vo.getId(),vo.getPw(),vo.getName(),vo.getRole()};
		jdbcTemplate.update(insertSQL,args);
	}
	
	public void updateMember(Member123VO vo) {
		System.out.println("jdbcTemplate로 updateMember");
		Object[] args= {vo.getPw(),vo.getName(),vo.getId()};
		jdbcTemplate.update(updateSQL,args);
		
	}
	
	public void deleteMember(Member123VO vo) {
		System.out.println("jdbcTemplate로 deleteMember");
		jdbcTemplate.update(updateSQL,vo.getId());
	}
	
	
	
	

}


