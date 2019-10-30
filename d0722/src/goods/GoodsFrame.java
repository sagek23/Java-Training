package goods;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GoodsFrame extends JFrame {
	
	JTextField jno;
	JTextField jname;
	JTextField jprice;
	//JTextField qty;
	JFileChooser jfc;
	JComboBox<Integer> cbQty;
	JButton btn;
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	JLabel jl4;
	JLabel jl5;
	JTextField jfname;
	//JComboBox<String> cbFname;
	FileInputStream fis;
	FileOutputStream fos;
	File file;
	Vector<Integer> items;
	public GoodsFrame() {
		jfc = new JFileChooser();
	
		jno = new JTextField(10);
		jfname = new JTextField(10);
		jname = new JTextField(10);
		jprice = new JTextField(10);
		//qty = new JTextField();
		
		jl2 = new JLabel("상품명");
		jl3 = new JLabel("가격");
		jl4 = new JLabel("수량");
		jl5 = new JLabel("상품파일명");
		btn = new JButton("등록");
		Integer jqty[] = new Integer[100];
		items = new Vector<Integer>();
		/*
		for(int i=0;i<jqty.length;i++)
		{
			jqty[i] = i+1;
			items.add(i);
			
		}
		*/
		for(int i=1;i<=100;i++)
		{
			items.add(i);
		}
		//cbQty = new JComboBox<Integer>(jqty);
		cbQty = new JComboBox<Integer>(items);
		//cbFname = new JComboBox<String>(fname);
		
		JButton btnImg = new JButton("상품이미지");
		btnImg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jfc.showOpenDialog(null);
				file = jfc.getSelectedFile();
				jfname.setText(jfc.getSelectedFile().getName());
			}
		});
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String name = jname.getText();
					int price = Integer.parseInt(jprice.getText());
					int qty = (Integer)cbQty.getSelectedItem();
					String fname = jfname.getText();
					GoodsVo v = new GoodsVo(0, name, price, qty, fname);
					GoodsDao da  = new GoodsDao();
					int re = da.InsertGoods(v);
					
					if(re==1)
					{
							fis = new FileInputStream(file);
							fos = new FileOutputStream("c:/Goods/"+file.getName());
							int data;
							while((data=fis.read())!=-1)
							{
								fos.write(data);
								System.out.println();
							}
							fis.close();
							fos.close();
							
							JOptionPane.showMessageDialog(null, "등록 성공");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
			}
		});
		
		//jl1 = new JLabel("상품번호");
		
		setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4,2));
		//jp1.add(jl1);
		//jp1.add(jno);
		jp1.add(jl2);
		jp1.add(jname);
		jp1.add(jl3);
		jp1.add(jprice);
		jp1.add(jl4);
		jp1.add(cbQty);
		jp1.add(btnImg);
		jp1.add(jfname);
		
		add(jp1, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GoodsFrame();
	}

}
