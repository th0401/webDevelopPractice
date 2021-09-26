package model.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.comments.CommentsVO;
import model.common.DBCP;

public class CommentsDAO {
   
   // �⺻ CRUD
   private static String sql_SELECT_ALL = "SELECT * FROM comments";
   private static String sql_SELECT_ONE = "SELECT * FROM comments WHERE cnum=?";
   private static String sql_INSERT = "INSERT INTO comments (cnum, cment, cdate, c_user, c_post) VALUES((SELECT NVL(MAX(cnum),0) + 1 FROM comments), ?, sysdate, ?, ?)";
   private static String sql_DELETE = "DELETE FROM comments WHERE cnum=?";
   private static String sql_UPDATE = "UPDATE comments SET cment=?, cdate=sysdate WHERE cnum=?";
   
   // ����� ���� �Լ�
   private static String sql_SELECT_POST = "SELECT * FROM comments WHERE c_post=?"; // c_post�� �޾Ƽ� �� ���� ��۵��� ����
   
   // SELECT ALL -> ��ü DB���� ����
   public ArrayList<CommentsVO> SelectAll(){
      Connection conn = DBCP.connect();
      ArrayList<CommentsVO> datas = new ArrayList();
      PreparedStatement pstmt = null;

      try {
         pstmt = conn.prepareStatement(sql_SELECT_ALL);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            CommentsVO vo = new CommentsVO();
            vo.setCnum(rs.getInt("cnum"));
            vo.setCment(rs.getString("cment"));
            vo.setCdate(rs.getDate("cdate"));
            vo.setC_user(rs.getString("c_user"));
            vo.setC_post(rs.getInt("c_post"));
            datas.add(vo);
         }
         rs.close();
      }
      catch(Exception e) {
         System.out.println("CommentsDAO SelectAll()���� ���");
         e.printStackTrace();
      }
      finally {
         DBCP.disconnect(pstmt, conn);
      }
      return datas;
   }

   // SELECT ONE -> �α��� 
   public CommentsVO SelectOne(CommentsVO vo) {
      Connection conn=DBCP.connect();
      CommentsVO data=null;
      PreparedStatement pstmt=null;
      try{
         pstmt=conn.prepareStatement(sql_SELECT_ONE);
         pstmt.setInt(1, vo.getCnum());
         ResultSet rs=pstmt.executeQuery();
         if(rs.next()){
            data=new CommentsVO();
            data.setCnum(rs.getInt("cnum"));
            data.setCment(rs.getString("cment"));
            data.setCdate(rs.getDate("cdate"));
            data.setC_user(rs.getString("c_user"));
            data.setC_post(rs.getInt("c_post"));
         }   
         rs.close();
      }
      catch(Exception e){
         System.out.println("CommentsDAO SelectOne()���� ���");
         e.printStackTrace();
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return data;
   }
   
   // INSERT -> ��� DB ���
   public boolean InsertDB(CommentsVO vo) {
      Connection conn=DBCP.connect();
      boolean res = false;
      PreparedStatement pstmt=null;
      try{
         pstmt=conn.prepareStatement(sql_INSERT);
         pstmt.setString(1, vo.getCment());
         pstmt.setString(2, vo.getC_user());
         pstmt.setInt(3, vo.getC_post());
         pstmt.executeUpdate();
         res=true;
      }
      catch(Exception e){
         System.out.println("CommentsDAO InsertDB()���� ���");
         e.printStackTrace();
         //res=false;
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return res;
   }
   
   // DELETE -> ��� ����
   public boolean DeleteDB(CommentsVO vo) {
      Connection conn=DBCP.connect();
      boolean res=false;
      PreparedStatement pstmt=null;
      try{
         pstmt=conn.prepareStatement(sql_DELETE);
         pstmt.setInt(1, vo.getCnum());
         pstmt.executeUpdate();
         res=true;
      }
      catch(Exception e){
         System.out.println("CommentsDAO DeleteDB()���� ���");
         e.printStackTrace();
         //res=false;
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return res;
   }

   // UPDATE -> ��� cment ����
   public boolean UpdateDB(CommentsVO vo) {
      Connection conn=DBCP.connect();
      boolean res=false;
      PreparedStatement pstmt=null;
      try{
         pstmt=conn.prepareStatement(sql_UPDATE);
         pstmt.setString(1, vo.getCment());
         pstmt.setInt(2, vo.getCnum()); // 9/25 ����(�̿���)
         pstmt.executeUpdate();
         res=true;
      }
      catch(Exception e){
         System.out.println("CommentsDAO UpdateDB()���� ���");
         e.printStackTrace();
         //res=false;
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return res;
   }
   
   // �Է� vo �ȿ��� c_post�� �����ϸ� �˴ϴ�. ������ �� �ۿ� �޸� ��۵鸸 �̾��ݴϴ�. 
   public ArrayList<CommentsVO> SelectPost(CommentsVO vo){
      Connection conn = DBCP.connect();
      ArrayList<CommentsVO> datas = new ArrayList();
      PreparedStatement pstmt = null;

      try {
         pstmt = conn.prepareStatement(sql_SELECT_POST);
         pstmt.setInt(1,vo.getC_post());
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            CommentsVO data = new CommentsVO();
            data.setCnum(rs.getInt("cnum"));
            data.setCment(rs.getString("cment"));
            data.setCdate(rs.getDate("cdate"));
            data.setC_user(rs.getString("c_user"));
            data.setC_post(rs.getInt("c_post"));
            datas.add(data); // 9/25 ����(�̿���)
         }
         rs.close();
      }
      catch(Exception e) {
         System.out.println("CommentsDAO SelectPost()���� ���");
         e.printStackTrace();
      }
      finally {
         DBCP.disconnect(pstmt, conn);
      }
      return datas;
   }
}