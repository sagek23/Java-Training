package BE_AdminVo;

public class BE_AdministrationVo {

	int ad_Num;
	int noNum;
	int noticeNum;
	int faqNum;
	int eventNum;
	int cqNum;
	public int getAd_Num() {
		return ad_Num;
	}
	public void setAd_Num(int ad_Num) {
		this.ad_Num = ad_Num;
	}
	public int getNoNum() {
		return noNum;
	}
	public void setNoNum(int noNum) {
		this.noNum = noNum;
	}
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public int getFaqNum() {
		return faqNum;
	}
	public void setFaqNum(int faqNum) {
		this.faqNum = faqNum;
	}
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
	public int getCqNum() {
		return cqNum;
	}
	public void setCqNum(int cqNum) {
		this.cqNum = cqNum;
	}
	public BE_AdministrationVo(int ad_Num, int noNum, int noticeNum, int faqNum, int eventNum, int cqNum) {
		super();
		this.ad_Num = ad_Num;
		this.noNum = noNum;
		this.noticeNum = noticeNum;
		this.faqNum = faqNum;
		this.eventNum = eventNum;
		this.cqNum = cqNum;
	}
	public BE_AdministrationVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
