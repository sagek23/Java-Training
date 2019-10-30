package LogOn;

public class LogOnVO {
	String id;
	String pwd;
	public LogOnVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public LogOnVO() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
	
}
