package model.member123;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


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


	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Member123VO getMember(Member123VO vo) {
		System.out.println("jdbcTemplate¿∏∑Œ getMember123");
		Object[] args= {vo.getId(),vo.getPw()};

		return jdbcTemplate.queryForObject(getMember123SQL,args,new Member123RowMapper());

	}

}


