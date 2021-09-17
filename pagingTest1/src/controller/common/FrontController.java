package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.DeleteMessage;
import controller.action.DeleteReply;
import controller.action.InsertMessage;
import controller.action.InsertReply;
import controller.action.LikeUp;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.SignUpAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 사용자의 요청을 분석
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
		
		ActionForward forward = null;
		// 2) 컨트롤러랑 매핑
		// 메인창
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		// 로그인
		else if(action.equals("/login.do")) {
			forward=new LoginAction().execute(request, response);
		}
		//로그아웃
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		// 회원가입
		else if(action.equals("/signUp.do")) {
			forward=new SignUpAction().execute(request, response);
		}
		// message추가
		else if(action.equals("/insertMDB.do")) {
			forward = new InsertMessage().execute(request, response);
		}
		// message삭제
		else if(action.equals("/deleteMDB.do")) {
			forward = new DeleteMessage().execute(request, response);
		}
		// reply추가
		else if(action.equals("/insertRDB.do")) {
			forward = new InsertReply().execute(request, response);
		}
		// reply삭제
		else if(action.equals("/deleteRDB.do")) {
			forward = new DeleteReply().execute(request, response);
		}
		// 좋아요누르는기능
		else if(action.equals("/likeup.do")) {
			forward = new LikeUp().execute(request, response);
		}
		
		else {
			// 에러페이지랑 연결	
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		if(forward != null) {
		// 3) 사용자에게 결과 화면 출력
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
