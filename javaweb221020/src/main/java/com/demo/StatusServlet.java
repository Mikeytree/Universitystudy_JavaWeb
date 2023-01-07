package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status-servlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
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
		PrintWriter out=response.getWriter();
		String qq=request.getParameter("q");
		if(qq==null) {
			out.print("没有提供参数");	
		}else if(qq.equals("0")){
			out.print(response.getStatus()+"<br>");
		}else if(qq.equals("1")) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}else if(qq.equals("2")) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}else {
			response.sendError(404, "resource connot founded!");
		}
	}

}
