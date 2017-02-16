package cn.edu.svtcc.bookshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.svtcc.bookshop.dao.ICategoriesDao;
import cn.edu.svtcc.bookshop.db.DataBase;
import cn.edu.svtcc.bookshop.entity.Books;
import cn.edu.svtcc.bookshop.entity.Categories;

public class CategoriesDaoImpl implements ICategoriesDao {
	DataBase db;

	public CategoriesDaoImpl() {
		db = new DataBase();
	}

	/**
	 * ��ͼ��������ѯ
	 */
	@Override
	public List<Categories> getCategories() {
		// ����һ��������
		List<Categories> clist = new ArrayList<Categories>();
		// �õ�����
		Connection con = db.getConnection();
		String sql = "select * from categories";
		// �������
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			// �������
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categories c = new Categories();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				clist.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ���ؽ��
		return clist;
		
	}

	@Override
	public boolean addCategory(Categories c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(Categories c) {
		// TODO Auto-generated method stub
		return false;
	}

}
