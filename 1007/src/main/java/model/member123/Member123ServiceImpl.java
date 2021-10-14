package model.member123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("member123Service")
public class Member123ServiceImpl implements Member123Service{
	@Autowired
	private SpringMember123DAO member123DAO;
	
	@Override
	public Member123VO getMember(Member123VO vo) {
		return member123DAO.getMember(vo);
	}

	@Override
	public void insertMember(Member123VO vo) {
		member123DAO.insertMember(vo);
		
	}

	@Override
	public void updateMember(Member123VO vo) {
		member123DAO.updateMember(vo);
		
	}

	@Override
	public void deleteMember(Member123VO vo) {
		member123DAO.deleteMember(vo);
		
	}
}
