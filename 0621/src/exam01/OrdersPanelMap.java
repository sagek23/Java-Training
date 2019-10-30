//아직 클래스 관계 적용안함
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
import java.util.HashMap;
import java.util.Map;
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

public class OrdersPanelMap extends JPanel {
	
	
	  HashMap<String, Integer> map_book;
	  HashMap<String, Integer> map_customer; 
	
	  JComboBox<String> cb_bNum;
	  JComboBox<String> cb_cNum;
	  
	    
	  Vector<String> v_bNum;
	  Vector<String> v_cNum;
	     
	  JTextField tf_oQuantity;
	     
	  Vector<String> colNames;
	  Vector<Vector<String>> rowData;
	  JTable table;
	  
	  


	int oNum= 0;
	    
		public OrdersPanelMap() {
			
			//setLayout(new FlowLayout());
			//add(new JButton("고객관리"));
		
			
			v_bNum = new Vector<String>();
			v_cNum = new Vector<String>();
			
			  	        
	        map_book = new HashMap<String, Integer>();
	        map_customer = new HashMap<String,Integer>();
	       
	        listBookno();
	        listCustomerno(); 
			
			
	        cb_bNum= new JComboBox<String>(v_bNum);
			cb_cNum= new JComboBox<String>(v_cNum);
			tf_oQuantity = new JTextField(10);
			
			
			colNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			
			colNames.add("주문번호");
			colNames.add("도서이름");
			colNames.add("고객이름");
			colNames.add("주문수량");
			colNames.add("주문금액");
			colNames.add("주문날짜");
			//테이블 만들기도 전에 주문내역 보고싶어서 listorders();여기에다가 써도됨
			
			table = new JTable(rowData,colNames);
			
			listOrders();
			
			
			table.addMouseListener(new MouseListener() {
				
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
					
					int row = table.getSelectedRow();
					Vector<String> v = rowData.get(row);
					oNum = Integer.parseInt(v.get(0));
					
					cb_bNum.setSelectedItem(v.get(1));
					cb_cNum.setSelectedItem(v.get(2));
					tf_oQuantity.setText(v.get(3));
				}
			});
			
			JScrollPane jsp = new JScrollPane(table);
			
			setLayout(new BorderLayout());
			JPanel up = new JPanel();
			JPanel up_input = new JPanel();
			JPanel up_btn = new JPanel();
			
			up_input.setLayout(new GridLayout(3,2));
			up_btn.setLayout(new FlowLayout());
			up.setLayout(new BorderLayout());
			
			up_input.add(new JLabel("도서명:"));
			up_input.add(cb_bNum);

			up_input.add(new JLabel("고객명:"));
			up_input.add(cb_cNum);

			up_input.add(new JLabel("주문수량:"));
			up_input.add(tf_oQuantity);
			
			
			
			JButton btnAdd = new JButton("등록");
			JButton btnUpdate = new JButton("수정");
			JButton btnDelete = new JButton("삭제");
			JButton btnList = new JButton("출력");

