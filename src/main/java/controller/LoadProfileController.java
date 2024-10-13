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
import model.bean.Userinfo;
import model.bo.BO;


@WebServlet("/EditProfileController")
public class LoadProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo = new BO();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		try {
			List<Userinfo> list = bo.getUserinfo(username);
			List<Category> listC = bo.getAllCategory();
//			String message = (String)session.getAttribute("wrong");
			session.setAttribute("listuserinfo", list);
			request.setAttribute("listC", listC);
//			request.setAttribute("wrongmessage", message);

			request.getRequestDispatcher("Profile.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
