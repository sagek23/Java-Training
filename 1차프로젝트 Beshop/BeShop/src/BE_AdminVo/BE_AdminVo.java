package BE_AdminVo;

public class BE_AdminVo {
	
	String beUid;
	int adminNum;
	public String getbeUid() {
		return beUid;
	}
	public void setbeUid(String beUids) {
		this.beUid = beUid;
	}
	public int getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}
	public BE_AdminVo(String beUid, int adminNum) {
		super();
		this.beUid = beUid;
		this.adminNum = adminNum;
	}
	public BE_AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
