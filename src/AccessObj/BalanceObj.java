package AccessObj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceObj extends BaseObj {
	/*
	 * ����ȡ
	 */
	public String readbalance(String type,String acc) {
		String rsnum="";
		if("User".equals(type)) {
			String sql = "select * from userbalance where account='"+acc+"'";               //sql���--�����ݿ��������
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
			String sql = "select * from bussinessbalance where account='"+acc+"'";               //sql���--�����ݿ��������
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
	 * ����ֵ
	 */
	public String recharge(String type,String acc,int i) {
		String rss="��ֵʧ�ܣ�";
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
				if(rst > 0 && i>0) rss="�û���"+acc+"����ֵ�ɹ���";
				if(rst > 0 && i<=0) rss="�û���"+acc+"�����ѳɹ���";
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
					if(rst > 0) rss="�̼ҡ�"+acc+"����ֵ�ɹ���";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rss;
			}
	}
}
