package model.member123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("member123Service")
public class Member123ServiceImpl implements Member123Service{
	@Autowired
	private Member123DAO member123DAO;
	
	@Override
	public Member123VO getBoard(Member123VO vo) {
		return member123DAO.getBoard(vo);
	}
}
