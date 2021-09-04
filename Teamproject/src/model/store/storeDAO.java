package model.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;
import model.menu.menuVO;

public class storeDAO {

   static String sql_INSERT="insert into store (snum, sname, scall, mnum) values((SELECT NVL(MAX(snum), 0)+1 FROM store),?,?,?)";
   static String sql_DELETE="delete from store where snum=?";
   static String sql_UPDATE="update store set sname=?, scall=? where snum=?";
   static String sql_SELECT_ONE="select * from store where snum=?";
   static String sql_SELECT_ALL="select * from store order by snum asc";
   static String sql_StoreMember_List = "select * from store where mnum = ?";
   private Connection conn=null;
   private PreparedStatement pstmt=null;

   public void insert(storeVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_INSERT);
         pstmt.setString(1, vo.getSname());
         pstmt.setString(2, vo.getScall());
         pstmt.setInt(3, vo.getMnum());	// 로그인한 mnum을 가져와서 set mnun
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
   }

   public void delete(storeVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_DELETE);
         pstmt.setInt(1, vo.getSnum());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("deleteStore 수행완료");
   }

   public void update(storeVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_UPDATE);

         pstmt.setString(1, vo.getSname());
         pstmt.setString(2, vo.getScall());
         pstmt.setInt(3, vo.getSnum());
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }

      // System.out.println("updateStore 수행완료!");
   }


   public storeVO selectOne(storeVO vo) {

      conn=JDBC.getConnection();
      storeVO data=null;
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ONE);
         pstmt.setInt(1, vo.getSnum());
         ResultSet rs =pstmt.executeQuery();

         if(rs.next()) {
            data=new storeVO();
            data.setSnum(rs.getInt("snum"));
            data.setSname(rs.getString("sname"));
            data.setScall(rs.getString("scall"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      // System.out.println("getStore 수행완료!");      
      return data;

   }

   public ArrayList<storeVO> selectList() {

      conn=JDBC.getConnection();
      ArrayList<storeVO> datas=new ArrayList();
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ALL);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            storeVO vo=new storeVO();
            vo.setSnum(rs.getInt("snum"));
            vo.setSname(rs.getString("sname"));
            vo.setScall(rs.getString("scall"));
            datas.add(vo);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("getStoreList 수행완료!");
      return datas;
   }

   public ArrayList<storeVO> StoreMember_List(storeVO vo) {

      conn=JDBC.getConnection();
      ArrayList<storeVO> datas=new ArrayList();

      try {
         pstmt=conn.prepareStatement(sql_StoreMember_List);
         pstmt.setInt(1, vo.getMnum());
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {

            storeVO data=new storeVO();
            data.setSnum(rs.getInt("snum"));
            data.setSname(rs.getString("sname"));
            data.setMnum(rs.getInt("mnum"));
            data.setScall(rs.getString("scall"));
            datas.add(data);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("StoreMember_List 수행완료!");
      return datas;
   }


}