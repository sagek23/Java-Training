package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;

import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.LineBorder;

import BE_SellerVo.BE_VideoVo;
import DB.ConnectionProvider;

public class BE_Shopping extends JPanel{
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	JTable jt;
	JLabel lb1;
	JLabel lb2;
	JLabel lb3;
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	JList list;
	JScrollPane jsp;
	Object[] data;
	String pname;
	String p_image;
	String ipath;
	int price;
	int pnum;
	Font f1, f2, f3;
	JButton ca6;
	JButton ca7;
	public BE_Shopping() {
		f1 = new Font("돋움", Font.PLAIN, 20);
		f2 = new Font("돋움", Font.PLAIN, 15);
		f3 = new Font("돋움", Font.PLAIN, 40);
		
		JLabel ca = new JLabel("카테고리");
		JButton ca1 = new JButton("가전/TV/디카");
		JButton ca2 = new JButton("컴퓨터/노트북");
		JButton ca3 = new JButton("태블릿/모바일");
		JButton ca4 = new JButton("아웃도어/스포츠");
		JButton ca5 = new JButton("자동차/용품/공구");
		ca.setHorizontalAlignment(JLabel.CENTER);
		JPanel cate = new JPanel();
		cate.setBorder(new LineBorder(Color.black));
		cate.setPreferredSize(new Dimension(200,1000));
		cate.setLayout(new GridLayout(40,1));
		cate.add(ca);
		cate.add(ca1);
		cate.add(ca2);
		cate.add(ca3);
		cate.add(ca4);
		cate.add(ca5);
		selectProduct();
		
		ImageIcon timg[] = new ImageIcon[3];
		ImageIcon iimg[] = new ImageIcon[3];
		ImageIcon rimg[] = new ImageIcon[3];
		
		JLabel lbimg[] = new JLabel[3];
		ArrayList<BE_VideoVo> list;
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		lb1 = new JLabel("TODAY");
		setLayout(new BorderLayout());
		
		JPanel jp1 = new JPanel();
		JPanel jp1a = new JPanel();
		
		for(int i=0;i<=2;i++)
		{
			timg[i] = new ImageIcon("image/img"+ i +".png");
			lbimg[i] = new JLabel(timg[i]);
		}
		for(int i=0;i<=2;i++)
		{
			jp1.add(lbimg[i]);
		}
		jp1.setLayout(new GridLayout());
		
		jp1a.setLayout(new BorderLayout());
		jp1a.add(lb1, BorderLayout.NORTH);
		jp1a.add(jp1, BorderLayout.CENTER);
		ipath = "";
		for(int i=0;i<=2;i++) {
		lbimg[i].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				BE_ShoppingDetail3 sd = new BE_ShoppingDetail3();
				ipath = "image/"+p_image;
				sd.imgPath = ipath;
			}
		});
		}
		lb2 = new JLabel("관심채널");
		JLabel lbimg2[] = new JLabel[3];
		JPanel jp2 = new JPanel();
		JPanel jp2a = new JPanel();
		for(int i=0;i<=2;i++)
		{
			iimg[i] = new ImageIcon("image/img"+ i +".png");
			lbimg2[i] = new JLabel(iimg[i]);
		}
		for(int i=0;i<=2;i++)
		{
			jp2.add(lbimg2[i]);
		}

		jp2.setLayout(new GridLayout());
		
		jp2a.setLayout(new BorderLayout());
		jp2a.add(lb2, BorderLayout.NORTH);
		jp2a.add(jp2, BorderLayout.CENTER);
		for(int i=0;i<=2;i++) {
			lbimg2[i].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					new BE_ShoppingDetail3();
				}
			});
			}
		
		
		lb3 = new JLabel("추천채널");
		JLabel lbimg3[] = new JLabel[3];
		JPanel jp3 = new JPanel();
		JPanel jp3a = new JPanel();
		for(int i=0;i<=2;i++)
		{
			rimg[i] = new ImageIcon("image/img"+ i +".png");
			lbimg3[i] = new JLabel(iimg[i]);
		}
		for(int i=0;i<=2;i++)
		{
			jp3.add(lbimg3[i]);
		}
		jp3.setLayout(new GridLayout());
		
		jp3a.setLayout(new BorderLayout());
		jp3a.add(lb3, BorderLayout.NORTH);
		jp3a.add(jp3, BorderLayout.CENTER);
		
		for(int i=0;i<=2;i++) {
			lbimg3[i].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					new BE_ShoppingDetail3();
					
				}
			});
			}
		JPanel jpa = new JPanel();
		jpa.setLayout(new GridLayout(3,3));
		jpa.add(jp1a);
		jpa.add(jp2a);
		jpa.add(jp3a);
		
		lb1.setFont(f3);
		lb2.setFont(f3);
		lb3.setFont(f3);
		
		ca.setFont(f2);
		ca1.setFont(f2);
		ca2.setFont(f2);
		ca3.setFont(f2);
		ca4.setFont(f2);
		ca5.setFont(f2);
		
		add(cate, BorderLayout.WEST);
		add(jpa, BorderLayout.CENTER);
		
			ca1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ca1.getText().equals("가전/TV/디카"));
				{
					ca1.setText("계절가전");
					ca2.setText("생활가전");
					ca3.setText("주방가전");
					ca4.setText("TV/프로젝터");
					ca5.setText("디카/액션캠");
					ca6 = new JButton("DSLR");
					ca7 = new JButton("이전 카테고리");
					cate.add(ca6);
					cate.add(ca7);
					
				
					ca6.setFont(f2);
					ca7.setFont(f2);
					ca1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
									new BE_ShoppingDetail3();
							};	
					});
					ca7.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(ca7.getText().contentEquals("이전 카테고리"))
							{
								ca1.setText("가전/TV/디카");
								ca2.setText("컴퓨터/노트북");
								ca3.setText("태블릿/모바일");
								ca4.setText("아웃도어/스포츠");
								ca5.setText("자동차/용품/공구");
								cate.remove(ca6);
								cate.remove(ca7);
								cate.updateUI();
								ca1.setFont(f2);
								ca2.setFont(f2);
								ca3.setFont(f2);
								ca4.setFont(f2);
								ca5.setFont(f2);
								
							}
						}
					});
					
				}
			}
		});
			
		int y = res.height;
		int x = res.width;
		

	}
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BE_Shopping();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
*/
public void selectProduct() {
		
		String sql = "select pname, p_price, pnum, p_image from product where pnum = 1";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				pname = rs.getString(1);

				price = rs.getInt(2);
				pnum = rs.getInt(3);
				p_image= rs.getString(4);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
