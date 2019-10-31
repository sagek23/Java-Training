package BE_ShoppingVo;

public class BE_ShoppingVo {
	int pNum;
	int chNum;
	int gNum;
	String small_Search;
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getChNum() {
		return chNum;
	}
	public void setChNum(int chNum) {
		this.chNum = chNum;
	}
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public String getSmall_Search() {
		return small_Search;
	}
	public void setSmall_Search(String small_Search) {
		this.small_Search = small_Search;
	}
	public BE_ShoppingVo(int pNum, int chNum, int gNum, String small_Search) {
		super();
		this.pNum = pNum;
		this.chNum = chNum;
		this.gNum = gNum;
		this.small_Search = small_Search;
	}
	public BE_ShoppingVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
