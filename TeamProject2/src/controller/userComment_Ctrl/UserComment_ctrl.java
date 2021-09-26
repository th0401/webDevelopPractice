package controller.userComment_Ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;

/**
 * Servlet implementation class UserComment_ctrl
 */
@WebServlet("/UserComment_ctrl")
public class UserComment_ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserComment_ctrl() {
		super();
	}

	// [�θ�޼���] - get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	// [�θ�޼���] - post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}


	// [�������� �޼���]
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// [����� ��û ����]
		String uri=request.getRequestURI();
		String cp=request.getContextPath();
		String action=uri.substring(cp.length()+1); // +1 ==  "/"���� sub�ϱ� ����
		System.out.println("----------------------------------------------------");
		System.out.println("UCC : "+action);
		// [��û ����]
		ActionForward forward = null;

		////////////////////////////////////comments���� ////////////////////////////////////

		// [����ī�װ� ���] showList
		if(action.equals("post.ucdo")) {
			forward = new Post_Action().execute(request, response);
		}
		// [����������] post_ctrl -> main
		else if(action.equals("main.ucdo")) {
			forward = new Main_Action().execute(request, response);
		}


		////////////////////////////////////userInfo////////////////////////////////////

		// [ȸ������] --- view���� �� param (id,pw) �޾ƾ� �� 
		else if(action.equals("signUp.ucdo")) {
			new U_SignUp_Action().execute(request, response);
			return; //���� ���� �̵������� �����Ƿ� ����
		}
		// [�α���] �α��ν� session���� �� userInfoData
		else if(action.equals("joinUs.ucdo")) {
			forward = new U_JoinUs_Action().execute(request, response);

		}
		// [�α׾ƿ�] session����
		else if(action.equals("logOut.ucdo")) {
			forward = new U_logOut_Action().execute(request, response);

		}
		//[ID/PWã��] ID=pw+name , PW=id
		// VIEW parameter �޾ƾ��� �� 
		//     type �� "id" �Ǵ� "pw"
		//     id = "pw" + "name"    ||   pw = "id"
		else if(action.equals("infoHelp.ucdo")) {
			forward = new U_InfoHelp_Action().execute(request, response);
		}

		// ps) ���������� --- login�� session�� setAttribute�صδ� 
		//             �ﰢ������ �ҷ��� ����Ͻø� �˴ϴ�.
		//   ��ver2 ������ UserSetClass �����Ͽ� ��ü ������ ����!


		//[���������� �� ��������] --- view���� �� param (id,pw,name) ��� �޾ƾ� ��
		else if(action.equals("updateUser.ucdo")) {
			forward = new U_UpdateUser_Action().execute(request, response);

		}
		//[���������� �� ȸ��Ż��] session �ʱ�ȭ
		else if (action.equals("deleteUser.ucdo")) {
			forward = new U_DeleteUser_Action().execute(request, response);

		}


		/////////////////////////////////////comment/////////////////////////////////////

		// [��� �б� R]
		// [���� �Խù�---showOne] ���� (�Խù�+���ƿ�+���) 
		else if (action.equals("selectOne.ucdo")) {
			forward = new C_SelectOne_Action().execute(request, response);
		}
		// [���  ���� C]
		else if (action.equals("insertComment.ucdo")) {
			forward = new C_InsertComment_Action().execute(request, response);

		}
		//[���  ���� U]
		else if (action.equals("editComment.ucdo")) {
			forward = new C_EditComment_Action().execute(request, response);

		}
		//[��� ���� D]
		else if (action.equals("deleteComment.ucdo")) {
			forward = new C_DeleteComment_Action().execute(request, response);

		}else {// �������� ��� -> 404
			forward.setPath("error/error404.jsp");
			forward.setRedirect(false);
		}




		// [response ����]
		if(forward!=null) { // ��ȯ���� forward�� null�� �ƴ϶��
			
			// redirect�� true == sendredirect���
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}
			else{ //forward���
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}//if
		
		
	}

}
