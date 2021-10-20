package controller.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
    
	public void init() {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
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
		// 1) 사용자의 요청을 분석
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String action = uri.substring(cp.length());
		
		//ActionForward forward = null;
		// => 이제 HM에게 action 값을 전달, Controller객체를 반환받는다!
		// -> lookup(검색, 탐색) == 객체를 찾는 행위		
		Controller controller = handlerMapping.getController(action);
		
		// 클라이언트의 요청을 실질적으로 수행하는 controller객체!
		//그 결과로 "경로"를 리턴!
		String view = controller.execute(request, response);
		
		if(!view.contains(".do")) {
			view = viewResolver.getView(view);
		}
		
		
		response.sendRedirect(view);
		
		
		
		
		
		/*
		// 2) 컨트롤러랑 매핑
		// 메인창
		if(action.equals("/main.do")) {
			forward=new MainAction().execute(request, response);
		}
		// 로그인
		else if(action.equals("/login.do")) {
			forward=new LoginController().execute(request, response);
		}
		//로그아웃
		else if(action.equals("/logout.do")) {
			forward=new LogoutAction().execute(request, response);
		}
		// 회원가입
		else if(action.equals("/signUp.do")) {
			forward=new SignUpAction().execute(request, response);
		}
		// 글 등록
		else if(action.equals("/insertBoard.do")) {
			forward=new InsertBoardAction().execute(request, response);
		}
		// 글 보기
		else if(action.equals("/getBoard.do")) {
			forward=new GetBoardAction().execute(request, response);
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
	}*/
		
	}

}
