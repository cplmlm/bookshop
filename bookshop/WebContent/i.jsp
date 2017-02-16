<%@page import="cn.edu.svtcc.bookshop.entity.Books"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    .div1{position:absolute;display:none;}
    .div2{position:absolute;display:block;}
     .div3{position:absolute;display:block;}
    </style>


</head>
<body >
	<div>
		<div style="float: left; width: 15%">
			<form method="get" id="form1">
				<c:if test="${applicationScope.clist!=null}">
					<c:forEach items="${applicationScope.clist}" var="c">
						<li><a href="BookServlet?opt=ByCategory&id=${c.id}">${c.name}
						</a></li>
					</c:forEach>
				</c:if>
			</form>
		</div>
		
			<div style="float: right; width: 85%">
				<div style="height: 15%">
					<form action="BookServlet?opt=byTitle" method="post">
						请输入图书名称：<input type="text" name="title"> <input
							type="submit" value="查询">
					</form>
					<form action="BookServlet?opt=byIsbn" method="post">
						请输入ISBN：<input type="text" name="isbn"> <input
							type="submit" value="查询">
					</form>
					<a href="CartServlet?opt=show">查看购物车</a>

				</div>
				<div style="height: 85%">
				<!--种类查询  -->
<div class="div">
						<c:if test="${sessionScope.blist!=null}">
							<table>
								<tr>
									<td>书名</td>
									<td>作者</td>

									<td>购买</td>
								</tr>
								<c:forEach items="${sessionScope.blist}" var="b">
									<tr>
										<td>${b.title}</td>
										<td>${b.author}</td>
										<td><a href="CartServlet?opt=add&isbn=${b.isbn}">购买</a></td>
									</tr>
								</c:forEach>
							</table>
						</c:if>
						</div>

<!-- ISBN查询 -->
<div class="div1">
					<%
						//获取book的值
						Books b = (Books) session.getAttribute("b");
						if (b != null) {
					%>

					<table>
						<tr>
						
							<td>书名</td>
							<td>ISBN</td>
							<td>单价</td>
						</tr>
						<tr>
							<td><%=b.getTitle()%></td>
							<td><%=b.getIsbn()%></td>
							<td><%=b.getUnitPrice()%></td>
						</tr>
						<%
							}
						%>
						</table>
</div>
						</div>
				</div>
</body>
</html>
