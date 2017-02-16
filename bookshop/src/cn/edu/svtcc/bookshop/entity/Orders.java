package cn.edu.svtcc.bookshop.entity;

public class Orders {
private int id;
private String orderDate;
private int userId;
private double totlePrice;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public double getTotlePrice() {
	return totlePrice;
}
public void setTotlePrice(double totlePrice) {
	this.totlePrice = totlePrice;
}

}
