<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="user" class="cn.edu.svtcc.bookshop.entity.Users"
	scope="session" />
<jsp:useBean id="dao"
	class="cn.edu.svtcc.bookshop.dao.impl.UserDaoImpl" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty property="*" name="user"/>
<%
		if (dao.addUser(user)) {
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%
		} else {
	%>
	<jsp:forward page="doRegister.jsp"></jsp:forward>
	<%
		}
	%>
</body>
</html>