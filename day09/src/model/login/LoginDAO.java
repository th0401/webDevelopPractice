package model.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.JDBC;


public class LoginDAO {
	
	public LoginVO selectOne(LoginVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		LoginVO data=null;
		try{
			String sql="select * from ltest where ID=? and PW=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new LoginVO();
				data.setMnum(rs.getInt("mnum"));
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("LoginDAO selectOne()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	} 
	
}
