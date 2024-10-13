package model.bean;

public class Product {
	private int id;
	private String name;
	private String image;
	private Double price;
	private String description;

	public Product(int id, String name, String image, Double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
	}
//	public Product() {
//		
//	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
