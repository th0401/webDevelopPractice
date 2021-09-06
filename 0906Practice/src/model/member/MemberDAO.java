package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.JDBC;

public class MemberDAO {
	
	public MemberVO selectOne(MemberVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		MemberVO data=null;
		try{
			String sql="select * from member where userID=? and userPW=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MemberVO();				
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("MemberDAO selectOne()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}	
		
	public boolean insertM(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="insert into member values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getUserName());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertMDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public boolean updateM(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update member set userPW=?, userName=? where userID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserPW());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getUserID());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateMDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;

	}
	
	public boolean deleteM(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from member where userID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteMDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	
}
