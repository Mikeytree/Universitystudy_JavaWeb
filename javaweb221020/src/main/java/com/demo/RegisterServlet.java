package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.action")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 54L;
	private static final  String TITLE="�û���Ϣ";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>"); 
		out.println("<html><head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>" + TITLE + "</title></head>");
		out.println("</head>");
		out.println("<body><h4>" + TITLE + "</h4>");
		out.println("<table>");
		out.println("<tr><td>�û���</td>");
		String username = request.getParameter("username");
		out.println("<td>" + username + "</td></tr>"); 
		out.println("<tr><td>����:</td>");
		out. println("<td>" + request.getParameter("password")
					+ "</td></tr>");
		out.println("<tr><td>�Ա�:</td>"); 
		out. println("<td>" + request.getParameter("sex")+ "</td></tr>");
		out.println("<tr><td>����:</td>");
		out.println("<td>" + request.getParameter("age") + "</td></tr>"); 
		out.println("<tr><td>����:</td>"); out.println("<td>");
		String[] hobbys=request.getParameterValues("hobby"); 
		if(hobbys!=null){
			//��ǿforѭ��
			for(String hobby:hobbys){
				out.println(hobby+ "<br/>");
			}
		}
		out.println("</td></tr>");
		out.println("<tr><td>ѧ��:</td>");
		out.println("<td>" + request.getParameter("education")
					+"</td></tr>");
		out.println("<tr><td>�ʼ���ַ:</td>");
		out.println("<td>" + request.getParameter("email") + "</td></tr>"); 
		out.println("<tr><td>����:</td>");
		out.println("<td>" + request.getParameter("resume") + "</td></tr>");
		out.println("</table>");
		out.println("</body>"); 
		out.println("</html>");
		}

	}


