package cn.edu.svtcc.bookshop.shoppingcart;

import java.io.Serializable;

import cn.edu.svtcc.bookshop.entity.Books;

public class ShoppingItem implements Serializable {
private  Books item;
private int amount=0;
public ShoppingItem(Books newBook,int num){
	super();

	if(num>0){
		item=newBook;amount=num;
	}
}
public Books getItem() {
	return item;
}
public void setItem(Books item) {
	this.item = item;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int inAmount(){
	return amount++;
}
public int deAmount(){
	return amount--;
}
}
