package member;

public class MemberVo {	
	String id;
	String pwd;
	String name;
	public MemberVo(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}
	public MemberVo() {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
