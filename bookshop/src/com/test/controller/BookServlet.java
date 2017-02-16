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

	// ����������ѯ
	protected void queryByTitle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡͼ������
		String bname = request.getParameter("title");
		// ����BookDaoImpl�е�getBooksByTitle����
		BookDaoImpl dao = new BookDaoImpl();
		List<Books> blist = dao.getBooksByTitle(bname);
		// ��blist����session��ȥ
		request.getSession().setAttribute("blist", blist);
		// ҳ����ת(��ʾͼ����Ϣҳ��)
		response.sendRedirect("index.jsp");
	}

	// ����ISBN��ѯ
	protected void queryByIsbn(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡISBN
		String isbn = request.getParameter("isbn");
		// ����BookDaoImpl�е�getBooksByISBN����
		BookDaoImpl dao = new BookDaoImpl();
		Books bk = dao.getBooksByIsbn(isbn);
		System.out.println("isbn" + isbn);
		// ��b�ŵ�session��ȥ
		request.getSession().setAttribute("bk", bk);
		// ҳ����ת(��ʾͼ����Ϣҳ��)
		response.sendRedirect("index.jsp");
	}

	// �������ѯ
	protected void queryByCategoryId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡͼ������
		int bcate = Integer.parseInt(request.getParameter("id"));
		// ����BookDaoImpl�е�getBooksByTitle����
		BookDaoImpl dao = new BookDaoImpl();
		List<Books> clist = dao.getBooksByCategoryId(bcate);
		// ��clist�ŵ�session��ȥ
		request.getSession().setAttribute("blist", clist);
		// ҳ����ת(��ʾͼ����Ϣҳ��)
		response.sendRedirect("index.jsp");
	}
}
