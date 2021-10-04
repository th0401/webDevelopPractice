package model.member123;

public class Member123VO {
	private String id;
	private String pw;
	private String name;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Member123VO [id=" + id + ", pw=" + pw + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
	
}
