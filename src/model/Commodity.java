package model;

/*
 * Commodity(商品)表
 */

public class Commodity { 
	private String no;
	private String name;
	private int stock; //库存
	private int price;
	private String describeit;
	private String publisher; //发布者
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescribeit() {
		return describeit;
	}
	public void setDescribeit(String describeit) {
		this.describeit = describeit;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
