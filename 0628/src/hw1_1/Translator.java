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
String suffix [] = {"��", "��","��", "��", "��", "����"};
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
	

	
	//�ܾ �Ű������� ���޹޾� �� �ܾ ����(suffix)�߿� �ϳ��� ��������
	//�Ǻ��Ͽ� �ش� ���縦 ��ȯ�ϴ� �޼ҵ带 ����.
	//����� �������ʴ� �ܾ�� null�� ��ȯ.
	

	
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
