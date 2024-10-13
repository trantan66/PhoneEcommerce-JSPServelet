package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.bean.Account;
import model.bean.Category;
import model.bean.Order;
import model.bean.OrderDetail;
import model.bean.Product;
import model.bean.ProductDetail;
import model.bean.Userinfo;
import model.dao.DAO;

public class BO {
	DAO dao = new DAO();
	public List<Product> getAllProduct() throws Exception{
		return dao.getAllProduct();
	}
	
	public List<Product> getAllProductbyCategory(String cid) throws Exception{
		return dao.getAllProductByCategory(cid);
	}
	public List<Product> getAllProductByIdDesc() throws Exception{
		return dao.getAllProductByIdDesc();
	}
	public List<Category> getAllCategory() throws Exception{
		return dao.getAllCategory();
	}
	public List<Product> getAllProductbyId(String idP) throws Exception{
		return dao.getAllProductById(idP);
	}
	public List<ProductDetail> getAllProductDetailById(String idP) throws Exception{
		return dao.getAllProductDetailById(idP);
	}
	public List<Product> getAllProductByName(String key) throws Exception{
		return dao.getAllProductByName(key);
	}
	public Account checkLogin(String username, String password) {
		return dao.checkLogin(username, password);
	}
	public List<Order> getAllOrderByDatecreate(String datecreate) {
		return dao.getAllOrderByDatecreate(datecreate);
	}
	public List<Product> getProductByName(String name) throws Exception{
		return dao.getProductByName(name);
	}
	public List<Order> getAllOrder() throws Exception{
		return dao.getAllOrder();
	}
	public List<Order> getAllOrderByUsername(String username) throws Exception{
		return dao.getAllOrderByUsername(username);
	}
	public List<OrderDetail> getAllOrderDetailById(String id) throws Exception{
		return dao.getAllOrderDetailById(id);
	}
	public boolean checkUsername(String username) {
		return dao.checkUsername(username);
	}
	public int checkRole(String username, String password) {
		return dao.checkRole(username, password);
	}
	public String getLastName(String username) {
		return dao.getLastName(username);
	}
	public List<Userinfo> getUserinfo(String username) throws Exception{
		return dao.getUserinfo(username);
	}
	public boolean checkOldPassword(String username, String password) {
		return dao.checkOldPassword(username, password);
	}
}
