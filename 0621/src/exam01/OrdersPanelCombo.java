package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ConnectionProvider;

public class OrdersPanelCombo extends JPanel {
	

		JComboBox<Integer> cb_bNum;
		JComboBox<Integer> cb_cNum;
		Vector<Integer> v_bNum;
		Vector<Integer> v_cNum;
		
		JTextField tf_oQuantity;
		int oNum =0;

		Vector<String> colNames;
		Vector<Vector<String>> rowData;

		JTable table;


		public OrdersPanelCombo() {
			
			//setLayout(new FlowLayout());
			//add(new JButton("고객관리"));
		
			
			v_bNum = new Vector<Integer>();
			v_cNum = new Vector<Integer>();
			
			listBookno();
	        listCustomerno();   
			
			
			cb_bNum= new JComboBox<>(v_bNum);
			cb_cNum= new JComboBox<>(v_cNum);
			tf_oQuantity = new JTextField(10);
			
			
			colNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			
			colNames.add("주문번호");
			colNames.add("도선번호");
			colNames.add("고객번호");
			colNames.add("주문수량");
			colNames.add("주문금액");
			colNames.add("날짜");

			
			table = new JTable(rowData,colNames);
			
			
			JScrollPane jsp = new JScrollPane(table);
			
			
			setLayout(new BorderLayout());
			JPanel up = new JPanel();
			JPanel up_input = new JPanel();
			JPanel up_btn = new JPanel();
			
			up_input.setLayout(new GridLayout(3,2));
			up_btn.setLayout(new FlowLayout());
			up.setLayout(new BorderLayout());
			
			up_input.add(new JLabel("도서번호:"));
			up_input.add(cb_bNum);

			up_input.add(new JLabel("고객번호:"));
			up_input.add(cb_cNum);
			

			up_input.add(new JLabel("주문수량:"));
			up_input.add(tf_oQuantity);
			
			
			
			JButton btnAdd = new JButton("등록");
			JButton btnUpdate = new JButton("수정");
			JButton btnDelete = new JButton("삭제");
			JButton btnWrite = new JButton("출력");

			btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					  insertOrders();
		              listBook();
				}
			});
			

			btnUpdate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					updateBook();
					listBook();
				}
			});

						
			btnDelete.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					deleteBook();
					listBook();
				}
			});

			
			

			btnWrite.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					listBook();
				}
			});

					
			up_btn.add(btnAdd);
			up_btn.add(btnUpdate);
			up_btn.add(btnDelete);
			up_btn.add(btnWrite);
			
			up.add(up_input, BorderLayout.CENTER);
			up.add(up_btn, BorderLayout.SOUTH);
			
			add(up, BorderLayout.NORTH);
			add(jsp, BorderLayout.CENTER);
		    

		    setSize(400, 300);
		    setVisible(true);
					
			// TODO Auto-generated constructor stub
		}

	
		
		  public void listCustomerno()
		    {
		        String sql = "select cNum from customer";
		        try {
		            Connection conn = ConnectionProvider.getConnection();
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            while(rs.next())
		            {
		                v_cNum.add(rs.getInt(1));
		            }
		             
		            //cb_bno.updateUI();
		            ConnectionProvider.close(conn, stmt, rs);           
		             
		        }catch (Exception e) {
		            // TODO: handle exception
		            System.out.println(e.getMessage());
		        }
		         
		    }
		    public void listBookno()
		    {
		        String sql = "select bNum from book";
		        try {
		            Connection conn = ConnectionProvider.getConnection();
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            while(rs.next())
		            {
		                v_bNum.add(rs.getInt(1));
		            }
		             
		            //cb_bno.updateUI();
		            ConnectionProvider.close(conn, stmt, rs);           
		             
		        }catch (Exception e) {
		            // TODO: handle exception
		            System.out.println(e.getMessage());
		        }
		         
		    }
		     

		protected void listBook() {
			// TODO Auto-generated method stub
		
		    }




		protected void updateBook() {
			// TODO Auto-generated method stub
			

			
		}


		protected void deleteBook() {
			// TODO Auto-generated method stub
			
	

		}


	    protected void insertOrders() {
	        // TODO Auto-generated method stub
	         
	        //int bno = (Integer)cb_bno.getSelectedItem();
	        int bNum= v_bNum.get(cb_bNum.getSelectedIndex());
	        int cNum = (Integer)cb_cNum.getSelectedItem();
	         
	        int oQuantity = Integer.parseInt(tf_oQuantity.getText());
	         
	        String sql = "insert into orders values(seq_orders.nextval,?,?,?,?,"
	                + "sysdate)";
	         
	        int bprice = getPrice(bNum);
	        int oPrice = bprice*oQuantity;
	         
	        try {
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            //seq_orders.nextval,?,?,?,?,sysdate
	            pstmt.setInt(1, bNum);
	            pstmt.setInt(2, cNum);
	            pstmt.setInt(3, oQuantity);
	            pstmt.setInt(4, oPrice);
	             
	            int re = pstmt.executeUpdate();
	            if(re >=1)
	            {
	                JOptionPane.showMessageDialog(this, "주문성공");
	            }
	            else
	            {
	                JOptionPane.showMessageDialog(this, "주문실패");
	            }
	             
	            ConnectionProvider.close(conn, pstmt);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	         
	    }
	 
	    private int getPrice(int bNum) {
	        // TODO Auto-generated method stub
	         
	        String sql = "select bprice from book where bNum=?";
	        int price = 0;
	        try {
	            Connection conn = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, bNum);
	            ResultSet rs = pstmt.executeQuery();
	             
	            if(rs.next())
	            {
	                price = rs.getInt(1);
	            }
	            ConnectionProvider.close(conn, pstmt, rs);
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }
	         
	         
	        return price;
	    }
	}