package model.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JNDI;

public class TestDAO {

	public ArrayList<TestVO> selectAll(){
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;
		ArrayList<TestVO> datas = new ArrayList<TestVO>();
		try{						
			String sql="select * from test";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TestVO data=new TestVO();
				data.setName(rs.getString("name"));
				data.setEmail(rs.getString("email"));
				datas.add(data);	  
			}
			rs.close();			

		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;		

	}

	public ArrayList<TestVO> selectOne(TestVO vo) {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;
		ArrayList<TestVO> datas = new ArrayList<TestVO>();
		TestVO data = null;

		try{

			String sql="select * from test where name=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new TestVO();
				data.setName(rs.getString("name"));
				data.setEmail(rs.getString("email"));
				datas.add(data);	  
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}		
		return datas;
	}

	public boolean insertDB(TestVO vo) {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;		
		boolean flag=false;
		try{

			String sql="insert into test values(?,?)";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.executeUpdate();

			flag=true;

		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}		
		return flag;
	}
	public boolean updateDB(TestVO vo) {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;		
		boolean flag=false;
		try{

			String sql="update test set email=? where name=?";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getName());
			pstmt.executeUpdate();

			flag=true;

		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}		
		return flag;
	}
	public boolean deleteDB(TestVO vo) {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;		
		boolean flag=false;
		try{

			String sql="delete from test where name=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());

			pstmt.executeUpdate();

			flag=true;					
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}		
		return flag;
	}













}
