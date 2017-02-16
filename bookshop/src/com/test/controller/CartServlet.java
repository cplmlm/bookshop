package com.test.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.svtcc.bookshop.dao.impl.BookDaoImpl;
import cn.edu.svtcc.bookshop.entity.Books;
import cn.edu.svtcc.bookshop.shoppingcart.ShoppingCart;
import cn.edu.svtcc.bookshop.shoppingcart.ShoppingItem;

/**
 * Servlet implementation class CartSevrvlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if (opt.equals("add")) {
			addCart(request, response);
		}
		if (opt.equals("buy")) {
			buyCart(request, response);
		}
		if (opt.equals("show")) {
			showCart(request, response);
		}
		if (opt.equals("del")) {
			delCart(request, response);
		}
		if (opt.equals("clear")) {
			clearCart(request, response);
		}
		if (opt.equals("less")) {
			lessAmount(request, response);
		}
		if (opt.equals("increase")) {
			inAmount(request, response);
		}
	}

	/**
	 * 将商品见添加到购物车
	 */
	protected void addCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		BookDaoImpl bdao = new BookDaoImpl();
		Books b = bdao.getBooksByIsbn(isbn);
		request.getSession().setAttribute("b", b);
		response.sendRedirect("buy.jsp");
	}

	/**
	 * 购买图书
	 */
	protected void buyCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中取购物车对象cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// 判断数量是够为空
		if (cart == null) {
			cart = new ShoppingCart();
		}
		// 获取购买的数量
		int num = Integer.parseInt(request.getParameter("num"));
		// 获取购买的图书
		String isbn = request.getParameter("isbn");
		BookDaoImpl bdao = new BookDaoImpl();
		Books b = bdao.getBooksByIsbn(isbn);
		// 把商品添加到购物车
		cart.add(isbn, b, num);
		// 把购物车放到session
		request.getSession().setAttribute("cart", cart);
		// 页面跳转
		response.sendRedirect("index.jsp");
	}

	/**
	 * 显示购物车信息
	 */
	protected void showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中取购物车对象cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		if (cart != null) {
			// 调用getItems方法
			Collection<ShoppingItem> silist = cart.getItems();
			// 把购物车的ShoppingItem放入session
			request.getSession().setAttribute("silist", silist);
			// 获得价格总和
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			response.sendRedirect("showcart.jsp");
		}

	}

	/**
	 * 删除购物车中商品
	 */
	protected void delCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中取购物车对象cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// 判空
		if (cart != null) {
			// 获得删除图书的ISBN
			String isbn = request.getParameter("isbn");
			// 删除这个图书
			if (isbn != null && !isbn.equals("")) {
				cart.remove(isbn);
			}
			// 把修改后的购物车的对象放入session
			request.getSession().setAttribute("cart", cart);
			// 获得价格总和
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// 页面跳转
			response.sendRedirect("showcart.jsp");
		}
	}

	/**
	 * 清空购物车
	 */
	protected void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中取购物车对象cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// 判空
		if (cart != null) {
			// 清楚购物车信息
			cart.clear();
			// 把修改后的购物车的对象放入session
			request.getSession().setAttribute("cart", cart);
			// 获得价格总和
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// 页面跳转
			response.sendRedirect("showcart.jsp");
		}
	}

	/**
	 * 增加数量
	 */
	protected void inAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中取购物车对象cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// 判空
		if (cart != null) {
			// 获得删除图书的ISBN
			String isbn = request.getParameter("isbn");
			// 添加一本这个图书
			ShoppingItem items = cart.getItem(isbn);
			if (items != null) {
				items.inAmount();

			}
			// 把修改后的购物车的对象放入session
			request.getSession().setAttribute("cart", cart);
			// 获得价格总和
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// 页面跳转
			response.sendRedirect("showcart.jsp");
		}
	}

	/**
	 * 减少商品数量
	 */
	protected void lessAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从session中取购物车对象cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// 判空
		if (cart != null) {
			// 获得删除图书的ISBN
			String isbn = request.getParameter("isbn");
			// 添加一本这个图书
			ShoppingItem items = cart.getItem(isbn);
			if (items != null && items.getAmount() > 1) {
				items.deAmount();
			}
			// 把修改后的购物车的对象放入session
			request.getSession().setAttribute("cart", cart);
			// 获得价格总和
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// 页面跳转
			response.sendRedirect("showcart.jsp");
		}
	}
}
