package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientInfoServlet
 */
@WebServlet("/client-information")
public class ClientInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=uTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println("<title>客户信息</title></head>");
		out.println("<body>");
		out.println("<p>客户端信息</p>");
		out.println(request.getMethod()+""+request.getRequestURI()+""+request.getProtocol()+"<br>");
		out.println("<p>客户端主机名："+request.getRemoteHost()+"</p>");
		out.println("<p>客户端ip号："+request.getRemoteAddr()+"</p>");
		out.println("<p>端口号："+request.getRemotePort()+"</p>");
		out.println("</body></html>");
	}

}
