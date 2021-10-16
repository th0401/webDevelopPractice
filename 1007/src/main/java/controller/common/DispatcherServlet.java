package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.GetBoardAction;
import controller.action.InsertBoardAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.SignUpAction;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request,response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) ������� ��û�� �м�
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
		
		ActionForward forward = null;
		// 2) ��Ʈ�ѷ��� ����
		// ����â
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		// �α���
		else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		}
		//�α׾ƿ�
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		// ȸ������
		else if(action.equals("/signUp.do")) {
			forward=new SignUpAction().execute(request, response);
		}
		// �� ���
		else if(action.equals("/insertBoard.do")) {
			forward=new InsertBoardAction().execute(request, response);
		}
		// �� ����
		else if(action.equals("/getBoard.do")) {
			forward=new GetBoardAction().execute(request, response);
		}
		else {
			// ������������ ����	
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		if(forward != null) {
		// 3) ����ڿ��� ��� ȭ�� ���
		if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		}
		else {
			RequestDispatcher dispatcher= request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}
		
	}

}
