package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.board.BoardVO;
import model.common.JDBC;

public class MemberDAO {
	public boolean getDBData(MemberVO vo){
		Connection conn=JDBC.connect();
		ArrayList<MemberVO> datas = new ArrayList();
		MemberVO data=null;
		PreparedStatement pstmt=null;
		boolean res=false;
		try{
			String sql="select * from bmember";
						
			pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				data=new MemberVO();
				data.setBmem(rs.getInt("bmem"));
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
				datas.add(data);
			}
			for(int i = 0; i<datas.size();i++) {
				if(datas.get(i).getUserID().equals(vo.getUserID())&&datas.get(i).getUserPW().equals(vo.getUserPW())) {
					 res=true;
				}				
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBDataMember()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	public MemberVO selectOne(MemberVO vo) {
		Connection conn=JDBC.connect();
		PreparedStatement pstmt=null;
		MemberVO data=null;
		try{
			String sql="select * from bmember where userID=? and userPW=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new MemberVO();
				data.setBmem(rs.getInt("bmem"));
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setUserName(rs.getString("userName"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("MemberDAO selectOne()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}
	

	public boolean insertMember(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="insert into bmember values((select nvl(max(bnum),0)+1 from board),?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getUserName());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertMemberDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	public boolean deleteMember(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from bmember where bmem=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBmem());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteMemberDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	public boolean updateMember(MemberVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update bmember set userPW=?, userName=? where bmem=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getUserName());
			
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateMemberDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	public ArrayList<BoardVO> showMyPage(){
		Connection conn=JDBC.connect();
		ArrayList<BoardVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from board where userName=? order by postnum desc"; // 최근 게시글 상단 배치
			
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				BoardVO vo=new BoardVO();
				vo.setContent(rs.getString("content"));
				vo.setBnum(rs.getInt("bnum"));
				vo.setTitle(rs.getString("title"));
				vo.setBdate(rs.getDate("bdate"));
				vo.setWriter(rs.getString("writer"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		
		return datas;
	}
}
