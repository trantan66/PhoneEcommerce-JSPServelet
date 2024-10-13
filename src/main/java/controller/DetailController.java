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

/**
 * Servlet implementation class DetailController
 */
@WebServlet("/DetailController")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo = new BO();
		String idP = request.getParameter("idP");
//		String idP = "1";
		try {
			List<Product> list = bo.getAllProductbyId(idP);
			List<Product> listAll = bo.getAllProduct();
			List<ProductDetail> listD = bo.getAllProductDetailById(idP);
			List<Category> listC = bo.getAllCategory();

			request.setAttribute("listP", list);
			request.setAttribute("listAll", listAll);
			request.setAttribute("listD", listD);
			request.setAttribute("listC", listC);

			request.getRequestDispatcher("Detail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
