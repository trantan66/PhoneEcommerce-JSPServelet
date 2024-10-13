package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.BO;
import model.dao.DAO;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		BO bo = new BO();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");

		String confirmnewpassword = request.getParameter("confirmnewpassword");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gmail = request.getParameter("gmail");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phonenumber");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		if (oldpassword != null) {
			if (bo.checkOldPassword(username, oldpassword)) {
				if (!newpassword.equals(confirmnewpassword)) {
					session.setAttribute("wrong", "New password and confirm new password is not same!");
					response.sendRedirect("EditProfileController");
				} else {
					dao.changePassword(username, newpassword);
					dao.editUserinfo(firstname, lastname, gmail, address, phonenumber, country, city, state, username);
					response.sendRedirect("EditProfileController");
				}
			}else {
				session.setAttribute("wrongoldpassword", "Old password is not true!");
				response.sendRedirect("EditProfileController");
			}
		} else {
			dao.editUserinfo(firstname, lastname, gmail, address, phonenumber, country, city, state, username);
			response.sendRedirect("EditProfileController");

		}
	}

}
