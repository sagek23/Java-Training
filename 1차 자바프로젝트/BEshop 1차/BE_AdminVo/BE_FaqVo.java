package BE_AdminVo;

public class BE_FaqVo {

	int faqNum;
	String faqName;
	String faq_Con;
	public int getFaqNum() {
		return faqNum;
	}
	public void setFaqNum(int faqNum) {
		this.faqNum = faqNum;
	}
	public String getFaqName() {
		return faqName;
	}
	public void setFaqName(String faqName) {
		this.faqName = faqName;
	}
	public String getFaq_Con() {
		return faq_Con;
	}
	public void setFaq_Con(String faq_Con) {
		this.faq_Con = faq_Con;
	}
	public BE_FaqVo(int faqNum, String faqName, String faq_Con) {
		super();
		this.faqNum = faqNum;
		this.faqName = faqName;
		this.faq_Con = faq_Con;
	}
	public BE_FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
