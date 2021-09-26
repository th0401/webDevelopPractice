package model.userInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.DBCP;
import model.userInfo.UserInfoVO;

public class UserInfoDAO {
	
	// ����Ͻ� �޼���
	private static String sql_SELECT_ALL = "SELECT * FROM userInfo";
	private static String sql_SELECT_ONE = "SELECT * FROM userInfo WHERE id=? AND pw=?";
	private static String sql_INSERT = "INSERT INTO userInfo VALUES(?, ?, ?)";
	private static String sql_DELETE = "DELETE FROM userInfo WHERE id=?";
	private static String sql_UPDATE = "UPDATE userInfo SET name=?, pw=? WHERE id=?";
	
	// ����� ���� �Լ� (���̵�/��й�ȣ ã��)
	private static String sql_FindID = "SELECT * FROM userInfo WHERE pw=? AND name=?";
	private static String sql_FindPW = "SELECT * FROM userInfo WHERE id=?";
	
	// SELECT ALL -> ��ü DB���� ����
	public ArrayList<UserInfoVO> SelectAll(){
		Connection conn = DBCP.connect();
		ArrayList<UserInfoVO> datas = new ArrayList();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				UserInfoVO vo = new UserInfoVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("UserDAO SelectAll()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}

	// SELECT ONE -> �α��� 
	public UserInfoVO SelectOne(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		UserInfoVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new UserInfoVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO SelectOne()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
	
	// INSERT -> ȸ������
	public boolean InsertDB(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("UserDAO InsertDB()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// DELETE -> ȸ�� Ż��
	public boolean DeleteDB(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_DELETE);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("UserDAO DeleteDB()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}

	// UPDATE -> Name, Pw ����
	public boolean UpdateDB(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getId());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("UserDAO UpdateDB()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// ���̵� ã��
	public UserInfoVO FindID(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		UserInfoVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_FindID);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new UserInfoVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO FindID()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
	
	// ��й�ȣ ã��
	public UserInfoVO FindPW(UserInfoVO vo) {
		Connection conn=DBCP.connect();
		UserInfoVO data=null;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_FindPW);
			pstmt.setString(1, vo.getId());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new UserInfoVO();
				data.setId(rs.getString("id"));
				data.setPw(rs.getString("pw"));
				data.setName(rs.getString("name"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("UserDAO FindPW()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
}
