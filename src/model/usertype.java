package model;

/*
 * �û�����ö��
 */

public enum usertype {                     //�û�����ö�ٺ���
	ADMIN("����Ա",0),BUSSINESS("�̼�",1),USER("�û�",2);
	
	private String Name;
	private int Index;
	
	private usertype(String Name,int Index)
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
	
	public String toString()     //��дtoString��֤View�����û����ͺ��ֵ���ʾ����
	{
		return this .Name;
	}
	
}
