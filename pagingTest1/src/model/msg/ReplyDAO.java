package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.common.JNDI;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	public boolean insert(ReplyVO vo) {
		conn = JNDI.getConnection();
		String sql = "insert into reply(reid,meid,userID,rmsg,udate) values((select nvl(max(reid),0)+1 from reply),?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMeid());
			pstmt.setString(2, vo.getUserID());
			pstmt.setString(3, vo.getRmsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean delete(ReplyVO vo) {
		conn = JNDI.getConnection();
		String sql = "delete from reply where reid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getReid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	
	}
}
