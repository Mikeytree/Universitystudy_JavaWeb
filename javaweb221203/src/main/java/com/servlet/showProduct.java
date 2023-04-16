package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.model.Products;

@WebServlet("/showProduct")
public class showProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public showProduct() {
        super();
    }

    ServletContext context;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		int id= Integer.parseInt(request.getParameter("id"));
		ProductDao dao=new ProductDao();
		Products product = dao.findById(id);
		if(product != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("product",product);
			session.setAttribute("username", username);
			response.sendRedirect("ShowProduct.jsp") ;
		}else {
			out.println("No product found");
			out.println(username+","+id);
		}
		
	}

}
