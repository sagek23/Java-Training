package BE_UserVo;

public class BE_PointHitVo {
	 String beUid;
	 int pointPurNum;
	public String getbeUid() {
		return beUid;
	}
	public void setbeUid(String beUid) {
		this.beUid = beUid;
	}
	public int getPointPurNum() {
		return pointPurNum;
	}
	public void setPointPurNum(int pointPurNum) {
		this.pointPurNum = pointPurNum;
	}
	public BE_PointHitVo(String beUid, int pointPurNum) {
		super();
		this.beUid = beUid;
		this.pointPurNum = pointPurNum;
	}
	public BE_PointHitVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
