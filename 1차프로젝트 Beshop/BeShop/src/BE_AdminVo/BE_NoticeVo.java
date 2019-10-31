package BE_AdminVo;

import java.sql.Date;

public class BE_NoticeVo {
	
	int noticeNum;
	String notice_Ca;
	String noticeName;
	Date noticeDate;
	String notice_Con;
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNotice_Ca() {
		return notice_Ca;
	}
	public void setNotice_Ca(String notice_Ca) {
		this.notice_Ca = notice_Ca;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNotice_Con() {
		return notice_Con;
	}
	public void setNotice_Con(String notice_Con) {
		this.notice_Con = notice_Con;
	}
	public BE_NoticeVo(int noticeNum, String notice_Ca, String noticeName, Date noticeDate, String notice_Con) {
		super();
		this.noticeNum = noticeNum;
		this.notice_Ca = notice_Ca;
		this.noticeName = noticeName;
		this.noticeDate = noticeDate;
		this.notice_Con = notice_Con;
	}
	public BE_NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
