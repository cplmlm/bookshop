package cn.edu.svtcc.bookshop.dao;

import java.util.List;


import cn.edu.svtcc.bookshop.entity.OrderBook;
import cn.edu.svtcc.bookshop.entity.OrderBookCustom;
import cn.edu.svtcc.bookshop.entity.Orders;
public interface IOrderDao {
	//��Ӷ���
	public int addOrder(Orders order);
	//��Ӷ�������
	public boolean addOrderBook(OrderBook orderBook) ;
	//�õ����ж�����Ϣ
	 public List<OrderBookCustom> getAllOrders(int UserId);
}
