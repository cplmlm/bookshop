
package cn.edu.svtcc.bookshop.shoppingcart;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import cn.edu.svtcc.bookshop.entity.Books;
public class ShoppingCart implements Serializable {
	private HashMap<String,ShoppingItem> items;
	private int itemAmount;
	/**
	 * 构造函数：用于初始化购物车及购物车中的数量
	 */
	public ShoppingCart(){
		super();
		items=new HashMap<String,ShoppingItem>();
		itemAmount=0;
	}
	/**
	 * 往购物车中添加图书
	 * @param isbn:添加图书的ISBN
	 * @param book:要添加的图书
	 * @param num:要添加的图书的数量
	 */
	public synchronized void add(String isbn,Books book,int num){
		if(items.containsKey(isbn)){
			items.remove(isbn);
			ShoppingItem newitem=new ShoppingItem(book,num);
			items.put(isbn,newitem);
		}else{
			ShoppingItem newitem=new ShoppingItem(book,num);
			items.put(isbn, newitem);
			itemAmount++;
		}
	}
	public synchronized void remove(String isbn){
		if(items.containsKey(isbn)){
			items.remove(isbn);
		}
	}
	/**
	 * @param 获取购物车中所有的图书
	 */
	public synchronized Collection<ShoppingItem> getItems(){
		return items.values();
	}
	
	protected void finalize(){
		items.clear();
	}
	
	public synchronized int getItemAmount(){
		return itemAmount;
	}


	/**
	 * @return 计算购物车中所有的图书总价
	 */
	public synchronized double getTotalReal(){
		double total=0.0;
		Iterator<ShoppingItem> it;
		for(it=getItems().iterator();it.hasNext();){
			ShoppingItem si=it.next();
			Books book=si.getItem();
			total+=book.getUnitPrice()*si.getAmount();
		}
		return total;
	}
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		items.clear();
		itemAmount=0;
	}
	public synchronized ShoppingItem getItem(String isbn){
		return items.get(isbn);
	}
}
