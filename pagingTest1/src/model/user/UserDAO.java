package model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class UserDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean insert(UserVO vo) {
		conn = JNDI.getConnection();
		String sql = "insert into userInfo(userID,name,userPW,udate) values(?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getUserPW());
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
	public boolean login(UserVO vo) {
		conn = JNDI.getConnection();
		String sql = "select userID, userPW from userInfo where userID = ?";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getString("userPW").equals(vo.getUserPW()))
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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
		return result;
	}
	public ArrayList<UserVO> selectAll() {
		ArrayList<UserVO> datas = new ArrayList<UserVO>();
		conn = JNDI.getConnection();
		String sql = "select * from userInfo order by udate desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO data=new UserVO();
				data.setUdate(rs.getDate("udate"));
				data.setName(rs.getString("name"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserID(rs.getString("userID"));
				datas.add(data);
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
	public UserVO selectOne(UserVO vo) {
		UserVO data = null;
		conn = JNDI.getConnection();
		String sql = "select * from userInfo where userID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				data=new UserVO();
				data.setUdate(rs.getDate("udate"));
				data.setName(rs.getString("name"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserID(rs.getString("userID"));				
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
		return data;
	}
}
