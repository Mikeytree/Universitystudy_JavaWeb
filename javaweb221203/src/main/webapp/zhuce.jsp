<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="css/zhuce.css">
</head>
<body bgcolor="#F9F9F9">
<div style="height:105px;width:100%;border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#FFFFFF;"></div>
<div style="width:1100px;margin:auto;">
<div class="header">
			<div class="header_left"><a href="zhuce.jsp"><img src="images/zhuce/sc.png" width="100px" height="80px" align="absbottom" ></a>|欢迎注册</div>
			<div class="header_right">如有账号你可以&nbsp;<a href="login.jsp">登录</a></div>
		</div>
		<!--注册页面-->
		<div class="main" >
			<br>
			<br>
            <br>
			<div class="main_left" style=background-color: lightbule; >
			<center>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
<form action="zhuceServlet" method="post">
用户名:<input type="text" name="username" id="username"><br>
<div style="height:10px;"></div>
密&nbsp;&nbsp;&nbsp;码:<input type=password name="password"><br>
<div style="height:10px;"></div>
性&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="sex" value="男">男
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="sex" value="女" >女&nbsp;&nbsp;&nbsp;&nbsp;<br>
<div style="height:10px;"></div>
年&nbsp;&nbsp;&nbsp;龄:<input type="text" name="age" id="age"><br>
<div style="height:10px;"></div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="注册">&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置">&nbsp;&nbsp;&nbsp;

</form>
</center>
</div>
<div class="main_right"><img src="./images/zhuce/Rick.jpg" width="100%"height="420px"/></div>
</div>
<!--版权-->
		<div class="footer">
			&nbsp;<a href="#" target="_blank">关于我们</a>|<a href="#" target="_blank">联系我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">商家入驻</a>&nbsp;|&nbsp;<a href="#" target="_blank">营销中心</a>&nbsp;|&nbsp;<a href="#" target="_blank">友情链接</a>&nbsp;|&nbsp;<a href="#" target="_blank">网上商城社区</a>&nbsp;<br>
			Copyright© ZZZhuo 2022-2023，All Rights Reserved
		</div>
</div>			
</body>
</html>