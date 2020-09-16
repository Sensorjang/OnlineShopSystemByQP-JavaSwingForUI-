package AccessObj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bussiness;

public class BussinessMagObj extends BaseObj {                         //显示操作
	
	public List<Bussiness> getbussinesslist(String acc){
		List<Bussiness> retlist = new ArrayList<Bussiness>();
		String sql="select * from bussiness";
		if(!"".equals(acc)) {
			sql +=" where account like '%"+acc+"%'";
		}
		try {
			PreparedStatement prep=null;
			prep =conn.prepareStatement(sql);            //sql语句--》数据库操作对象
			//prep.setString(1,acc);
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				Bussiness bussiness = new Bussiness();
				bussiness.setAccount(rs.getString("account"));
				bussiness.setPassword(rs.getString("password"));
				bussiness.setCreatedate(rs.getString("createdate"));
				retlist.add(bussiness);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retlist;
	}
}
