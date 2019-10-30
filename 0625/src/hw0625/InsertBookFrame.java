package hw0625;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hwdao.BookDao;
import hwvo.BookVo;

public class InsertBookFrame extends JFrame {

	// TODO Auto-generated method stub
	JTextField tfBname; 
	JTextField tfPublisher; 
	JTextField tfPrice; 
	
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	
	JButton btn;
	
	public InsertBookFrame()
	{
		lb1 = new JLabel("������");
		lb2 = new JLabel("���ǻ�");
		lb3 = new JLabel("����");
		
		tfBname = new JTextField(10);
		tfPublisher = new JTextField(10);
		tfPrice = new JTextField(10);
		
		btn = new JButton("���");
		
		JPanel jp = new JPanel();
		
		setLayout(new BorderLayout());
		jp.add(lb1);
		jp.add(tfBname);
		jp.add(lb2);
		jp.add(tfPublisher);
		jp.add(lb3);
		jp.add(tfPrice);
		
		jp.setLayout(new GridLayout(3, 2));
		
		add(jp, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BookVo vo = new BookVo();
				BookDao dao = new BookDao();
				
				int price = Integer.parseUnsignedInt(tfPrice.getText());
				vo.setBookname(tfBname.getText());
				vo.setPublisher(tfPublisher.getText());
				vo.setPrice(price);
				
				
				int re = dao.insertBook(vo);
				if (re>0)
					JOptionPane.showMessageDialog(null, "��ϼ���");
				else
					JOptionPane.showMessageDialog(null, "��Ͻ���");
			}
		});
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
	
		new InsertBookFrame();
		
	}

}
