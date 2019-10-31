package BE_SellerVo;

public class BE_RecentbroadcastVo {
	String beUid;
	int pNum;
	int vNum;
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
	public int getvNum() {
		return vNum;
	}
	public void setvNum(int vNum) {
		this.vNum = vNum;
	}
	public BE_RecentbroadcastVo(String beUid, int pNum, int vNum) {
		super();
		this.beUid = beUid;
		this.pNum = pNum;
		this.vNum = vNum;
	}
	public BE_RecentbroadcastVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
