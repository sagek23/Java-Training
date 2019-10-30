package Layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//BorderLayout은 화면을 위, 아래, 좌, 우, 가운데의 5개의 영역으로
//분할하는 방식이다. 

/*
 * 위,아래,좌,우는 생략하면 center가 나머지 공간을 차지.
 * center는 생략하면 center의 자리가 공백이됨.
 * center를 주로 하고 부수적인 내용을 위,아래,좌,우에 배치한다. 
 */
public class Border extends JFrame {

	public Border() {
		// TODO Auto-generated constructor stub
		
		setLayout(new BorderLayout());
		
		add(new JButton("위"), BorderLayout.NORTH);
		add(new JButton("아래"), BorderLayout.SOUTH);
		//add(new JButton("오른쪽"), BorderLayout.EAST);
		//add(new JButton("왼쪽"), BorderLayout.WEST);
		add(new JButton("가운데"), BorderLayout.CENTER);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Border();
	}

}
