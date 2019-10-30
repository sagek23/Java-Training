package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import BE_PurchaseDao.BE_PayDao;
import BE_PurchaseVo.BE_PayVo;
import BE_PurchaseVo.BE_PurchaseVo;
import DB.ConnectionProvider;
import javafx.scene.layout.Border;

public class BE_Purchase extends JFrame {
	BE_PurchaseVo pv = new BE_PurchaseVo();
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	JTextField mamount;
	JTextField orderP1;
	JTextField orderP2;
	JTextField orderP3;
	JTextField orderP4;
	JTextField orderP5;
	JTextField addr;
	JTextField name;
	JTextField zip;
	JTextField phone;
	JButton order;
	String ppname;
	String ppopt;
	int pprice;
	int ppcount;
	int pnum;
	int pcnum;
	int pri;
	String pphone;
	String pzip;
	String paddr;
	JTextField money;
	int fee;
	JTextField shFee;
	String shipping;
	String bpoint;
	String kakao;
	String credit;
	String deposit;
	Font f1, f2, f3;
	BE_PayVo v;
	BE_PayDao dao;
	static String imgPath;
	ImageIcon img;
	//BE_ShoppingDetail3 sd = new BE_ShoppingDetail3();
	public BE_Purchase(String imgPath) {
		// TODO Auto-generated constructor stub
		v = new BE_PayVo();
		dao = new BE_PayDao();
		f1 = new Font("돋움", Font.PLAIN, 20);
		f2 = new Font("돋움", Font.PLAIN, 15);
		f3 = new Font("돋움", Font.PLAIN, 40);
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		int y = res.height;
		int x= res.width;
		img = new ImageIcon(imgPath);
		
		selectProduct();
		lb1 = new JLabel("배송지");
		lb2 = new JLabel("주문상품");
		lb3 = new JLabel(img);
		lb4 = new JLabel("최종결제금액");
		order = new JButton("주문하기");
		addr = new JTextField(100);
		name = new JTextField(100);
		zip = new JTextField(100);
		phone = new JTextField(100); //배송지
		
		
		
		JPanel ainfo = new JPanel();
		JPanel info = new JPanel();
		JLabel wname = new JLabel("이름");
		JLabel wphone = new JLabel("전화번호");
		JLabel wzip = new JLabel("우편번호");
		JLabel waddr = new JLabel("주소");
		info.setLayout(new GridLayout(1,2));
		info.add(wname);
		info.add(name);
		
		
		JPanel info2 = new JPanel();
		info2.setLayout(new GridLayout(1,2));
		info2.add(wphone);
		info2.add(phone);
		
		
		JPanel info3 = new JPanel();
		info3.setLayout(new GridLayout(1,2));
		info3.add(wzip);
		info3.add(zip);
		
		JPanel info4 = new JPanel();
		info4.setLayout(new GridLayout(1,2));
		info4.add(waddr);
		info4.add(addr);
		
		JPanel allinfo = new JPanel(); //배송지
		allinfo.setLayout(new BoxLayout(allinfo, BoxLayout.Y_AXIS));
		allinfo.add(info);
		allinfo.add(info2);
		allinfo.add(info3);
		allinfo.add(info4);
		JPanel adrs = new JPanel();
		adrs.setBorder(new LineBorder(Color.black));
		adrs.setLayout(new GridLayout(1,2));
		adrs.add(lb1);
		adrs.add(allinfo);
		adrs.setSize(x, (y/4));
		
	
		orderP1 = new JTextField(20);
		orderP2 = new JTextField(20);
		orderP3 = new JTextField(20);
		orderP4 = new JTextField(20);
		orderP5 = new JTextField(20);
		
		orderP1.setText(ppname);
		orderP2.setText(Integer.toString(pprice));
		
		if(pprice>=50000)
		{
			fee=0;
			shipping="배송비: 무료";
		}
		else
		{
			fee = 2500;
			shipping = "배송비: 선불 2500원";
		}
		
		orderP3.setText(shipping);
		orderP1.setEditable(false);
		orderP2.setEditable(false);
		orderP3.setEditable(false);
		orderP4.setEditable(false);
		orderP5.setEditable(false);
		
		JPanel pp = new JPanel(); //제품명, 가격, 배송비
		pp.setLayout(new BoxLayout(pp, BoxLayout.Y_AXIS));
		pp.add(orderP1);
		pp.add(orderP2);
		pp.add(orderP5);
		pp.add(orderP4);
		pp.add(orderP3);
		JPanel prod = new JPanel(); 
		prod.setLayout(new BorderLayout());
		prod.add(pp, BorderLayout.CENTER);
		
		JPanel lab = new JPanel();
		lab.setLayout(new BoxLayout(lab, BoxLayout.Y_AXIS));
		lab.add(lb2);
		lab.add(lb3);
		JPanel oPro = new JPanel(); //주문상품
		oPro.setBorder(new LineBorder(Color.black));
		oPro.setLayout(new GridLayout(1,2));
		//oPro.add(lb2);
		//oPro.add(lb3);
		oPro.add(lab);
		oPro.add(prod);
		oPro.setSize(x, (y/4));
		
		JLabel amount = new JLabel("결제금액");
		JLabel sFee = new JLabel("배송비");
		mamount = new JTextField(100);
		mamount.setEditable(false);
		shFee = new JTextField(100);
		shFee.setEditable(false);
		int totm = pprice*ppcount;
		int tota = pprice+fee;
		
		//mamount.setText(Integer.toString(totm));
		
		if(pprice>=50000)
		{
			shFee.setText("0");
		}
		else
		{
			shFee.setText("2500");
		}
		
		JPanel pa = new JPanel();
		pa.setLayout(new GridLayout(2,2));
		pa.add(amount);
		pa.add(sFee);
		pa.add(mamount);
		pa.add(shFee);
		
		JPanel pAmount = new JPanel(); //결제금액,배송비
		pAmount.setLayout(new BorderLayout());
		//pAmount.add(lb4);
		pAmount.add(pa, BorderLayout.CENTER);
		pAmount.setBorder(new LineBorder(Color.black));
		pAmount.setSize(x, (y/4));
		
		JPanel total = new JPanel();//최종금액
		total.setLayout(new BoxLayout(total, BoxLayout.Y_AXIS));
		total.setBorder(new LineBorder(Color.black));
		JPanel mm = new JPanel();
		mm.setLayout(new GridLayout(1,1));		
		JLabel pment = new JLabel("총 결제금액 ");
		money = new JTextField();
		money.setEditable(false);
		//money.setText(Integer.toString(pprice+fee));
		mm.add(pment);
		mm.add(money);
		total.add(mm);
		total.add(order);
		total.setSize(x, (y/4));
		
		JPanel pmethod = new JPanel();//결제방법
		JLabel pmet = new JLabel("결제 방법");
		JRadioButton rb1 = new JRadioButton("BPoint");
		JRadioButton rb2 = new JRadioButton("카카오페이");
		JRadioButton rb3 = new JRadioButton("신용카드");
		JRadioButton rb4 = new JRadioButton("무통장입금");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		bg.add(rb4);
		pmethod.add(rb1);
		pmethod.add(rb2);
		pmethod.add(rb3);
		pmethod.add(rb4);
		

		lb1.setFont(f1);
		lb2.setFont(f1);
		lb3.setFont(f1);
		lb4.setFont(f1);
		
		order.setFont(f1);
		addr.setFont(f1);
		name.setFont(f1);
		zip.setFont(f1);
		phone.setFont(f1);
		wphone.setFont(f1);
		wname.setFont(f1);
		waddr.setFont(f1);
		wzip.setFont(f1);
		amount.setFont(f1);
		sFee.setFont(f1);
		mamount.setFont(f1);
		money.setFont(f1);
		rb1.setFont(f1);
		rb2.setFont(f1);
		rb3.setFont(f1);
		rb4.setFont(f1);
		pment.setFont(f1);
		pmet.setFont(f1);
		orderP1.setFont(f1);
		orderP2.setFont(f1);
		orderP3.setFont(f1);
		orderP4.setFont(f1);
		orderP5.setFont(f1);
		shFee.setFont(f1);
		
		rb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bpoint = rb1.getText();
				v.setPayWay(bpoint);
			}
		});
		rb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				kakao = rb2.getText();
				v.setPayWay(kakao);
			}
		});
		rb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				credit = rb3.getText();
				v.setPayWay(credit);
			}
		});
		rb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deposit = rb4.getText();
				v.setPayWay(deposit);
			}
		});
		pmethod.setLayout(new FlowLayout());
		
		JPanel radio = new JPanel();
		radio.setLayout(new GridLayout(3,1));
		JLabel blank = new JLabel();
		radio.add(blank);
		radio.add(blank);
		radio.add(blank);
		radio.add(blank);
		radio.add(pmethod);
		
		JPanel payment = new JPanel();
		payment.setLayout(new GridLayout(1,2));
		payment.add(pmet);
		payment.add(radio);
		payment.setBorder(new LineBorder(Color.black));
		payment.setSize(x, (y/4));
		payment.setBorder(new LineBorder(Color.black));
		
		phone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pphone = phone.getText();
			}
		});
		zip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pzip = zip.getText();
			}
		});
		addr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				paddr = addr.getText();
			}
		});
		
		setLayout(new GridLayout(5,1));
		add(oPro);
		add(adrs);
		add(pAmount);
		add(payment);
		add(total);
		
		v.setPayPrice(tota);
		
		v.setPcNum(1);
		
		order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertPurchase();
				dao.insertPay(v);
			}
		});
		setSize(x, y);
		setVisible(true);
	}
	
	public int insertPurchase()	{
		int re =-1;
		String sql = "insert into purchase values((select max(pcnum)+1 from purchase), ?,?,?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pnum);
			pstmt.setInt(2, Integer.parseInt(orderP4.getText()));
			pstmt.setInt(3, Integer.parseInt(money.getText()));
			pstmt.setString(4, phone.getText());
			pstmt.setString(5, zip.getText());
			pstmt.setString(6, addr.getText());
			pstmt.setString(7, orderP5.getText());
			re = pstmt.executeUpdate();
			if(re>=1)
			{
				JOptionPane.showMessageDialog(null, "주문이 정상적으로 접수되었습니다.");
			}
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	public void selectProduct() {

		String sql = "select pname, p_price, pnum from product where pnum = 1";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				//sd.pname.setText(rs.getString(1));
				//sd.price.setText(Integer.toString(rs.getInt(2)));
				pnum = rs.getInt(3);
				ppname = rs.getString(1);
				pprice = rs.getInt(2);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Application.launch(ShoppingApp.class, args);
		new BE_Purchase(imgPath);
		
	}
}
