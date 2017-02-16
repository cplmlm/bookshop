package cn.edu.svtcc.bookshop.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cn.edu.svtcc.bookshop.listener.DataSourceProvider;
public class DataBase {
	String driverName;
	String url;
	String userName;
	String pwd;
	Properties p;
	public DataBase(){
		p=new Properties();
		InputStream in=DataBase.class.getResourceAsStream("db.properties");
		try {
			try {
				p.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driverName=p.getProperty("driverName");
			url=p.getProperty("url");
			userName=p.getProperty("userName");
			pwd=p.getProperty("pwd");
			//加载驱动
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 得到一个连接
	 * @return
	 */
public Connection getConnection(){
		try {
			return DriverManager.getConnection(url, userName, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 释放连接
	 * @param con
	 */
	public void CloseConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*DataSource ds;
	public DataBase(){
	try{
		Context ctx=new InitialContext();
		ds=(DataSource)ctx.lookup("java:com/env/jdbc/dbpooling");
	}catch(NamingException e){
		e.printStackTrace();
	}
	ds=DataSourceProvider.getInstance().getDataSource();
}
public Connection getConnection(){
		try{
			return ds.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
}*/
	/*DataSource ds;
	public DataBase(){
		try {
			Context ctx=new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/dbpooling");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
}
