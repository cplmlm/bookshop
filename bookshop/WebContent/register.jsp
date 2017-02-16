<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>

<title>注册</title>
<meta charset="UTF-8">
<meta name="keywords" content="注册页面模板,网站注册页面,注册模板页面,网站模板,注册页面表单验证">
<meta name="description" content="JS代码网提供大量的注册页面模板的学习和下载">
<link type="text/css" href="theme/css/v3/reset.css" rel="stylesheet">
<link type="text/css" href="theme/css/v3/public.css" rel="stylesheet">
<link type="text/css" href="theme/css/v3/register.css" rel="stylesheet">
<link rel="shortcut icon" href="favicon.ico" />
<script src="theme/js/jquery.min.js" type="text/javascript"></script>
<script src="theme/js/jquery.form.js" type="text/javascript"></script>
<script src="theme/js/json.parse.js" type="text/javascript"></script>

<script type="text/javascript">
//验证用户名
function checkna(){
	na=form1.loginId.value;
  	if( na.length <8 || na.length >12)  
		{  	
			divname.innerHTML='<font class="tips_false">长度是8~12个字符</font>';
		     
		}else{  
		    divname.innerHTML='<font class="tips_true">输入正确</font>';		   
		}  
}
//验证密码 
function checkpsd1(){    
	psd1=form1.loginPwd.value;  
	var flagZM=false ;
	var flagSZ=false ; 
	var flagQT=false ;
	if(psd1.length<6 || psd1.length>12){   
		divpassword1.innerHTML='<font class="tips_false">长度为6-12个字符</font>';
	}else
		{   
		  for(i=0;i < psd1.length;i++)   
			{    
				if((psd1.charAt(i) >= 'A' && psd1.charAt(i)<='Z') || (psd1.charAt(i)>='a' && psd1.charAt(i)<='z')) 
				{   
					flagZM=true;
				}
				else if(psd1.charAt(i)>='0' && psd1.charAt(i)<='9')    
				{ 
					flagSZ=true;
				}else    
				{ 
					flagQT=true;
				}   
			}   
			if(!flagZM||!flagSZ||flagQT){
			divpassword1.innerHTML='<font class="tips_false">密码必须是字母数字的组合</font>'; 
			 
			}else{
				
			divpassword1.innerHTML='<font class="tips_true">输入正确</font>';
			 
			}  
		 
		}	
}
//验证确认密码 
function checkpsd2(){ 
		if(form1.loginPwd.value!=form1.yourpass2.value) { 
		     divpassword2.innerHTML='<font class="tips_false">您两次输入的密码不一样</font>';
		} else { 
		     divpassword2.innerHTML='<font class="tips_true">输入正确</font>';
		}
}
//验证邮箱

function checkmail(){
			apos=form1.mail.value.indexOf("@");
			dotpos=form1.mail.value.lastIndexOf(".");
			if (apos<1||dotpos-apos<2) 
			  {
			  	divmail.innerHTML='<font class="tips_false">输入错误</font>' ;
			  }
			else {
				divmail.innerHTML='<font class="tips_true">输入正确</font>' ;
			}
}
//电话号码验证
function checkMobile() {
	var sMobile = form1.phone.value
	if (!(/^((\+?86)|(\(\+86\)))?\d{3,4}-\d{7,8}(-\d{3,4})?$|^((\+?86)|(\(\+86\)))?1\d{10}$/
			.test(sMobile))) {
		divphone.innerHTML = '<font class="tips_false">请检查电话号码</font>';
	} else {
		divphone.innerHTML = '<font class="tips_true">输入正确</font>';
	}
}
</script>
<style type="text/css">
		.tips{
			color: rgba(0, 0, 0, 0.5);
			padding-left: 10px;
		}
		.tips_true,.tips_false{
			padding-left: 10px;
		}
		.tips_true{
			color: green;
		}
		.tips_false{
			color: red;
		}
