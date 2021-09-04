package model;


// 직접 구현은 하지 않고 함수 이름과 순서만 맞춰놓은 '명세 페이지' 라 생각하시면 됩니다. :)

import java.util.ArrayList;

import model.member.memberVO;

public interface DAO {
	// CRUD 정의
	void insert(Object vo);
	void update(Object vo);
	void delete(Object vo);
	Object select(Object vo);
	ArrayList selectList(Object vo);
	
}
