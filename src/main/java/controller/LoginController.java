package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.Userinfo;
import model.bo.BO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo = new BO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Account account = bo.checkLogin(username, password);
			if(account == null) {
				request.setAttribute("message", "Wrong username or password!");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				
			}else {
//				request.setAttribute("isAdmin", "isAdmin");
//				request.getRequestDispatcher("HomeController").forward(request, response);
				HttpSession session  = request.getSession();
				if(bo.checkRole(username, password) == 0) {
					session.setAttribute("adminSession", account);
//					session.setMaxInactiveInterval(600);
					response.sendRedirect("HomeController");
				}else {
					String lastname = bo.getLastName(username);
					List<Userinfo> list = bo.getUserinfo(username);
					session.setAttribute("listuserinfo", list);
					session.setAttribute("userSession", account);
					session.setAttribute("lastname", lastname);
					session.setAttribute("username", username);

					session.setMaxInactiveInterval(300);
					response.sendRedirect("HomeController");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
