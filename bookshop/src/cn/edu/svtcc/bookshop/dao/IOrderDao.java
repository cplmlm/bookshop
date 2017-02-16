package cn.edu.svtcc.bookshop.dao;

import java.util.List;


import cn.edu.svtcc.bookshop.entity.OrderBook;
import cn.edu.svtcc.bookshop.entity.OrderBookCustom;
import cn.edu.svtcc.bookshop.entity.Orders;
public interface IOrderDao {
	//添加订单
	public int addOrder(Orders order);
	//添加订单详情
	public boolean addOrderBook(OrderBook orderBook) ;
	//得到所有订单信息
	 public List<OrderBookCustom> getAllOrders(int UserId);
}
