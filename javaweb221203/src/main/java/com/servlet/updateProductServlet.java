package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

@WebServlet("/updateProductServlet")
public class updateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public updateProductServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String id1=request.getParameter("id");
		String stock1=request.getParameter("stock");
		int id = Integer.parseInt(id1);
		int stock=Integer.parseInt(stock1);
		ProductDao dao=new ProductDao();
		boolean b;
		b=dao.updateUser(id, stock);
		if(b==true) {
			out.println("<HTML>");
			out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("�޸���Ʒ����ɹ�");
			out.println("<a href=' guanli.jsp'>�ص���ҳ��</ a>");  
			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}else
		{
			
			out.println("<HTML>");
			out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println(" <BODY>");
			out.println("�޸ļ�¼ʧ��!");
			out.println("<a href='updateProudct.jsp'>�����޸�!</a>");
			out.println(" </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			}
	}
}


