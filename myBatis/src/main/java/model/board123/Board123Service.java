package model.board123;

import java.util.List;

public interface Board123Service {
	void insertBoard123(Board123JPAVO vo); // 메서드 시그니처
	void updateBoard123(Board123JPAVO vo);
	void deleteBoard123(Board123JPAVO vo);
	List<Board123JPAVO> getBoard123List(Board123JPAVO vo);
	Board123JPAVO getBoard123(Board123JPAVO vo);
}
