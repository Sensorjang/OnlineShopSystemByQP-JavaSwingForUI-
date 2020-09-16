package AccessObj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import model.Commodity;

/*
 * Commodity(��Ʒ)����ʶ���
 */
public class CommodityObj extends BaseObj {
	/*
	 * ��ȡ��Ʒ�б�
	 */
	public List<Commodity> admingetcommoditylist(String no,String name){
		List<Commodity> retlist = new ArrayList<Commodity>();
		String sql="select * from commodity";
		if(!"".equals(no)  ||  !"".equals(name)) {
			if(!"".equals(no)  &&  !"".equals(name)) {
				sql +=" where no like '%"+no+"%' or name like '%"+name+"%'";
			}else if(!"".equals(no)) {
				sql += " where no like '%"+no+"%'";
			}else {
				sql += " where name like '%"+name+"%'";
			}
		}
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setNo(rs.getString("no"));
				commodity.setName(rs.getString("name"));
				commodity.setStock(rs.getInt("stock"));
				commodity.setPrice(rs.getInt("price"));
				commodity.setDescribeit(rs.getString("describeit"));
				commodity.setPublisher(rs.getString("publisher"));
				retlist.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retlist;
	}
	/*
	 * ����Ա �� �̼�  ɾ����Ʒ
	 */
	public String deletecommodity (String acc,String no) {
		if("Admin".equals(acc)) {                                                                           //����Ա����"Admin"
			int result=0;
			try {
				String sql = "delete from commodity where no='"+no+"'";
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
				result =prep.executeUpdate();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result<=0)return "δ�ҵ���Ʒ��";
			String flag = "ɾ��ʧ�ܣ�";
			try {
				String sql = "select * from commodity where no='"+no+"'";
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
				ResultSet rs=prep.executeQuery();
				if(!rs.next()  &&  result>0)flag= "ɾ���ɹ�!";
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}else {
			int result=0;
			String iacc=null;         //�洢 ��Ʒ�� publisher
			try {
				String sql = "select * from commodity where no='"+no+"'";
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
				ResultSet rs=prep.executeQuery();
				if(rs.next())iacc=rs.getString("publisher");            //iaccΪ������
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String flag = "";
			int result2=0;
			if( acc.equals(iacc)  &&  !"".equals(iacc) ) {                                                 //�̼Ҵ���account
					try {
						String sql = "delete from commodity where no=?";
						PreparedStatement prep=null;
						prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
						prep.setString(1, no);
						result2 =prep.executeUpdate();
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(result2<=0)return "δ�ҵ���Ʒ��";
					try {
						String sql = "select * from commodity where no='"+no+"'";
						PreparedStatement prep=null;
						prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
						ResultSet rs=prep.executeQuery();
						if(!rs.next())flag += "ɾ���ɹ�!";
						else flag += "ɾ��ʧ�ܣ�";
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			}else flag += "����ɾ�������̼ҵ���Ʒ";
			return flag;
		}
		
	}
	
	/*
	 * �ϼ���Ʒ
	 */
	public String putoncommodity(String name,String stock,String price,String describeit,String publisher) {
		String rss="";
		String sql="insert into commodity values(null,'"+name+"','"+stock+"','"+price+"','"+describeit+"','"+publisher+"')";
		try {
			java.sql.Statement state=conn.createStatement ();  //Statement
			state.executeUpdate(sql);                             //sql���--�����ݿ��������
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2="select * from commodity where name=? and price=? and publisher=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql2);            //sql���--�����ݿ��������
			prep.setString(1, name);
			prep.setString(2, price);
			prep.setString(3, publisher);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				rss += "��ӳɹ�����Ʒ���Ϊ��"+rs.getString("no");
			}else rss += "���ʧ�ܣ�";
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rss;
	}
	
	/*
	 * �̼ң��ҵ���Ʒ
	 */
	public List<Commodity> mycommodity(String acc,String no,String name){
		List<Commodity> retlist = new ArrayList<Commodity>();
		String sql="select * from commodity where publisher='"+acc+"'";
		if(!"".equals(no)  ||  !"".equals(name)) {
			if(!"".equals(no)  &&  !"".equals(name)) {
				sql +=" and (no like '%"+no+"%' or name like '%"+name+"%')";
			}else if(!"".equals(no)) {
				sql += " and no like '%"+no+"%'";
			}else {
				sql += " and name like '%"+name+"%'";
			}
		}
		   //////////////////////////////////////////////////////////where [name] like case when (select COUNT(*) from table1 where [name]='a')    Mysql�Ⱦ�ȷ��ģ����ѯ
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql���--�����ݿ��������
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setNo(rs.getString("no"));
				commodity.setName(rs.getString("name"));
				commodity.setStock(rs.getInt("stock"));
				commodity.setPrice(rs.getInt("price"));
				commodity.setDescribeit(rs.getString("describeit"));
				commodity.setPublisher(rs.getString("publisher"));
				retlist.add(commodity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retlist;
	}
	
	/*
	 * �޸�����
	 */
	public String chgdesc(String acc,int no,String newdesc) {
		String rss="";
		String sql = "select * from commodity where no=?";
		String sql2 = "update commodity set describeit=? where no=?";
		boolean flag=false;
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setInt(1, no);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				if(rs.getString("publisher").equals(acc)) {
					flag=true;
				}else rss="�����޸ķ�����������Ʒ������";
			}else rss="δ�ҵ���Ʒ��";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag=true) {
			PreparedStatement prep2=null;
			try {
				prep2 =conn.prepareStatement(sql2);
				prep2.setString(1, newdesc);
				prep2.setInt(2, no);
				int rst= prep2.executeUpdate();
				if(rst > 0)rss="�޸ĳɹ���";
				else rss="�޸�ʧ�ܣ�";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
	
	/*
	 * �޸ļ۸�
	 */
	public String chgprice(String acc,int no,int newprice) {
		String rss="";
		String sql = "select * from commodity where no=?";
		String sql2 = "update commodity set price=? where no=?";
		boolean flag=false;
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setInt(1, no);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				if(rs.getString("publisher").equals(acc)) {
					flag=true;
				}else rss="�����޸ķ�����������Ʒ�۸�";
			}else rss="δ�ҵ���Ʒ��";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag=true) {
			PreparedStatement prep2=null;
			try {
				prep2 =conn.prepareStatement(sql2);
				prep2.setInt(1, newprice);
				prep2.setInt(2, no);
				int rst= prep2.executeUpdate();
				if(rst > 0)rss="�޸ĳɹ���";
				else rss="�޸�ʧ�ܣ�";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
	
	/*
	 * �޸�����
	 */
	public String chgnum(String acc,int no,int newnum) {
		String rss="";
		String sql = "select * from commodity where no=?";
		String sql2 = "update commodity set stock=? where no=?";
		boolean flag=false;
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setInt(1, no);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				if(rs.getString("publisher").equals(acc)) {
					flag=true;
				}else rss="�����޸ķ�����������Ʒ�۸�";
			}else rss="δ�ҵ���Ʒ��";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag=true) {
			PreparedStatement prep2=null;
			try {
				prep2 =conn.prepareStatement(sql2);
				prep2.setInt(1, newnum);
				prep2.setInt(2, no);
				int rst= prep2.executeUpdate();
				if(rst > 0)rss="�޸ĳɹ���";
				else rss="�޸�ʧ�ܣ�";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
	/*
	 * ���  ��һ
	 */
	public String cutonestock(int no) {
		int newer=0;
		String rss="";
		String sql = "select * from commodity where no=?";
		String sql2 = "update commodity set stock=? where no=?";
		boolean flag=false;
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);
			prep.setInt(1, no);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				newer=Integer.parseInt(rs.getString("stock"));
			}else rss="δ�ҵ���Ʒ��";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag=true) {
			PreparedStatement prep2=null;
			try {
				prep2 =conn.prepareStatement(sql2);
				prep2.setInt(1, newer-1);
				prep2.setInt(2, no);
				int rst= prep2.executeUpdate();
				if(rst > 0)rss="�޸ĳɹ���";
				else rss="�޸�ʧ�ܣ�";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
}
