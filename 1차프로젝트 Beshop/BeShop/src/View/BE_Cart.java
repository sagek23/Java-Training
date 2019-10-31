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
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DB.ConnectionProvider;



public class BE_Cart extends JFrame {
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
	JTextField shFee;
	String ppname;//구매할 상품명
	String ppopt;//옵션
	int ppcount;//개수
	int pprice;//가격
	JLabel lb1;
	JLabel lb2;
	static String imgPath;
	JTextField mamount;
	JTextField eAmount;
	Font f1, f2, f3;
	ImageIcon img;
	public BE_Cart(String imgPath) {
		// TODO Auto-generated constructor stub
		//selectProduct();
		//ppname = sd.pname.getText();
		//ppopt = sd.jcb.getSelectedItem().toString();
		f1 = new Font("돋움", Font.PLAIN, 20);
		f2 = new Font("돋움", Font.PLAIN, 15);
		f3 = new Font("돋움", Font.PLAIN, 40);
		
		img = new ImageIcon(imgPath);
		
		lb1 = new JLabel("주문상품");
		lb2 = new JLabel(img);
		orderP1 = new JTextField(20);
		orderP2 = new JTextField(20);
		orderP3 = new JTextField(20);
		orderP4 = new JTextField(20);
		orderP5 = new JTextField(20);
		
		
		String shipping;
		if(pprice>=50000)
		{
		 shipping = "배송비: 무료";
		}
		else
		{
			shipping = "배송비: 선불 2500원";
		}
		orderP1.setText(ppname);
		orderP2.setText(pprice+"");
		orderP5.setText(ppopt);
		orderP4.setText(Integer.toString(ppcount));
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
		lab.add(lb1);
		lab.add(lb2);
		JPanel oPro = new JPanel(); //주문상품
		oPro.setBorder(new LineBorder(Color.black));
		oPro.setLayout(new GridLayout(1,2));
		//oPro.add(lb2);
		//oPro.add(lb3);
		oPro.add(lab);
		oPro.add(prod);
		
		JLabel amount = new JLabel("결제금액");
		JLabel sFee = new JLabel("배송비");
		mamount = new JTextField(100);
		mamount.setEditable(false);
		shFee = new JTextField(100);
		shFee.setEditable(false);
		mamount.setText(pprice+"");
	
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
		

		
		JPanel button = new JPanel();
		JButton keep = new JButton("쇼핑 계속하기");
		JButton buy = new JButton("구매하기");
		button.setLayout(new FlowLayout());
		button.add(keep);
		button.add(buy);
		
		JPanel ee = new JPanel();
		eAmount = new JTextField(100);
		JLabel esti = new JLabel("예상결제금액");
		int pri = pprice;
		int fee;
		if(pprice>=50000)
		{
			fee=0;
		}
		else
		{
			fee = 2500;
		}
		eAmount.setText((pri+fee)+"");
		eAmount.setEditable(false);
		ee.setLayout(new GridLayout(1,2));
		ee.add(esti);
		ee.add(eAmount);
		ee.setBorder(new LineBorder(Color.black));
		
		
		JPanel pAmount = new JPanel(); //결제금액,배송비
		pAmount.setLayout(new BoxLayout(pAmount, BoxLayout.Y_AXIS));
		//pAmount.add(lb4);
		pAmount.add(pa);
		pAmount.add(ee);
		pAmount.add(button);
		pAmount.setBorder(new LineBorder(Color.black));
		
		
		buy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BE_Purchase pp = new BE_Purchase(imgPath);
				pp.orderP5.setText(orderP5.getText());
				pp.orderP4.setText(orderP4.getText());
				int co = Integer.parseInt(orderP4.getText());
				int price = Integer.parseInt(orderP2.getText());
				int tot = price*co;

				int fee;
				
				if(price>=50000)
				{
					fee=0;

				}
				else
				{
					fee = 2500;
				}
				pp.mamount.setText(Integer.toString(tot));
				pp.money.setText(Integer.toString(tot+fee));
			}
		});
		
		
		add(oPro);
		add(pAmount);
		
		lb1.setFont(f1);
		lb2.setFont(f1);
		orderP1.setFont(f1);
		orderP2.setFont(f1);
		orderP3.setFont(f1);
		orderP4.setFont(f1);
		orderP5.setFont(f1);
		amount.setFont(f1);
		sFee.setFont(f1);
		shFee.setFont(f1);
		keep.setFont(f1);
		buy.setFont(f1);
		esti.setFont(f1);
		eAmount.setFont(f1);
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		int y = res.height;
		int x= res.width;
		setSize(x, y);
		setVisible(true);
		setLayout(new GridLayout(2,1));
	
	}
	
	public void selectOpc() {
		
		String sql = "select slcount, select_op from shoplist where slnum = 1";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				ppcount = rs.getInt(1);
				ppopt = rs.getString(2);
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
		new BE_Cart(imgPath);
		
	}
	
}
