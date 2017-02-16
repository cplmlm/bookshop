package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import cn.edu.svtcc.bookshop.dao.impl.BookDaoImpl;
import cn.edu.svtcc.bookshop.entity.Books;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if (opt.equals("byTitle")) {
			queryByTitle(request, response);
		}
		if (opt.equals("byIsbn")) {
			queryByIsbn(request, response);
		}
		if (opt.equals("ByCategory")) {
			queryByCategoryId(request, response);
		}
	}

	// 按照书名查询
	protected void queryByTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取图书名称
		String bname = request.getParameter("title");
		// 调用BookDaoImpl中的getBooksByTitle方法
		BookDaoImpl dao = new BookDaoImpl();
		List<Books> blist = dao.getBooksByTitle(bname);
		// 把blist方到session中去
		request.getSession().setAttribute("blist", blist);
		// 页面跳转(显示图书信息页面)
		response.sendRedirect("index.jsp");
	}

	// 按照ISBN查询
	protected void queryByIsbn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取ISBN
		String isbn = request.getParameter("isbn");
		// 调用BookDaoImpl中的getBooksByISBN方法
		BookDaoImpl dao = new BookDaoImpl();
		Books bk = dao.getBooksByIsbn(isbn);
		System.out.println("isbn" + isbn);
		// 把b放到session中去
		request.getSession().setAttribute("bk", bk);
		// 页面跳转(显示图书信息页面)
		response.sendRedirect("index.jsp");
	}

	// 按种类查询
	protected void queryByCategoryId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取图书名称
		int bcate = Integer.parseInt(request.getParameter("id"));
		// 调用BookDaoImpl中的getBooksByTitle方法
		BookDaoImpl dao = new BookDaoImpl();
		List<Books> clist = dao.getBooksByCategoryId(bcate);
		// 把clist放到session中去
		request.getSession().setAttribute("blist", clist);
		// 页面跳转(显示图书信息页面)
		response.sendRedirect("index.jsp");
	}
}
