package BE_ShoppingVo;

public class BE_ShopListVo {
	int Slnum;
	int slcount;
	int Pnum;
	public int getSlnum() {
		return Slnum;
	}
	public void setSlnum(int slnum) {
		Slnum = slnum;
	}
	public int getSlcount() {
		return slcount;
	}
	public void setSlcount(int slcount) {
		this.slcount = slcount;
	}
	public int getPnum() {
		return Pnum;
	}
	public void setPnum(int pnum) {
		Pnum = pnum;
	}
	public BE_ShopListVo(int slnum, int slcount, int pnum) {
		super();
		Slnum = slnum;
		this.slcount = slcount;
		Pnum = pnum;
	}
	public BE_ShopListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
