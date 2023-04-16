<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加商品</title>
</head>
<body>
<center>
<p>请输入一条商品记录</p>

<form action = "addProductServlet" method = "post">
 <table>
 <tr><td>商品号：</td> <td><input type="text" name="id" ></td></tr>
  <tr><td>商品名：</td> <td><input type="text" name="pname" ></td></tr>
   <tr><td>品牌：</td><td><input type="text" name="brand"></td></tr>      
   <tr><td>价格：</td><td><input type="text" name="price" ></td></tr>
   <tr><td>库存量：</td><td><input type="text" name="stock" ></td></tr>
   <tr><td><input type="submit" value="确定" ></td>
      <td><input type="reset" value="重置" ></td>
  </tr>
</table>
</form>
</center>
</body>
</html>