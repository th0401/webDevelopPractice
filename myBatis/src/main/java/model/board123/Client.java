package model.board123;

import java.util.List;

public class Client {
	public static void main(String[] args) {

		Board123DAO dao = new Board123DAO();
		
		Board123VO vo = new Board123VO();

		/*vo.setTitle("��Ƽ������");
		vo.setWriter("��Ƽ������");
		vo.setContent("��Ƽ������");
		
		dao.insertBoard123(vo);*/
		
		List<Board123VO> datas = dao.getBoard123List(vo);
		for(Board123VO v : datas) {
			System.out.println(v);
		}
		
	}
}
