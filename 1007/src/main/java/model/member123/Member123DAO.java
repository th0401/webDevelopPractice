package model.member123;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("member123DAO")
public class Member123DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String getMember123SQL="select * from member123 where id=? and pw=?";
	private final String insertSQL="insert into member123 (id,pw,name,role) values(?,?,?,?)";
	private final String updateSQL="update member123 set pw=?,name=? where id=?";
	private final String deleteSQL="delete member123 where id=?";
	
	public boolean insertMember(Member123VO vo) {
		System.out.println("dao로 insertMember");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return true;
	}
	public boolean updateMember(Member123VO vo) {
		System.out.println("dao로 updateMember");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return true;
	}
	
	public boolean deleteMember(Member123VO vo) {
		System.out.println("dao로 deleteMember");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return true;
	}
	
	
	
	public Member123VO getMember(Member123VO vo) {
		// 로그인에 성공한다면, Member123VO 객체가 리턴(반환)
		// 실패한다면, 리턴이 null
		Member123VO data=null;
		
		System.out.println("Member123DAO로 get");

		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMember123SQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new Member123VO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPw(rs.getString("pw"));
				data.setRole(rs.getString("role"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		
		return data;
	}
}
