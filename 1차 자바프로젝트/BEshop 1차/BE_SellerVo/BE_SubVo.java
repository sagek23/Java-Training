package BE_SellerVo;

public class BE_SubVo {
	String beUid;
	int snum;
	public String getbeUid() {
		return beUid;
	}
	public void setbeUid(String beUid) {
		this.beUid = beUid;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public BE_SubVo(String beUid, int snum) {
		super();
		this.beUid = beUid;
		this.snum = snum;
	}
	public BE_SubVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
