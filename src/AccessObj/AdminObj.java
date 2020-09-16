package AccessObj;


import java.sql.*;

import View.AdminChgInfo;
import model.Admin;
import model.Info;

/*
 * Admin����ʶ���
 */

public class AdminObj extends BaseObj {
	/*
	 * ��½����
	 */
	public Admin login(Admin admin) {              //����һ��admin����
		
		Admin adminrs=null;               //�����������Ϳն���
		
		String sql="select * from admin where account=? and password=?";
		try {
			PreparedStatement prep=conn.prepareStatement(sql);            //sql���--�����ݿ��������
			prep.setString(1, admin.getAccount());
			prep.setString(2, admin.getPassword());
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				adminrs =new Admin();
				adminrs.setAccount(rs.getString("account"));             //����admin�����account 
				adminrs.setCreatedate(rs.getString("createdate"));
				adminrs.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {                                       //�Ͽ�����
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return adminrs;
	}
	
	/*
	 * �޸��������
	 */
	public String editpwd(Admin admin,String newpwd,String oldpwd) {
		String sql="select * from admin where account=? and password=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
			prep.setString(1, admin.getAccount());
			prep.setString(2, oldpwd);
			ResultSet rs=prep.executeQuery();
			if(!rs.next()) {
				String rstr="ԭ�������";
				return rstr;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rstr="�޸�ʧ�ܣ�";
		String sql2="update admin set password=? where account=?";           
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql2);            //sql���--�����ݿ��������
			prep.setString(1, newpwd);
			prep.setString(2, admin.getAccount());
			int rst= prep.executeUpdate();
			if(rst > 0) {
				rstr="�޸ĳɹ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rstr;
	}
	
	/*
	 * ��ȡ��Ϣ����
	 */
	public Info readinfo(String acc) {
		
		Info admininfors= null;           //����һ��info����
		
		String sql="select * from admininfo where account=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
			prep.setString(1, acc);
			ResultSet rs=prep.executeQuery();
			
			if(rs.next()) {
				admininfors =new Info();
				admininfors.setAccount(rs.getString("account"));
				admininfors.setName(rs.getString("name"));
				admininfors.setAge(rs.getString("age"));
				admininfors.setGender(rs.getString("gender"));
				admininfors.setTel(rs.getString("tel"));
				admininfors.setEmail(rs.getString("email"));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admininfors;
		
	}
	
	/*
	 * �޸���Ϣ����
	 */
	public String writeinfo(String acc,String name,String age,String gender,String tel,String email) {
		String rss="�޸�ʧ�ܣ�";
		String sql="select * from admininfo where account=?";
		String sql2="update admininfo set name=?,age=?,gender=?,tel=?,email=? where account=?";
		String sql3="insert into admininfo values('?','?','?','?','?'','?')";
			try {
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
				prep.setString(1, acc);
				ResultSet rs=prep.executeQuery();
				
				if(rs.next()) {
					PreparedStatement prep2=null;
					prep2 =conn.prepareStatement(sql2);            //sql���--�����ݿ��������
					prep2.setString(1, name);
					prep2.setString(2, age);
					prep2.setString(3, gender);
					prep2.setString(4, tel);
					prep2.setString(5, email);
					prep2.setString(6, acc);
					int rst= prep2.executeUpdate();
					if(rst > 0)rss="�޸ĳɹ���";
				}else {
					PreparedStatement prep3=null;
					prep3 =conn.prepareStatement(sql3);            //sql���--�����ݿ��������
					prep3.setString(1, acc);
					prep3.setString(2, name);
					prep3.setString(3, age);
					prep3.setString(4, gender);
					prep3.setString(5, tel);
					prep3.setString(6, email);
					int rst= prep3.executeUpdate();
					if(rst > 0)rss="��Ϣ�����ƣ�";
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rss;
			
	}
	
	/*
	 * ע���˻�����
	 */
	public String deleteadmin(String acc) {
		String rss="";
		String sql="delete from admin where account=?";
		String sql2="delete from admininfo where account=?";
		
		try {
			PreparedStatement prep=null;
			PreparedStatement prep2=null;
			prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
			prep2 =conn.prepareStatement(sql2); 
			prep.setString(1, acc);
			prep2.setString(1, acc);
			int result =prep.executeUpdate();
			int result2 =prep2.executeUpdate();
			if(result>0 && result2>0)rss="ע����ɣ�";
			else rss="ע��ʧ�ܣ�";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rss;
	}
}
