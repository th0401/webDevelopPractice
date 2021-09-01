package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
	public static Connection connect() {
		Connection conn = null;
		String DName="oracle.jdbc.driver.OracleDriver";

	      String url="jdbc:oracle:thin:@localhost:1521:xe";
	      String user="kim";
	      String password="1234";
	      
	      try {
			Class.forName(DName);
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("connect에서 오류");
			e.printStackTrace();
		}	      
	      return conn;
	}
	
	public static void disconnect(PreparedStatement pstmt,Connection conn) {
		
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("disconnect에서 오류");
			e.printStackTrace();
		}
		
	}
	
	
	
}
