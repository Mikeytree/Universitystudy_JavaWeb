<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册界面</title>
</head>
<body>
<h4>用户注册页面</h4>
<form action="register.action"method="post">
<table>
<tr><td>用户名：</td>
<td><input type="text"name="username"size="15"></td>
<tr><td>密码：</td>
<td><input type="password"name="password"size="16"></td></tr>
<tr><td>性别：</td>
<td><input type="radio"name="sex"value="male">男
<input type="radio"name="sex"value="female">女</td></tr>
<tr><td>年龄：</td>
<td><input type="text"name="age"size="5"></td></tr>
<tr><td>兴趣：</td>
<td><input type="checkbox"name="hobby"value="read">文学
	<input type="checkbox"name="hobby"value="sport">体育
	<input type="checkbox"name="hobby"value="computer">电脑</td></tr>
	<tr><td>学历:</td>
<td><select name = "education">
<option value ="bachelor">学士</option >
<option value ="master">硕士</option>
<option value = "doctor">博士</option>
</select></td></tr>
<tr><td>邮件地址:</td><td><input type = "text" name = "email"size="20"></td></tr>
<tr><td>简历: </td>
<td><textarea name = "resume"rows = "5"cols ="30"></textarea></td></tr>
<tr><td><input type ="submit" name="submit"value="提交"></td><td>
		<input type = "reset" name ="reset" value="重置"></td></tr>
</table>
</form>
</body>
</html>