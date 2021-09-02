package model;

public class MemberBean {
	private String id = "kim";
	private String pw = "!123";
	
	public boolean login(String id,String pw) {
		boolean isTrue = false;
		if(id.equals(this.id)&&pw.equals(this.pw)) {
			
			isTrue = true;
		}
		
		return isTrue;
		
		
		
	}
}
