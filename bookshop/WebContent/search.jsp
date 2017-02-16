<%@page import="java.util.List"%>
<%@page import="cn.edu.svtcc.bookshop.entity.Books"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BookServlet?opt=byTitle" method="post">
		请输入图书名称：<input type="text" name="title"> <input type="submit"
			value="查询">
	</form>
	<c:if test="${sessionScope.blist!=null}">
		<table>
			<tr>
				<td>书名</td>
				<td>单价</td>
			</tr>
			<c:forEach items="${sessionScope.blist}" var="b">
				<tr>
					<td>${b.title }</td>
					<td>${b.unitPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>