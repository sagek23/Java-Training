package goods;

public class GoodsVo {
	int no;
	String name;
	int price;
	int qty;
	String fname;
	public GoodsVo(int no, String name, int price, int qty, String fname) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.fname = fname;
	}
	
	public GoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
}
