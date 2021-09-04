package model.gift;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;

public class giftDAO {

   // ������ ��Ʈ�ѷ��κп��� �����ؼ� �־��ִ� ���� �����Ͱ��Ƽ� nvl ó�� ���� �ʰڽ��ϴ�!
   
   static String sql_INSERT="insert into gift values(?,?,?)";
   static String sql_DELETE="delete from gift where gnum=?";
   static String sql_UPDATE="update gift set gprice=? where gnum=?";
   static String sql_SELECT_ONE="select * from gift where gnum=?";
   static String sql_SELECT_ALL="select * from gift order by gnum asc";
   static String sql_SELECT_MEMBER = "select * from gift where mnum=?";

   private Connection conn=null;
   private PreparedStatement pstmt=null;

   public void insert(giftVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_INSERT);
         pstmt.setInt(1, vo.getMnum());
         pstmt.setString(2, vo.getGnum());
         pstmt.setInt(3, vo.getGprice());
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }

      // System.out.println("insertGift ����Ϸ�!");
   }
   
   public void delete(giftVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_DELETE);
         pstmt.setString(1, vo.getGnum());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("deleteGift ����Ϸ�");
   }
   
   // ������ȣ�� �ݾ��� �޾Ƽ� ������ �ܾ��� ����
   public void update(giftVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_UPDATE);

         pstmt.setInt(1, vo.getGprice());
         pstmt.setString(2, vo.getGnum());
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }

      // System.out.println("updateGift ����Ϸ�!");
   }


   public giftVO selectOne(giftVO vo) {

      conn=JDBC.getConnection();
      giftVO data=null;
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ONE);
         pstmt.setString(1, vo.getGnum());
         ResultSet rs =pstmt.executeQuery();

         if(rs.next()) {
            data=new giftVO();
            data.setMnum(rs.getInt("mnum"));
            data.setGnum(rs.getString("gnum"));
            data.setGprice(rs.getInt("gprice"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      // System.out.println("getGift ����Ϸ�!");      
      return data;

   }

   public ArrayList<giftVO> selectList() {

      conn=JDBC.getConnection();
      ArrayList<giftVO> datas=new ArrayList();
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ALL);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            giftVO vo=new giftVO(); 
            vo.setMnum(rs.getInt("mnum"));
            vo.setGnum(rs.getString("gnum"));
            vo.setGprice(rs.getInt("gprice"));
            datas.add(vo);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("getGiftList ����Ϸ�!");
      return datas;
   }
   // *** �߰��� �Լ� , �Է¹��� vo��ü�� mnum�� �̿��ؼ� mnum�� �ش��ϴ� ����� ������ ������ִ� �Լ�(���ϰ��� ArrayList)!
   public ArrayList<giftVO> MemberGiftList(giftVO vo){
      
      conn=JDBC.getConnection();
      ArrayList<giftVO> datas = new ArrayList();
      
      try {
            pstmt=conn.prepareStatement(sql_SELECT_MEMBER);
            pstmt.setInt(1, vo.getMnum());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
               giftVO data=new giftVO(); 
               data.setMnum(rs.getInt("mnum"));
               data.setGnum(rs.getString("gnum"));
               data.setGprice(rs.getInt("gprice"));
               datas.add(data);
            }

         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            JDBC.close(conn, pstmt);
         }
         // System.out.println("MemberGiftList ����Ϸ�!");
         return datas;
       }





}