<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,com.model.Products,com.dao.ProductDao"%>
<!DOCTYPE html>
<%
ProductDao dao=new ProductDao();
ArrayList<Products> productList =dao.findAllUser();
String username=(String)request.getSession().getAttribute("username");
%>
<html>
<head>
<meta charset="UTF-8">
<title>购物管理页面</title>
</head>
<body background="images/bgimg/05.jpg"></body>
<body>
<form action="showProduct" method="post">
<center>
<h3>商品列表</h3>
<table>
	<tr><td>商品号</td><td>商品名</td><td>种类</td><td>价格</td><td>库存</td><td>详细信息</td></tr>
	<!-- 从应用作用域中取出productList对象 -->
	<%
		for(Products product:productList){
	%>
	
	<tr>
	<td><%=product.getId()%></td>
	<td><%=product.getPname() %></td>
	<td><%=product.getBrand() %></td>
	<td><%=product.getPrice()%></td>
	<td><%=product.getStock()%></td>
	<td><a href="showProduct?id=<%=product.getId()%>&&username=<%=username%>">详细信息</a></td>
	<%} %>
	<tr><td><a href="showCart.jsp?username=<%=username%>">查看购物车</a><td></tr>
</table>
</center>
</form>
</body>
</html>