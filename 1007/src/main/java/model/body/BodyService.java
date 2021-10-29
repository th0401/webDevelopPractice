package model.body;

import java.util.List;

public interface BodyService {

	List<BodyVO> selectAll(BodyVO vo);
	BodyVO selectOne(BodyVO vo);
	void insertBody(BodyVO vo);
	void updateBody(BodyVO vo);
	void deleteBody(BodyVO vo);
	
}
