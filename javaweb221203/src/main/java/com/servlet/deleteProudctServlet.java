package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;


@WebServlet("/deleteProudctServlet")
public class deleteProudctServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteProudctServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		  PrintWriter out=response.getWriter();
		  
		  String id1=request.getParameter("id");
		  int id=Integer.parseInt(id1);
		  ProductDao dao=new ProductDao();
		  boolean b;
		  b=dao.deleteUser(id);
		  if(b==true) {
			  out.println("<HTML>");
				out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
				out.println("<BODY>");
				out.print("ɾ����¼�ɹ���");
				out.println("<a href=' guanli.jsp'>�ص���ҳ��</ a>");  
				out.flush();
				out.close();
		  }else {out.println("<HTML>");
			out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("<BODY>");
			out.print("ɾ����¼ʧ�ܣ�");
			out.println("<a href='deleteProudct.jsp'>�ص���ҳ��</ a>");  
			out.flush();
			out.close();
			  
		  }
		      out.println("</BODY>");
		      out.println("</HTML>");
		      out.flush();
		      out.close();
		 }

		}
