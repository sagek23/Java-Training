package hw1_1;

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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Translator extends JFrame {

 JTextArea taKor;
 JTextArea taEng;
 
 String kor;
 String eng;
 
 JButton btnTrans;
 JButton btnCancel;
 
 HashMap<String, String> mapTrans;
String suffix [] = {"가", "로","는", "이", "은", "에게"};
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
	

	
	//단어를 매개변수로 전달받아 그 단어가 조사(suffix)중에 하나로 끝나는지
	//판별하여 해당 조사를 반환하는 메소드를 정의.
	//조사로 끝나지않는 단어는 null을 반환.
	

	
	btnTrans.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String text = taKor.getText();
			Scanner sc = new Scanner(text);
			
			while(sc.hasNext())
			{
				String line = sc.nextLine();
				Scanner scWord = new Scanner(line);
				while(scWord.hasNext())
				{
					String word = scWord.next();
					
					String ends = suff(word);
					word = word.substring(0, word.length()-ends.length());
					
					String result = mapTrans.get(word);
					if(result!=null)
					{
						String r = suff(word);
						
					
						taEng.append(result+ends+" ");
					}
					else
					{
						taEng.append(word+ends+" ");
					}
				}
				taEng.append("\n");
			}
			
			sc.close();
			
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

public String suff(String word) {
	String r = "";
	for(String s:suffix)
	{
		if(word.endsWith(s))
		{
			r =s;
			break;
		}
	}
	return r;
}
	
}
