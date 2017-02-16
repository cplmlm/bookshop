package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.svtcc.bookshop.dao.impl.CategoriesDaoImpl;
import cn.edu.svtcc.bookshop.dao.impl.UserDaoImpl;
import cn.edu.svtcc.bookshop.entity.Categories;
import cn.edu.svtcc.bookshop.entity.Users;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt=request.getParameter("opt");
		//访问CategoriesDaoImpl类中的getCategories方法
		CategoriesDaoImpl cdao=new CategoriesDaoImpl();
		List<Categories>clist=cdao.getCategories();
		//把种类绑到session
		request.getSession().setAttribute("clist", clist);
		if(opt.equals("login")){
		   doLogin(request,response);
		}
		if(opt.equals("register")){
			doRegister(request,response);
		}
		}
	protected void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取用户输入的注册信息
		String loginId=request.getParameter("loginId");
		String loginPwd=request.getParameter("loginPwd");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String mail=request.getParameter("mail");
		Users u = new Users(loginId, loginPwd, name, address, phone, mail, 1, 1);
		//2.调用UserDaoImpl中的addUser方法
		UserDaoImpl dao=new UserDaoImpl();
		boolean result=dao.addUser(u);
		//3.根据addUser方法返回值决定页面的跳转
		if(result){
			response.sendRedirect("login.jsp");
		}
		else{
			response.sendRedirect("register.jsp");
		}
	}
	
		protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//1.接收用户输入的用户名和密码
			String name=request.getParameter("loginId");
			String pwd=request.getParameter("loginPwd");
			//2.调用UserDaoImpl中的doLogin方法
			UserDaoImpl dao=new UserDaoImpl();
			Users user=dao.doLogin(name, pwd);
			//3.根据doLogin方法的返回值，进行页面跳转
			if(user!=null){
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}
			else{
				response.sendRedirect("login.jsp");
			}
		}
	}
		


