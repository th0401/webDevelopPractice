package model.member123;

import java.util.List;

public interface Member123Service {
	void insertmember123(Member123VO vo);
	void updateMember123(Member123VO vo);	
	void deleteMember123(Member123VO vo);
	List<Member123VO> getMember123List(Member123VO vo); 
	Member123VO getMember123(Member123VO vo);

}
