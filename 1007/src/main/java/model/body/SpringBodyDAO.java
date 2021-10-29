package model.body;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



class BodyRowMapper implements RowMapper<BodyVO>{

	@Override
	public BodyVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		BodyVO data = new BodyVO();
		data.setBnum(rs.getInt("bnum"));
		data.setHeight(rs.getFloat("height"));
		data.setWeight(rs.getFloat("weight"));
		data.setBdate(rs.getDate("bdate"));
		data.setB_user(rs.getString("b_user"));
		return data;
	}
}
@Repository
public class SpringBodyDAO {

	private final String sql_SELECT_ALL = "SELECT * FROM body ORDER BY bnum DESC";
	private static String sql_SELECT_ONE = "SELECT * FROM body WHERE bnum=?";
	private final String sql_INSERT="INSERT INTO body (bnum,height,weight,bdate,b_user) VALUES((SELECT NVL(MAX(bnum),0) + 1 FROM body),?,?,sysdate,?)";
	private final String sql_UPDATE="UPDATE body SET height=?,weight=? WHERE bnum=?";
	private final String sql_DELETE="DELETE body WHERE bnum=?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BodyVO> selectAll(BodyVO vo) {
		System.out.println("jdbcTemplate으로 bodySelectAllDAO");
		
			return jdbcTemplate.query(sql_SELECT_ALL, new BodyRowMapper());
		
	}
	
	public BodyVO selectOne(BodyVO vo) {
		System.out.println("jdbcTemplate으로 bodySelectOneDAO");
		
		Object[] args= {vo.getBnum()};
		
			return jdbcTemplate.queryForObject(sql_SELECT_ONE, args, new BodyRowMapper());
		
	}
	
	
	public void insertBody(BodyVO vo) {
		System.out.println("jdbcTemplate로 insertBody");
		
		Object[] args= {vo.getHeight(),vo.getWeight(),vo.getB_user()};
		jdbcTemplate.update(sql_INSERT,args);
	}
	
	public void updateBody(BodyVO vo) {
		System.out.println("jdbcTemplate로 updateBody");
		Object[] args= {vo.getHeight(),vo.getWeight(),vo.getBnum()};
		jdbcTemplate.update(sql_UPDATE,args);
		
	}
	
	public void deleteBody(BodyVO vo) {
		System.out.println("jdbcTemplate로 deleteBody");
		jdbcTemplate.update(sql_DELETE,vo.getBnum());
	}
	
	
}
