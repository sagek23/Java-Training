package BE_ShoppingVo;

import java.util.Date;

public class BE_ReviewVo {
	int reNum;
	String beUid;
	int pNum;
	String reTitle;
	int reGrade;
	int re_Hits;
	Date reDate;
	String reContent;
	String re_Answer;
	public int getReNum() {
		return reNum;
	}
	public void setReNum(int reNum) {
		this.reNum = reNum;
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
	public String getReTitle() {
		return reTitle;
	}
	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}
	public int getReGrade() {
		return reGrade;
	}
	public void setReGrade(int reGrade) {
		this.reGrade = reGrade;
	}
	public int getRe_Hits() {
		return re_Hits;
	}
	public void setRe_Hits(int re_Hits) {
		this.re_Hits = re_Hits;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public String getRe_Answer() {
		return re_Answer;
	}
	public void setRe_Answer(String re_Answer) {
		this.re_Answer = re_Answer;
	}
	public BE_ReviewVo(int reNum, String beUid, int pNum, String reTitle, int reGrade, int re_Hits, Date reDate,
			String reContent, String re_Answer) {
		super();
		this.reNum = reNum;
		this.beUid = beUid;
		this.pNum = pNum;
		this.reTitle = reTitle;
		this.reGrade = reGrade;
		this.re_Hits = re_Hits;
		this.reDate = reDate;
		this.reContent = reContent;
		this.re_Answer = re_Answer;
	}
	public BE_ReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
