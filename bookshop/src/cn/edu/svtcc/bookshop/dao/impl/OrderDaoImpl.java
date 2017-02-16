package cn.edu.svtcc.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.svtcc.bookshop.entity.Books;
import cn.edu.svtcc.bookshop.entity.Orders;
import cn.edu.svtcc.bookshop.entity.OrderBook;
import cn.edu.svtcc.bookshop.entity.OrderBookCustom;
import cn.edu.svtcc.bookshop.db.DataBase;

public class OrderDaoImpl {
	DataBase db;

	public OrderDaoImpl() {
		db = new DataBase();
	}

	public int addOrder(Orders order) {
		//得到连接
		Connection con = db.getConnection();

		String sql = "insert into orders(orderDate,userId,totalPrice)" + " value(CURRENT_TIMESTAMP(),?,?)";
		PreparedStatement stmt = null;
		try {
			//
			stmt = con.prepareStatement(sql);
			//
			stmt.setInt(1, order.getUserId());
			stmt.setDouble(2, order.getTotlePrice());
			//
			int row = stmt.executeUpdate();
			if (row > 0) {
				//
				ResultSet rs = stmt.executeQuery("select LAST_INSERT_ID()");
				if (rs.next())
					//
					return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
		return -1;
	}

	/**
	 * 
	 * @param orderBook
	 * @return
	 */
	public boolean addOrderBook(OrderBook orderBook) {
		//
		Connection con = db.getConnection();
		//
		String sql = "insert into orderbook(orderId,bookId,quantity,unitPrice)" + " value(?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			//
			stmt = con.prepareStatement(sql);
			//
			stmt.setInt(1, orderBook.getOrderId());
			stmt.setInt(2, orderBook.getBookId());
			stmt.setInt(3, orderBook.getQuantity());
			stmt.setDouble(4, orderBook.getUnitPrice());
			//
			int rs = stmt.executeUpdate();
			if (rs > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<OrderBookCustom> getAllOrders(int userId) {
		List<OrderBookCustom> olist = new ArrayList<OrderBookCustom>();
		//
		Connection con = db.getConnection();
		//
		String sql = "SELECT orderbook.*,orders.OrderDate,books.Title FROM orders,orderbook,books WHERE orderbook.OrderID=orders.Id AND orderbook.BookID=books.Id AND orders.UserId="
				+ userId;
		try {
			//
			PreparedStatement stmt = con.prepareStatement(sql);
			//
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//
				OrderBookCustom obc = new OrderBookCustom();

				obc.setOrderId(rs.getInt(2));
				obc.setBookId(rs.getInt(3));
				obc.setQuantity(rs.getInt(4));
				obc.setUnitPrice(rs.getDouble(5));
				obc.setOrderDate(rs.getString(6));
				obc.setTitle(rs.getString(7));
				olist.add(obc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olist;
	}
}