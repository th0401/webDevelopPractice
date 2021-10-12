package model.member1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class Member1RowMapper implements RowMapper<Member1VO>{

	@Override
	public Member1VO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Member1VO data=new Member1VO();
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setPassword(rs.getString("password"));
		data.setRole(rs.getString("role"));
		
		return data;
	}
	
}

@Repository
public class SpringMember1DAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String getMember1SQL="select * from member1 where id=? and password=?";
	private static String insertSQL = "insert into member1 (id,password,name,role) values(?,?,?,?)";
	public Member1VO getMember(Member1VO vo) {
		// 로그인에 성공한다면, Member123VO 객체가 리턴(반환)
		// 실패한다면, 리턴이 null
		
		
		System.out.println("jdbcTemplete Member1DAO로 get");
		
		Object[] args= {vo.getId(),vo.getPassword()};
		 try {
			 return jdbcTemplate.queryForObject(getMember1SQL, args,new Member1RowMapper());
		 }
		 catch(DataAccessException e){
			 
			 return null;
		 }			
		
	}
	public void insertMember1(Member1VO vo) {
		System.out.println("jdbcTemplete insert");
		Object[] args= {vo.getId(),vo.getPassword(),vo.getName(),vo.getRole()};
		jdbcTemplate.update(insertSQL,args);
		
	}
}
