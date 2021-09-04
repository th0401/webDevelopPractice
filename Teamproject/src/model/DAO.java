package model;


// ���� ������ ���� �ʰ� �Լ� �̸��� ������ ������� '�� ������' �� �����Ͻø� �˴ϴ�. :)

import java.util.ArrayList;

import model.member.memberVO;

public interface DAO {
	// CRUD ����
	void insert(Object vo);
	void update(Object vo);
	void delete(Object vo);
	Object select(Object vo);
	ArrayList selectList(Object vo);
	
}
