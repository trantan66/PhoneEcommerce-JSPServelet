package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Category;
import model.bean.Order;
import model.bean.Product;
import model.bo.BO;

@WebServlet("/PaymentHistoryController")
public class PaymentHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo = new BO();
		HttpSession session = request.getSession();

		String username = (String)session.getAttribute("username");
		try {
			List<Product> list = bo.getAllProduct();
			List<Category> listC = bo.getAllCategory();
			List<Order> listOrder = bo.getAllOrderByUsername(username);
			request.setAttribute("listP", list);
			request.setAttribute("listC", listC);
			request.setAttribute("listOrder", listOrder);

			request.getRequestDispatcher("PaymentHistory.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
