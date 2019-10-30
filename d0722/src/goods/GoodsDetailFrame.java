package goods;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GoodsDetailFrame extends JFrame {
	JLabel jlb_fname;
	JTextField jtf_name;
	JTextField jtf_price;
	JTextField jtf_qty;
	JTextField jtf_no;
	
	public GoodsDetailFrame(GoodsVo g) {
	
		ImageIcon icon = new ImageIcon("c:/goods/"+g.getFname());
		jlb_fname = new JLabel(icon);
		jtf_name = new JTextField(g.getName());
		jtf_price = new JTextField(g.getPrice()+"");
		jtf_qty = new JTextField(g.getQty()+"");
		jtf_no = new JTextField(g.getNo()+"");
		
		add(jlb_fname, BorderLayout.CENTER);
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 2));
		jp.add(new JLabel("상품번호"));
		jp.add(jtf_no);
		jp.add(new JLabel("상품명"));
		jp.add(jtf_name);
		jp.add(new JLabel("상품가격"));
		jp.add(jtf_price);
		jp.add(new JLabel("수량"));
		jp.add(jtf_qty);
		setVisible(true);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("상품상세");
		add(jp, BorderLayout.EAST);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				GoodsListFrame.detail = null;
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void changeGoods(GoodsVo g) {
		// TODO Auto-generated method stub
		ImageIcon icon = new ImageIcon("c:/goods/"+g.getFname());
		jlb_fname.setIcon(icon);
		jtf_name.setText(g.getName());
		jtf_price.setText(g.getPrice()+"");
		jtf_qty.setText(g.getQty()+"");
		jtf_no.setText(g.getNo()+"");
	}

}
