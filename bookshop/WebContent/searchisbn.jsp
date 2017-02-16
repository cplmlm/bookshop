<%@page import="cn.edu.svtcc.bookshop.entity.Books"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="BookServlet?opt=byIsbn" method="post">
请输入ISBN：<input type="text" name="isbn">
<input type="submit" value="查询">
</form>

<%
//获取book的值
   Books b=(Books)session.getAttribute("b");
if(b!=null){%>

  <table>
   <tr>
   <td>书名</td><td>ISBN</td><td>单价</td>
   </tr>
		   <tr>
		   <td> <%=b.getTitle() %></td>
		     <td><%=b.getIsbn() %></td>
		   <td> <%=b.getUnitPrice() %></td>
		    </tr>
		    <% 
}
%>
</body>
</html>