			 	btnAdd.addActionListener(new ActionListener() {
	             
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // TODO Auto-generated method stub              
		            	 insertOrders();
		                 listOrders();
		            }
		        });
		         
		     	btnUpdate.addActionListener(new ActionListener() {
		             
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // TODO Auto-generated method stub
		                updateOrders();
		                listOrders();
		            }
		        });
		         
		        btnDelete.addActionListener(new ActionListener() {
		             
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // TODO Auto-generated method stub
		                deleteOrders();
		                listOrders();
		            }
		        });
		         
		        btnList.addActionListener(new ActionListener() {
		             
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // TODO Auto-generated method stub
		                listOrders();
		            }
		        });
			
					
			up_btn.add(btnAdd);
			up_btn.add(btnUpdate);
			up_btn.add(btnDelete);
			up_btn.add(btnList);
			
			up.add(up_input, BorderLayout.CENTER);
			up.add(up_btn, BorderLayout.SOUTH);
			
			add(up, BorderLayout.NORTH);
			add(jsp, BorderLayout.CENTER);
		    
			//setVisibel size안해도딤
		    //setSize(500, 400);
		    //setVisible(true);
					
			// TODO Auto-generated constructor stub
		}

		
		
		
		  public void listCustomerno()
		    {
			  			  
		        String sql = "select cName,cNum from customer";
		        try {
		            Connection conn = ConnectionProvider.getConnection();
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            while(rs.next())
		            {
		            	  v_cNum.add(rs.getString(1));
		                  map_customer.put(rs.getString(1), rs.getInt(2));
		            }
		             
		            
		            ConnectionProvider.close(conn, stmt, rs);           
		             
		        }catch (Exception e) {
		            // TODO: handle exception
		            System.out.println(e.getMessage());
		        }
		         
		    }
		    public void listBookno()
		    {
		        String sql = "select bName,bNum from book";
		        try {
		            Connection conn = ConnectionProvider.getConnection();
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);
		            while(rs.next())
		            {
		            	v_bNum.add(rs.getString(1));
		                map_book.put(rs.getString(1), rs.getInt(2));
		            }
		             
		            
		            ConnectionProvider.close(conn, stmt, rs);           
		             
		        }catch (Exception e) {
		            // TODO: handle exception
		            System.out.println(e.getMessage());
		        }
		         
		    }
		     

		protected void listOrders() {
			// TODO Auto-generated method stub
		rowData.clear();
		System.out.println("listOrders call?");
		String sql ="select oNum,bName,cName,oQuantity,oPrice,oDate from book,customer,orders where book.bNum=orders.bNum and customer.cNum=orders.cNum order by oNum";
		try {
		Connection conn = ConnectionProvider.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);		
		
		while(rs.next()) {
			Vector<String> v = new Vector<String>();
			v.add(rs.getInt(1)+"");
			v.add(rs.getString(2));
			v.add(rs.getString(3));
			v.add(rs.getInt(4)+"");
			v.add(rs.getInt(5)+"");
			v.add(rs.getString(6));
			rowData.add(v);
		}
			
			System.out.println("주문건수:"+rowData.size());
            
			table.updateUI();
             
            ConnectionProvider.close(conn, stmt, rs);
                     
		
	
			
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println(e.getMessage());
		}
		
		}


		protected void updateOrders() {
			// TODO Auto-generated method stub
			
			
			int bNum = map_book.get((String)cb_bNum.getSelectedItem());
			int cNum = map_book.get((String)cb_cNum.getSelectedItem());
			int oQuantity = Integer.parseInt(tf_oQuantity.getText());
			int oPrice =getPrice(bNum)*oQuantity;
								
			String sql = "update orders set bNum =?,cNum =?,oQuantity = ?, oPrice=? where oNum=?";
			try {

				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bNum);
				pstmt.setInt(2, cNum);
				pstmt.setInt(3, oQuantity);
				pstmt.setInt(4, oPrice);
				pstmt.setInt(5, oNum);
				int re = pstmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			System.out.println(e.getMessage());
			}
			
		}


		protected void deleteOrders() {
			// TODO Auto-generated method stub
			String sql = "delete orders where oNum=?";
					try {
						Connection conn = ConnectionProvider.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, oNum);
						int re = pstmt.executeUpdate();
						if(re>=1) {
							JOptionPane.showConfirmDialog(this, "주문취소");
						}
						else {
							JOptionPane.showConfirmDialog(this, "주문취소실패");
						}
						
							
						
					} catch (Exception e) {
						// TODO: handle exception
					System.out.println(e.getMessage());
					}
	

		}


	    protected void insertOrders() {
	        // TODO Auto-generated method stub
	         
	        //int bno = (Integer)cb_bno.getSelectedItem();
	    	String bookName = (String) cb_bNum.getSelectedItem();
	    	String custName = (String) cb_cNum.getSelectedItem(); 
	   
	    	int bNum = map_book.get(bookName);
		    int cNum = map_customer.get(custName);
	    	
	    	int oQuantity = Integer.parseInt(tf_oQuantity.getText());
	        	            	        	         
	        String sql = "insert into orders values(seq_orders.nextval,?,?,?,?,sysdate)";
	         
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