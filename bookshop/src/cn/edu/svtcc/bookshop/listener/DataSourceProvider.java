package cn.edu.svtcc.bookshop.listener;

import javax.sql.*;

public class DataSourceProvider {
	private DataSource ds;
	private static DataSourceProvider instance;
	private DataSourceProvider()
	{}
	/**
	 * 用单例模式来获得DataSourceProvider的实例
	 * @return
	 */
	public static DataSourceProvider getInstance()
	{
		if(instance==null)
		{
			instance=new DataSourceProvider();
		}
		return instance;		
	}
	/**初始化DataSource实例
	 * @param ds
	 */
	 public void initDataSource(DataSource ds)
	 {
		 this.ds=ds;
	 }
	 /**
	  * 得到一个DataSource
	  * @return
	  * 
	  */
	 public DataSource getDataSource()
	 {
		 return ds;		 
	 }
}
