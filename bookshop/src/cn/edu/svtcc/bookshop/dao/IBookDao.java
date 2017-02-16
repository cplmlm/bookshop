package cn.edu.svtcc.bookshop.dao;

import java.util.List;

import cn.edu.svtcc.bookshop.entity.Books;

public interface IBookDao {
   //����������ѯ
	public List<Books>getBooksByTitle(String title);
	//�������ѯ
	public List<Books>getBooksByCategoryId(int categoryId );
	//��Isbn��ѯ
	public Books getBooksByIsbn(String isbn);
	//��ȡ����  ����id
	public String getBookNamebyId(int  id);
}
