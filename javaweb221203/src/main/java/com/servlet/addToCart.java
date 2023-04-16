package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.dao.ProductDao;
import com.dao.ShoppingCartDao;
import com.model.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class addToCart extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	ServletContext context;

	public addToCart() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int quantity;

		String username = request.getParameter("username");
		int id = Integer.parseInt(request.getParameter("id"));
		String pname = new String(request.getParameter("pname").getBytes("ISO-8859-1"), "UTF-8");
		float price = Float.parseFloat(request.getParameter("price"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		ShoppingCart cart = new ShoppingCart();
		cart.setUsername(username);
		cart.setId(id);
		cart.setPname(pname);
		cart.setPrice(price);
		cart.setQuantity(quantity);
		
		ShoppingCartDao cartdao = new ShoppingCartDao();
		ProductDao dao1 = new ProductDao();
		Products p1 = new Products();
		
		p1 = dao1.findById(id);

		if (quantity >= 0 && p1.getStock() >= quantity) {
			ShoppingCart cart1 = cartdao.findByName(username, id);

			if (cart1.getId() != 0) {

				cartdao.updateUser(username, cart1.getId(), cart1.getQuantity() + quantity);
				int stock = p1.getStock() - quantity;
				dao1.updateUser(id, stock);
				request.getSession().setAttribute("username", username);
				response.sendRedirect("showCart.jsp");

			} else if (cart1.getId() == 0) {
				cartdao.addUser(cart);
				cartdao.updateUser(username, cart1.getId(), cart1.getQuantity() + quantity);
				int stock = p1.getStock() - quantity;
				dao1.updateUser(id, stock);
				request.getSession().setAttribute("username", username);
				response.sendRedirect("showCart.jsp");

			}

		}

		else if (p1.getStock() < quantity) {
			out.println("库存不足！");
			out.print("<a href='showCart.jsp'>查看购物车</a>");
		} else
			out.println("数量必须大于或等于0！");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