</style>
<!--[if IE 6]>
<script src="themes/js/DD_belatedPNG.js"  type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png_bg');</script>
<![endif]-->
</head>
<body>
	<div id="header">
		<div class="header">
		
			<a class="png_bg" href="index.jsp">返回主页</a>
		</div>
	</div>
	
	<div class="register_content">
	
		<ul class="step_ul step1 clear">
			<li class="li1">欢迎注册</li>
			<li class="li2"></li>
		</ul>
		
		 <form name="form1" method="post" id='registerForm' action="UserServlet?opt=register" style="padding:60px 40px 88px 40px;font-family:Microsoft Yahei">
			<div class="div_form clear ">
				<label>用户名：</label>
				<div class="input_div input_div5">
					<input id="username" name="loginId" placeholder="请输入用户名"  onblur="checkna()" required/><span class="tips" id="divname">长度8~12个字符</span>
			
				</div>
			</div>
			<div class="div_form clear ">
				<label>密码：</label>
				<div class="input_div input_div5" >
					<input id="username" type="password" name="loginPwd" placeholder="请输入你的密码" onblur="checkpsd1()" required/><span class="tips" id="divpassword1">密码必须由字母和数字组成</span>
			
				</div>
			</div>
			<div class="div_form clear ">
				<label>确认密码：</label>
				<div class="input_div input_div5">
					<input id="username" type="password" name="yourpass2" placeholder="请再次输入你的密码" onblur="checkpsd2()" required/><span class="tips" id="divpassword2">两次密码需要相同</span>
				
				</div>
			</div>
			<div class="div_form clear ">
				<label>姓名：</label>
				<div class="input_div input_div4">
					<input id="username" type="text" name="name" placeholder="请输入你的真实姓名">
				
				</div>
			</div>
			<div class="div_form clear ">
				<label>家庭地址：</label>
				<div class="input_div input_div5">
					<input id="username" type="text" name="address" placeholder="请输入你的家庭地址" >
			
				</div>
			</div>
			<div class="div_form clear ">
				<label>电话号码：</label>
				<div class="input_div input_div5">
					<input id="username" type="text" name="phone" placeholder="请输入电话号码"  onblur="checkMobile()" required/><span class="tips" id="divphone">如18482100778或0818-6902090</span>
				
				</div>
			</div>
			<div class="div_form clear ">
				<label>email：</label>
				<div class="input_div input_div5">
					<input id="username" type="text" name="mail" placeholder="请输入邮箱"  onblur="checkmail()" required/><span class="tips" id="divmail">如865007010@qq.com</span>
				
				</div>
			</div>
			<div class="div_form clear ">
				<label>用户角色：</label>
				<div class="input_div input_div5">
					<input id="username" type="text" name="userRoleId" placeholder="请输入用户角色"  >
				
				</div>
			</div>
			<div class="div_form clear ">
				<label>用户权限：</label>
				<div class="input_div input_div5">
					<input id="username" type="text" name="userStateId" placeholder="请输入用户权限" >
				
				</div>
			</div>
            
			<div class="div_form clear ">
				<label></label>
				<div class="input_div">
					<input id="btn" class="btn" type="submit" value="注册" />
				</div>
			</div>
			
		</form>
		
		<div class="reg_login">
			<p>已有帐号？</p>
			<a class="btn2" href="login.jsp">登录</a>
		</div>
		<div class="bg"></div>
	</div>
	
	<!-- footer start -->
<div id="footer" class="clear">

    <div class="friendLink clear">
        <a  href="#" target="_blank" title="隐私政策" rel="nofollow">隐私政策</a>
        <a href="#" target="_blank" rel="nofollow">服务条款</a>
        <a href="#" target="_blank" rel="nofollow">关于我们</a>
        <a href="#" target="_blank" rel="nofollow">js代码招聘</a>
        <a href="#" target="_blank" rel="nofollow">联系我们</a>
        <a href="#" target="_blank" rel="nofollow">友情链接</a>
    </div>
    <p>Copyright © 2004-2016 Shop Around.com 版权所有</p>
    <div class="weixin">
 
    </div>
</div>
<script type="text/javascript">
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F5d12e2b4eed3b554ae941c0ac43c330a' type='text/javascript'%3E%3C/script%3E"));
</script>
<!-- footer end -->
</body>
</html>
















    