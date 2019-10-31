package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BE_ShoppingDao.BE_ProductDao;
import BE_ShoppingVo.BE_ProductVo;
import DB.ConnectionProvider;

public class BE_Productinsert extends JFrame{
		JPanel p;
		//JFrame f;
		JTextField p_date;
		JTextField as_info;
		JTextField p_cdate;
		JTextField pname;
		JTextField brand;
		JTextField stock;
		JTextField p_category;
		JTextField p_image;
		JTextArea p_sangse;
		JTextField company;
		JTextField select_op;
		JLabel likes;
		JLabel hits;
		JTextField pricenum;
		JTextField origin;
		JButton btn_in;
		JButton btn_update;
		JComboBox cb_ct;
		JComboBox cb_sct;
		int like=0;
		int hit=0;
		String[]ct={"가전디지털","컴퓨터/노트북","태블릿/모바일","아웃도어/스포츠","자동차/용품/공구"};
		String[]sct= {"카메라","계절가전","주방가전","TV/프로젝터"};
		
		String year;
		String month;
		String day;
		int forday;
		int ctnum=0;
		public BE_Productinsert() {
			// TODO Auto-generated constructor stub
			
			p_date =new JTextField("2019-08-13");
			p_date.setEditable(false);
			as_info=new JTextField(20);
			p_cdate=new JTextField(20);
			pname=new JTextField(20);
			brand=new JTextField(20);
			stock=new JTextField(20);
			p_category=new JTextField(20);
			p_image=new JTextField(20);
			company =new JTextField(20);
			select_op =new JTextField(20);
			likes =new JLabel(like+"");
			hits =new JLabel(hit+"");
			pricenum =new JTextField(20);
			origin =new JTextField(20);
			
			JComboBox <Integer>upday=new JComboBox<Integer>();
			for (int i = 1; i <= 100; i++) 
			{
				upday.addItem(i);
			}
			
			String sql = "select ctnum from Category where bigname='가전디지털' and smname='카메라' ";
			try {
				Connection conn = ConnectionProvider.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					
				 ctnum=rs.getInt(1);
					
				}
				ConnectionProvider.close(conn, stmt, rs);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			cb_ct=new JComboBox(ct);
			cb_sct=new JComboBox(sct);
			JPanel cb=new JPanel();
			String pct=  cb_ct.getSelectedItem().toString();
			String pct2=  cb_sct.getSelectedItem().toString();
			
			cb.add(cb_ct);
			cb.add(cb_sct);
			
			p=new JPanel();
			p.setLayout(new GridLayout(14,1));
			try {
				
				p.setFont(new Font("나눔고딕",Font.CENTER_BASELINE, 15));
				p.add(new JLabel("상품명"));
				p.add(pname);
				p.add(new JLabel("판매가격"));
				p.add(pricenum);
				p.add(new JLabel("상품수량"));
				p.add(stock);
				p.add(new JLabel("카테고리명"));
				p.add(cb);
				p.add(new JLabel("상품상세 카테고리"));
				p.add(p_category);
				p.add(new JLabel("등록일"));
				p.add(p_date);
				p.add(new JLabel("상품게시기간"));
				p.add(upday);
	//			p.add(new JLabel("상세정보"));
	//			p.add(p_sangse);
				p.add(new JLabel("브랜드"));
				p.add(brand);
				p.add(new JLabel("제조사"));
				p.add(company);
				p.add(new JLabel("제조국가"));
				p.add(origin);
				p.add(new JLabel("A/S정보"));
				p.add(as_info);
				p.add(new JLabel("상품이미지"));
				p.add(p_image);
				p.add(new JLabel("좋아요"));
				p.add(likes);
				p.add(new JLabel("조회수"));
				p.add(hits);
				
			
				
				Date date;
	//			SimpleDateFormat to=new SimpleDateFormat()
				 year="2019";
	           	 month="08";
	          	 day = "13";
				
				 forday = (Integer)upday.getSelectedItem();
	//			String today = "19/08/13";
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("VO오류: "+e.getMessage());
			}
			JPanel btn=new JPanel();
			btn_in=new JButton("등록하기");
			
			btn.add(btn_in);
			
//			BE_ProductVo po=new BE_ProductVo();
			btn_in.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					JOptionPane.showMessageDialog(null,"상품등록에 성공하셨습니다");
					
					// TODO Auto-generated method stub
					BE_ProductVo po = new BE_ProductVo();
					BE_ProductDao dao=new BE_ProductDao();
					try {
						
					
						po.setPname(pname.getText());
						po.setP_Price(Integer.parseInt(pricenum.getText()));
						po.setStock(Integer.parseInt(stock.getText()));
						po.setCtNum(ctnum);
						po.setP_Category(p_category.getText());
						po.setP_Cdate(transformDate(year, month, day+forday));
						po.setBrand(brand.getText());
						po.setCompany(company.getText());
						po.setOrigin(origin.getText());
						po.setAs_Info(as_info.getText());
						po.setP_Image(p_image.getText());
						po.setLikes(Integer.parseInt(likes.getText()));
						po.setHits(Integer.parseInt(hits.getText()));
						po.setP_Sangse(p_sangse.getText());
						int re=dao.insertProduct(po);
						System.out.println(re);
					if(re==1)
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"상품등록에 실패하셨습니다");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				}
			});
			JLabel title=new JLabel("상품등록");
			title.setFont(new Font("나눔고딕", Font.BOLD, 20));
			//f=new JFrame();
			JPanel tt=new JPanel();
			tt.setLayout(new BorderLayout());
			tt.add(title,BorderLayout.WEST);
			JPanel p_total=new JPanel();
			p_total.setLayout(new BorderLayout());
			p_total.add(p,BorderLayout.NORTH);
			JPanel total=new JPanel();
			total.setLayout(new BorderLayout(0, 0));
			total.add(tt, BorderLayout.NORTH);
			total.add(p_total, BorderLayout.CENTER);
			p_sangse =new JTextArea();
			p_sangse.setColumns(30);
			
			JPanel ta=new JPanel();
			p_total.add(ta, BorderLayout.CENTER);
			ta.setLayout(new BorderLayout());
			ta.add(new JLabel("상세정보"),BorderLayout.NORTH);
			ta.add(p_sangse,BorderLayout.CENTER);
			total.add(btn, BorderLayout.SOUTH);
			
			getContentPane().add(total);
			
			
			setSize(600,1000);
			setVisible(true);
		}
		 public Date transformDate(String year, String month, String day)
		    {
		        String date = year+"/"+month+"/"+day;
		        Date d = Date.valueOf(date);
		        
		        return d;
		    }
		 public void insertProduct() {
			 
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BE_Productinsert();
	}
 
}
