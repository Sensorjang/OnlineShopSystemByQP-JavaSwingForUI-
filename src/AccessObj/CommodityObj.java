package AccessObj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import model.Commodity;

/*
 * Commodity(商品)表访问对象
 */
public class CommodityObj extends BaseObj {
	/*
	 * 获取商品列表
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
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
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
	 * 管理员 和 商家  删除商品
	 */
	public String deletecommodity (String acc,String no) {
		if("Admin".equals(acc)) {                                                                           //管理员传入"Admin"
			int result=0;
			try {
				String sql = "delete from commodity where no='"+no+"'";
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
				result =prep.executeUpdate();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result<=0)return "未找到商品！";
			String flag = "删除失败！";
			try {
				String sql = "select * from commodity where no='"+no+"'";
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
				ResultSet rs=prep.executeQuery();
				if(!rs.next()  &&  result>0)flag= "删除成功!";
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}else {
			int result=0;
			String iacc=null;         //存储 商品的 publisher
			try {
				String sql = "select * from commodity where no='"+no+"'";
				PreparedStatement prep=null;
				prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
				ResultSet rs=prep.executeQuery();
				if(rs.next())iacc=rs.getString("publisher");            //iacc为发布者
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String flag = "";
			int result2=0;
			if( acc.equals(iacc)  &&  !"".equals(iacc) ) {                                                 //商家传入account
					try {
						String sql = "delete from commodity where no=?";
						PreparedStatement prep=null;
						prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
						prep.setString(1, no);
						result2 =prep.executeUpdate();
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(result2<=0)return "未找到商品！";
					try {
						String sql = "select * from commodity where no='"+no+"'";
						PreparedStatement prep=null;
						prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
						ResultSet rs=prep.executeQuery();
						if(!rs.next())flag += "删除成功!";
						else flag += "删除失败！";
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			}else flag += "不能删除其他商家的商品";
			return flag;
		}
		
	}
	
	/*
	 * 上架商品
	 */
	public String putoncommodity(String name,String stock,String price,String describeit,String publisher) {
		String rss="";
		String sql="insert into commodity values(null,'"+name+"','"+stock+"','"+price+"','"+describeit+"','"+publisher+"')";
		try {
			java.sql.Statement state=conn.createStatement ();  //Statement
			state.executeUpdate(sql);                             //sql语句--》数据库操作对象
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2="select * from commodity where name=? and price=? and publisher=?";
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql2);            //sql语句--》数据库操作对象
			prep.setString(1, name);
			prep.setString(2, price);
			prep.setString(3, publisher);
			ResultSet rs=prep.executeQuery();
			if(rs.next()) {
				rss += "添加成功！商品编号为："+rs.getString("no");
			}else rss += "添加失败！";
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rss;
	}
	
	/*
	 * 商家：我的商品
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
		   //////////////////////////////////////////////////////////where [name] like case when (select COUNT(*) from table1 where [name]='a')    Mysql先精确再模糊查询
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
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
	 * 修改描述
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
				}else rss="不能修改非您发布的商品描述！";
			}else rss="未找到商品！";
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
				if(rst > 0)rss="修改成功！";
				else rss="修改失败！";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
	
	/*
	 * 修改价格
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
				}else rss="不能修改非您发布的商品价格！";
			}else rss="未找到商品！";
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
				if(rst > 0)rss="修改成功！";
				else rss="修改失败！";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
	
	/*
	 * 修改数量
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
				}else rss="不能修改非您发布的商品价格！";
			}else rss="未找到商品！";
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
				if(rst > 0)rss="修改成功！";
				else rss="修改失败！";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
	/*
	 * 库存  减一
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
			}else rss="未找到商品！";
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
				if(rst > 0)rss="修改成功！";
				else rss="修改失败！";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rss;
	}
}
