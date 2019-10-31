package BE_PurchaseVo;

public class BE_DeliveryComVo {
	int dcNum;
	String licenseNum;
	String dcName;
	String dcAddr;
	String dcPhone;
	int dCharge;
	String dStatus;
	String dNum;
	public int getDcNum() {
		return dcNum;
	}
	public void setDcNum(int dcNum) {
		this.dcNum = dcNum;
	}
	public String getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	public String getDcName() {
		return dcName;
	}
	public void setDcName(String dcName) {
		this.dcName = dcName;
	}
	public String getDcAddr() {
		return dcAddr;
	}
	public void setDcAddr(String dcAddr) {
		this.dcAddr = dcAddr;
	}
	public String getDcPhone() {
		return dcPhone;
	}
	public void setDcPhone(String dcPhone) {
		this.dcPhone = dcPhone;
	}
	public int getdCharge() {
		return dCharge;
	}
	public void setdCharge(int dCharge) {
		this.dCharge = dCharge;
	}
	public String getdStatus() {
		return dStatus;
	}
	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
	}
	public String getdNum() {
		return dNum;
	}
	public void setdNum(String dNum) {
		this.dNum = dNum;
	}
	public BE_DeliveryComVo(int dcNum, String licenseNum, String dcName, String dcAddr, String dcPhone, int dCharge,
			String dStatus, String dNum) {
		super();
		this.dcNum = dcNum;
		this.licenseNum = licenseNum;
		this.dcName = dcName;
		this.dcAddr = dcAddr;
		this.dcPhone = dcPhone;
		this.dCharge = dCharge;
		this.dStatus = dStatus;
		this.dNum = dNum;
	}
	public BE_DeliveryComVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
