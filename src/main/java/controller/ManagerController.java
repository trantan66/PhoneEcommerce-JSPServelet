package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Product;
import model.bo.BO;

/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo = new BO();
		try {
			List<Product> list = bo.getAllProduct();
			List<Category> listC = bo.getAllCategory();

			request.setAttribute("listP", list);
			request.setAttribute("listC", listC);

			request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
