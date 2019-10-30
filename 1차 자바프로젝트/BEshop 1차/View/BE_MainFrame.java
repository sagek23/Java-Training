package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;


public class BE_MainFrame extends JFrame {
	
	JPanel jp = new JPanel();
	static BE_NorthMainPanel benm;
	static BE_MainPanel bem;
	int Vnum;
	BE_MainFrame main;
	public BE_MainFrame(){
		benm = new BE_NorthMainPanel();
		bem = new BE_MainPanel();
		setLayout(new BorderLayout());
		add(benm,BorderLayout.NORTH);
		add(bem,BorderLayout.CENTER);
		setSize(1200,900);
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		benm.btnMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("실행");
				bem.jtab.setSelectedIndex(0);
			}
		});
		bem.btnS_event1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("이벤트 링크");
				bem.jtab.setSelectedIndex(5);
			}
		});
		bem.btnS_event2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("이벤트 링크");
				bem.jtab.setSelectedIndex(5);
			}
		});
		BE_SubPanel.eventJL.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				bem.jtab.setSelectedIndex(5);
			}
		});
		
	}
	public static void main(String[] args) {
		new BE_MainFrame();
	}
	
}
