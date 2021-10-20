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
	
	public HandlerMapping() { // ������
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/signUp.do", new SignUpController());
		mappings.put("/main.do", new MainController());
	}

	// URL��û�� ���ڷ� �޾Ƽ�, Controller��ü�� ��ȯ
	public Controller getController(String path) {
		return mappings.get(path);
	}


	
}

