package cn.edu.svtcc.bookshop.listener;

import javax.sql.*;

public class DataSourceProvider {
	private DataSource ds;
	private static DataSourceProvider instance;
	private DataSourceProvider()
	{}
	/**
	 * �õ���ģʽ�����DataSourceProvider��ʵ��
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
	/**��ʼ��DataSourceʵ��
	 * @param ds
	 */
	 public void initDataSource(DataSource ds)
	 {
		 this.ds=ds;
	 }
	 /**
	  * �õ�һ��DataSource
	  * @return
	  * 
	  */
	 public DataSource getDataSource()
	 {
		 return ds;		 
	 }
}
