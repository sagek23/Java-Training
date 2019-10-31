package BE_PurchaseVo;

import java.util.Date;

public class BE_OrderDeliveryVo {
	int oNum;
	String beUid;
	int pNum;
	int dcNum;
	int oCount;
	int oPrice;
	String odAddr1;
	String odAddr2;
	String oPhone;
	Date oDate;
	String odZip;
	public int getoNum() {
		return oNum;
	}
	public void setoNum(int oNum) {
		this.oNum = oNum;
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
	public int getDcNum() {
		return dcNum;
	}
	public void setDcNum(int dcNum) {
		this.dcNum = dcNum;
	}
	public int getoCount() {
		return oCount;
	}
	public void setoCount(int oCount) {
		this.oCount = oCount;
	}
	public int getoPrice() {
		return oPrice;
	}
	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}
	public String getOdAddr1() {
		return odAddr1;
	}
	public void setOdAddr1(String odAddr1) {
		this.odAddr1 = odAddr1;
	}
	public String getOdAddr2() {
		return odAddr2;
	}
	public void setOdAddr2(String odAddr2) {
		this.odAddr2 = odAddr2;
	}
	public String getoPhone() {
		return oPhone;
	}
	public void setoPhone(String oPhone) {
		this.oPhone = oPhone;
	}
	public Date getoDate() {
		return oDate;
	}
	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	public String getOdZip() {
		return odZip;
	}
	public void setOdZip(String odZip) {
		this.odZip = odZip;
	}
	public BE_OrderDeliveryVo(int oNum, String beUid, int pNum, int dcNum, int oCount, int oPrice, String odAddr1,
			String odAddr2, String oPhone, Date oDate, String odZip) {
		super();
		this.oNum = oNum;
		this.beUid = beUid;
		this.pNum = pNum;
		this.dcNum = dcNum;
		this.oCount = oCount;
		this.oPrice = oPrice;
		this.odAddr1 = odAddr1;
		this.odAddr2 = odAddr2;
		this.oPhone = oPhone;
		this.oDate = oDate;
		this.odZip = odZip;
	}
	public BE_OrderDeliveryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
