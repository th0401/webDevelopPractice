package model.board;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC;
public class BoardDAO {

	public ArrayList<BoardVO> getDBList(){
		Connection conn=JDBC.connect();
		ArrayList<BoardVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from board order by bnum desc"; // 최근 게시글 상단 배치
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				BoardVO vo=new BoardVO();
				vo.setContent(rs.getString("content"));
				vo.setBnum(rs.getInt("bnum"));
				vo.setTitle(rs.getString("title"));
				vo.setBdate(rs.getDate("bdate"));
				vo.setWriter(rs.getString("writer"));
				vo.setBmem(rs.getInt("bmem"));
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

	public BoardVO getDBData(BoardVO vo){
		Connection conn=JDBC.connect();
		BoardVO data=null;
		PreparedStatement pstmt=null;
		try{
			String sql="select * from board where bnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBnum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new BoardVO();
				data.setContent(rs.getString("content"));
				data.setBnum(rs.getInt("bnum"));
				data.setTitle(rs.getString("title"));
				data.setBdate(rs.getDate("bdate"));
				data.setWriter(rs.getString("writer"));
				data.setBmem(rs.getInt("bmem"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}

	public boolean insertDB(BoardVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="insert into board values((select nvl(max(bnum),0)+1 from board),?,?,?,sysdate,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getBmem());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	public boolean deleteDB(BoardVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="delete from board where bnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("deleteDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	public boolean updateDB(BoardVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update board set writer=?, title=?, content=?, bdate=sysdate where bnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getBnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}
	
}
