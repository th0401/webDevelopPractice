package model.bank1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bank2.Bank2VO;
import model.common.JNDI;

public class Bank1DAO {
	
	public ArrayList<Bank1VO> getBank1List() {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;
		ArrayList<Bank1VO> datas = new ArrayList<Bank1VO>();
		Bank1VO data = null;
		
		
		String sql="select * from bank1";
		
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				data = new Bank1VO();
				
				data.setB1num(rs.getInt("b1num"));
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
	
	public boolean trans(Bank1VO vo,Bank2VO v,int balance) {
		Connection conn=JNDI.connect();
		PreparedStatement pstmt=null;
		try {
			conn.setAutoCommit(false); // set autocommit=0;
			String sql1="update bank1 set balance=balance-? where b1num=?";
			String sql2="update bank2 set balance=balance+? where b2num=?";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, balance);
			pstmt.setInt(2, vo.getB1num());
			pstmt.executeUpdate(); 
			
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, balance);
			pstmt.setInt(2, v.getB2num());
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement("select balance from bank1 where b1num=?");
			pstmt.setInt(1, vo.getB1num());
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
