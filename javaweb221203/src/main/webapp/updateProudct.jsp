<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品信息</title>
</head>
<body>
<center>
<form action="updateProductServlet" method="post">
<br/>
请输入要修改的商品编号:<input type="text" name="id">
<br/>
修改库存:<input type="text" name="stock">
<input type="submit" value="修改">
</form>
</center>
</body>
</html>