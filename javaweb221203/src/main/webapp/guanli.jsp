<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.model.Products, com.dao. ProductDao"%>
<!DOCTYPE html>
<%
ProductDao dao=new ProductDao();
ArrayList<Products> productList =dao.findAllUser();
%>
<html>
<head>
<meta charset="UTF-8">
<title>购物系统首页</title>
</head>
<body>
<center>
<h3>商品列表</h3>
<table>
	<tr><td>商品号</td><td>商品名</td><td>种类</td><td>价格</td><td>库存</td></tr>
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
	</tr>
	<%} %>
</table>
<a href="addProudct.jsp">增加商品</a>
<a href="updateProudct.jsp">修改商品</a>
<a href="deleteProudct.jsp">删除商品</a>
</center>
</body>
</html>