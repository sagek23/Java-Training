package memberLogOn;

public class logOnVo {

	String id="";
	String pwd="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public logOnVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public logOnVo(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
}
