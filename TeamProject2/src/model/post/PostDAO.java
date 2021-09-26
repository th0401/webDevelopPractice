package model.post;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.common.DBCP;

public class PostDAO {
	
	// �⺻ CRUD
	private static String sql_SELECT_ALL = "SELECT * FROM post ORDER BY pnum DESC";
	private static String sql_SELECT_ONE = "SELECT * FROM post WHERE pnum=?";
	private static String sql_INSERT = 
			"INSERT INTO post (pnum, category, title, content, writer, p_user, path)"
			+ " VALUES((SELECT NVL(MAX(pnum),0) + 1 FROM post), ?, ?, ?, ?, ?, ?)";
	private static String sql_DELETE = "DELETE FROM post WHERE pnum=?";
	private static String sql_UPDATE = "UPDATE post SET category=?, title=?, content=?, writer=?, path=?, pdate=sysdate WHERE pnum=?";
	
	// ����� ���� �Լ�
	// ��ȸ�� ��, ���ƿ� �� �ٿ�
	private static String sql_ViewsUp = "UPDATE post SET views=views+1 WHERE pnum=?";
	private static String sql_LikesUp = "UPDATE post SET plike=plike+1 WHERE pnum=?";
	private static String sql_LikesDown = "UPDATE post SET plike=plike-1 WHERE pnum=?";
	// �˻�
	private static String sql_SearchPostTitle = "SELECT * from post WHERE title like %?%";
	private static String sql_SearchPostWriter = "SELECT * from post WHERE writer like %?%";
	private static String sql_SearchPostContent = "SELECT * from post WHERE content like %?%";
	// ������ ����
	private static String sql_SELECT_CATEGORY = "SELECT * FROM post WHERE category=?";
	private static String sql_SELECT_VIEWS = "SELECT * FROM post ORDER BY views DESC";
	
