package BE_UserVo;

/*Wnum	NUMBER	?��?��리스?��번호
Uid	VARCHAR2	?��?��ID
Pnum	NUMBER	?��?��?���?*/

public class BE_WishListVo {
	int wNum;
	String beUid;
	int pNum;
	public int getwNum() {
		return wNum;
	}
	public void setwNum(int wNum) {
		this.wNum = wNum;
	}
	public String getbeUid() {
		return beUid;
	}
	public void setbeUid(String beUid) {
		this.beUid = beUid;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public BE_WishListVo(int wNum, String beUid, int pNum) {
		super();
		this.wNum = wNum;
		this.beUid = beUid;
		this.pNum = pNum;
	}
	public BE_WishListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
