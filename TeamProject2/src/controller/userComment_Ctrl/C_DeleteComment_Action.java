package controller.userComment_Ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.comments.CommentsDAO;
import model.comments.CommentsVO;

public class C_DeleteComment_Action implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		// VO DAO �ν��Ͻ�ȭ
	    CommentsVO commentVO = new CommentsVO();
	    CommentsDAO commentDAO = new CommentsDAO();
	    
	    
	    // DAO���� �ʿ䵥���� SET
	    commentVO.setCnum(Integer.parseInt(request.getParameter("cnum")));
	    
	    
	    //DAO ����
	    // ��� ���� �Ϸ�
	    if (commentDAO.DeleteDB(commentVO)) {
	    	String parameter = "?pnum="+request.getParameter("c_post"); // parameter �߰�
	    	forward.setRedirect(false); // forward
	    	forward.setPath("selectOne.pdo"+parameter); // post ��Ʈ�ѷ����� ������ ��û(ShowList(���� �Խù�)�̵�)
	    }
	    // �ݿ� ���� -> ���� ����
	    else {
	    	try {
				throw new Exception("C_DeleteComment_Action ���� �߻�!");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	    }
	    
	    return forward;
	}
}
