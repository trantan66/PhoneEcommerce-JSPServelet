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


@WebServlet("/AddToCheckOutController")
public class AddToCheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Cart> cart_List = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
		session.setAttribute("checkout-list", cart_List);
		session.removeAttribute("cart-list");
		response.sendRedirect("CheckOutController");
	}

}
