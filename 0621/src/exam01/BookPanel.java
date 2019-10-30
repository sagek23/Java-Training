package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import db.ConnectionProvider;

public class BookPanel extends JPanel {

		
	JTextField tf_bName;
	JTextField tf_bPrice;
	JTextField tf_bPub;
	JTextField tf_bAuthor;
	int bNum =0;
	
	Vector<String> colNames;
	Vector<Vector<String>> rowData;
	
	JTable table;
	
	
	public BookPanel() {
		
		setLayout(new FlowLayout());
		add(new JButton("도서관리"));
		
		tf_bName= new JTextField(10);
		tf_bPrice = new JTextField(10);
		tf_bPub = new JTextField(10);
		tf_bAuthor= new JTextField(10);
		
		colNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		
		colNames.add("책번호");
		colNames.add("책이름");
		colNames.add("책가격");
		colNames.add("출판사");
		colNames.add("저자");
		
		table = new JTable(rowData,colNames);
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
                Vector<String> v= rowData.get(row);
                //[21, 신나는 자바, 25000, 길벗, 김명섭]
                tf_bName.setText(v.get(1));
                tf_bPrice.setText(v.get(2));
                tf_bPub.setText(v.get(3));
                tf_bAuthor.setText(v.get(4));
                bNum =  Integer.parseInt(v.get(0));
            }
        });
				
		
		JScrollPane jsp = new JScrollPane(table);
		
		
		setLayout(new BorderLayout());
		JPanel up = new JPanel();
		JPanel up_input = new JPanel();
		JPanel up_btn = new JPanel();
		
		up_input.setLayout(new GridLayout(4,2));
		up_btn.setLayout(new FlowLayout());
		up.setLayout(new BorderLayout());
		
		up_input.add(new JLabel("책이름:"));
		up_input.add(tf_bName);

		up_input.add(new JLabel("책가격:"));
		up_input.add(tf_bPrice);
		

		up_input.add(new JLabel("저자:"));
		up_input.add(tf_bAuthor);
		

		up_input.add(new JLabel("출판사:"));
		up_input.add(tf_bPub);
					
		
		JButton btnAdd = new JButton("등록");
		JButton btnUpdate = new JButton("수정");
		JButton btnDelete = new JButton("삭제");
		JButton btnWrite = new JButton("출력");

		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  insertBook();
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
	    
	
        //setSize(400, 300);
        //setVisible(true);
				
		// TODO Auto-generated constructor stub
	}


	protected void listBook() {
		// TODO Auto-generated method stub
		rowData.clear();
		 String sql = "select * from book";
	        try {           
	            Connection conn = ConnectionProvider.getConnection();
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next())
	            {
	                Vector<String > v= new Vector<String>();
	                v.add(rs.getInt(1)+"");
	                v.add(rs.getString(2));
	                v.add(rs.getInt(3)+"");
	                v.add(rs.getString(4));
	                v.add(rs.getString(5));
	                 
	                rowData.add(v);
	            }
	             
	            table.updateUI();
	             
	            ConnectionProvider.close(conn, stmt, rs);
	             
	        }catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	        }       
	         
	    }
	
	


	protected void updateBook() {
		// TODO Auto-generated method stub
		

		String sql = "update book set bName = ?,bPrice = ?, bPub = ?, bAuthor = ? where bNum= ?";
	
		 if(!isAllInput())
	        {
	            JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
	            clearText();
	            return;
	        }
				
		String bName = tf_bName.getText();
		int bPrice = Integer.parseInt(tf_bPrice.getText());
		String bAuthor = tf_bAuthor.getText();
		String bPub = tf_bPub.getText();		
				
				
				
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bName);
			//int로 변환된거 넣어주는 것임
			pstmt.setInt(2, bPrice);
			pstmt.setString(3, bAuthor);
			pstmt.setString(4, bPub);
			pstmt.setInt(5, bNum);
			
			int re = pstmt.executeUpdate();
			if(re>=1) {
				JOptionPane.showMessageDialog(this, "도서를 수정하였습니다");
			}
			else {
				JOptionPane.showMessageDialog(this, "도서수정에 실패하였습니다");
			}
			
			conn.close();
			pstmt.close();
			
			
			}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생: "+e.getMessage());
			}		
	}


	protected void deleteBook() {
		// TODO Auto-generated method stub
		
	int r = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?");	
	if(r !=0)
		return;
	
	String sql = "delete book where bNum = ?";
    System.out.println("삭제");
    System.out.println("책번호:"+bNum);
	try {
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bNum);
		int re = pstmt.executeUpdate();
		
		if(re >=1) {
			JOptionPane.showMessageDialog(this, "도서를 삭제하였습니다");
		}
		else {
			JOptionPane.showMessageDialog(this, "도서삭제 실패하였습니다");
		}
		
		ConnectionProvider.close(conn, pstmt);
	} catch (Exception e) {
		// TODO: handle exception
	System.out.println(e.getMessage());
	}

	
	}


	protected void insertBook() {
		// TODO Auto-generated method stub
		
		if(!isAllInput()) {
			JOptionPane.showMessageDialog(this, "입력값을 확인하세요");
			clearText();
			return;
		}
		
		
		String bName = tf_bName.getText();
		int bPrice = Integer.parseInt(tf_bPrice.getText());
		String bAuthor = tf_bAuthor.getText();
		String bPub = tf_bPub.getText();
				
				
		String sql ="insert into book values(seq_book.nextval,?,?,?,?)";
				try {
					Connection conn = ConnectionProvider.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, bName);
					//int로 변환된거 넣어주는 것임
					pstmt.setInt(2, bPrice);
					pstmt.setString(3, bAuthor);
					pstmt.setString(4, bPub);
					
					int re = pstmt.executeUpdate();
					if(re>=1) {
						JOptionPane.showMessageDialog(this, "도서를 등록하였습니다");
					}
					else {
						JOptionPane.showMessageDialog(this, "도서를 등록에 실패하였습니다");
					}
					
					ConnectionProvider.close(conn, pstmt);
					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("예외발생: "+e.getMessage());
				}
				
				clearText();
	}


	private boolean isAllInput() {
		// TODO Auto-generated method stub
		
		boolean f = true;
		if(tf_bName.getText().trim().equals("")||
		   tf_bPrice.getText().trim().equals("")||
		   tf_bAuthor.getText().trim().equals("")||
		   tf_bPub.getText().trim().equals("")
			) {
			f =false;
		}
		return f;
	}


	private void clearText() {
		// TODO Auto-generated method stub
		tf_bName.setText("");
		tf_bPrice.setText("");
		tf_bAuthor.setText("");
		tf_bPub.setText("");
	}

	
	


}

