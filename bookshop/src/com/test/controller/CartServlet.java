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
	 * ����Ʒ����ӵ����ﳵ
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
	 * ����ͼ��
	 */
	protected void buyCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��session��ȡ���ﳵ����cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// �ж������ǹ�Ϊ��
		if (cart == null) {
			cart = new ShoppingCart();
		}
		// ��ȡ���������
		int num = Integer.parseInt(request.getParameter("num"));
		// ��ȡ�����ͼ��
		String isbn = request.getParameter("isbn");
		BookDaoImpl bdao = new BookDaoImpl();
		Books b = bdao.getBooksByIsbn(isbn);
		// ����Ʒ��ӵ����ﳵ
		cart.add(isbn, b, num);
		// �ѹ��ﳵ�ŵ�session
		request.getSession().setAttribute("cart", cart);
		// ҳ����ת
		response.sendRedirect("index.jsp");
	}

	/**
	 * ��ʾ���ﳵ��Ϣ
	 */
	protected void showCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��session��ȡ���ﳵ����cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		if (cart != null) {
			// ����getItems����
			Collection<ShoppingItem> silist = cart.getItems();
			// �ѹ��ﳵ��ShoppingItem����session
			request.getSession().setAttribute("silist", silist);
			// ��ü۸��ܺ�
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			response.sendRedirect("showcart.jsp");
		}

	}

	/**
	 * ɾ�����ﳵ����Ʒ
	 */
	protected void delCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��session��ȡ���ﳵ����cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// �п�
		if (cart != null) {
			// ���ɾ��ͼ���ISBN
			String isbn = request.getParameter("isbn");
			// ɾ�����ͼ��
			if (isbn != null && !isbn.equals("")) {
				cart.remove(isbn);
			}
			// ���޸ĺ�Ĺ��ﳵ�Ķ������session
			request.getSession().setAttribute("cart", cart);
			// ��ü۸��ܺ�
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// ҳ����ת
			response.sendRedirect("showcart.jsp");
		}
	}

	/**
	 * ��չ��ﳵ
	 */
	protected void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��session��ȡ���ﳵ����cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// �п�
		if (cart != null) {
			// ������ﳵ��Ϣ
			cart.clear();
			// ���޸ĺ�Ĺ��ﳵ�Ķ������session
			request.getSession().setAttribute("cart", cart);
			// ��ü۸��ܺ�
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// ҳ����ת
			response.sendRedirect("showcart.jsp");
		}
	}

	/**
	 * ��������
	 */
	protected void inAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��session��ȡ���ﳵ����cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// �п�
		if (cart != null) {
			// ���ɾ��ͼ���ISBN
			String isbn = request.getParameter("isbn");
			// ���һ�����ͼ��
			ShoppingItem items = cart.getItem(isbn);
			if (items != null) {
				items.inAmount();

			}
			// ���޸ĺ�Ĺ��ﳵ�Ķ������session
			request.getSession().setAttribute("cart", cart);
			// ��ü۸��ܺ�
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// ҳ����ת
			response.sendRedirect("showcart.jsp");
		}
	}

	/**
	 * ������Ʒ����
	 */
	protected void lessAmount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��session��ȡ���ﳵ����cart
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// �п�
		if (cart != null) {
			// ���ɾ��ͼ���ISBN
			String isbn = request.getParameter("isbn");
			// ���һ�����ͼ��
			ShoppingItem items = cart.getItem(isbn);
			if (items != null && items.getAmount() > 1) {
				items.deAmount();
			}
			// ���޸ĺ�Ĺ��ﳵ�Ķ������session
			request.getSession().setAttribute("cart", cart);
			// ��ü۸��ܺ�
			double total = cart.getTotalReal();
			request.getSession().setAttribute("total", total);
			// ҳ����ת
			response.sendRedirect("showcart.jsp");
		}
	}
}
