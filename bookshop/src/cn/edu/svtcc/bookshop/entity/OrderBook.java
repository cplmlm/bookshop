package cn.edu.svtcc.bookshop.entity;
import java.io.Serializable;

public class OrderBook implements Serializable {
	    private int orderId;
	    private int bookId;
	    private int quantity;
	    private double unitPrice;

	    public int getOrderId() {
	        return orderId;
	    }
	    public void setOrderId(int orderId) {
	        this.orderId = orderId;
	    }
	    public int getBookId() {
	        return bookId;
	    }
	    public void setBookId(int bookId) {
	        this.bookId = bookId;
	    }
	    public int getQuantity() {
	        return quantity;
	    }
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	    public double getUnitPrice() {
	        return unitPrice;
	    }
	    public void setUnitPrice(double unitPrice) {
	        this.unitPrice = unitPrice;
	        
	    }

}
