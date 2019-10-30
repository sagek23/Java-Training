package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import BE_SellerVo.BE_QnaVo;
import BE_Sellerdao.BE_QnaDao;
import BE_ShoppingDao.BE_ProductDao;
import BE_ShoppingDao.BE_ReViewDao;
import BE_ShoppingVo.BE_ReviewVo;
import DB.ConnectionProvider;

public class GbuyDetailPage extends JFrame{
	
	//�μ�Ʈ�Ǿ� �ִ� ������ db���� �������� 
	String vname="";
	String pname="";
	int p_Price=0;
	int stock=0;
	String p_image="";
	Date P_cdate=null;
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	Vector<String> colNames1;
	Vector<Vector<String>> rowData1;
	JTable jt;
	JTable jt1;
	public GbuyDetailPage() { 
		// TODO Auto-generated constructor stub
		
		String sql="select vname,pname,p_Price,stock,p_Image,p_cdate from Product,Video where Product.pnum=Video.pnum and product.pnum=1";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement stmt =conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				vname=rs.getString(1);
				pname=rs.getString(2);
				p_Price=rs.getInt(3);
				stock=rs.getInt(4);
				p_image=rs.getString(5);
				P_cdate=rs.getDate(6);
			
			}
			ConnectionProvider.close(conn, stmt,rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		rowData = new Vector<Vector<String>>();//qna
		colNames = new Vector<String>();//qna
		rowData1 = new Vector<Vector<String>>(); //review
		colNames1 = new Vector<String>(); //revoew
		
		colNames.add("제목"); //qna
		colNames.add("작성자");
		colNames.add("작성일");
		colNames1.add("제목"); //review
		colNames1.add("작성자");
		colNames1.add("조회수");
		colNames1.add("작성일");

		try {
			selectQna();
			selectReview();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		jt = new JTable(rowData, colNames); //qna
		jt1 = new JTable(rowData1, colNames1); //review
		JScrollPane jspp = new JScrollPane(jt);
		JScrollPane jspp2 = new JScrollPane(jt1);
		
		//ImageIcon imgfile=new ImageIcon("image/videoimg.jpg");
		JPanel video=new VideoPlayer(4);
		video.setPreferredSize(new Dimension(500,500));
		JLabel uptime=new JLabel("LIVE 2019:08:13:02:30 실시간방송");
		
		JLabel vtitle=new JLabel(vname);
		JLabel title=new JLabel(pname);
		title.setFont(new Font("나눔고딕",Font.BOLD,13 ));
		
		JLabel detail2=new JLabel("2019.08.14 마감");
		JLabel detail3=new JLabel("600%달성");
		
		JLabel price=new JLabel(p_Price+"원");
		price.setFont(new Font("나눔고딕",Font.BOLD, 20));

	
		String amount[]= {"1","2","3","4"};
		JComboBox cb=new JComboBox(amount);
		
		JButton cart=new JButton("장바구니"); 
		JButton order=new JButton("바로구매");
		
		JPanel btn=new JPanel();
		btn.add(cart);
		btn.add(order);
		btn.setLayout(new FlowLayout());
		
		JPanel o=new JPanel();
		o.setLayout(new GridLayout(7,1));
		o.add(uptime);
		o.add(title);
		o.add(detail2);
		o.add(detail3);
		o.add(price);
		o.add(cb);
		o.add(btn);
		
		JPanel up=new JPanel();
		up.setLayout(new BorderLayout());
		up.add(video,BorderLayout.CENTER);
		up.add(o,BorderLayout.EAST);
		
		
		ImageIcon imgdetail=new ImageIcon("image/ab.jpg");
		JLabel img=new JLabel(imgdetail);
		
		
	
		
		JPanel down=new JPanel();
		down.setLayout(new GridLayout(2,1));
		down.add(img);
		
		JTabbedPane tab=new JTabbedPane();
		tab.add("상세정보",down);
		tab.add("리뷰",jspp);
		tab.add("Q&A",jspp2);
		
		JPanel total=new JPanel();
		total.setLayout(new GridLayout(2,1));
		total.add(up);
		total.add(tab);
		
		
		add(total);
		setSize(1200,800);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void selectReview(){
		rowData1.clear();
		ArrayList<BE_ReviewVo> list1 = new ArrayList<BE_ReviewVo>();
		BE_ReViewDao dao = new BE_ReViewDao(); //새로 추가
		list1 = dao.selectReview();
		for(BE_ReviewVo vo : list1) {
			Vector<String> v = new Vector<String>();
			v.add(vo.getReTitle());
			v.add(vo.getbeUid());
			v.add(vo.getRe_Hits()+"");
			v.add(vo.getReDate()+"");
			rowData1.add(v);
		}
	}
	public void selectQna(){
		rowData.clear();
		ArrayList<BE_QnaVo> list = new ArrayList<BE_QnaVo>();
		BE_QnaDao dao = new BE_QnaDao(); //새로 추가
		list = dao.selectQna();
		for(BE_QnaVo vo : list) {
			Vector<String> v= new Vector<String>();
			v.add(vo.getQna_Title());
			v.add(vo.getbeUid());
			v.add(vo.getRegist_Date()+"");
			
			rowData.add(v);
		}
	}
}
