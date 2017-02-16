package cn.edu.svtcc.bookshop.dao.impl;

import java.sql.*;

import cn.edu.svtcc.bookshop.dao.IUserDao;
import cn.edu.svtcc.bookshop.db.DataBase;
import cn.edu.svtcc.bookshop.entity.Users;

public class UserDaoImpl implements IUserDao {
	DataBase db;

	public UserDaoImpl() {
		db = new DataBase();
	}

	@Override
	public Users doLogin(String name, String pwd) {
		Connection con = db.getConnection();
		String sql = "select * from users " + "where LoginId=? and LoginPwd=?";
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Users user = new Users();
				user.setId(rs.getInt(1));
				user.setLoginId(rs.getString(2));
				user.setLoginPwd(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhone(rs.getString(6));
				user.setMail(rs.getString(7));
				user.setUserRoleId(rs.getInt(8));
				user.setUserStateId(rs.getInt(9));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(Users u) {
		// 得到连接
		Connection con = db.getConnection();
		String sql = "insert into Users" + " (loginId,loginPwd,name,address,phone,mail,userRoleId,userStateId)"
				+ " values(?,?,?,?,?,?,1,1)";
		// 创建语句
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, u.getLoginId());
			stmt.setString(2, u.getLoginPwd());
			stmt.setString(3, u.getName());
			stmt.setString(4, u.getAddress());
			stmt.setString(5, u.getPhone());
			stmt.setString(6, u.getMail());
			// 执行语句
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 释放连接
		finally {

		}
		return false;
	}

}
