package model.common;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDI {

	public static Connection connect() {

		Connection conn=null;

		try {
			Context initContext=new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds= (DataSource)envContext.lookup("jdbc/orcl");						
			conn=ds.getConnection();
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
