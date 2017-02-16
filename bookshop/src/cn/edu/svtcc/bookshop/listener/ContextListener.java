package cn.edu.svtcc.bookshop.listener;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;

import javax.servlet.ServletContextListener;
import javax.sql.*;

public class ContextListener implements ServletContextListener {
	/**
	 * ��webӦ�ó�������ʱ���ر�����
	 * 
	 */
		@Override
		public void contextDestroyed(ServletContextEvent arg0) {
			// TODO Auto-generated method stub
			DataSource ds=DataSourceProvider.getInstance().getDataSource();
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * ������������ʱ����ø�����Դ������
		 * 
		 */

		@Override
		public void contextInitialized(ServletContextEvent arg0) {
			// TODO Auto-generated method stub
			Context ctx;
			try {
				ctx = new InitialContext();
				DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dbpooling");
				DataSourceProvider.getInstance().initDataSource(ds);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("webӦ�ó�������");
			
		}
}
