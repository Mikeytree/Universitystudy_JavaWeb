package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginUserDao;
import com.model.LoginUser;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public loginServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String username=new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String password=new String(request.getParameter("password").getBytes("iso-8859-1"),"utf-8");
		LoginUserDao dao=new LoginUserDao();
		LoginUser user2=new LoginUser();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println(" <BODY>");
		if(username.equals("admin")&&password.equals("123456"))
			response.sendRedirect("guanli.jsp");
		if(dao.ishave(username)) {
			user2=dao.findByName(username);
			if(username.equals(user2.getUsername())&&password.equals(user2.getPassword())) {
				request.getSession().setAttribute("username",username);
				response.sendRedirect("main.jsp");
			}
			else {
				out.println("密码错误");
				out.println("<a href = 'login.jsp'>重新登录</a>");
			}
		}else {
			out.println("用户名不存在");
			out.println("<a href = zhuce.jsp>请注册</a>");
		}
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

}
