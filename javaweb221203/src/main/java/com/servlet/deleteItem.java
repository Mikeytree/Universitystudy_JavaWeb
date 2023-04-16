package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.ShoppingCartDao;
import com.model.Products;
import com.model.ShoppingCart;

/**
 * Servlet implementation class deleteItem
 */
@WebServlet("/deleteItem")
public class deleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 ShoppingCartDao dao=new ShoppingCartDao();
		 ShoppingCart cart=new ShoppingCart();
		 
		 ProductDao dao1=new ProductDao();
		 Products product=dao1.findById(id);
		 
		 //System.out.println("ggggg");
		 cart=dao.findByName(username, id);
		 int quantity=cart.getQuantity()-1;
		 
		 if(cart.getQuantity()>0)
		 {
		  dao.updateUser(username, id, quantity);
		  dao1.updateUser(id, product.getStock()+1);
		 
		  if(cart.getQuantity()==0)
			  dao.deleteUser(username, id);
		  response.sendRedirect("showCart.jsp");
		  //System.out.println("guuuu");
		 }
		 else {
			 dao.deleteUser(username, id);
		 dao1.updateUser(id, product.getStock()+1);
		 response.sendRedirect("showCart.jsp");//System.out.println("iii");
		 }
		 
		 }

}
