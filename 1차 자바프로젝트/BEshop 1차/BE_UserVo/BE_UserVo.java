package BE_UserVo;

import java.sql.Date;

public class BE_UserVo {
	String beUid;
	String upw;
	String sex;
	Date birth;	//String
	String uname;
	String scNum;
	Date loginLog;
	String addr1;
	String addr2;
	String uPhone;
	String email;
	Date joinDate;
	String pf1;
	String pf2;
	String pf3;
	int gradeNum;
	public String getBeUid() {
		return beUid;
	}
	public void setBeUid(String beUid) {
		this.beUid = beUid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getScNum() {
		return scNum;
	}
	public void setScNum(String scNum) {
		this.scNum = scNum;
	}
	public Date getLoginLog() {
		return loginLog;
	}
	public void setLoginLog(Date loginLog) {
		this.loginLog = loginLog;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getPf1() {
		return pf1;
	}
	public void setPf1(String pf1) {
		this.pf1 = pf1;
	}
	public String getPf2() {
		return pf2;
	}
	public void setPf2(String pf2) {
		this.pf2 = pf2;
	}
	public String getPf3() {
		return pf3;
	}
	public void setPf3(String pf3) {
		this.pf3 = pf3;
	}
	public int getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public BE_UserVo(String beUid, String upw, String sex, Date birth, String uname, String scNum, Date loginLog,
			String addr1, String addr2, String uPhone, String email, Date joinDate, String pf1, String pf2, String pf3,
			int gradeNum) {
		super();
		this.beUid = beUid;
		this.upw = upw;
		this.sex = sex;
		this.birth = birth;
		this.uname = uname;
		this.scNum = scNum;
		this.loginLog = loginLog;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.uPhone = uPhone;
		this.email = email;
		this.joinDate = joinDate;
		this.pf1 = pf1;
		this.pf2 = pf2;
		this.pf3 = pf3;
		this.gradeNum = gradeNum;
	}
	public BE_UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
