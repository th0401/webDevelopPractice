package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test")
public class Test extends HttpServlet {
   private static final long serialVersionUID = 1L;
   // ��ü ����ȭ
   // �ڹٳ� Ŭ������ ���� ������ ���Ϸ� �����ϴ� ���
   // �ʿ��� �� �ٽ� ��üȭ�Ͽ� �޼���,����� �̿��Ҽ��ְԵ�
    // ������ �����Ҷ� �⺻�����ڴ� �ǵ������ʴ����̴�
   
    public Test() { // �⺻�����ڸ� �ݵ�� �ʿ����
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //response.getWriter().append("Served at: ").append(request.getContextPath());
   
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out=response.getWriter();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>���� ����</TITLE><HEAD>");
      out.println("<BODY><H1>���� �ǽ��̴�!~~</H1></BODY>");
      out.println("</HTML>");
      
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
      // Post������� ��û�ص�, Get���� ó���ϰڴ�~
   }

}