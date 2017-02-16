 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<title>大气带JS表单验证功能的登录页面模板 - JS代码网</title>
<meta charset="UTF-8">
<meta name="keywords" content="网站模板,登录页面模板,登陆页面模板,登录界面模板,登录页面表单验证">
<meta name="description" content="JS代码网提供大量的登录页面模板的学习和下载">
<link type="text/css" href="themes/css/v3/reset.css" rel="stylesheet">
<link type="text/css" href="themes/css/v3/public.css" rel="stylesheet">
<link type="text/css" href="themes/css/v3/register.css" rel="stylesheet">
<link rel="shortcut icon" href="favicon.ico" />
<script src="themes/js/jquery.min.js" type="text/javascript"></script>
<script src="themes/js/jquery.form.js" type="text/javascript"></script>
<script src="themes/js/json.parse.js" type="text/javascript"></script>
<style>
	.loginad{
		width:580px;
		height:595px;
		position: absolute;
	}
	.loginad .loginadtitle{
		width:100%;
		text-align:center;
		line-height:60px;
		font-size:32px;
		font-family:"幼圆",Microsoft Yahei;
		margin-top:70px;
		color:#FFF;
	}
	.loginad .loginaddes{
		line-height:30px;
		color:#FFF;
		font-family:Microsoft Yahei;
		font-size:16px;
		text-align:center
	}
	.loginad .loginadimg{
		width:100%; 
		height:320px;
		margin-top:40px;
		
	}
	.loginad .loginadbtn{ width:100%; height:40px; margin-top:30px; }
	.loginad .loginadbtn a{ display:block; width:190px; height:40px; margin:0 auto; text-align:center; line-height:40px; font-size:16px; color:#009fe3; font-weight:bold; background:url(/themes/images/v3/btn.png) center center no-repeat;
		-moz-border-radius:6px;
		-khtml-border-radius:6px;
		-webkit-border-radius:6px;
		border-radius:6px;
	}
</style>
</head>
<body>
	<div id="header">
		<div class="header">
			<a href="index.jsp">返回主页</a>
		</div>
	</div>	
	
	<div class="login_bg">
		<div class="form">
        	<div class="loginad">
            	<div class="loginadtitle"></div>
                <div class="loginaddes"></div>
                <div class="loginadbtn"><a  href="docs/api/id/59" target="_blank">马上查看</a></div>
                <div class="loginadimg" style="background:url('http://img.juhe.cn/www/news/201407/3275043504%20.png') center center no-repeat"></div>
            </div>
			
			<form name="loginForm" id="login_form" method="post" action="UserServlet?opt=login">
				<h2>登录</h2>
				<div class="div_user"><span></span><input  name="loginId" class="username" type="text" placeholder="用户名" /></div>
				<div class="div_pw"><span></span><input class="pw" name="loginPwd" type="password" placeholder="密码" /></div>
				<div class="div_box">
					<label><input type="checkbox" class="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下次自动登录</label>
		<a class="forgetPw" href="forget">忘记密码？</a>						</div>
				<div><input class="login_btn"   type="submit" value="登录" /></div>
                <div style="line-height:30px; text-indent:5px;color:#F30" id="loginTips">&nbsp;</div>
				<a  href="register.jsp">立即注册</a>					
					</form>
		</div>
	</div>
	
	
<!-- footer start -->
<div id="footer" class="clear">
 
    <div class="friendLink clear">
        <a  href="#" target="_blank" title="隐私政策" rel="nofollow">隐私政策</a>
        <a href="#" target="_blank" rel="nofollow">服务条款</a>
        <a href="#" target="_blank" rel="nofollow">关于我们</a>
        <a href="#" target="_blank" rel="nofollow">人员招聘</a>
        <a href="#" target="_blank" rel="nofollow">联系我们</a>
        <a href="#" target="_blank" rel="nofollow">友情链接</a>
    </div>
    <p>Copyright © 2004-2016 Shop Around.com 版权所有</p>
    <div class="weixin">
            </div>
</div>
</body>
</html>
















