package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Order;
import model.bo.BO;
import model.dao.DAO;

@WebServlet("/AddToOrderController")
public class AddToOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		BO bo = new BO();
		HttpSession session = request.getSession();
//		PrintWriter out = response.getWriter();

		LocalDateTime date = java.time.LocalDateTime.now();
		String datecreate = date.toString();
		String total = request.getParameter("subtotal");
		String username = (String)session.getAttribute("username");
//		out.println(username);
//		out.println(datecreate);
//		out.println(total);
		dao.addOrder(username ,datecreate, total);
		List<Order> listOrder = bo.getAllOrderByDatecreate(datecreate);
		session.setAttribute("listOrder", listOrder);

		response.sendRedirect("AddToCheckOutController");

	}

}
