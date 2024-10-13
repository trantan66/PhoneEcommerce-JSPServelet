package model.bean;

public class ProductDetail {
	private int id;
	private int productid;
	private String screen;
	private String system;
	private String frontcamera;
	private String rearcamera;
	private String chip;
	private String ram;
	private String capacity;
	private String sim;
	private String battery;
	private String company;
	public ProductDetail(int id, int productid, String screen, String system, String frontcamera, String rearcamera,
			String chip, String ram, String capacity, String sim, String battery, String company) {
		super();
		this.id = id;
		this.productid = productid;
		this.screen = screen;
		this.system = system;
		this.frontcamera = frontcamera;
		this.rearcamera = rearcamera;
		this.chip = chip;
		this.ram = ram;
		this.capacity = capacity;
		this.sim = sim;
		this.battery = battery;
		this.company = company;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getFrontcamera() {
		return frontcamera;
	}
	public void setFrontcamera(String frontcamera) {
		this.frontcamera = frontcamera;
	}
	public String getRearcamera() {
		return rearcamera;
	}
	public void setRearcamera(String rearcamera) {
		this.rearcamera = rearcamera;
	}
	public String getChip() {
		return chip;
	}
	public void setChip(String chip) {
		this.chip = chip;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
