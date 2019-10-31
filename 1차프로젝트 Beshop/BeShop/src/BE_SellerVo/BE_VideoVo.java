package BE_SellerVo;

import java.sql.Date;
import java.sql.Time;


public class BE_VideoVo {
	int Vnum;
	String vname;
	String vfile;
	Date Vupdate;
	int Pnum;
	String beUid;
	int Snum;
	int Formnum;
	Date Formdate;
	Time Vtime;
	String vtag;
	
	public int getVnum() {
		return Vnum;
	}

	public void setVnum(int vnum) {
		Vnum = vnum;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVfile() {
		return vfile;
	}

	public void setVfile(String vfile) {
		this.vfile = vfile;
	}

	public Date getVupdate() {
		return Vupdate;
	}

	public void setVupdate(Date vupdate) {
		Vupdate = vupdate;
	}

	public int getPnum() {
		return Pnum;
	}

	public void setPnum(int pnum) {
		Pnum = pnum;
	}

	public String getBeUid() {
		return beUid;
	}

	public void setBeUid(String beUid) {
		this.beUid = beUid;
	}

	public int getSnum() {
		return Snum;
	}

	public void setSnum(int snum) {
		Snum = snum;
	}

	public int getFormnum() {
		return Formnum;
	}

	public void setFormnum(int formnum) {
		Formnum = formnum;
	}

	public Date getFormdate() {
		return Formdate;
	}

	public void setFormdate(Date formdate) {
		Formdate = formdate;
	}

	public Time getVtime() {
		return Vtime;
	}

	public void setVtime(Time vtime) {
		Vtime = vtime;
	}

	public String getVtag() {
		return vtag;
	}

	public void setVtag(String vtag) {
		this.vtag = vtag;
	}

	public BE_VideoVo(int vnum, String vname, String vfile, Date vupdate, int pnum, String beUid, int snum, int formnum,
			Date formdate, Time vtime, String vtag) {
		super();
		Vnum = vnum;
		this.vname = vname;
		this.vfile = vfile;
		Vupdate = vupdate;
		Pnum = pnum;
		this.beUid = beUid;
		Snum = snum;
		Formnum = formnum;
		Formdate = formdate;
		Vtime = vtime;
		this.vtag = vtag;
	}
	
	public BE_VideoVo(){}
	

}
