package day04;

public class LoginBean {
	private String userID; // �ɹ������� -> view(.jsp,.html)�� name�� ��ġ��Ŵ!
	private String userPW;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	
	final String dbID="kim"; // DB����, ���� ���ȭ
	final String dbPW="1234";
	public boolean check() {
		if(userID.equals(dbID) && userPW.equals(dbPW)) {
			return true;
		}
		return false;
	}
}
