package EmpAdd;

import java.sql.Date;

public class AddVo {

	String eName;
	String addr;
	int sal;
	int comm;
	String job;
	String tel;
	Date hiredate;
	String strHiredate;
	int mgr;
	int dno;
	String email;
	public AddVo(String eName, String addr, int sal, int comm, String job, String tel, Date hiredate, int mgr, int dno,
			String email) {
		super();
		this.eName = eName;
		this.addr = addr;
		this.sal = sal;
		this.comm = comm;
		this.job = job;
		this.tel = tel;
		this.hiredate = hiredate;
		this.mgr = mgr;
		this.dno = dno;
		this.email = email;
	}
	
	
	
	public String getStrHiredate() {
		return strHiredate;
	}



	public void setStrHiredate(String strHiredate) {
		this.strHiredate = strHiredate;
	}



	public AddVo(String strHiredate) {
		super();
		this.strHiredate = strHiredate;
	}



	public AddVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
