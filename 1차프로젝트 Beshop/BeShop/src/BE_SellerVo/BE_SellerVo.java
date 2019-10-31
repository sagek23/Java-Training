package BE_SellerVo;

public class BE_SellerVo {
	int sNum;
	String beUid;
	int pNum;
	int suNum;
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
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
	public int getSuNum() {
		return suNum;
	}
	public void setSuNum(int suNum) {
		this.suNum = suNum;
	}
	public BE_SellerVo(int sNum, String beUid, int pNum, int suNum) {
		super();
		this.sNum = sNum;
		this.beUid = beUid;
		this.pNum = pNum;
		this.suNum = suNum;
	}
	public BE_SellerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
