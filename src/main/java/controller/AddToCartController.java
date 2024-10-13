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
import javax.servlet.http.HttpSession;

import model.bean.Cart;
import model.bean.Category;
import model.bean.Product;
import model.bo.BO;
import model.dao.DAO;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<script type=\"text/javascript\"> alert('Success');</script>");

		BO bo = new BO();
		ArrayList<Cart> cartList = new ArrayList<>();
		String idP = request.getParameter("idP");
		int id = Integer.parseInt(idP);
		int quantity = 1;
		try {
			List<Product> listP = bo.getAllProductbyId(idP);
			Cart cm = new Cart(listP.get(0).getId(), listP.get(0).getName(), listP.get(0).getImage(),
					listP.get(0).getPrice(), quantity);
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("cart-list");

			if (cart_List == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("ShopController");
			} else {
				cartList = cart_List;
				boolean exist = false;

				for (Cart c : cart_List) {
					if (c.getId() == id) {
						exist = true;

//						out.print("<script type=\"text/javascript\"> alert('Item already exist in Cart!!');</script>");
						response.sendRedirect("CartController");


					}
				}
				if (!exist) {
					cartList.add(cm);
					response.sendRedirect("ShopController");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
