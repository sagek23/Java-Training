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
	 
	 btnTrans = new JButton("변환");
	 btnCancel = new JButton("취소");
	 
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
	 
	 setTitle("텍스트변환");
	 setVisible(true);
	 setSize(400, 300);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 

	 
	 mapTrans.put("사자", "lion");
	 mapTrans.put("호랑이", "tiger");
	 mapTrans.put("고양이", "cat");
	 mapTrans.put("곰", "bear");
	 mapTrans.put("개", "dog");
	 mapTrans.put("표범", "leopard");
	 mapTrans.put("재규어", "jaguar");
	 mapTrans.put("치타", "cheetah");
	 mapTrans.put("독수리", "eagle");
	
	
	
	
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
					{result += word;}//map에 저장된 값이 아니면 null이므로 r의 값이 null인경우는 한글 그대로 출력
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
