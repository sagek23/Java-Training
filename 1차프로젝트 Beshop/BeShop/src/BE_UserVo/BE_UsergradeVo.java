package BE_UserVo;

public class BE_UsergradeVo {
	int gradeNum;
	String grade;
	String gBenefit;
	public int getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getgBenefit() {
		return gBenefit;
	}
	public void setgBenefit(String gBenefit) {
		this.gBenefit = gBenefit;
	}
	public BE_UsergradeVo(int gradeNum, String grade, String gBenefit) {
		super();
		this.gradeNum = gradeNum;
		this.grade = grade;
		this.gBenefit = gBenefit;
	}
	public BE_UsergradeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	
