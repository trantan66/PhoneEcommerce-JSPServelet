package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Product;
import model.bo.BO;
import model.dao.DAO;

@WebServlet("/EditProductController")
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		BO bo = new BO();
		try {
			String name = request.getParameter("Name");
			String image = request.getParameter("Image");
			String price = request.getParameter("Price");
			String description = request.getParameter("Description");
			String category = request.getParameter("Category");
			
			List<Product> list = (List<Product>)bo.getProductByName(name);
		
			String productid = String.valueOf(list.getLast().getId());
			dao.editProduct(name, image, price, description, category, productid);
			String screen = request.getParameter("Screen");
			String system = request.getParameter("System");
			String frontcamera = request.getParameter("BCamera");
			String rearcamera = request.getParameter("FCamera");
			String chip = request.getParameter("Chip");
			String ram = request.getParameter("RAM");
			String capacity = request.getParameter("Capacity");
			String sim = request.getParameter("Sim");
			String battery = request.getParameter("Battery");
			String company = request.getParameter("Company");
			
			dao.editProductDetail(screen, system, frontcamera, rearcamera, chip, ram, capacity, sim, battery, company, productid);
			response.sendRedirect("ManagerController");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
