package model.board123;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

//DAO-> 드라이버, CP, MyBatis, JPA, ...
//Service에서 DAO객체를 이용하여 CRUD기능을 제공할 예정!
//폰Service <-> 시계DAO
@Repository("board123DAO")
public class Board123DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private final String insertSQL="insert into board123 (id,title,writer,content) values((select nvl(max(id),0)+1 from board123),?,?,?)";
	private final String updateSQL="update board123 set title=?,content=? where id=?";
	private final String deleteSQL="delete board123 where id=?";
	private final String getBoardSQL="select * from board123 where id=?";
	private final String getBoardListSQL="select * from board123 order by id desc";

	public void insertBoard(Board123VO vo) {
		System.out.println("dao로 insertBoard");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void updateBoard(Board123VO vo) {
		System.out.println("dao로 updateBoard");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public void deleteBoard(Board123VO vo) {
		System.out.println("dao로 deleteBoard");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	public List<Board123VO> getBoardList(Board123VO vo) {
		System.out.println("dao로 getList");
		List<Board123VO> datas=new ArrayList<Board123VO>();
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getBoardListSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board123VO data=new Board123VO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt,rs);
		}
		return datas;
	}
	public Board123VO getBoard(Board123VO vo) {
		System.out.println("dao로 get");
		Board123VO data=null;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getBoardSQL);
			pstmt.setInt(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new Board123VO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
}
