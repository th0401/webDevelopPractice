package model.userInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;





class UserInfoRowMapper implements RowMapper<UserInfoVO>{

	@Override
	public UserInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserInfoVO data = new UserInfoVO();
		data.setId(rs.getString("id"));
		data.setName(rs.getString("name"));
		data.setPw(rs.getString("pw"));
		data.setGender(rs.getString("gender"));

		return data;
	}
}

@Repository
public class SpringUserInfoDAO {

	private final String sql_LOGIN="SELECT * FROM USERINFO WHERE ID=? AND PW=?";
	private final String sql_INSERT="INSERT INTO USERINFO (ID,PW,NAME,GENDER) VALUES(?,?,?,?)";
	private final String sql_UPDATE="UPDATE USERINFO SET PW=?,NAME=?,GENDER=? WHERE ID=?";
	private final String sql_DELETE="DELETE USERINFO WHERE ID=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserInfoVO login(UserInfoVO vo) {
		System.out.println("jdbcTemplate으로 loginDAO");
		Object[] args= {vo.getId(),vo.getPw()};

		try {
			return jdbcTemplate.queryForObject(sql_LOGIN,args,new UserInfoRowMapper());
		 }
		 catch(DataAccessException e){
			 
			 return null;
		 }		
		
	}
	
	public void insertUser(UserInfoVO vo) {
		System.out.println("jdbcTemplate로 insertUserInfo");
		
		Object[] args= {vo.getId(),vo.getPw(),vo.getName(),vo.getGender()};
		jdbcTemplate.update(sql_INSERT,args);
	}
	
	public void updateUser(UserInfoVO vo) {
		System.out.println("jdbcTemplate로 updateUserInfo");
		Object[] args= {vo.getPw(),vo.getName(),vo.getId()};
		jdbcTemplate.update(sql_UPDATE,args);
		
	}
	
	public void deleteUser(UserInfoVO vo) {
		System.out.println("jdbcTemplate로 deleteUserInfo");
		jdbcTemplate.update(sql_DELETE,vo.getId());
	}
	
	
	
	

}


