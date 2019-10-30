package hw1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Translator extends JFrame {

 JTextArea taKor;
 JTextArea taEng;
 
 String kor;
 String eng;
 
 JButton btnTrans;
 JButton btnCancel;
 
 HashMap<String, String> mapTrans;

 public Translator()
 {
	 Scanner sc = new Scanner(System.in);
	 taKor = new JTextArea(10,15);
	 taEng = new JTextArea(10,15);
	 
	 btnTrans = new JButton("��ȯ");
	 btnCancel = new JButton("���");
	 
	 mapTrans = new HashMap<String, String>();
	 
	 
	 JPanel jp_input = new JPanel();
	 JPanel jp_btn = new JPanel();
	 
	 JScrollPane jsp = new JScrollPane(taKor, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 JScrollPane jsp1 = new JScrollPane(taEng,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	 
	 setLayout(new BorderLayout());
	 jp_input.add(jsp);
	 jp_input.add(jsp1);
	 jp_input.setLayout(new GridLayout(1, 2, 10, 0));
	 ;
	 jp_btn.add(btnTrans);
	 jp_btn.add(btnCancel);
	 jp_btn.setLayout(new FlowLayout());
	 
	 
	
	 
	 add(jp_input, BorderLayout.CENTER);
	 add(jp_btn, BorderLayout.SOUTH);
	 
	 setTitle("�ؽ�Ʈ��ȯ");
	 setVisible(true);
	 setSize(400, 300);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 

	 
	 mapTrans.put("����", "lion");
	 mapTrans.put("ȣ����", "tiger");
	 mapTrans.put("�����", "cat");
	 mapTrans.put("��", "bear");
	 mapTrans.put("��", "dog");
	 mapTrans.put("ǥ��", "leopard");
	 mapTrans.put("��Ծ�", "jaguar");
	 mapTrans.put("ġŸ", "cheetah");
	 mapTrans.put("������", "eagle");
	
	
	
	
	btnTrans.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnTrans)
			{
				//taKor.setText("");
				String text = taKor.getText();
				//text.split(" ");
				StringTokenizer st = new StringTokenizer(text);
				
				String result = "";
				
				while(st.hasMoreElements())
				{
					String word = st.nextToken();
					String r = mapTrans.get(word);
					if(r != null)
					{result += r;}
					else
					{result += word;}//map�� ����� ���� �ƴϸ� null�̹Ƿ� r�� ���� null�ΰ��� �ѱ� �״�� ���
					result += " ";
				}
				//String word = mapTrans.get(taKor.getText());
				taEng.append(result);
			
			}
			
		}
	});
	
	btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnCancel)
			{
				taKor.setText("");	
				taEng.setText("");	
			}
			
		}
	});
 }
	
}
