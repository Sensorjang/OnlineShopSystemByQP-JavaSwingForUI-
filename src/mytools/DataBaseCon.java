package mytools;

import java.sql.*;

/*
 * �������ݿ����� ������
 */


public class DataBaseCon {
	public static final String driverClass ="com.mysql.jdbc.Driver";   //����
	public static final String username="root";               //�û���
	public static final String password="meiyoumima1710lj";            //����
	public static final String url="jdbc:mysql://localhost:3306/Myshop?useUnicode=true&characterEncoding=utf-8&useSSL=false";  //���ݿ��ַ
	/*
	 * ��ȡMysql���ݿ�����
	 */
	public Connection getCon(){           //�������Ӷ���
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
	
	public void closeConn(Connection conn) throws Exception{                //�Ͽ�����
		conn.close();
		System.out.println("���ӶϿ�!");
	}
	
	public static void main(String[] args) {
		DataBaseCon baseobj=new DataBaseCon();
		try {
			baseobj.getCon();
			System.out.println("���ӳɹ�!");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
