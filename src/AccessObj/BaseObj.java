package AccessObj;

import java.sql.*;

import mytools.DataBaseCon;


/*
 * �������ݿ��������
 */

public class BaseObj {
	public Connection conn= new DataBaseCon().getCon();
}
