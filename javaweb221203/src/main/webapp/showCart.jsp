<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.model.*,com.dao.*" %>
<html>
<head><title>用户购物车信息</title></head>
<body>
<center>
<%
  String username=(String)request.getSession().getAttribute("username");
  // 从购物车中取出每件商品并存储在ArrayList中
  ShoppingCartDao dao=new ShoppingCartDao();
  ArrayList<ShoppingCart> cartlist = new ArrayList<ShoppingCart>();
  cartlist=dao.findByName(username); 
%>
<p>您购物车信息</p>
  用户：<%=username%>
<table>
<tr><td style='width:50px'> 商品编号</td>
    <td style='width:80px'>商品名称</td>
    <td style='width:80px'>价格</td>
    <td style='width:80px'>数量</td>
    <td style='width:80px'>小计</td>
    <td style='width:80px'>是否删除</td> 
</tr>
<% 
    
     for(ShoppingCart cart:cartlist){
  %>

  <tr>
 <td><%=cart.getId() %></td>
    <td><%=cart.getPname() %></td>
    <td><%=cart.getPrice()%></td>
    <td><%=cart.getQuantity() %></td>
    <td><%=cart.getQuantity()*cart.getPrice()%></td>
   <td><a href="deleteItem?id=<%=cart.getId() %>&&username=<%=username%>">删除</a></td>
  </tr>
  <%} %>
 
</table>

<a href="main.jsp">返回继续购物</a>
</center>
</body>
</html>
