package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.OrderDetail;
import model.bo.BO;

@WebServlet("/PaymentHistoryDetailController")
public class PaymentHistoryDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BO bo =  new BO();
		String id = request.getParameter("id");
		try {
			List<OrderDetail> list = (List<OrderDetail>)bo.getAllOrderDetailById(id);
			List<Category> listC = bo.getAllCategory();
//			bo.getAllProductbyId(id);
			request.setAttribute("listOrderDetail", list);

			request.setAttribute("listC", listC);

			request.getRequestDispatcher("PaymentHistoryDetail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
