package cn.edu.svtcc.bookshop.entity;

import java.io.Serializable;

public class Books implements Serializable {
	private int id;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
private String title;
private String author;
private int publisherId;
private String publisherDate;
private String isbn;
private int wordsCount;
private Double unitPrice;
private String contentDescription;
private String authorDescription;
private String editorComment;
private String toc;
private int categoryId;
private int clicks;
private int bookId;
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getPublisherId() {
	return publisherId;
}
public void setPublisherId(int publisherId) {
	this.publisherId = publisherId;
}
public String getPublisherDate() {
	return publisherDate;
}
public void setPublisherDate(String publisherDate) {
	this.publisherDate = publisherDate;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public int getWordsCount() {
	return wordsCount;
}
public void setWordsCount(int wordsCount) {
	this.wordsCount = wordsCount;
}
public Double getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(Double unitPrice) {
	this.unitPrice = unitPrice;
}
public String getContentDescription() {
	return contentDescription;
}
public void setContentDescription(String contentDescription) {
	this.contentDescription = contentDescription;
}
public String getAuthorDescription() {
	return authorDescription;
}
public void setAuthorDescription(String authorDescription) {
	this.authorDescription = authorDescription;
}
public String getEditorComment() {
	return editorComment;
}
public void setEditorComment(String editorComment) {
	this.editorComment = editorComment;
}
public String getToc() {
	return toc;
}
public void setToc(String toc) {
	this.toc = toc;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public int getClicks() {
	return clicks;
}
public void setClicks(int clicks) {
	this.clicks = clicks;
}



}
