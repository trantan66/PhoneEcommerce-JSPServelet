package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Cart;

@WebServlet("/DeleteCartController")
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null) {
			ArrayList<Cart> cart_List = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
			if(cart_List != null) {
				for(Cart c: cart_List) {
					if(c.getId() == Integer.parseInt(id)) {
						cart_List.remove(cart_List.indexOf(c));
						break;
					}
				}
				response.sendRedirect("CartController");
			}
		}else {
			response.sendRedirect("CartController");
		}
		

	}

}