	// SELECT ALL -> ��ü �� ���� ����
	public ArrayList<PostVO> SelectAll(){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				vo.setPath(rs.getString("path"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SelectAll()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}

	// SELECT ONE -> �� ����
	public PostVO SelectOne(PostVO vo) {
	      Connection conn=DBCP.connect();
	      PostVO data=null;
	      PreparedStatement pstmt=null;
	      SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
	      Date dateOrigin;
	      String dateToStr;
	      try{
	         conn.setAutoCommit(false);
	         
	         //�ۺ���
	         pstmt=conn.prepareStatement(sql_SELECT_ONE);
	         pstmt.setInt(1, vo.getPnum());
	         ResultSet rs=pstmt.executeQuery();
	         if(rs.next()){
	            data=new PostVO();
	            data.setPnum(rs.getInt("pnum"));
	            data.setViews(rs.getInt("views"));
	            data.setPlike(rs.getInt("plike"));
	            data.setCategory(rs.getString("category"));
	            data.setTitle(rs.getString("title"));
	            data.setContent(rs.getString("content"));
	            data.setWriter(rs.getString("writer"));
	            dateOrigin = rs.getDate("pdate");
	            dateToStr = dateFix.format(dateOrigin);
	            data.setPdate(dateToStr);
	            data.setP_user(rs.getString("p_user"));
	            data.setPath(rs.getString("path"));
	         }   
	         rs.close();
	         
	         //��ȸ�� ��
	         pstmt=conn.prepareStatement(sql_ViewsUp); //
	         pstmt.setInt(1, vo.getPnum());
	         pstmt.executeUpdate();
	         
	         conn.commit(); // commit;
	         
	      }
	      catch(Exception e){
	         System.out.println("PostDAO SelectOne()���� ���");
	         e.printStackTrace();
	         try {
	            conn.rollback();
	         } catch (SQLException e1) {
	            e1.printStackTrace();
	         }
	      }
	      finally {
	         DBCP.disconnect(pstmt,conn);
	      }
	      return data;
	   }
	
	// INSERT -> pnum, pdate, views, plike�� �ڵ��Է�
	public boolean InsertDB(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			pstmt.setString(5, vo.getP_user());
			pstmt.setString(6, vo.getPath());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO InsertDB()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// DELETE -> ����Ʈ ����
	public boolean DeleteDB(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO DeleteDB()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}

	// UPDATE -> ī�װ�, ����, ���� ����
	public boolean UpdateDB(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			pstmt.setString(5,  vo.getPath());
			pstmt.setInt(6, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO UpdateDB()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// ��ȸ�� ++
	public boolean ViewsUp(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_ViewsUp);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO ViewsUp()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// ���ƿ� ++
	public boolean LikesUp(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_LikesUp);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO LikesUp()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	// ���ƿ� --
	public boolean LikesDown(PostVO vo) {
		
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_LikesDown);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO LikesDown()���� ���");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// �˻����
	public ArrayList<PostVO> SearchPostTitle(String text){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SearchPostTitle);
			pstmt.setString(1, text);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SearchPostTitle()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public ArrayList<PostVO> SearchPostWriter(String text){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SearchPostWriter);
			pstmt.setString(1, text);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SearchPostWriter()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public ArrayList<PostVO> SearchPostContent(String text){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SearchPostContent);
			pstmt.setString(1, text);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SearchPostContent()���� ���");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	// SELECT Category -> ī�װ� �� �� ���� ����
    public ArrayList<PostVO> SelectCategory(PostVO vo){
       Connection conn = DBCP.connect();
       ArrayList<PostVO> datas = new ArrayList();
       PreparedStatement pstmt = null;
       SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
       Date dateOrigin;
       String dateToStr;
       try {
          pstmt = conn.prepareStatement(sql_SELECT_CATEGORY);
          pstmt.setString(1, vo.getCategory());
          ResultSet rs = pstmt.executeQuery();
          while(rs.next()) {
             PostVO data = new PostVO();
             data.setPnum(rs.getInt("pnum"));
             data.setViews(rs.getInt("views"));
             data.setPlike(rs.getInt("plike"));
             data.setCategory(rs.getString("category"));
             data.setTitle(rs.getString("title"));
             data.setContent(rs.getString("content"));
             dateOrigin = rs.getDate("pdate");
             dateToStr = dateFix.format(dateOrigin);
             data.setPdate(dateToStr);
             data.setP_user(rs.getString("p_user"));
             datas.add(data);
          }
          rs.close();
       }
       catch(Exception e) {
          System.out.println("PostDAO SelectCategory()���� ���");
          e.printStackTrace();
       }
       finally {
          DBCP.disconnect(pstmt, conn);
       }
       return datas;
    }
    
    // SELECT VIEWS -> ��ü �� ���� ��ȸ�� ���� �ؼ� ��ȯ
    public ArrayList<PostVO> SelectViews(){
       Connection conn = DBCP.connect();
       ArrayList<PostVO> datas = new ArrayList();
       PreparedStatement pstmt = null;
       SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
       Date dateOrigin;
       String dateToStr;
       try {
          pstmt = conn.prepareStatement(sql_SELECT_VIEWS);
          ResultSet rs = pstmt.executeQuery();
          while(rs.next()) {
             PostVO vo = new PostVO();
             vo.setPnum(rs.getInt("pnum"));
             vo.setViews(rs.getInt("views"));
             vo.setPlike(rs.getInt("plike"));
             vo.setCategory(rs.getString("category"));
             vo.setTitle(rs.getString("title"));
             vo.setContent(rs.getString("content"));
             dateOrigin = rs.getDate("pdate");
             dateToStr = dateFix.format(dateOrigin);
             vo.setPdate(dateToStr);
             vo.setP_user(rs.getString("p_user"));
             datas.add(vo);
          }
          rs.close();
       }
       catch(Exception e) {
          System.out.println("PostDAO SelectViews()���� ���");
          e.printStackTrace();
       }
       finally {
          DBCP.disconnect(pstmt, conn);
       }
       return datas;
    }
	
}
