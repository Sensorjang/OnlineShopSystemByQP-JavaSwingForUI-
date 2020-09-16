package AccessObj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
/*
 * 管理员对 用户的管理
 */
public class UserMagObj extends BaseObj {                 //显示操作
		
	public List<User> getuserlist(String acc){
		List<User> retlist = new ArrayList<User>();
		String sql="select * from user";
		if(!"".equals(acc)) {
			sql +=" where account like '%"+acc+"%'";
		}
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			//prep.setString(1,acc);
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				User user= new User();
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setCreatedate(rs.getString("createdate"));
				retlist.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retlist;
	}
}
 