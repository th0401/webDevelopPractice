package model.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.common.JDBC;

public class PostDAO {
	
	public ArrayList<PostVO> getDBList(){
		Connection conn=JDBC.connect();
		ArrayList<PostVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from post order by pnum desc"; // 최근 게시글 상단 배치
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				PostVO vo=new PostVO();
				vo.setContent(rs.getString("content"));
				vo.setPnum(rs.getInt("pnum"));
				vo.setTitle(rs.getString("title"));
				vo.setPdate(rs.getDate("pdate"));
				vo.setUserID(rs.getString("userID"));
				
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("pGetDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		
		return datas;
	}
	
	public PostVO getDBData(PostVO vo){
		Connection conn=JDBC.connect();
		PostVO data=null;
		PreparedStatement pstmt=null;
		try{
			String sql="select * from post where pnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new PostVO();
				data.setContent(rs.getString("content"));
				data.setPnum(rs.getInt("pnum"));
				data.setTitle(rs.getString("title"));
				data.setPdate(rs.getDate("pdate"));
				data.setUserID(rs.getString("userID"));				
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("pGetDBData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}
	public boolean insertDB(PostVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="insert into post values((select nvl(max(pnum),0)+1 from post),?,?,sysdate,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getUserID());			
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("pInsertDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public boolean updateDB(PostVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update post set userID=?, title=?, content=?, pdate=sysdate where pnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("pUpdateDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public boolean deleteDB(PostVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from post where pnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("pDeleteDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
	public ArrayList<PostVO> getMyPost(PostVO vo){ //포스트VO의 객체가 vo니까 vo는 String int 다 되는거아니었나유... 
		
		Connection conn=JDBC.connect();
		ArrayList<PostVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from post where userID=? order by pnum desc"; // 최근 게시글 상단 배치
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				PostVO v=new PostVO();
				v.setContent(rs.getString("content"));
				v.setPnum(rs.getInt("pnum"));
				v.setTitle(rs.getString("title"));
				v.setPdate(rs.getDate("pdate"));
				v.setUserID(rs.getString("userID"));
				
				datas.add(v);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("pGetDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		
		return datas;
	}
	
	public ArrayList<PostVO> serchingList(String col, String word){
		Connection conn=JDBC.connect();
		ArrayList<PostVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			if(col.equals("title")) {
				String sql="select * from post where title like '%"+word+"%' order by pnum desc"; // 최근 게시글 상단 배치
				pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					PostVO vo=new PostVO();
					vo.setContent(rs.getString("content"));
					vo.setPnum(rs.getInt("pnum"));
					vo.setTitle(rs.getString("title"));
					vo.setPdate(rs.getDate("pdate"));
					vo.setUserID(rs.getString("userID"));
					
					datas.add(vo);
					}
				rs.close();
				} 
			else if(col.equals("userID")){
				String sql="select * from post where userID like '%"+word+"%' order by pnum desc"; // 최근 게시글 상단 배치
				pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					PostVO vo=new PostVO();
					vo.setContent(rs.getString("content"));
					vo.setPnum(rs.getInt("pnum"));
					vo.setTitle(rs.getString("title"));
					vo.setPdate(rs.getDate("pdate"));
					vo.setUserID(rs.getString("userID"));
					
					datas.add(vo);
					}
				rs.close();
				} 
			}						
		catch(Exception e){
			System.out.println("pGetDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		
		return datas;
	}
}
