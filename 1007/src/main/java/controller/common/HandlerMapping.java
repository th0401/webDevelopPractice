package controller.common;

import java.util.HashMap;
import java.util.Map;

import controller.action.GetBoardController;
import controller.action.InsertBoardController;
import controller.action.LoginController;
import controller.action.LogoutController;
import controller.action.MainController;
import controller.action.SignUpController;

public class HandlerMapping {
	private Map<String,Controller> mappings;
	
	public HandlerMapping() { // 생성자
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/signUp.do", new SignUpController());
		mappings.put("/main.do", new MainController());
	}

	// URL요청을 인자로 받아서, Controller객체를 반환
	public Controller getController(String path) {
		return mappings.get(path);
	}


	
}

