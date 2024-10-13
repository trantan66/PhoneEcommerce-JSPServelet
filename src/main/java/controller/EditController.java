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
import model.bean.ProductDetail;
import model.bo.BO;

@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo = new BO();
		String pid = request.getParameter("pid");
		
		try {
			List<Product> list = bo.getAllProductbyId(pid);
			List<ProductDetail> listDetail = bo.getAllProductDetailById(pid);

			List<Category> listC = bo.getAllCategory();

			request.setAttribute("listP", list);
			request.setAttribute("listDetail", listDetail);
			request.setAttribute("listC", listC);
			request.getRequestDispatcher("Edit.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
