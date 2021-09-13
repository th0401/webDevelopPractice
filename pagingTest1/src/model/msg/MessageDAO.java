package model.msg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class MessageDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<MsgSet> selectAll(String userID,int cnt) {
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();
		conn = JNDI.getConnection();
		String sql;
		try {
			// 전체
			if((userID == null) || (userID.equals(""))) {
				sql = "select * from mmessage where rownum <= ? order by udate";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cnt);
			}
			// 특정 회원
			else{
				sql = "select * from mmessage where userID=? rownum <= ? order by udate";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,userID);
				pstmt.setInt(2,cnt);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MsgSet ms = new MsgSet();
				MessageVO m = new MessageVO();
				ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();
				
				m.setMeid(rs.getInt("meid"));
				m.setMsg(rs.getString("msg"));
				m.setFavcount(rs.getInt("favcount"));
				m.setUserID(rs.getString("userID"));
				m.setUdate(rs.getDate("udate"));
				
				String rsql = "select * from reply where meid=? order by udate desc";
				pstmt = conn.prepareStatement(rsql);
				pstmt.setInt(1,rs.getInt("meid"));
				ResultSet rrs = pstmt.executeQuery();
				int rcnt=0;
				while(rrs.next()) {
					ReplyVO r = new ReplyVO();
					r.setUdate(rrs.getDate("udate"));
					r.setMeid(rrs.getInt("meid"));
					r.setReid(rrs.getInt("reid"));
					r.setRmsg(rrs.getString("rmsg"));
					r.setUserID(rrs.getString("userID"));
					rlist.add(r);
					rcnt++;
				}
				m.setReplycount(rcnt);
				
				ms.setM(m);
				ms.setRlist(rlist);
				datas.add(ms);
				rrs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return datas;
	}
	public boolean insert(MessageVO vo) {
		conn = JNDI.getConnection();
		String sql = "insert into mmessage(meid,userID, msg, udate) values((select nvl(max(meid),0)+1 from mmessage),?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMsg());
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
	public boolean delete(MessageVO vo) {
		conn = JNDI.getConnection();
		String sql = "delete from mmessage where meid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMeid());
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
	public void update(MessageVO vo) {
		conn = JNDI.getConnection();
		String sql = "update mmessage set favcount=favcount+1 where meid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMeid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
