package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.model.Products;

@WebServlet("/addProductServlet")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addProductServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String id1=request.getParameter("id");
		int id = Integer.parseInt(id1);
		String pname=new String(request.getParameter("pname").getBytes("iso-8859-1"),"utf-8");
		String brand=new String(request.getParameter("brand").getBytes("iso-8859-1"),"utf-8");
		String price1=request.getParameter("price");
		float price=Float.parseFloat(price1);
		String stock1=request.getParameter("stock");
		int stock=Integer.parseInt(stock1);
		Products p=new Products();
		p.setBrand(brand);
		p.setId(id);
		p.setPname(pname);
		p.setPrice(price);
		p.setStock(stock);
		ProductDao dao=new ProductDao();
		boolean b=false;
		if(dao.ishave(id)) {
			out.println("<HTML>");
			out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<a href='addProudct.jsp'>您输入的商品已存在，请重新输入!</a>");
			out.println("<BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}else
		{
			b=dao.addProducts(p);
			out.println("<HTML>");
			out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println(" <BODY>");
			if(b==true) {
				out.println("插入记录成功!");
				out.println("<a href='guanli.jsp'>返回主页面!</a>");
			}
			else
			{
				out.println("插入记录失败!");
				out.println("<a href='addProudct.jsp'>请重新输入!</a>");
			}
			out.println(" </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

}
