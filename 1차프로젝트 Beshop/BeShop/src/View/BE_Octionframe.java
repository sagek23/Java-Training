package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.ConnectionProvider;

public class BE_Octionframe extends JPanel{
	int price=0;
	int point=0;
	
	public BE_Octionframe() {
		// TODO Auto-generated constructor stub
		
		String sql="select p_Price from Product where pnum=1";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement stmt =conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				price=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt,rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		String sql2="select porintBalance from  point where beUid='godkkoo'";
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement stmt =conn.prepareStatement(sql2);
			ResultSet rs = stmt.executeQuery(sql2);
			if(rs.next())
			{
				point=rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt,rs);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		JFrame f=new JFrame();
		JLabel pricep=new JLabel(price+"");
		pricep.setFont(new Font("나눔고딕",Font.BOLD,20));
		JLabel ftime=new JLabel("경매종료까지 11시간 31분 7초 남았습니다");
		JLabel detailA=new JLabel("입찰가는 보유한 포인트 이하로 제시해주세요 ");
		detailA.setFont(new Font("나눔고딕",Font.PLAIN,12));
		JLabel detailB=new JLabel("입찰가");
		detailB.setFont(new Font("나눔고딕",Font.BOLD,16));
		
		JLabel pointp=new JLabel("보유한포인트"+point+"원");
		pointp.setFont(new Font("나눔고딕",Font.BOLD, 15));
		JButton btn_charge=new JButton("충전하기");
		JPanel pointpanel=new JPanel();
		pointpanel.setLayout(new FlowLayout());
		pointpanel.add(pointp);
		pointpanel.add(btn_charge);
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		p.add(pointpanel,BorderLayout.WEST);
		
		
		JTextField tf_o=new JTextField(30);
		JButton btn_o=new JButton("입찰하기");
		JPanel down=new JPanel();
		down.setLayout(new FlowLayout());
		down.add(tf_o);
		down.add(btn_o);
		//입찰하기버튼 액션
		btn_o.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//충전하기버튼 액션
		btn_charge.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel detailC=new JLabel("경매가 끝나거나 판매자가 입장종료시 가장높은금액의 입찰자가 입찰됩니다");
		detailC.setFont(new Font("나눔고딕",Font.PLAIN,12));
		
		JPanel song=new JPanel();
		song.setLayout(new GridLayout(7,1));
		song.add(pricep);
		song.add(ftime);
		song.add(detailA);
		song.add(detailB);
		song.add(p);
		song.add(down);
		song.add(detailC);
		
		f.add(song);
		f.setSize(500,300);
		f.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new BE_Octionframe();
	}
}
