package View;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BE_QnaDetail extends JFrame {
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	JLabel lb4;
	JLabel lb5;
	JTextField title;
	JTextField uid;
	JTextField qdate;
	JTextArea question;
	JButton ans;
	JTextArea answer;
	Font f1, f2, f3;
	public BE_QnaDetail() {
		// TODO Auto-generated constructor stub
		f1 = new Font("돋움", Font.PLAIN, 20);
		f2 = new Font("돋움", Font.PLAIN, 15);
		f3 = new Font("돋움", Font.PLAIN, 40);
		lb1 = new JLabel("제목");
		lb2 = new JLabel("작성자");
		lb3 = new JLabel("작성일");
		lb4 = new JLabel("문의내용");
		lb5 = new JLabel("답변");
		title = new JTextField(40);
		uid = new JTextField(10);
		qdate = new JTextField(10);
		question = new JTextArea(20,20);
		ans = new JButton("답변");
		answer = new JTextArea(20,20);
		
		lb1.setFont(f1);
		lb2.setFont(f1);
		lb3.setFont(f1);
		lb4.setFont(f1);
		lb5.setFont(f1);
		
		title.setFont(f1);
		uid.setFont(f1);
		qdate.setFont(f1);
		question.setFont(f1);
		ans.setFont(f1);
		answer.setFont(f1);
		
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		JPanel c = new JPanel();
		JPanel all = new JPanel();
		
		a.setLayout(new FlowLayout());
		a.add(lb1);
		a.add(title);
		a.add(lb2);
		a.add(uid);
		a.add(lb3);
		a.add(qdate);
		a.add(ans);
		b.setLayout(new BorderLayout());
		b.add(lb4, BorderLayout.NORTH);
		b.add(question, BorderLayout.CENTER);
		
		ans.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.setLayout(new BorderLayout());
				c.add(lb5, BorderLayout.NORTH);
				c.add(answer, BorderLayout.CENTER);
				ans.updateUI();
				answer.updateUI();
				lb5.updateUI();
				all.add(c);
			}
		});
		
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
		new BE_QnaDetail();
	}

}
