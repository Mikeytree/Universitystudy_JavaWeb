package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowTimeServlet
 */
@WebServlet("/showtime-servlet")
public class ShowTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Refresh","5");
//		response.setHeader("Refresh","5;URL=https://www.bilibili.com/");
//		五秒后跳转到某一个网站
		PrintWriter out=response.getWriter();
		LocalTime now=LocalTime.now();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("hh:mm:ss");
		String t=now.format(format);
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>当前时间</title><head>");
		out.println("<body>");
		out.println("<p>每五秒刷新一次页面</p>");
		out.println("<p>现在的时间是："+t+"</p>");
		out.println("</body>");
		out.println("</html>");
	
	
	
	}

		
	

}
