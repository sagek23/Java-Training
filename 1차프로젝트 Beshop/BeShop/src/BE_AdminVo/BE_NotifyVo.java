package BE_AdminVo;

public class BE_NotifyVo {

	int noNum;
	String noTitle;
	String no_Con;
	String beUid;
	int vNum;
	int	pNum;
	public int getNoNum() {
		return noNum;
	}
	public void setNoNum(int noNum) {
		this.noNum = noNum;
	}
	public String getNoTitle() {
		return noTitle;
	}
	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}
	public String getNo_Con() {
		return no_Con;
	}
	public void setNo_Con(String no_Con) {
		this.no_Con = no_Con;
	}
	public String getbeUid() {
		return beUid;
	}
	public void setUid(String beUid) {
		this.beUid = beUid;
	}
	public int getvNum() {
		return vNum;
	}
	public void setvNum(int vNum) {
		this.vNum = vNum;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public BE_NotifyVo(int noNum, String noTitle, String no_Con, String beUid, int vNum, int pNum) {
		super();
		this.noNum = noNum;
		this.noTitle = noTitle;
		this.no_Con = no_Con;
		this.beUid = beUid;
		this.vNum = vNum;
		this.pNum = pNum;
	}
	public BE_NotifyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
