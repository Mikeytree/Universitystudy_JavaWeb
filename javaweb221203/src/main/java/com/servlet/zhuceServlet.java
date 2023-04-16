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

@WebServlet("/zhuceServlet")
public class zhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public zhuceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		String username=new String(request.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		String password=new String(request.getParameter("password").getBytes("iso-8859-1"),"utf-8");
		String sex=new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		String age1=new String(request.getParameter("age").getBytes("iso-8859-1"),"utf-8");
		int age=Integer.parseInt(age1);
		LoginUser user2=new LoginUser();
		user2.setUsername(username);
		user2.setPassword(password);
		user2.setSex(sex);
		user2.setAge(age);
		LoginUserDao dao=new LoginUserDao();
		boolean b=false;
		if(dao.ishave(username))
		{
			out.println("<HTML>");
			out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<a href = 'zhuce.jsp'>您输入的用户已存在，请重新输入!</a>");
			out.println(" </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		else
		{
			b=dao.addUser(user2);
			out.println("<HTML>");
			out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("<BODY>");
			if(b==true) {
				out.println("<a href = 'login.jsp'>注册成功,请重新登录</a>");
				}
			else
				{
				out.println("插入记录失败！");
				out.println("<a href = 'zhuce.jsp'></a>");
				}
			out.println(" </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

}
