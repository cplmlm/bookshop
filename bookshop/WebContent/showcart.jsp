<%@page import="cn.edu.svtcc.bookshop.entity.Books"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>Free CSS template Collect from Cssmoban.com</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--[if lte IE 6]><link rel="stylesheet" href="css/ie6.css" type="text/css" media="all" /><![endif]-->
	
	<meta name="keywwords" content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />
	<meta name="description" content="Shop Around - Great free html template for on-line shop. Use it as a start point for your on line business. The template can be easily implemented in many open source E-commerce platforms" />
	
	<!-- JS -->
	<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>	
	<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>	
	<script src="js/jquery-func.js" type="text/javascript"></script>	
	<!-- End JS -->
	<style type="text/css">
    .div1{position:absolute;display:none;}
    .div2{position:absolute;display:block;}
     .div3{position:absolute;display:block;}
    </style>
</head>
<body>
	
<!-- Shell -->	
<div class="shell">
	
	<!-- Header -->	
	<div id="header">
		<h1 id="logo"><a href="#">shoparound</a></h1>	
		
		<!-- Cart -->
		<div id="cart">
			<a href="CartServlet?opt=show" class="cart-link">购物车</a>
							

		</div>
		<!-- End Cart -->
		
		<!-- Navigation -->
		<div id="navigation">
			<ul>
			     <li><a href="index.jsp">首页</a></li>
			    <li><a href="login.jsp">登录</a></li>
			    <li><a href="register.jsp">注册</a></li>
              <li><a href="OrderServlet?opt=showOrder&userId=${sessionScope.user.id }">我的订单</a></li>
			</ul>
		</div>
		<!-- End Navigation -->
	</div>
	<!-- End Header -->
	<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>
	<!-- Main -->
	<div id="main">
		<div class="cl">&nbsp;</div>
		
		<!-- Content -->
		<div id="content">
			

			<!-- End Content Slider -->
			
			<!-- Products -->
			<div class="products">
				<c:if test="${sessionScope.silist==null}">
您还没有添加善品到购物车！
</c:if>
		<c:if test="${sessionScope.silist!=null }"></c:if>
   <center>购物车明细</center><br>
<table>
<tr>
<td>商品名</td>
<td>单价</td>
<td>数量</td>
<td>小计</td>
<td>删除</td>
</tr>
<c:forEach items="${sessionScope.silist }"  var="s">
<tr>
<td>${s.item.title }</td>
<td>${s.item.unitPrice }</td>

<td>
<a href="CartServlet?opt=less&isbn=${s.item.isbn}">-</a>&nbsp;&nbsp;
<input type="text" value="${s.amount } " size="1" >
&nbsp;&nbsp;<a href="CartServlet?opt=increase&isbn=${s.item.isbn}">+</a>
</td>

<td>${s.item.unitPrice*s.amount}</td>
<td><a href="CartServlet?opt=del&isbn=${s.item.isbn}">删除</a></td>
</tr>
</c:forEach>
</table>
购物车商品总价：${sessionScope.total}<br>
<a href="CartServlet?opt=clear">清空购物车</a>

<a href="OrderServlet?opt=add&userId=${sessionScope.user.id}">确认订单</a>
</div>
			
			
			
			<!-- End Products -->
			
		</div>
		<!-- End Content -->
		
		<!-- Sidebar -->
		<div id="sidebar">
			
			<!-- Search -->
			<div class="box search">
				<h2><span></span></h2>
				<div class="box-content">
					<form action="" method="post">
	<form action="BookServlet?opt=byTitle" method="post">
						书名：<input type="text" name="title"> <input
							type="submit" value="搜索">
					</form><br>
					<form action="BookServlet?opt=byIsbn" method="post">
						ISBN：<input type="text" name="isbn"> <input
							type="submit" value="搜索">
					</form>
		
						

	
					</form>
				</div>
			</div>
			<!-- End Search -->
			
			<!-- Categories -->
			<div class="box categories">
				<h2>全部图书分类 <span></span></h2>
				<div class="box-content">
					<ul>
								<form method="get" id="form1">
				<c:if test="${applicationScope.clist!=null}">
					<c:forEach items="${applicationScope.clist}" var="c">
						<li><a href="BookServlet?opt=ByCategory&id=${c.id}">${c.name}
						</a></li>
					</c:forEach>
				</c:if>
			</form>
					</ul>
				</div>
			</div>
			<!-- End Categories -->
			
		</div>
		<!-- End Sidebar -->
		
		<div class="cl">&nbsp;</div>
	</div>
	<!-- End Main -->
	
	<!-- Side Full -->
	<div class="side-full">
		
		<!-- More Products -->
		<div class="more-products">
			<div class="more-products-holder">
				<ul>
				    <li><a href="#"><img src="css/images/1.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/2.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/3.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/4.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/5.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/6.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/7.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/1.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/2.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/3.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/4.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/5.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/6.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/7.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/1.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/2.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/3.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/4.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/5.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/6.jpg" alt="" /></a></li>
				    <li class="last"><a href="#"><img src="css/images/7.jpg" alt="" /></a></li>
				</ul>
			</div>
			<div class="more-nav">
				<a href="#" class="prev">previous</a>
				<a href="#" class="next">next</a>
			</div>
		</div>
		<!-- End More Products -->
		

	<div class="cols">
			<div class="cl">&nbsp;</div>
			<div class="col">
				<h2>购物指南</h2><br>
			
				<p>免费注册</p>
				<p>开通支付宝</p>
				<p>支付宝充值</p>
			</div>
			<div class="col">
				<h2>购物保障</h2><br>
				<p>发票保障</p>
				<p>售后规则</p>
				<p>缺货赔付</p>
			</div>
			<div class="col">
				<h2>支付方式</h2><br>
				<p>快捷支付</p>
				<p>支付宝</p>
				<p>信用卡</p>
				<p>货到付款</p>
			</div>
			<div class="col col-last">
				<h2>卖家服务</h2><br>
				<p>卖家入驻</p>
				<p>卖家中心</p>
				<p>店铺规则</p>
				<p>物流服务</p>
				<p>运营服务</p>
			</div>
			<div class="cl">&nbsp;</div>
		</div>
	</div>
	
	<!-- Footer -->
	<div id="footer">
	
		<p class="right">
			&copy; 2010 Shop Around.
			Collect form <a href="http://www.cssmoban.com" target="_blank" title="The Sweetest CSS Templates WorldWide">225工作室</a>
		</p>
	</div>
	<!-- End Footer -->
	
</div>	
<!-- End Shell -->
	
	
</body>
</html>