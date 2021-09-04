package model.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;

public class menuDAO {

   static String sql_INSERT="insert into menu (menunum, snum, menuname, price, menucnt) values((SELECT NVL(MAX(menunum),0)+1 FROM menu),?,?,?,?)";
   static String sql_DELETE="delete from menu where menunum=?";
   static String sql_UPDATE="update menu set snum=?, menuname=?, price=?, menucnt=? where menunum=?";
   static String sql_SELECT_ONE="select * from menu where menunum=?";
   static String sql_SELECT_ALL="select * from menu order by menunum asc";
   static String sql_StoreMenu_List="select * from menu where snum=?";

   private Connection conn=null;
   private PreparedStatement pstmt=null;

   public void insert(menuVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_INSERT);
         pstmt.setInt(1, vo.getSnum());
         pstmt.setString(2, vo.getMenuname());
         pstmt.setInt(3, vo.getPrice());
         pstmt.setInt(4, vo.getMenucnt());
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }

      // System.out.println("insertMenu 수행완료!");
   }

   public void delete(menuVO vo) {

      conn=JDBC.getConnection();
      
      try {
         pstmt=conn.prepareStatement(sql_DELETE);
         pstmt.setInt(1, vo.getMenunum());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("deleteMenu 수행완료");
   }
   
   // menunum에 해당하는 메뉴를 업데이트 -> sname은 건들지않음.
   public void update(menuVO vo) {

      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_UPDATE);
         pstmt.setInt(1, vo.getSnum());
         pstmt.setString(2, vo.getMenuname());
         pstmt.setInt(3, vo.getPrice());
         pstmt.setInt(4, vo.getMenucnt());
         pstmt.setInt(5, vo.getMenunum());
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }

      // System.out.println("updateMenu 수행완료!");
   }


   public menuVO selectOne(menuVO vo) {

      conn=JDBC.getConnection();
      menuVO data=null;
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ONE);
         pstmt.setInt(1, vo.getMenunum());
         ResultSet rs =pstmt.executeQuery();

         if(rs.next()) {
            data=new menuVO();
            data.setSnum(rs.getInt("snum"));
            data.setMenunum(rs.getInt("menunum"));
            data.setMenuname(rs.getString("menuname"));
            data.setPrice(rs.getInt("price"));
            data.setMenucnt(rs.getInt("menucnt"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      // System.out.println("getMenu 수행완료!");      
      return data;

   }

   public ArrayList<menuVO> selectList() {

      conn=JDBC.getConnection();
      ArrayList<menuVO> datas=new ArrayList();
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ALL);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            menuVO vo=new menuVO(); 
            vo.setSnum(rs.getInt("snum"));
            vo.setMenunum(rs.getInt("menunum"));
            vo.setMenuname(rs.getString("menuname"));
            vo.setPrice(rs.getInt("price"));
            vo.setMenucnt(rs.getInt("menucnt"));
            datas.add(vo);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("getMenuList 수행완료!");
      return datas;
   }
   
   public ArrayList<menuVO> StoreMenu_List(menuVO vo) {

      conn=JDBC.getConnection();
      ArrayList<menuVO> datas=new ArrayList();
      
      try {
         pstmt=conn.prepareStatement(sql_StoreMenu_List);
         pstmt.setInt(1, vo.getSnum());
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            
            menuVO data=new menuVO();
            data.setSnum(rs.getInt("snum"));
            data.setMenunum(rs.getInt("menunum"));
            data.setMenuname(rs.getString("menuname"));
            data.setPrice(rs.getInt("price"));
            data.setMenucnt(rs.getInt("menucnt"));
            datas.add(data);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("StoreMenu_List 수행완료!");
      return datas;
   }





}