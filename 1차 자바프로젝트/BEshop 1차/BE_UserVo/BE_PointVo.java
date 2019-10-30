package BE_UserVo;

import java.sql.Date;

/*Uid	VARCHAR2	?쉶?썝ID
PointPurNum	NUMBER	?룷?씤?듃援щℓ踰덊샇
porintBalance	NUMBER	異⑹쟾?옍?븸
chargeMethod	VARCHAR2	異⑹쟾諛⑸쾿
chargeDate	DATE	異⑹쟾?궇吏?
PointDetails	NUMBER	異⑹쟾湲덉븸*/

public class BE_PointVo {
	 int pointPurNum;
	 String beUid;
	 int pointBalance;
	 String changeMethod;
	 Date changeDate;
	 int pointDetails;
	public int getPointPurNum() {
		return pointPurNum;
	}
	public void setPointPurNum(int pointPurNum) {
		this.pointPurNum = pointPurNum;
	}
	public String getbeUid() {
		return beUid;
	}
	public void setbeUid(String beUid) {
		this.beUid = beUid;
	}
	public int getPointBalance() {
		return pointBalance;
	}
	public void setPointBalance(int pointBalance) {
		this.pointBalance = pointBalance;
	}
	public String getChangeMethod() {
		return changeMethod;
	}
	public void setChangeMethod(String changeMethod) {
		this.changeMethod = changeMethod;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public int getPointDetails() {
		return pointDetails;
	}
	public void setPointDetails(int pointDetails) {
		this.pointDetails = pointDetails;
	}
	public BE_PointVo(int pointPurNum, String beUid, int pointBalance, String changeMethod, Date changeDate,
			int pointDetails) {
		super();
		this.pointPurNum = pointPurNum;
		this.beUid = beUid;
		this.pointBalance = pointBalance;
		this.changeMethod = changeMethod;
		this.changeDate = changeDate;
		this.pointDetails = pointDetails;
	}
	public BE_PointVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
