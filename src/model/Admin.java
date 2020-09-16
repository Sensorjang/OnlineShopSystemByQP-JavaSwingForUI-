package model;

import AccessObj.BaseObj;

/*
 * Admin表
 */
public class Admin  extends BaseObj {              //继承自BaseObj
	
	private String account;             //account是主键
	private String password;
	private String createdate;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
}
