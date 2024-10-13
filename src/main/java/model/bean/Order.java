package model.bean;

public class Order {
	private int id;
	private String username;
	private String datecreate;
	private int total;
	public Order(int id, String username, String datecreate, int total) {
		this.id = id;
		this.username = username;
		this.datecreate = datecreate;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
