package mytools;

import java.sql.*;

/*
 * 建立数据库连接 工具类
 */


public class DataBaseCon {
	public static final String driverClass ="com.mysql.jdbc.Driver";   //驱动
	public static final String username="root";               //用户名
	public static final String password="meiyoumima1710lj";            //密码
	public static final String url="jdbc:mysql://localhost:3306/Myshop?useUnicode=true&characterEncoding=utf-8&useSSL=false";  //数据库地址
	/*
	 * 获取Mysql数据库连接
	 */
	public Connection getCon(){           //返回连接对象
		try {
			Class.forName(driverClass).newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public void closeConn(Connection conn) throws Exception{                //断开操作
		conn.close();
		System.out.println("连接断开!");
	}
	
	public static void main(String[] args) {
		DataBaseCon baseobj=new DataBaseCon();
		try {
			baseobj.getCon();
			System.out.println("连接成功!");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
