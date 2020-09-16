package AccessObj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceObj extends BaseObj {
	/*
	 * 余额获取
	 */
	public String readbalance(String type,String acc) {
		String rsnum="";
		if("User".equals(type)) {
			String sql = "select * from userbalance where account='"+acc+"'";               //sql语句--》数据库操作对象
			PreparedStatement prep;
			try {
				prep = conn.prepareStatement(sql);
				ResultSet rs=prep.executeQuery();
				if(rs.next())rsnum = rs.getString("balance");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}            
			
		}else {
			String sql = "select * from bussinessbalance where account='"+acc+"'";               //sql语句--》数据库操作对象
			PreparedStatement prep;
			try {
				prep = conn.prepareStatement(sql);
				ResultSet rs=prep.executeQuery();
				if(rs.next())rsnum = rs.getString("balance");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}            
		}
		return rsnum;
	}
	/*
	 * 余额充值
	 */
	public String recharge(String type,String acc,int i) {
		String rss="充值失败！";
		int rsbalance = 0;
		if("User".equals(type)) {
			String sql = "select * from userbalance where account='"+acc+"'";
			try {
				PreparedStatement prep=null;
				prep = conn.prepareStatement(sql);
				ResultSet rs=prep.executeQuery();
				if(rs.next())rsbalance =  Integer.parseInt(rs.getString("balance"))+i;
				PreparedStatement prep2=null;
				String sql2 = "update userbalance set balance='"+rsbalance+"' where account='"+acc+"'";
				prep2 = conn.prepareStatement(sql2);
				int rst= prep2.executeUpdate();
				if(rst > 0 && i>0) rss="用户【"+acc+"】充值成功！";
				if(rst > 0 && i<=0) rss="用户【"+acc+"】消费成功！";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rss;
		}else {
				String sql = "select * from bussinessbalance where account='"+acc+"'";
				try {
					PreparedStatement prep=null;
					prep = conn.prepareStatement(sql);
					ResultSet rs=prep.executeQuery();
					if(rs.next())rsbalance = Integer.parseInt(rs.getString("balance"))+i;
					PreparedStatement prep2=null;
					String sql2 = "update bussinessbalance set balance='"+rsbalance+"' where account='"+acc+"'";
					prep2 = conn.prepareStatement(sql2);
					int rst= prep2.executeUpdate();
					if(rst > 0) rss="商家【"+acc+"】充值成功！";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rss;
			}
	}
}
