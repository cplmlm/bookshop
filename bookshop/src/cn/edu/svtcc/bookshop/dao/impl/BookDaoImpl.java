package cn.edu.svtcc.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.svtcc.bookshop.dao.IBookDao;
import cn.edu.svtcc.bookshop.db.DataBase;
import cn.edu.svtcc.bookshop.entity.Books;

public class BookDaoImpl implements IBookDao {
DataBase db;
public BookDaoImpl(){
	db=new DataBase();
}
//��������ѯ
	@Override
	public List<Books> getBooksByTitle(String title) {
		List<Books> blist=new ArrayList<Books>();
		//�õ�����
	Connection con=db.getConnection();
	String sql="select *" +
	           "  from books" +
			   "  where title like'%"+title+"%'";
	try {
		//�������
		PreparedStatement stmt=con.prepareStatement(sql);
		//ִ�����
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			Books b=new Books();
			b.setId(rs.getInt(1));
			b.setTitle(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPublisherId(rs.getInt(4));
			b.setPublisherDate(rs.getString(5));
			b.setIsbn(rs.getString(6));
			b.setWordsCount(rs.getInt(7));
			b.setUnitPrice(rs.getDouble(8));
			b.setContentDescription(rs.getString(9));
			b.setAuthorDescription(rs.getString(10));
			b.setEditorComment(rs.getString(11));
			b.setToc(rs.getString(12));
			b.setCategoryId(rs.getInt(13));
			b.setClicks(rs.getInt(14));	
			blist.add(b);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return blist;
	}
//�������ѯ
	@Override
	public List<Books> getBooksByCategoryId(int categoryId) {
		List<Books> blist=new ArrayList<Books>();
		//�õ�����
	Connection con=db.getConnection();
	String sql="select *  from books  where CategoryId=?";
	
	try {
	//�������
	PreparedStatement stmt=con.prepareStatement(sql);
	//���ò���
	stmt.setInt(1, categoryId);
	ResultSet rs=stmt.executeQuery();
	while(rs.next()){
		Books b=new Books();
		b.setId(rs.getInt(1));
		b.setTitle(rs.getString(2));
		b.setAuthor(rs.getString(3));
		b.setPublisherId(rs.getInt(4));
		b.setPublisherDate(rs.getString(5));
		b.setIsbn(rs.getString(6));
		b.setWordsCount(rs.getInt(7));
		b.setUnitPrice(rs.getDouble(8));
		b.setContentDescription(rs.getString(9));
		b.setAuthorDescription(rs.getString(10));
		b.setEditorComment(rs.getString(11));
		b.setToc(rs.getString(12));
		b.setCategoryId(rs.getInt(13));
		b.setClicks(rs.getInt(14));
		blist.add(b);
	}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return blist;
	}
    //��ISBN��ѯ
	@Override
	public Books getBooksByIsbn(String isbn) {
		//�õ�����
		Connection con=db.getConnection();
		String sql="select *" +
		           "  from books" +
				   "  where isbn=?";
		Books b=new Books();
		try {
			//�������
			PreparedStatement stmt=con.prepareStatement(sql);
			//���ò���
			stmt.setString(1, isbn);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisherId(rs.getInt(4));
				b.setPublisherDate(rs.getString(5));
				b.setIsbn(rs.getString(6));
				b.setWordsCount(rs.getInt(7));
				b.setUnitPrice(rs.getDouble(8));
				b.setContentDescription(rs.getString(9));
				b.setAuthorDescription(rs.getString(10));
				b.setEditorComment(rs.getString(11));
				b.setToc(rs.getString(12));
				b.setCategoryId(rs.getInt(13));
				b.setClicks(rs.getInt(14));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return b;
		}
	
	
	public String getBookNamebyId(int id) {
		Connection con=db.getConnection();
		String sql="select Title from books where Id="+id;
		try{
			
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){
			String bookName=rs.getString(1);
			return bookName;
		}
		return null;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;

	}
	}

	
