package model;

/*
 * 注册类型枚举
 */

public enum registertype {                   //注册用户类型枚举函数
	BUSSINESS("商家",1),USER("用户",2);
	
	private String Name;
	private int Index;
	
	private registertype(String Name,int Index)
	{
		this.Name=Name;
		this.Index=Index;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getIndex() {
		return Index;
	}

	public void setIndex(int index) {
		Index = index;
	}
	
	public String toString()     //重写toString保证View界面用户类型汉字的显示正常
	{
		return this .Name;
	}
}
