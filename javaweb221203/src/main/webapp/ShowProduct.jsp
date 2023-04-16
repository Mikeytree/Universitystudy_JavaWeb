<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.Products" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示商品详细信息</title>
<script language="JavaScript" type="text/javascript">
 function check(form){
	 var regu=/^[1-9]\d*$/;
	 if(form.quantity,value==''){
		 alert("数量值不能为空！")
		 form.quantity,focus();
		 return false;	 
	 }
	 if(!regu.test(form.quantity.value)){
		 alert("必须输入整数！");
		 form.quantity.focus();
		 return false;
	 }
	 
 }
</script>
</head>
<body>
<center>
<%
Products product=(Products)request.getSession().getAttribute("product");
String username=(String)request.getSession().getAttribute("username");

%>
<p>商品详细信息</p>
<form name="myform" method="post" action='addToCart'>
<input type="hidden" name="username" value='<%=username%>'/>
<input type="hidden" name="id" value='<%=product.getId()%>'/>
<input type="hidden" name="pname" value='<%=product.getPname()%>'/>
<input type="hidden" name="price" value='<%=product.getPrice()%>'/>
<input type="hidden" name="stock" value='<%=product.getStock()%>'/>
<table>
<tr><td>用户名:</td><td><%=username %></td></tr>
<tr><td>商品名:</td><td><%=product.getId()%></td></tr>
<tr><td>商品名:</td><td><%=product.getPname() %></td></tr>
<tr><td>类型:</td><td><%=product.getBrand() %></td></tr>
<tr><td>价格:</td><td><%=product.getPrice() %></td></tr>
<tr><td>库存量:</td><td><%=product.getStock() %></td></tr>

<tr><td><input type="text" name='quantity' id='quantity'/></td>
<td><input type='submit' value='放入购物车' onclick="check(this.form)"/></td></tr>
<tr><td colspan='2'><a href='main.jsp'>显示商品列表</a></td></tr>
</table>
</form>
</center>
</body>
</html>