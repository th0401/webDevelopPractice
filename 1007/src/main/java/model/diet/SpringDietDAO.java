package model.diet;

public class SpringDietDAO {

	private static String sql_SELECT_ALL = "SELECT * FROM diet ORDER BY dnum DESC";
	private static String sql_SELECT_ONE = "SELECT * FROM diet WHERE dnum=?"; 
	private static String sql_INSERT = "INSERT INTO diet (dnum,breakfast,lunch,diner,another,breakfastCalorie,lunchCalorie,dinerCalorie,anotherCalorie,dayCalorie,ddate,d_user) values(?,?,?,?,?,?,?,?,?,?,sysdate,?)";
	private static String sql_UPDATE = "UPDATE diet SET breakfast=?, lunch=?, diner=?,another=?, breakfastCalorie, lunchCalorie=?, dinerCalorie=?, dayColorie=? WHERE dnum=?";
	
	
	
	
	
	
	
	
}
