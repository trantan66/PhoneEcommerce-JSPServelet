package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import databaseConnect.dbconnect;
import model.bean.Account;
import model.bean.Category;
import model.bean.Order;
import model.bean.OrderDetail;
import model.bean.Product;
import model.bean.ProductDetail;
import model.bean.Userinfo;

public class DAO {
	public List<Product> getAllProduct(){
		List<Product> list = new ArrayList<>();
		String sql = "select * from product";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<Product> getAllProductByCategory(String cid){
		List<Product> list = new ArrayList<>();
		String sql = "select * from product where cateid = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<Product> getAllProductByIdDesc(){
		List<Product> list = new ArrayList<>();
		String sql = "select * from product order by id desc limit 4;";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<Category> getAllCategory(){
		List<Category> list = new ArrayList<>();
		String sql = "select * from category";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Category(
						rs.getInt(1),
						rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public List<Product> getAllProductById(String idP){
		List<Product> list = new ArrayList<>();
		String sql = "select * from product where id = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idP);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public List<ProductDetail> getAllProductDetailById(String idP){
		List<ProductDetail> list = new ArrayList<>();
		String sql = "select * from productdetail where productid = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idP);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductDetail(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<Product> getAllProductByName(String key){
		List<Product> list = new ArrayList<>();
		String sql = "select * from product where name like ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"%" +key+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public Account checkLogin(String username, String password) {
		String sql = "select * from account where username = ? and password = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(
						rs.getString(1),
						rs.getString(2),
						rs.getInt(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean checkOldPassword(String username, String password) {
		boolean inValid = false;
		String sql = "select * from account where username = ? and password = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				inValid = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inValid;
	}
	public int checkRole(String username, String password) {
		int isAdmin = 0;
		String sql = "select * from account where username = ? and password = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				isAdmin = rs.getInt(3);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isAdmin;
	}
	public boolean checkUsername(String username) {
		boolean exist = false;
		String sql = "select * from account where username = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				exist = true;
			}else {
				exist = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return exist;
	}
	public void registerUser(String username, String password, String roleid) {
		String sql = "INSERT INTO `account` (`username`,`password`, `roleid`) VALUES (?, ?, ?);";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, roleid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void registerUserinfo(String username, String firstname, String lastname, String gmail, String address, String phonenumber, String country, String city, String state) {
		String sql = "INSERT INTO `userinfo` (`id`,`username`,`firstname`, `lastname`,`gmail`, `address`,`phonenumber`, `country`,`city`, `state`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, gmail);
			ps.setString(5, address);
			ps.setString(6, phonenumber);
			ps.setString(7, country);
			ps.setString(8, city);
			ps.setString(9, state);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String getLastName(String username){
		String lastname = "";
		String sql = "select * from userinfo where username = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lastname = rs.getString(4);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lastname;
	}
	public List<Userinfo> getUserinfo(String username){
		List<Userinfo> list = new ArrayList<>();
		String sql = "select * from userinfo where username = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Userinfo(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public void editUserinfo(String firstname, String lastname, String gmail, String address, String phonenumber, String country, String city, String state, String username) {
		String sql = "UPDATE `userinfo` SET `firstname` = ?, `lastname` = ?, `gmail` = ?,`address` = ?, `phonenumber` = ?, `country` = ?, `city` = ?, `state` = ? WHERE `userinfo`.`username` = ?;";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, gmail);
			ps.setString(4, address);
			ps.setString(5, phonenumber);
			ps.setString(6, country);
			ps.setString(7, city);
			ps.setString(8, state);
			ps.setString(9, username);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void changePassword(String username, String password) {
		String sql = "UPDATE `account` SET `password` = ? WHERE `account`.`username` = ?;";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void addProduct(String name, String image, String price, String description, String category) {
		String sql = "INSERT INTO `product` (`id`, `name`, `image`, `price`, `description`, `cateid`) VALUES (NULL, ?, ?, ?, ?, ?);";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, description);
			ps.setString(5, category);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Product> getProductByName(String name){
		List<Product> list = new ArrayList<>();
		String sql = "select * from product where name = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(
						rs.getInt(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public void addProductDetail(String productid, String screen, String system, String frontcamera, String rearcamera, String chip, String ram, String capacity,String sim, String battery, String company) {
		String sql = "INSERT INTO `productdetail` (`id`, `productid`, `screen`, `system`, `frontcamera`, `rearcamera`, `chip`, `ram`, `capacity`, `sim`, `battery`, `company`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productid);
			ps.setString(2, screen);
			ps.setString(3, system);
			ps.setString(4, frontcamera);
			ps.setString(5, rearcamera);
			ps.setString(6, chip);
			ps.setString(7, ram);
			ps.setString(8, capacity);
			ps.setString(9, sim);
			ps.setString(10, battery);
			ps.setString(11, company);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void editProduct(String name, String image, String price, String description, String category, String id) {
		String sql = "UPDATE `product` SET `name` = ?, `image` = ?, `price` = ?,`description` = ?, `cateid` = ? WHERE `product`.`id` = ?;";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price);
			ps.setString(4, description);
			ps.setString(5, category);
			ps.setString(6, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void editProductDetail(String screen, String system, String frontcamera, String rearcamera, String chip, String ram, String capacity,String sim, String battery, String company, String productid) {
		String sql = "UPDATE `productdetail` SET `screen` = ?, `system` = ?, `frontcamera` = ?, `rearcamera` = ?, `chip` = ?, `ram` = ?, `capacity` = ?, `sim` = ?, `battery` = ?, `company` = ? WHERE `productdetail`.`productid` = ?;";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);		
			ps.setString(1, screen);
			ps.setString(2, system);
			ps.setString(3, frontcamera);
			ps.setString(4, rearcamera);
			ps.setString(5, chip);
			ps.setString(6, ram);
			ps.setString(7, capacity);
			ps.setString(8, sim);
			ps.setString(9, battery);
			ps.setString(10, company);
			ps.setString(11, productid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void deleteProduct(String pid) {
		String sql = "delete from product where id = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void deleteProductDetail(String pid) {
		String sql = "delete from productdetail where productid = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void addOrder(String username, String datecreate, String total) {

		String sql = "INSERT INTO `orders` (`id`, `username`, `datecreate`,`total`) VALUES (NULL, ?, ?, ?);";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, datecreate);
			ps.setString(3, total);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Order> getAllOrderByDatecreate(String datecreate){
		List<Order> list = new ArrayList<>();
		String sql = "select * from orders where datecreate = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, datecreate);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Order(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public void addOrderDetail(String idorder,String idproduct, String quantity, String total, String firstname, String lastname, String gmail, String address, String phonenumber, String country, String city, String state, String payment ) {
		String sql = "INSERT INTO `orderdetail` (`id`,`idorder` ,`idproduct`,`quantity`, `total`,`firstname`, `lastname`,`gmail`, `address`,`phonenumber`, `country`,`city`, `state`,`payment`) VALUES (NULL, ?, ?, ?, ?,?, ?, ?,?, ?, ?,?, ?, ?);";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idorder);
			ps.setString(2, idproduct);
			ps.setString(3, quantity);
			ps.setString(4, total);
			ps.setString(5, firstname);
			ps.setString(6, lastname);
			ps.setString(7, gmail);
			ps.setString(8, address);
			ps.setString(9, phonenumber);
			ps.setString(10, country);
			ps.setString(11, city);
			ps.setString(12, state);
			ps.setString(13, payment);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Order> getAllOrder(){
		List<Order> list = new ArrayList<>();
		String sql = "select * from orders";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Order(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getInt(4)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<Order> getAllOrderByUsername(String username){
		List<Order> list = new ArrayList<>();
		String sql = "select * from orders where username = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Order(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getInt(4)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	public List<OrderDetail> getAllOrderDetailById(String id){
		DAO dao = new DAO();
		List<OrderDetail> list = new ArrayList<>();
		String sql = "select * from orderdetail where idorder = ?";
		try {
			Connection conn = dbconnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				List<Product> listP = dao.getAllProductById(String.valueOf(rs.getInt(3)));
				list.add(new OrderDetail(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12), 
						rs.getString(13), 
						rs.getString(14),
						listP.getLast().getName()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	public static void main(String[] args) {
		DAO dao = new DAO();
//		List<Product> list = dao.getAllProductByName("Iphone 15");
//		System.out.println(dao.checkRole("user1", "1"));
		
//		for(Product o : list) {
//			System.out.println(o.getName());
//		}
	}
}
