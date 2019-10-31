package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BE_ReviewDetail extends JFrame {
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	JTextField title;
	JTextField uid;
	JTextField rdate;
	JTextArea review;
	//JButton ans;
	//JTextArea answer;
	Font f1, f2, f3;
	public BE_ReviewDetail() {
		// TODO Auto-generated constructor stub
		f1 = new Font("돋움", Font.PLAIN, 20);
		f2 = new Font("돋움", Font.PLAIN, 15);
		f3 = new Font("돋움", Font.PLAIN, 40);
		lb1 = new JLabel("제목");
		lb2 = new JLabel("작성자");
		lb3 = new JLabel("작성일");
		lb4 = new JLabel("리뷰");
		
		title = new JTextField(40);
		uid = new JTextField(10);
		rdate = new JTextField(10);
		review = new JTextArea(20,20);
		
		lb1.setFont(f1);
		lb2.setFont(f1);
		lb3.setFont(f1);
		lb4.setFont(f1);
		
		title.setFont(f1);
		uid.setFont(f1);
		rdate.setFont(f1);
		review.setFont(f1);
		//answer = new JTextArea(20, 20);
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		
		a.setLayout(new FlowLayout());
		a.add(lb1);
		a.add(title);
		a.add(lb2);
		a.add(uid);
		a.add(lb3);
		a.add(rdate);
	
		b.setLayout(new BorderLayout());
		b.add(lb4, BorderLayout.NORTH);
		b.add(review, BorderLayout.CENTER);
		
		JPanel all = new JPanel();
		all.add(a);
		all.add(b);
		all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
		
		setLayout(new BorderLayout());
		add(all, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1500, 1000);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BE_ReviewDetail();
	}

}
