package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Value;

import model.bean.Cart;
import model.bean.Order;
import model.dao.DAO;

@WebServlet("/AddToOrderDetail")
public class AddToOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		List<Order> listOrder = (List<Order>)request.getSession().getAttribute("listOrder");
		List<Cart> list = (List<Cart>)request.getSession().getAttribute("checkout-list");

		for(int i = 0; i<list.size(); i++) {
			String idproduct = String.valueOf(list.get(i).getId());
			String idOrder = String.valueOf(listOrder.getLast().getId());
			int quantity1 = list.get(i).getQuantity();
			Double price = list.get(i).getPrice();
			String total = String.valueOf(quantity1*price);
			String quantity = String.valueOf(list.get(i).getQuantity());
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String gmail = request.getParameter("gmail");
			String address = request.getParameter("address");
			String phonenumber = request.getParameter("phonenumber");
			String country = request.getParameter("country");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String payment = request.getParameter("payment");
			dao.addOrderDetail(idOrder, idproduct, quantity, total, firstname, lastname, gmail, address, phonenumber, country, city, state, payment);
			
//			PrintWriter out = response.getWriter();
//			out.println(idOrder);
//			out.println(idproduct);
//			out.println(quantity);
//			out.println(price);
//			out.println(firstname);
//			out.println(lastname);	
//			out.println(gmail);
//			out.println(address);
//			out.println(phonenumber);
//			out.println(country);
//			out.println(city);
//			out.println(state);
//			out.println(payment);
		}
		response.sendRedirect("HomeController");
	}

}
