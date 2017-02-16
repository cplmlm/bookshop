package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.svtcc.bookshop.dao.impl.CategoriesDaoImpl;
import cn.edu.svtcc.bookshop.entity.Categories;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(name = "InitServlet", urlPatterns = { "/InitServlet" }, loadOnStartup = 0)
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 调用Model的方法
		CategoriesDaoImpl dao = new CategoriesDaoImpl();
		List<Categories> clist = dao.getCategories();
		config.getServletContext().setAttribute("clist", clist);
	}

}
