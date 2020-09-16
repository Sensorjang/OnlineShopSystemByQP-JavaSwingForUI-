package AccessObj;

import java.sql.*;

import mytools.DataBaseCon;


/*
 * 访问数据库的主对象
 */

public class BaseObj {
	public Connection conn= new DataBaseCon().getCon();
}
