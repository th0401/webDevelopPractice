package model.member123;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;
@Repository("Member123DAO")
public class Member123DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL="insert into member123 VALUES(?, ?, ?, ?)";
	
	private final String updateSQL="update member123 set pw=?,name=? where id=?";
	
	private final String deleteSQL="delete from member123 where id=?";
	private final String getMember123="select * from member123 where id=?";
	private final String getMember123List="select * from member123 order by id desc";
	
	public void insertmember123(Member123VO vo) {
		System.out.println("dao로 insert");				
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		
		
	}
	public void updateMember123(Member123VO vo) {
		System.out.println("dao로 update");
		
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getId());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void deleteMember123(Member123VO vo) {
		System.out.println("dao로 delete");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<Member123VO> getMember123List(Member123VO vo) {
		System.out.println("dao로 getMember123List");
		List<Member123VO> datas = new ArrayList<Member123VO>();
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(getMember123List);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member123VO data = new Member123VO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));				
				datas.add(data);
			}
			System.out.println(datas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
				
		return datas;
	}
	public Member123VO getMember123(Member123VO vo) {
		System.out.println("dao로 getMember123");
				
		Member123VO data = null;
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(getMember123);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new Member123VO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		
		return data;
	}
}
