package BE_SellerVo;

import java.sql.Date;

public class BE_QnaVo {
	int qnanum;
	String beUid;
	int pNum;
	String sec_Pw;
	String qna_Title;
	String qna_Content;
	String qna_Answer;
	Date answer_Time;
	Date regist_Date;
	String qna_Category;
	public int getQnanum() {
		return qnanum;
	}
	public void setQnanum(int qnanum) {
		this.qnanum = qnanum;
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
	public String getSec_Pw() {
		return sec_Pw;
	}
	public void setSec_Pw(String sec_Pw) {
		this.sec_Pw = sec_Pw;
	}
	public String getQna_Title() {
		return qna_Title;
	}
	public void setQna_Title(String qna_Title) {
		this.qna_Title = qna_Title;
	}
	public String getQna_Content() {
		return qna_Content;
	}
	public void setQna_Content(String qna_Content) {
		this.qna_Content = qna_Content;
	}
	public String getQna_Answer() {
		return qna_Answer;
	}
	public void setQna_Answer(String qna_Answer) {
		this.qna_Answer = qna_Answer;
	}
	public Date getAnswer_Time() {
		return answer_Time;
	}
	public void setAnswer_Time(Date answer_Time) {
		this.answer_Time = answer_Time;
	}
	public Date getRegist_Date() {
		return regist_Date;
	}
	public void setRegist_Date(Date regist_Date) {
		this.regist_Date = regist_Date;
	}
	public String getQna_Category() {
		return qna_Category;
	}
	public void setQna_Category(String qna_Category) {
		this.qna_Category = qna_Category;
	}
	public BE_QnaVo(int qnanum, String beUid, int pNum, String sec_Pw, String qna_Title, String qna_Content,
			String qna_Answer, Date answer_Time, Date regist_Date, String qna_Category) {
		super();
		this.qnanum = qnanum;
		this.beUid = beUid;
		this.pNum = pNum;
		this.sec_Pw = sec_Pw;
		this.qna_Title = qna_Title;
		this.qna_Content = qna_Content;
		this.qna_Answer = qna_Answer;
		this.answer_Time = answer_Time;
		this.regist_Date = regist_Date;
		this.qna_Category = qna_Category;
	}
	public BE_QnaVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
