package model.board1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("board1DAO")
public class Board1DAO {
	
	private static String selectAll = "select * from board1 order by id desc";
	private static String insertSQL = "insert into board1 (id,title,writer,content) values((select nvl(max(id),0)+1 from board1),?,?,?)";
	
	private Connection conn=null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public List<Board1VO> getBoard1List(Board1VO vo){
		System.out.println("Board1 selectAll수행");		
		ArrayList<Board1VO> datas = new ArrayList<Board1VO>();
		Board1VO data = null;
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(selectAll);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				data = new Board1VO();
				data.setId(rs.getInt("id"));
				data.setTitle(rs.getString("title"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getDate("wdate"));
				datas.add(data);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("selectAll에서 오류발생");
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		
		return datas;
	}
	
	public void insertBoard1(Board1VO vo) {
		System.out.println("Board1 insert수행");
		try {
			conn = JDBC.getConnection();
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
}
