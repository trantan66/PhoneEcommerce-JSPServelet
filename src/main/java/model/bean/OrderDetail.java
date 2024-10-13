package model.bean;

public class OrderDetail {
	private int id;
	private int idorder;
	private int idproduct;
	private int quantity;
	private int total;
	private String firstname;
	private String lastname;
	private String gmail;
	private String address;
	private String phonenumber;
	private String country;
	private String city;
	private String state;
	private String payment;
	private String name;
	public OrderDetail(int id, int idorder, int idproduct, int quantity, int total, String firstname, String lastname,
			String gmail, String address, String phonenumber, String country, String city, String state, String payment,
			String name) {
		this.id = id;
		this.idorder = idorder;
		this.idproduct = idproduct;
		this.quantity = quantity;
		this.total = total;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gmail = gmail;
		this.address = address;
		this.phonenumber = phonenumber;
		this.country = country;
		this.city = city;
		this.state = state;
		this.payment = payment;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdorder() {
		return idorder;
	}
	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}
	public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
