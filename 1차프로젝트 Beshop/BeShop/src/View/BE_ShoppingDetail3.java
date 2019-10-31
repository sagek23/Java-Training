package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BE_SellerVo.BE_QnaVo;
import BE_Sellerdao.BE_QnaDao;
import BE_ShoppingDao.BE_ReViewDao;
import BE_ShoppingVo.BE_ProductVo;
import BE_ShoppingVo.BE_ReviewVo;
import DB.ConnectionProvider;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;


public class BE_ShoppingDetail3 extends JFrame{
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	Vector<String> colNames1;
	Vector<Vector<String>> rowData1;
	JTable jt;
	JTable jt1;
	Socket socket;   
	OutputStream os; 
	InputStream is;  
	String ip;       
	int port=8080;   
	String myMsg;  
	String name;    
	
	int pnum;
	JComboBox<String> jcb;
	JComboBox<Integer> jcount;
	JTextField pname;
	JTextField price;
	JLabel lb;
	JButton cart;
	JButton buyNow;
	WebView webview;
	Scene sc;
	Vector<String> option;
	Vector<Integer> pprice;
	Vector<Integer> qty;
	String ppopt;
	String p_image;
	String imgPath;
	int ppcount; 
	String ppri;
	String ppna;
	JTextArea chat;
	JTextField jtf;
	JButton ent;
	JButton auc;
	int qnanum;
	int renum;
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	
	Font f1, f2, f3;
	ArrayList<BE_QnaVo> list;
	ArrayList<BE_ReviewVo> list1;
	BE_ProductVo vo = new BE_ProductVo();
	public BE_ShoppingDetail3() {
		f1 = new Font("돋움", Font.PLAIN, 20);
		f2 = new Font("돋움", Font.PLAIN, 15);
		f3 = new Font("돋움", Font.PLAIN, 40);
		option = new Vector<String>();
		pprice = new Vector<Integer>();
		qty = new Vector<Integer>();
		list = new ArrayList<BE_QnaVo>();
		list1 = new ArrayList<BE_ReviewVo>();
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

		com.sun.javafx.application.PlatformImpl.startup(()->{});
		Platform.runLater(() -> {
		webview = new WebView();
		int y = res.height;
		int x = res.width;
		
		jt = new JTable(rowData, colNames); //qna
		jt1 = new JTable(rowData1, colNames1); //review
		JScrollPane jspp = new JScrollPane(jt);
		JScrollPane jspp2 = new JScrollPane(jt1);
		JTabbedPane tab = new JTabbedPane();
		JPanel info = new JPanel();
		JPanel review = new JPanel();
		JPanel qna = new JPanel();
		JPanel delivery = new JPanel();
		int rnum;
		
		JFXPanel fx = new JFXPanel();
		fx.setScene(new Scene(webview));

		
		
		try {
			selectQna();
			selectReview();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		jt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//BE_QnaDetail qd = new BE_QnaDetail();
				qnanum = jt.getSelectedRow()+1;
				selectQnaAll(qnanum);
				
			}
		});
		
		
		jt1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//BE_ReviewDetail rd = new BE_ReviewDetail();
				renum = jt1.getSelectedRow()+1;
				selectReviewAll(renum);
			}
		});
		
		
		String url="https://www.youtube.com/embed/ECQLmaoyQhQ?autoplay=1";
   	    webview.getEngine().load(
   	    url
   	    );

		tab.addTab("상세정보", info);
		ImageIcon img = new ImageIcon("image/galaxyNote10.jpg");
		JLabel propho = new JLabel(img);
		info.add(propho);
		tab.addTab("구매후기",jspp2);
		tab.addTab("상품Q&A", jspp);
		//tab.addTab("배송/교환/반품", delivery);
		tab.setFont(f2);
		JScrollPane jspt = new JScrollPane(tab);
		
		jcb = new JComboBox<String>(option);
		jcount =  new JComboBox<Integer>(qty);
		pname = new JTextField(50);
		price = new JTextField(50);
		lb = new JLabel("방송제목");
		pname.setFont(f1);
		price.setFont(f1);
		lb.setFont(f3);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1.add(lb, BorderLayout.NORTH);
		//jp1.setScene(new Scene(webview));
		//jp1.setScene(sc);
		jp1.add(fx, BorderLayout.CENTER);
		//jp1.setSize(x, y);
		JPanel jp = new JPanel();//tab
		jp.setLayout(new BorderLayout());
		jp.add(jspt, BorderLayout.CENTER);
		
		JPanel jp3 = new JPanel();
		jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));
		//jp3.setLayout(new BorderLayout());
		jp3.add(jp1);
		jp3.add(jp);
		jp3.setSize(1500, y);
		
		cart = new JButton("장바구니");
		buyNow = new JButton("바로구매");
		auc = new JButton("경매");
		JButton wish = new JButton("찜하기");
		JButton full = new JButton("전체화면");
		JButton mini = new JButton("소형화면");
		JPanel jpbtn = new JPanel();
		JPanel jpscr = new JPanel();
		JPanel jpshop = new JPanel();
		jpscr.setLayout(new FlowLayout());
		jpscr.add(full);
		jpscr.add(mini);
		jpshop.setLayout(new FlowLayout());
		jpshop.add(cart);
		jpshop.add(buyNow);
		jpshop.add(auc);
		jpshop.add(wish);
		jpbtn.setLayout(new BorderLayout());
		
		jpbtn.add(jpscr, BorderLayout.NORTH);
		jpbtn.add(jpshop, BorderLayout.CENTER);
		
		
		wish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertWish();
			}
		});
		
		jcb.setFont(f2);
		jcount.setFont(f2);
		JPanel blank = new JPanel();
		JPanel blank2 = new JPanel();
		JPanel blank3 = new JPanel();
		JPanel blank4 = new JPanel();
		JPanel blank5 = new JPanel();
		JPanel blank6 = new JPanel();
		chat = new JTextArea(75, 50);
		jtf = new JTextField(50);
		JScrollPane cha = new JScrollPane(chat);
		ent = new JButton("입력");
		
		JPanel chatty = new JPanel();
		chatty.setLayout(new FlowLayout());
		chatty.add(jtf);
		chatty.add(ent);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));
		jp2.add(blank);
		jp2.add(blank2);
		jp2.add(pname);
		jp2.add(blank3);
		jp2.add(price);
		jp2.add(blank4);
		jp2.add(jcb);
		jp2.add(blank5);
		jp2.add(jcount);
		jp2.add(blank6);
	//	jp2.add(jpbtn);
		jp2.add(jpshop);
		jp2.add(cha);
		jp2.add(chatty);
		jp2.setSize(1000, 1000);
		
		cart.setFont(f2);
		buyNow.setFont(f2);
		wish.setFont(f2);
		ent.setFont(f2);
		auc.setFont(f2);
		
		
		//ppcount = Integer.parseInt((String)jcount.getSelectedItem());

		selectProduct();
		selectOption();
		selectStock();
		
		String name = pname.getText();
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ppopt = jcb.getSelectedItem().toString();
			
			}
		});
		jcount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				ppcount = Integer.parseInt(jcount.getSelectedItem().toString());
			}
		});
		
		cart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					insesrtCart();
					BE_Cart ca = new BE_Cart(imgPath);			
					ca.imgPath = imgPath;
					ca.orderP1.setText(name);
					ca.orderP5.setText(ppopt);
					ca.orderP1.setText(name);
					ca.orderP2.setText(price.getText());
					int pri = Integer.parseInt(price.getText());
					int totm = pri*ppcount;
					//pp.mamount.setText(Integer.toString(totm));
					if(totm>=50000)
					{
						ca.shFee.setText("0");
					}
					else
					{
						ca.shFee.setText("2500");
					}
					ca.orderP5.setText(ppopt);
					ca.orderP4.setText(Integer.toString(ppcount));
					ca.mamount.setText(Integer.toString(totm));
					int fee;
					if(pri>=50000)
					{
						fee=0;

					}
					else
					{
						fee = 2500;
					}
					ca.eAmount.setText(Integer.toString(totm+fee));
			}
		});
		
		buyNow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BE_Purchase pp = new BE_Purchase(imgPath);
				pp.orderP1.setText(name);
				pp.orderP5.setText(ppopt);
				pp.ppcount = ppcount;
				pp.orderP4.setText(Integer.toString(ppcount));
				pp.orderP1.setText(name);
				pp.orderP2.setText(price.getText());
				int pri = Integer.parseInt(price.getText());
				int totm = pri*ppcount;
				//pp.mamount.setText(Integer.toString(totm));
				
				int fee;
				if(pp.pprice>=50000)
				{
					fee=0;

				}
				else
				{
					fee = 2500;
				}
				pp.mamount.setText(Integer.toString(totm));
				pp.money.setText(Integer.toString(totm+fee));
			}
		});
	
		auc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					new BE_Octionframe();
			}
		});
		
		setLayout(new BorderLayout());
		add(jp3, BorderLayout.CENTER);
		add(jp2, BorderLayout.EAST);
		setSize(x, y);
		setVisible(true);
		});
		
	}
	public void selectProduct() {
		
		String sql = "select pname, p_price, pnum from product where pnum = 1";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				pname.setText(rs.getString(1));
				pname.setEditable(false);
				price.setText(rs.getInt(2)+"");
				price.setEditable(false);
				pnum = rs.getInt(3);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	

	public void selectOption() {
		String sql = "select select_op from product where pnum = 1";
		try {
			Connection conn = ConnectionProvider.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				String option[] = {rs.getString(1)}; 
				for(int i=0;i<=option.length;i++)
				{
					jcb.addItem(option[i]);
				}
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void selectStock() {
		String sql = "select stock from product where pnum = 1";
		try {
			Connection conn = ConnectionProvider.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				int stock = rs.getInt(1);
				for(int j=1;j<=stock;j++)
				{
					jcount.addItem(new Integer(j));
				}
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public int insesrtCart() {
		int re = -1;
		String sql = "insert into shoplist values((select max(slnum)+1 from shoplist), ?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			String option = jcb.getSelectedItem().toString();
			int count = Integer.parseInt(jcount.getSelectedItem().toString());
			pstmt.setInt(1, pnum);
			pstmt.setInt(2, count);
			pstmt.setString(3, option);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int insertWish() {
		int re = -1;
		String sql = "insert into wishlist values((select max(wnum)+1 from wishlist), 'godkkoo',2)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			//PreparedStatement pstmt = conn.prepareStatement(sql);
			//String option = jcb.getSelectedItem().toString();
			////String uid = "";
			//pstmt.setString(1, uid);
			//pstmt.setInt(2, pnum);

			if(re==1)
			{
				JOptionPane.showMessageDialog(null, "위시리스트에 추가되었습니다");
			}
			ConnectionProvider.close(conn, stmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	public void selectReviewAll(int renum){
		BE_ReviewDetail rd = new BE_ReviewDetail();
		ArrayList<BE_ReviewVo> list1 = new ArrayList<BE_ReviewVo>();
		BE_ReViewDao dao = new BE_ReViewDao(); //새로 추가
		list1 = dao.selectReviewAll(renum);
		for(BE_ReviewVo vo : list1) {
			rd.title.setText(vo.getReTitle());
			rd.title.setEditable(false);
			rd.uid.setText(vo.getbeUid());
			rd.uid.setEditable(false);
			rd.rdate.setText(vo.getReDate()+"");
			rd.rdate.setEditable(false);
			rd.review.setText(vo.getReContent());
			rd.review.setEditable(false);
		}
	}
	
	
	public void selectQnaAll(int qnanum){
		BE_QnaDetail qd = new BE_QnaDetail();
		ArrayList<BE_QnaVo> list = new ArrayList<BE_QnaVo>();
		BE_QnaDao dao = new BE_QnaDao();
		list = dao.selectQnaAll(qnanum);
		for(BE_QnaVo vo : list) {
			qd.title.setText(vo.getQna_Title());
			qd.title.setEditable(false);
			qd.uid.setText(vo.getbeUid());
			qd.uid.setEditable(false);
			qd.qdate.setText(vo.getRegist_Date()+"");
			qd.qdate.setEditable(false);
			qd.question.setText(vo.getQna_Content());
			qd.question.setEditable(false);
			qd.answer.setText(vo.getQna_Answer());
			qd.answer.setEditable(false);
		}
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
