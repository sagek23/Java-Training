package BE_UserVo;

/*Uid	VARCHAR2	?��?��id
Dnum	NUMBER	구분번호
Ds	NUMBER	구분분류*/

public class BE_DivVo {
	int dnum;
	String beUid;
	String ds;
	public int getdNum() {
		return dnum;
	}
	public void setdNum(int dnum) {
		this.dnum = dnum;
	}
	public String getbeUid() {
		return beUid;
	}
	public void setbeUid(String beUid) {
		this.beUid = beUid;
	}
	public String getDs() {
		return ds;
	}
	public void setDs(String ds) {
		this.ds = ds;
	}
	public BE_DivVo(int dnum, String beUid, String ds) {
		super();
		this.dnum = dnum;
		this.beUid = beUid;
		this.ds = ds;
	}
	public BE_DivVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
