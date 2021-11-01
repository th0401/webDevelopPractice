package model.diet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import model.userInfo.UserInfoVO;


class DietRowMapper implements RowMapper<DietVO>{

	@Override
	public DietVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		DietVO data = new DietVO();
		data.setDnum(rs.getInt("dnum"));
		data.setBreakfast(rs.getString("breakfast"));
		data.setLunch(rs.getString("lunch"));
		data.setDiner(rs.getString("diner"));
		data.setAnother(rs.getString("another"));
		data.setBreakfastCalorie(rs.getInt("breakfastCalorie"));
		data.setLunchCalorie(rs.getInt("lunchCalorie"));
		data.setDinerCalorie(rs.getInt("dinerCalorie"));
		data.setAnotherCalorie(rs.getInt("anotherCalorie"));
		data.setDayCalorie(rs.getInt("dayCalorie"));
		data.setBreakfastDate(rs.getDate("breakfastDate"));
		data.setLunchDate(rs.getDate("lunchDate"));
		data.setDinerDate(rs.getDate("dinertDate"));
		data.setDdate(rs.getDate("ddate"));
		data.setD_user(rs.getString("d_user"));
		
		return data;
	}
}



@Repository
public class SpringDietDAO {

	private static String sql_SELECT_ALL = "SELECT * FROM DIET WHERE D_USER=? ORDER BY DNUM DESC";
	private static String sql_SELECT_ONE = "SELECT * FROM DIET WHERE DNUM=?"; 
	private static String sql_INSERT = "INSERT INTO DIET (DNUM,BREAKFAST,LUNCH,DINER,ANOTHER,BREAKFASTCALORIE,LUNCHCALORIE,DINERCALORIE,ANOTHERCALORIE,DAYCALORIE,BREAKFASTDATE,LUNCHDATE,DINERDATE,DDATE,D_USER) VALUES((SELECT NVL(MAX(DNUM),0) + 1 FROM DIET),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static String sql_UPDATE = "UPDATE DIET SET BREAKFAST=?, LUNCH=?, DINER=?,ANOTHER=?, BREAKFASTCALORIE, LUNCHCALORIE=?, DINERCALORIE=?, DAYCOLORIE=? , BREAKFASTDATE=?, LUNCHDATE=?, DINERDATE=?, DDATE=? WHERE DNUM=?";
	private static String sql_DELETE = "DELETE * FROM DIET WHERE DNUM=?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<DietVO> selectAll(UserInfoVO vo) {
		System.out.println("jdbcTemplate으로 DietSelectAllDAO");
		Object[] args= {vo.getId()};
			return jdbcTemplate.query(sql_SELECT_ALL,args, new DietRowMapper());
			
	}
	
	public DietVO selectOne(DietVO vo) {
		System.out.println("jdbcTemplate으로DietSelectOneDAO");
		
		Object[] args= {vo.getDnum()};
		
			return jdbcTemplate.queryForObject(sql_SELECT_ONE, args, new DietRowMapper());
		
	}
	
	
	public void insertDiet(DietVO vo) {
		System.out.println("jdbcTemplate로 insertDiet");
		
		Object[] args= {vo.getBreakfast(),vo.getLunch(),vo.getDiner(),vo.getAnother(),vo.getBreakfastCalorie(),vo.getLunchCalorie(),vo.getDinerCalorie(),vo.getAnotherCalorie(),vo.getDayCalorie(),vo.getBreakfastDate(),vo.getLunchDate(),vo.getDinerDate(),vo.getDdate(),vo.getD_user()};
		jdbcTemplate.update(sql_INSERT,args);
	}
	
	public void updateDiet(DietVO vo) {
		System.out.println("jdbcTemplate로 updateDiet");
		Object[] args= {vo.getBreakfast(),vo.getLunch(),vo.getDiner(),vo.getAnother(),vo.getBreakfastCalorie(),vo.getLunchCalorie(),vo.getDinerCalorie(),vo.getAnotherCalorie(),vo.getDayCalorie(),vo.getBreakfastDate(),vo.getLunchDate(),vo.getDinerDate(),vo.getDdate(),vo.getDnum()};
		jdbcTemplate.update(sql_UPDATE,args);
		
	}
	
	public void deleteDiet(DietVO vo) {
		System.out.println("jdbcTemplate로 deleteDiet");
		jdbcTemplate.update(sql_DELETE,vo.getDnum());
	}
	
	
	
	
}
