<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
 <body bgcolor="#F9F9F9">
	<div style="height:105px;width:100%;border-bottom:1px solid #CCC; z-index:-1; position:absolute; background:#FFFFFF;"></div>
	<div style="width:1100px;margin:auto;">
		<div class="header">
			<!--logo-->
			<div class="header_left"><a href="login.jsp"><img src="./images/login/sc.jpg" width="100px" height="80px" align="absbottom" ></a>|欢迎登录</div>
			<div class="header_right">您好欢迎登录&nbsp;<a href="zhuce.jsp">免费注册</a></div>
		</div>
		<div class="main">
			<br>
			<br>
            <br>0
			<!--左侧广告-->
			<div class="main_left"><img src="./images/login/wo.jpg" width="100%" height="420px"></div>
			<!--右侧登录-->
			<div class="main_right">
				 <form action="loginServlet" method="post">
					<div style="height:80px;">
						<div style="height:15px;"></div>
						<div id="msg" class="errmsg"></div>
					</div>
					<div class="main_left_username">账号：</div>
					<div class="main_left_login">
						<input type="text" id="userName" name ="username" placeholder="用户名/管理员账号" style="width:100%; height:38px; padding-left:5px;" value="" control-id="ControlID-1">
					</div>
					<div style="height:20px;"></div>
					<div class="main_left_password">密码：</div>
					<div class="main_left_login">
						<input type="password" id="pwd" name = "password" placeholder="密码" style="width:100%; height:38px; padding-left:5px;" value="" control-id="ControlID-2">
					</div>
					<div style="height:20px;"></div>
					<div class="main_left_login">
						<div class="main_left_automaticLogon"><input type="checkbox" id="checkboxID" name="checkboxID" checked="checked" control-id="ControlID-3">下次自动登录</div>
						<div class="main_left_forgetPassword"><a href="Forgot_password.jsp" target="_blank">忘记密码？</a></div>
					</div>
					<div class="main_left_login">
						<input type="submit" style="width:100%; height:40px; background:#C00; color:#FFF; border:1px solid #F63; font-size:18px; font-weight:500; font-weight:bold;" value="登录" control-id="ControlID-4">
					</div>
					<div style="height:35px;"></div>
					<hr style="border:5px solid #EEE; width:80%; text-align:center;">
					<div style="text-align:left; margin-left:10%; font-size:14px;">
						<div style="height:23px; color:#999;">使用合作网站登录：</div>
						<div><a href =''>QQ</a>&nbsp;|&nbsp;<a href="">微信</a>&nbsp;|&nbsp;<a>邮箱</a></div>
					</div>
				</form>
			</div>
		</div>
		<!--版权-->
		<div class="footer">
			&nbsp;<a href="#" target="_blank">关于我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">联系我们</a>&nbsp;|&nbsp;<a href="#" target="_blank">商家入驻</a>&nbsp;|&nbsp;<a href="#" target="_blank">营销中心</a>&nbsp;|&nbsp;<a href="#" target="_blank">友情链接</a>&nbsp;|&nbsp;<a href="#" target="_blank">网上商城社区</a>&nbsp;<br>
			Copyright© ZZZhuo 2022-2023，All Rights Reserved
		</div>
	</div>
</html>