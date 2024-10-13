package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Cart;

@WebServlet("/QuantityController")
public class QuantityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Cart> cart_List = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
		
		if(action != null) {
			if(action.equals("inc")) {
				for(Cart c: cart_List) {
					if(c.getId() == id) {
						int quantity = c.getQuantity();
						quantity++;
						c.setQuantity(quantity);
						response.sendRedirect("CartController");
					}
				}
				
			}
			if(action.equals("dec")) {
				for(Cart c: cart_List) {
					if(c.getId() == id && c.getQuantity()>1) {
						int quantity = c.getQuantity();
						quantity--;
						c.setQuantity(quantity);
						response.sendRedirect("CartController");
					}	
				}
			}
		}
	}

}
