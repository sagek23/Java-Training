package BE_PurchaseVo;

public class BE_CustomerVo {
	String beUid;
	int slNum;
	int oNum;
	public String getbeUid() {
		return beUid;
	}
	public void setbeUid(String beUid) {
		this.beUid = beUid;
	}
	public int getSlNum() {
		return slNum;
	}
	public void setSlNum(int slNum) {
		this.slNum = slNum;
	}
	public int getoNum() {
		return oNum;
	}
	public void setoNum(int oNum) {
		this.oNum = oNum;
	}
	public BE_CustomerVo(String beUid, int slNum, int oNum) {
		super();
		this.beUid = beUid;
		this.slNum = slNum;
		this.oNum = oNum;
	}
	public BE_CustomerVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
