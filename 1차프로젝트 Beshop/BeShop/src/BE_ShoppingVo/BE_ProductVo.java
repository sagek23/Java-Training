package BE_ShoppingVo;

import java.util.Date;

public class BE_ProductVo {
	int pNum;
	int ctNum;
	Date p_Date;
	String as_Info;
	Date p_Cdate;
	String pname;
	String brand;
	int stock;
	String p_Category;
	String p_Image;
	String p_Sangse;
	int p_Price;
	String company;
	String select_Op;
	int likes;
	int hits;
	String origin;
	
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public int getCtNum() {
		return ctNum;
	}
	public void setCtNum(int ctNum) {
		this.ctNum = ctNum;
	}
	public Date getP_Date() {
		return p_Date;
	}
	public void setP_Date(Date p_Date) {
		this.p_Date = p_Date;
	}
	public String getAs_Info() {
		return as_Info;
	}
	public void setAs_Info(String as_Info) {
		this.as_Info = as_Info;
	}
	public Date getP_Cdate() {
		return p_Cdate;
	}
	public void setP_Cdate(Date p_Cdate) {
		this.p_Cdate = p_Cdate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getP_Category() {
		return p_Category;
	}
	public void setP_Category(String p_Category) {
		this.p_Category = p_Category;
	}
	public String getP_Image() {
		return p_Image;
	}
	public void setP_Image(String p_Image) {
		this.p_Image = p_Image;
	}
	public String getP_Sangse() {
		return p_Sangse;
	}
	public void setP_Sangse(String p_Sangse) {
		this.p_Sangse = p_Sangse;
	}
	public int getP_Price() {
		return p_Price;
	}
	public void setP_Price(int p_Price) {
		this.p_Price = p_Price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSelect_Op() {
		return select_Op;
	}
	public void setSelect_Op(String select_Op) {
		this.select_Op = select_Op;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public BE_ProductVo(int pNum, int ctNum, Date p_Date, String as_Info, Date p_Cdate, String pname, String brand,
			int stock, String p_Category, String p_Image, String p_Sangse, int p_Price, String company,
			String select_Op, int likes, int hits, String origin) {
		super();
		this.pNum = pNum;
		this.ctNum = ctNum;
		this.p_Date = p_Date;
		this.as_Info = as_Info;
		this.p_Cdate = p_Cdate;
		this.pname = pname;
		this.brand = brand;
		this.stock = stock;
		this.p_Category = p_Category;
		this.p_Image = p_Image;
		this.p_Sangse = p_Sangse;
		this.p_Price = p_Price;
		this.company = company;
		this.select_Op = select_Op;
		this.likes = likes;
		this.hits = hits;
		this.origin = origin;
	}
	public BE_ProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
