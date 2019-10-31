package BE_AdminVo;

public class BE_CqnaVo {
	
	int cqNum;
	int cqnaS;
	String cqnaName;
	String cqna_Con;
	String cq_Answer;
	
	public int getCqNum() {
		return cqNum;
	}
	public void setCqNum(int cqNum) {
		this.cqNum = cqNum;
	}
	public int getCqnaS() {
		return cqnaS;
	}
	public void setCqnaS(int cqnaS) {
		this.cqnaS = cqnaS;
	}
	public String getCqnaName() {
		return cqnaName;
	}
	public void setCqnaName(String cqnaName) {
		this.cqnaName = cqnaName;
	}
	public String getCqna_Con() {
		return cqna_Con;
	}
	public void setCqna_Con(String cqna_Con) {
		this.cqna_Con = cqna_Con;
	}
	public String getCq_Answer() {
		return cq_Answer;
	}
	public void setCq_Answer(String cq_Answer) {
		this.cq_Answer = cq_Answer;
	}
	public BE_CqnaVo(int cqNum, int cqnaS, String cqnaName, String cqna_Con, String cq_Answer) {
		super();
		this.cqNum = cqNum;
		this.cqnaS = cqnaS;
		this.cqnaName = cqnaName;
		this.cqna_Con = cqna_Con;
		this.cq_Answer = cq_Answer;
	}
	public BE_CqnaVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
