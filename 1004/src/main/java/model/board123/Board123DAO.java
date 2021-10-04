package model.board123;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

// DAO -> 드라이버, CP, MyBatis, JPA, ...
// Service에서 DAO객체를 이용하여 CRUD 제공할 예정!
// 폰 (Service) <-> 시계(DAO)

@Repository("Board123DAO")
public class Board123DAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String insertSQL="insert into board123 (id,title,writer,content,wdate) VALUES((SELECT NVL(MAX(id),0) + 1 FROM board123), ?, ?, ?, sysdate)";
	private final String updateSQL="update board123 set content=? whrer id=?";
	
	private final String deleteSQL="delete from board123 where id=?";
	private final String getBoard123="select * from board123 where id=?";
	private final String getBoard123List="select * from board123 order by id desc";
	
	public void insertBoard123(Board123VO vo) {
		System.out.println("dao로 insert");				
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		
		
	}
	public void updateBoard123(Board123VO vo) {
		System.out.println("dao로 update");
		
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getId());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void deleteBoard123(Board123VO vo) {
		System.out.println("dao로 delete");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<Board123VO> getBoard123List(Board123VO vo) {
		System.out.println("dao로 getBoard123List");
		List<Board123VO> datas = new ArrayList<Board123VO>();
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(getBoard123List);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board123VO data = new Board123VO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWriter(rs.getString("writer"));
				data.setWdate(rs.getDate("wdate"));
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
	public Board123VO getBoard123(Board123VO vo) {
		System.out.println("dao로 getBoard123");
				
		Board123VO data = null;
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(getBoard123);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new Board123VO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWriter(rs.getString("writer"));
				data.setWdate(rs.getDate("wdate"));				
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
