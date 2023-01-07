package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcelServlet
 */
@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel;charset=gb2312");
		response.setHeader("Content-Disposition","attachment;filename=excel.xls");
		
		PrintWriter pw=response.getWriter();
		pw.println("姓名\t性别\t年龄\t专业");
		pw.println("张三\t男\t19\t软件工程");
		pw.println("张一一\t女\t20\t计算机科学");
	}
	

}
