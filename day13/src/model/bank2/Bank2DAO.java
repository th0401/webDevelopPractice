package model.bank2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bank1.Bank1VO;
import model.common.JNDI;

public class Bank2DAO {
	public ArrayList<Bank2VO> getBank2List() {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;
		ArrayList<Bank2VO> datas = new ArrayList<Bank2VO>();
		Bank2VO data = null;
		
		
		String sql="select * from bank2";
		
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				data = new Bank2VO();
				
				data.setB2num(rs.getInt("b2num"));
				data.setName(rs.getString("name"));
				data.setBalance(rs.getInt("balance"));
				datas.add(data);
			}
					}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public boolean trans(Bank2VO vo,Bank1VO v,int balance) {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;
		try {
			conn.setAutoCommit(false); // set autocommit=0;
			String sql1="update bank2 set balance=balance-? where b2num=?";
			String sql2="update bank1 set balance=balance+? where b1num=?";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, balance);
			pstmt.setInt(2, vo.getB2num());
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, balance);
			pstmt.setInt(2, v.getB1num());
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement("select balance from bank2 where b2num=?");
			pstmt.setInt(1, vo.getB2num());
			ResultSet rs=pstmt.executeQuery();	
									
			rs.next();
			if(rs.getInt(1)<0) { // 잔액이 0미만이면,
				conn.rollback();
				return false;
			}
			else {
				conn.commit(); // commit;
			}
			
			conn.setAutoCommit(true); // set autocommit=0;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
				
		return true;
	}
	
}
