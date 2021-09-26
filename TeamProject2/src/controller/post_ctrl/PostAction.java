package controller.post_ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import controller.ActionForward;
import model.comments.CommentsVO;
import model.post.PostDAO;
import model.post.PostVO;

public class PostAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward action = new ActionForward();
		PostDAO PDAO = new PostDAO();
		PostVO PVO = new PostVO();
		ArrayList<PostVO> datas = PDAO.SelectAll();
		ArrayList<CommentsVO> CommentDatas = (ArrayList<CommentsVO>) request.getAttribute("CommentDatas");
		ArrayList<Integer> commentsCnt = new ArrayList<Integer>(datas.size()); // ����Ʈ ����Ʈ�� ���� ũ�⸦ ���� ��ۼ� AL����
		for (int i = 0; i < commentsCnt.size(); i++) { // ��ۼ� AL 0���� �ʱ�ȭ
			commentsCnt.set(i, 0);
		}
		for (int i = 0; i < CommentDatas.size(); i++) {
			int index = (CommentDatas.get(i).getC_post() - 1);
			commentsCnt.add(index, (commentsCnt.get(index) + 1)); // commentsCnt index = postnum - 1
		}
		request.setAttribute("PostList", datas); // PostList�� SelectAll �����͸� �ѱ�
		request.setAttribute("commentsCnt", commentsCnt); // ��� �� AL�� �ѱ� 0�� �ε����� 1�� ����Ʈ�� ��� ���� �������!
		action.setPath("main.jsp");
		action.setRedirect(false);
		return action;
	}

}
