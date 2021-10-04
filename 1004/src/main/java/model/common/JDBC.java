package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	
	public static Connection getConnection(){
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String password = "1234";
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	public static void close(Connection conn,PreparedStatement pstmt) {
	      try {
	    
	         pstmt.close();
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	
	   public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
	      try {
	    	 if(rs!=null){
	    		 rs.close();
	    	 } 
	         pstmt.close();
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }

	
}
