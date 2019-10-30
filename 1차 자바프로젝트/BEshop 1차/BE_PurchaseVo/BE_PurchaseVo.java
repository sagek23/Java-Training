package BE_PurchaseVo;

public class BE_PurchaseVo {
	int pcNum;
	int pcCount;
	int discount;
	String pcPhone;
	int pNum;
	String zipcode;
	int pcPrice;
	String pcAddr1;
	String pcAddr2;
	public int getPcNum() {
		return pcNum;
	}
	public void setPcNum(int pcNum) {
		this.pcNum = pcNum;
	}
	public int getPcCount() {
		return pcCount;
	}
	public void setPcCount(int pcCount) {
		this.pcCount = pcCount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getPcPhone() {
		return pcPhone;
	}
	public void setPcPhone(String pcPhone) {
		this.pcPhone = pcPhone;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getPcPrice() {
		return pcPrice;
	}
	public void setPcPrice(int pcPrice) {
		this.pcPrice = pcPrice;
	}
	public String getPcAddr1() {
		return pcAddr1;
	}
	public void setPcAddr1(String pcAddr1) {
		this.pcAddr1 = pcAddr1;
	}
	public String getPcAddr2() {
		return pcAddr2;
	}
	public void setPcAddr2(String pcAddr2) {
		this.pcAddr2 = pcAddr2;
	}
	public BE_PurchaseVo(int pcNum, int pcCount, int discount, String pcPhone, int pNum, String zipcode, int pcPrice,
			String pcAddr1, String pcAddr2) {
		super();
		this.pcNum = pcNum;
		this.pcCount = pcCount;
		this.discount = discount;
		this.pcPhone = pcPhone;
		this.pNum = pNum;
		this.zipcode = zipcode;
		this.pcPrice = pcPrice;
		this.pcAddr1 = pcAddr1;
		this.pcAddr2 = pcAddr2;
	}
	public BE_PurchaseVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
