package com.test.controller;

import java.io.IOException;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.svtcc.bookshop.dao.impl.OrderDaoImpl;
import cn.edu.svtcc.bookshop.entity.OrderBook;
import cn.edu.svtcc.bookshop.entity.OrderBookCustom;
import cn.edu.svtcc.bookshop.entity.Orders;
import cn.edu.svtcc.bookshop.shoppingcart.ShoppingCart;
import cn.edu.svtcc.bookshop.shoppingcart.ShoppingItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String opt = request.getParameter("opt");
		if (opt.equals("add")) {
			addOrder(request, response);
		}
		if (opt.equals("showOrder")) {
			showOrder(request, response);

		}
	}

	/**
	 * ��Ӷ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��session�е�cart(���ﳵ)����
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		// ��ȡ��jspҳ�洫������userId
		int userId = Integer.parseInt(request.getParameter("userId"));
		// ����ȡ�����ݷ�װ��Orders����
		Orders order = new Orders();
		order.setUserId(userId);
		order.setTotlePrice(cart.getTotalReal());
		// ����dao����Ӷ�������
		OrderDaoImpl dao = new OrderDaoImpl();
		int orderId = dao.addOrder(order);
		// ������صĶ���Id��Ϊ-1,���ʾ��Ӷ����ɹ�
		if (orderId != -1) {
			// ��ȡ���ﳵ�е�����ͼ������
			Collection<ShoppingItem> silist = cart.getItems();
			// ����ÿһ��ͼ��
			for (ShoppingItem item : silist) {
				// ��װ��OrderBook����
				OrderBook ob = new OrderBook();
				ob.setOrderId(orderId);
				ob.setBookId(item.getItem().getId());
				ob.setQuantity(item.getAmount());
				ob.setUnitPrice(item.getItem().getUnitPrice());
				// ��ӵ���ϸ��
				dao.addOrderBook(ob);
			}
			// ��չ��ﳵ
			request.getSession().removeAttribute("cart");
			// ҳ����ת
			response.sendRedirect("order.jsp");
		} else {
			// ҳ����ת
			response.sendRedirect("showcart.jsp");
		}

	}

	/**
	 * �鿴����
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��jspҳ�洫������userId
		int userId = Integer.parseInt(request.getParameter("userId"));

		// ����dao��Ļ�ȡ��������
		OrderDaoImpl dao = new OrderDaoImpl();
		List<OrderBookCustom> olist = dao.getAllOrders(userId);

		// ��ӵ�session��
		request.getSession().setAttribute("olist", olist);
		// ҳ����ת
		response.sendRedirect("showorder.jsp");
	}

}
