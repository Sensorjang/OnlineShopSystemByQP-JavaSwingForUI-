package AccessObj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Commodity;
import model.ShoppingCartMod;

public class ShoppingCartObj extends BaseObj {
	/*
	 * ��ӹ��ﳵ
	 */
	public String add(int no,String acc) {
		String rss="";
		String sql = "select * from commodity where no=?";
		boolean flag=false;
		PreparedStatement prep2=null;
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setInt(1, no);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				flag=true;
			}else rss="�������";
			if(flag==true) {
				String sql2 = "insert into shoppingcart values(?,?,?,?,?)";
				prep2 =conn.prepareStatement(sql2);
				prep2.setInt(1,no);
				prep2.setString(2,rs.getString("name"));
				prep2.setInt(3, Integer.parseInt(rs.getString("price")));
				prep2.setString(4, rs.getString("publisher"));
				prep2.setString(5,acc);
			}else rss="�������";
			int i=prep2.executeUpdate();
			if(i > 0) {
				rss="����ɹ���";
			}else rss="�������";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rss;
	}
	/*
	 * ��ʾ���ﳵ
	 */
	public List<ShoppingCartMod> print(String acc){
		List<ShoppingCartMod> retlist = new ArrayList<ShoppingCartMod>();
		String sql="select * from shoppingcart where purchaser=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
			prep.setString(1, acc);
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				ShoppingCartMod ss = new ShoppingCartMod();
				ss.setNo(Integer.parseInt(rs.getString("no")));
				ss.setName(rs.getString("name"));
				ss.setPrice(Integer.parseInt(rs.getString("price")));
				ss.setPublisher(rs.getString("publisher"));
				ss.setPurchaser(acc);
				retlist.add(ss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retlist;
	}
	/*
	 * ɾ�����ﳵ
	 */
	public String delete(int no,String acc) {
		String rss="";
		String sql="select * from shoppingcart where purchaser=? and no=?";
		boolean flag=false;
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setString(1, acc);
			prep.setInt(2, no);
			ResultSet rs= prep.executeQuery();
			if(rs.next()) {
				flag=true;
			}else rss="�Ҳ����ü�¼��";
			if(flag==true) {
				PreparedStatement prep2=null;
				String sql2="delete from shoppingcart where purchaser=? and no=?";
				prep2 =conn.prepareStatement(sql2);
				prep2.setString(1, acc);
				prep2.setInt(2, no);
				int i=prep2.executeUpdate();
				if(i>0)rss="ɾ���ɹ���";
				else rss="ɾ��ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rss;
		
	}
	/*
	 * �ϼƼ۸�
	 */
	public int total(String acc) {
		int rss=0;
		String sql="select * from shoppingcart where purchaser=?";

		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setString(1, acc);
			ResultSet rs= prep.executeQuery();
			while(rs.next()) {
				rss+= Integer.parseInt(rs.getString("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rss;
	}
	/*
	 * �̼�������� ����
	 */
	public void bussin(String acc) {
		String sql="select * from shoppingcart where purchaser=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setString(1, acc);
			ResultSet rs= prep.executeQuery();
			while(rs.next()) {
				String buss=rs.getString("publisher");
				int moneyin=Integer.parseInt(rs.getString("price"));
				BalanceObj balanceobj =new BalanceObj();
				balanceobj.recharge("Bussiness",buss, moneyin);   //���̼��˻���ֵ
				CommodityObj commodityobj= new CommodityObj();
				commodityobj.cutonestock(Integer.parseInt(rs.getString("no")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
