package cn.edu.svtcc.bookshop.entity;
import java.io.Serializable;
/**
 * ������ϸ����չ��
 * @author Ctony
 *
 */
public class OrderBookCustom extends OrderBook implements Serializable{
    /*��չ�ֶ�*/
    //�µ�ʱ��
    private String orderDate;
    //����
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
