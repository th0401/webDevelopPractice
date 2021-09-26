package controller.userComment_Ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.comments.CommentsDAO;
import model.comments.CommentsVO;

public class Post_Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		// VO DAO �ν��Ͻ�ȭ
		CommentsVO commentVO = new CommentsVO();
		CommentsDAO commentDAO = new CommentsDAO();
		
		
		// DAO���� ������ SET
		commentVO.setC_post(Integer.parseInt(request.getParameter("c_post")));
		
		
		// post_ctrl -> post (���� ����Ʈ)
	    ArrayList<CommentsVO> CommentDatas = commentDAO.SelectPost(commentVO);
	    request.setAttribute("CommentDatas", CommentDatas);
	    
	    // ������ ���ۼ���
	    forward.setRedirect(false); // forward
	    forward.setPath("post.pdo"); // post Control���� ����
		
		
		return forward;
	}

}
