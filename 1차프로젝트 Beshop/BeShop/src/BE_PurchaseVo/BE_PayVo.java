package BE_PurchaseVo;

import java.util.Date;

public class BE_PayVo {
	int payNum;
	String payWay;
	String payCondition;
	Date payDate;
	int payPrice;
	int ApproveNum;
	int pcNum;
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getPayCondition() {
		return payCondition;
	}
	public void setPayCondition(String payCondition) {
		this.payCondition = payCondition;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public int getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}
	public int getApproveNum() {
		return ApproveNum;
	}
	public void setApproveNum(int approveNum) {
		ApproveNum = approveNum;
	}
	public int getPcNum() {
		return pcNum;
	}
	public void setPcNum(int pcNum) {
		this.pcNum = pcNum;
	}
	public BE_PayVo(int payNum, String payWay, String payCondition, Date payDate, int payPrice, int approveNum,
			int pcNum) {
		super();
		this.payNum = payNum;
		this.payWay = payWay;
		this.payCondition = payCondition;
		this.payDate = payDate;
		this.payPrice = payPrice;
		ApproveNum = approveNum;
		this.pcNum = pcNum;
	}
	public BE_PayVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
