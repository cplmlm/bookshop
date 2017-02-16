package cn.edu.svtcc.bookshop.dao;

import java.util.List;

import cn.edu.svtcc.bookshop.entity.Books;

public interface IBookDao {
   //按照书名查询
	public List<Books>getBooksByTitle(String title);
	//按种类查询
	public List<Books>getBooksByCategoryId(int categoryId );
	//按Isbn查询
	public Books getBooksByIsbn(String isbn);
	//获取书名  根据id
	public String getBookNamebyId(int  id);
}
