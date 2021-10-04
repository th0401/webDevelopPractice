package model.member123;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("member123Service")
public class Member123ServiceImpl implements Member123Service{

	@Autowired
	private Member123DAO member123dao;
	
	
	@Override
	public void insertmember123(Member123VO vo) {
		member123dao.insertmember123(vo);
		
	}

	@Override
	public void updateMember123(Member123VO vo) {
		member123dao.updateMember123(vo);
		
	}

	@Override
	public void deleteMember123(Member123VO vo) {
		member123dao.deleteMember123(vo);
		
	}

	@Override
	public List<Member123VO> getMember123List(Member123VO vo) {

		return member123dao.getMember123List(vo);
	}

	@Override
	public Member123VO getMember123(Member123VO vo) {

		return member123dao.getMember123(vo);
	}

}
