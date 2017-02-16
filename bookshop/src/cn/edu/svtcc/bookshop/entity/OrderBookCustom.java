package cn.edu.svtcc.bookshop.entity;
import java.io.Serializable;
/**
 * 订单明细表扩展类
 * @author Ctony
 *
 */
public class OrderBookCustom extends OrderBook implements Serializable{
    /*扩展字段*/
    //下单时间
    private String orderDate;
    //书名
    private String title;
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
