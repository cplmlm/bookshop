package cn.edu.svtcc.bookshop.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;

public class BookDao {
	DataSource ds;
	public BookDao(){
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
}}
