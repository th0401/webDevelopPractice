package model.member1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import model.board1.Board1VO;
import model.common.JDBC;

@Repository("member1DAO")
public class Member1DAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String getMember1SQL="select * from member1 where id=? and password=?";
	private static String insertSQL = "insert into member1 (id,password,name,role) values(?,?,?,?)";
	public Member1VO getMember(Member1VO vo) {
		// �α��ο� �����Ѵٸ�, Member123VO ��ü�� ����(��ȯ)
		// �����Ѵٸ�, ������ null
		Member1VO data=null;
		
		System.out.println("Member1DAO�� get");

		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMember1SQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new Member1VO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setPassword(rs.getString("password"));
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
	public void insertMember1(Member1VO vo) {
		System.out.println("Member1DAO�� insert");
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
						
		} catch (SQLException e) {
			System.out.println("member1 insert���� ������");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
}
