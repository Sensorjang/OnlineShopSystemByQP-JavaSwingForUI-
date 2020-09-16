package AccessObj;


import java.sql.*;

import View.AdminChgInfo;
import model.Admin;
import model.Info;

/*
 * Admin表访问对象
 */

public class AdminObj extends BaseObj {
	/*
	 * 登陆操作
	 */
	public Admin login(Admin admin) {              //返回一个admin对象
		
		Admin adminrs=null;               //创建返回类型空对象
		
		String sql="select * from admin where account=? and password=?";
		try {
			PreparedStatement prep=conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			prep.setString(1, admin.getAccount());
			prep.setString(2, admin.getPassword());
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				adminrs =new Admin();
				adminrs.setAccount(rs.getString("account"));             //返回admin对象的account 
				adminrs.setCreatedate(rs.getString("createdate"));
				adminrs.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {                                       //断开连接
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return adminrs;
	}
	
	/*
	 * 修改密码操作
	 */
	public String editpwd(Admin admin,String newpwd,String oldpwd) {
		String sql="select * from admin where account=? and password=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			prep.setString(1, admin.getAccount());
			prep.setString(2, oldpwd);
			ResultSet rs=prep.executeQuery();
			if(!rs.next()) {
				String rstr="原密码错误！";
				return rstr;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rstr="修改失败！";
		String sql2="update admin set password=? where account=?";           
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql2);            //sql语句--》数据库操作对象
			prep.setString(1, newpwd);
			prep.setString(2, admin.getAccount());
			int rst= prep.executeUpdate();
			if(rst > 0) {
				rstr="修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rstr;
	}
	
	/*
	 * 读取信息操作
	 */
	public Info readinfo(String acc) {
		
		Info admininfors= null;           //返回一个info对象
		
		String sql="select * from admininfo where account=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
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
	 * 修改信息操作
	 */
	public String writeinfo(String acc,String name,String age,String gender,String tel,String email) {
		String rss="修改失败！";
		String sql="select * from admininfo where account=?";
		String sql2="update admininfo set name=?,age=?,gender=?,tel=?,email=? where account=?";
		String sql3="insert into admininfo values('?','?','?','?','?'','?')";
			try {
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
				prep.setString(1, acc);
				ResultSet rs=prep.executeQuery();
				
				if(rs.next()) {
					PreparedStatement prep2=null;
					prep2 =conn.prepareStatement(sql2);            //sql语句--》数据库操作对象
					prep2.setString(1, name);
					prep2.setString(2, age);
					prep2.setString(3, gender);
					prep2.setString(4, tel);
					prep2.setString(5, email);
					prep2.setString(6, acc);
					int rst= prep2.executeUpdate();
					if(rst > 0)rss="修改成功！";
				}else {
					PreparedStatement prep3=null;
					prep3 =conn.prepareStatement(sql3);            //sql语句--》数据库操作对象
					prep3.setString(1, acc);
					prep3.setString(2, name);
					prep3.setString(3, age);
					prep3.setString(4, gender);
					prep3.setString(5, tel);
					prep3.setString(6, email);
					int rst= prep3.executeUpdate();
					if(rst > 0)rss="信息已完善！";
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rss;
			
	}
	
	/*
	 * 注销账户操作
	 */
	public String deleteadmin(String acc) {
		String rss="";
		String sql="delete from admin where account=?";
		String sql2="delete from admininfo where account=?";
		
		try {
			PreparedStatement prep=null;
			PreparedStatement prep2=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			prep2 =conn.prepareStatement(sql2); 
			prep.setString(1, acc);
			prep2.setString(1, acc);
			int result =prep.executeUpdate();
			int result2 =prep2.executeUpdate();
			if(result>0 && result2>0)rss="注销完成！";
			else rss="注销失败！";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rss;
	}
}
