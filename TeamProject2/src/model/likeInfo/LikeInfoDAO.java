package model.likeInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.DBCP;
import model.likeInfo.LikeInfoVO;

public class LikeInfoDAO {
   
   // �⺻ CRUD
   private static String sql_SELECT_ALL = "SELECT * FROM likeInfo"; // ���� content, condition ������ ����
   private static String sql_SELECT_ONE = "SELECT * FROM likeInfo WHERE l_user=? AND l_post=?";
   private static String sql_INSERT = "INSERT INTO likeInfo (l_user, l_post) VALUES(?, ?)";
   private static String sql_DELETE = "DELETE FROM likeInfo WHERE l_user=? AND l_post=?";
   
   // private static String sql_UPDATE = "UPDATE likeInfo SET l_user=?, l_post=? WHERE l_post=?";
   // UPDATE �� �� �����Ű��Ƽ� �ϴ� ����
   
   // SELECT ALL -> ��ü ���ƿ� ���� ���� 
   public ArrayList<LikeInfoVO> SelectAll(){
      Connection conn = DBCP.connect();
      ArrayList<LikeInfoVO> datas = new ArrayList();
      PreparedStatement pstmt = null;

      try {
         pstmt = conn.prepareStatement(sql_SELECT_ALL);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
           LikeInfoVO vo = new LikeInfoVO();
            vo.setL_user(rs.getString("l_user"));
            vo.setL_post(rs.getInt("l_post"));
            datas.add(vo);
         }
         rs.close();
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      finally {
         DBCP.disconnect(pstmt, conn);
      }
      return datas;
   }

   // SELECT ONE -> boolean Ÿ��, ������ true �ƴϸ� false ��ȯ.
   public boolean SelectOne(LikeInfoVO vo) {
      Connection conn=DBCP.connect();
      PreparedStatement pstmt=null;
      boolean res = false;
      try{
         pstmt=conn.prepareStatement(sql_SELECT_ONE);
         pstmt.setString(1, vo.getL_user());
         pstmt.setInt(2, vo.getL_post());
         ResultSet rs=pstmt.executeQuery();
         if(rs.next()){
            res= true;
         }   
         rs.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return res;
   }
   
   // INSERT -> ���ƿ� ���� ����
   public boolean InsertDB(LikeInfoVO vo) {
      Connection conn=DBCP.connect();
      boolean res = false;
      PreparedStatement pstmt=null;
      try{
         pstmt=conn.prepareStatement(sql_INSERT);
         pstmt.setString(1, vo.getL_user());
         pstmt.setInt(2, vo.getL_post());
         pstmt.executeUpdate();
         res=true;
      }
      catch(Exception e){
         e.printStackTrace();
         //res=false;
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return res;
   }
   
   // DELETE -> ���ƿ� ���
   public boolean DeleteDB(LikeInfoVO vo) {
      Connection conn=DBCP.connect();
      boolean res=false;
      PreparedStatement pstmt=null;
      try{
         pstmt=conn.prepareStatement(sql_DELETE);
         pstmt.setString(1, vo.getL_user());
         pstmt.setInt(2, vo.getL_post());
         pstmt.executeUpdate();
         res=true;
      }
      catch(Exception e){
         e.printStackTrace();
         //res=false;
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return res;
   }
   
   /*
   // UPDATE -> ī�װ�, ����, ���� ����
   public boolean UpdateDB(LikeInfoVO vo) {
      Connection conn=DBCP.connect();
      boolean res=false;
      PreparedStatement pstmt=null;
      try{
         pstmt=conn.prepareStatement(sql_UPDATE);
         pstmt.setString(1, vo.getL_user());
         pstmt.setInt(2, vo.getL_post());
         pstmt.executeUpdate();
         res=true;
      }
      catch(Exception e){
         System.out.println("UpdateDB()���� ���");
         e.printStackTrace();
         //res=false;
      }
      finally {
         DBCP.disconnect(pstmt,conn);
      }
      return res;
   }
   */
   
}