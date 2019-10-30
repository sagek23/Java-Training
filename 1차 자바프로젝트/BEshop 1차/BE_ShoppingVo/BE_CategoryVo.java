package BE_ShoppingVo;

public class BE_CategoryVo {
	int ctnum;
	String bigName;
	String smName;
	public int getCtnum() {
		return ctnum;
	}
	public void setCtnum(int ctnum) {
		this.ctnum = ctnum;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	public String getSmName() {
		return smName;
	}
	public void setSmName(String smName) {
		this.smName = smName;
	}
	public BE_CategoryVo(int ctnum, String bigName, String smName) {
		super();
		this.ctnum = ctnum;
		this.bigName = bigName;
		this.smName = smName;
	}
	public BE_CategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
