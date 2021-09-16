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
		String sql2 = "update mmessage set replycount=replycount+1 where meid=?";
		
		try {
			conn.setAutoCommit(false); //Ʈ����Ǳ�� - �ڵ�Ŀ�� falseó��
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMeid());
			pstmt.setString(2, vo.getUserID());
			pstmt.setString(3, vo.getRmsg());
			pstmt.executeUpdate();			
		
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, vo.getMeid());
			pstmt.executeUpdate();
			conn.commit(); // �ش� ���α��� ������ �ȳ����� Ŀ��ó��
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback(); // ���� ������ ���� �ѹ�!!
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
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
	public boolean delete(ReplyVO vo) throws SQLException {
		conn = JNDI.getConnection();
		String sql = "delete from reply where reid = ?";
		String sql3 = "update mmessage set replycount=replycount-1 where meid=?";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getReid());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, vo.getMeid());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
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
