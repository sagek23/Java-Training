package BE_AdminVo;

import java.sql.Date;

public class BE_EventVo {

	int eNum;
	String eName;
	Date eDate;
	String e_Image;
	public int geteNum() {
		return eNum;
	}
	public void seteNum(int eNum) {
		this.eNum = eNum;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	public String getE_Image() {
		return e_Image;
	}
	public void setE_Image(String e_Image) {
		this.e_Image = e_Image;
	}
	public BE_EventVo(int eNum, String eName, Date eDate, String e_Image) {
		super();
		this.eNum = eNum;
		this.eName = eName;
		this.eDate = eDate;
		this.e_Image = e_Image;
	}
	public BE_EventVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
