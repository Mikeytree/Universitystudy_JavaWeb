package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowHeadersServlet
 */
@WebServlet("/show-headers")
public class ShowHeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHeadersServlet() {
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
		out.println("<title>请求头信息</title></head>");
		out.println("服务器请求头的信息<p>");
		//Enumeration getHeaders(String name)
		//泛型
		Enumeration<String> headers=request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String header=(String) headers.nextElement();
			String value=request.getHeader(header);
			out.println(header+"="+value+"<br>");
		}
		out.println("</body></html>");
	}

}
