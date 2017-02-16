
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
	 * ���캯�������ڳ�ʼ�����ﳵ�����ﳵ�е�����
	 */
	public ShoppingCart(){
		super();
		items=new HashMap<String,ShoppingItem>();
		itemAmount=0;
	}
	/**
	 * �����ﳵ�����ͼ��
	 * @param isbn:���ͼ���ISBN
	 * @param book:Ҫ��ӵ�ͼ��
	 * @param num:Ҫ��ӵ�ͼ�������
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
	 * @param ��ȡ���ﳵ�����е�ͼ��
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
	 * @return ���㹺�ﳵ�����е�ͼ���ܼ�
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
	 * ��չ��ﳵ
	 */
	public void clear(){
		items.clear();
		itemAmount=0;
	}
	public synchronized ShoppingItem getItem(String isbn){
		return items.get(isbn);
	}
}
