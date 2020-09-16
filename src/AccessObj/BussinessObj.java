package AccessObj;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Admin;
import model.Bussiness;
import model.User;
import model.Info;

public class BussinessObj extends BaseObj {
	/*
	 * 登陆操作
	 */
	public Bussiness login(Bussiness bussiness) {              //返回一个Business对象
		
		Bussiness bussinessrs=null;               //创建返回类型空对象
		
		String sql="select * from bussiness where account=? and password=?";
		try {
			PreparedStatement prep=conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			prep.setString(1, bussiness.getAccount());
			prep.setString(2, bussiness.getPassword());
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				bussinessrs =new Bussiness();
				bussinessrs.setAccount(rs.getString("account"));             //返回Bussiness对象的account 
				bussinessrs.setCreatedate(rs.getString("createdate"));
				bussiness.setPassword(rs.getString("password"));
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
		return bussinessrs;
		
	}
	
	/*
	 * 注册操作
	 */
	
	public boolean register(Bussiness bussiness) {
		boolean foundflag=true;                      
		try {                        
			String sql="select account from bussiness where account=?";               //判断是否为合法的注册操作
			PreparedStatement prep=conn.prepareStatement(sql); 
			prep.setString(1, bussiness.getAccount());
			ResultSet rs=prep.executeQuery();
			if(rs.next())foundflag=false;
			if(foundflag==true)
			{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String now = formatter.format(new Date());
				String sql2="insert into bussiness values('"+bussiness.getAccount()+"','"+bussiness.getPassword()+"','"+now+"')";
				String sql3="insert into bussinessinfo values('"+bussiness.getAccount()+"',null,null,null,null,null)";
				String sql4="insert into bussinessbalance values('"+bussiness.getAccount()+"','0')";
				
				java.sql.Statement state=conn.createStatement();  
				state.executeUpdate(sql2);                             //sql语句--》数据库操作对象
				state.executeUpdate(sql3); 
				state.executeUpdate(sql4); 
			 
				Bussiness bussinesstest=this.login(bussiness);
				if(bussinesstest!=null)return true;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	/*
	 * 修改密码操作
	 */
	public String editpwd(Bussiness bussiness,String newpwd,String oldpwd) {
		String sql="select * from bussiness where account=? and password=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			prep.setString(1, bussiness.getAccount());
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
		String sql2="update bussiness set password=? where account=?";           
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql2);            //sql语句--》数据库操作对象
			prep.setString(1, newpwd);
			prep.setString(2, bussiness.getAccount());
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
		
		Info bussinessinfors = null;          //返回一个info对象
		
		String sql="select * from bussinessinfo where account=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			prep.setString(1, acc);
			ResultSet rs=prep.executeQuery();
			
			if(rs.next()) {
				bussinessinfors =new Info();
				bussinessinfors.setAccount(rs.getString("account"));
				bussinessinfors.setName(rs.getString("name"));
				bussinessinfors.setAge(rs.getString("age"));
				bussinessinfors.setGender(rs.getString("gender"));
				bussinessinfors.setTel(rs.getString("tel"));
				bussinessinfors.setEmail(rs.getString("email"));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bussinessinfors;
		
	}
	
	/*
	 * 修改信息操作
	 */
	public String writeinfo(String acc,String name,String age,String gender,String tel,String email) {
		String rss="修改失败！";
		String sql="select * from bussinessinfo where account=?";
		String sql2="update bussinessinfo set name=?,age=?,gender=?,tel=?,email=? where account=?";
		String sql3="insert into bussinessinfo values('?','?','?','?','?'','?')";
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
	public String deletebussiness(String acc) {
		String rss="";
		String sql="delete from bussiness where account=?";
		String sql2="delete from bussinessinfo where account=?";
		String sql3="delete from bussinessbalance where account=?";
		String sql4="delete from commodity where publisher=?";
		
		try {
			PreparedStatement prep=null;
			PreparedStatement prep2=null;
			PreparedStatement prep3=null;
			PreparedStatement prep4=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			prep2 =conn.prepareStatement(sql2); 
			prep3 =conn.prepareStatement(sql3);
			prep4 =conn.prepareStatement(sql4);
			prep.setString(1, acc);
			prep2.setString(1, acc);
			prep3.setString(1, acc);
			prep4.setString(1, acc);
			int result =prep.executeUpdate();
			int result2 =prep2.executeUpdate();
			int result3 =prep3.executeUpdate();
			int result4 =prep4.executeUpdate();
			if(result>0 && result2>0 && result3>0)rss="注销完成！";
			else rss="注销失败！";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rss;
	}
}
