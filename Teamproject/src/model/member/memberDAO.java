package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DAO;
import model.JDBC;

public class memberDAO{
   
   static String sql_INSERT="insert into member (mnum, id, pw) values((SELECT NVL(MAX(mnum),0)+1 FROM member),?,?)";
   static String sql_DELETE="delete from member where mnum=?";
   static String sql_UPDATE="update member set id=?, pw=? where mnum=?";
   static String sql_SELECT_ONE="select * from member where mnum=?";
   static String sql_SELECT_ALL="select * from member order by mnum asc";

   private Connection conn=null;
   private PreparedStatement pstmt=null;

   public void insert(memberVO vo) {
      
      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_INSERT);
         pstmt.setString(1, vo.getId());
         pstmt.setString(2, vo.getPw());
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }

      // System.out.println("insertMember 수행완료!");
   }

   public void delete(memberVO vo) {

      
      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_DELETE);
         pstmt.setInt(1, vo.getMnum());
         pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("deleteMember 수행완료");
   }

   public void update(memberVO vo) {

      
      conn=JDBC.getConnection();
      try {
         pstmt=conn.prepareStatement(sql_UPDATE);

         pstmt.setString(1, vo.getId());
         pstmt.setString(2, vo.getPw());
         pstmt.setInt(3, vo.getMnum());
         pstmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("updateMember 수행완료!");
   }
   
   public memberVO selectOne(memberVO vo) {
      
      conn=JDBC.getConnection();
      memberVO data=null;
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ONE);
         pstmt.setInt(1, vo.getMnum());
         ResultSet rs =pstmt.executeQuery();

         if(rs.next()) {
            data=new memberVO();
            data.setMnum(rs.getInt("mnum"));
            data.setId(rs.getString("id"));
            data.setPw(rs.getString("pw"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      // System.out.println("getMember 수행완료!");      
      return data;
   }
   
   public ArrayList<memberVO> selectList() {
      
      conn=JDBC.getConnection();
      ArrayList<memberVO> datas=new ArrayList();
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ALL);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            memberVO vo=new memberVO();
            vo.setMnum(rs.getInt("mnum"));
            vo.setId(rs.getString("id"));
            vo.setPw(rs.getString("pw"));
            datas.add(vo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      // System.out.println("getMemberList 수행완료!");
      return datas;
   }
   
}