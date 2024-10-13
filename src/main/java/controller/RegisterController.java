package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BO;
import model.dao.DAO;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		BO bo = new BO();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gmail = request.getParameter("gmail");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		if(!password.equals(confirmpassword)) {
			request.setAttribute("message1", "Password and confirm password is not same!");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		else if(bo.checkUsername(username) == true) {
			request.setAttribute("message2", "Username already exist");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		else {
			dao.registerUser(username, confirmpassword, "1");
			dao.registerUserinfo(username, firstname, lastname, gmail, address, phonenumber, country, city, state);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

	}

}
