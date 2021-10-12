package model.member1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("member1Service")
public class Member1ServiceImpl implements Member1Service{

	@Autowired
	private SpringMember1DAO member1dao;
	
	
	@Override
	public Member1VO getMember(Member1VO vo) {
		
		return member1dao.getMember(vo);
	}


	@Override
	public void insertMember1(Member1VO vo) {
		member1dao.insertMember1(vo);
		
	}

}
