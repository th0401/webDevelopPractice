package model.member123;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("member123DAO")
public class Member123DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String getMember123SQL="select * from member123 where id=? and pw=?";
	
	public Member123VO getBoard(Member123VO vo) {
		// �α��ο� �����Ѵٸ�, Member123VO ��ü�� ����(��ȯ)
		// �����Ѵٸ�, ������ null
		Member123VO data=null;
		
		System.out.println("Member123DAO�� get");

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
