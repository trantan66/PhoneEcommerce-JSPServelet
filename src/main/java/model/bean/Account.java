package model.bean;

public class Account {
	private String username;
	private String password;
	private int roleid;
	public Account(String username, String password, int roleid) {
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
