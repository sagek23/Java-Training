package Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//14면 마지막 한칸이 비고 12면 4열까지만 출력. 공백인 나머지 한줄은 출력되지 않는다.
/*
 * -행이 먼저 담긴다
 * -설정한 행열의 수보다 컴퍼넌트의 수가 행열에 맞추어 떨어지지 않을 때
 *  행먼저 담기고 나머지는 빈칸으로 표시된다.
 * -설정한 행열의 수보다 컴포넌트의 수가 작고 그 개수가 행열의 수로 
 *  맞추어 질때 설정한 행열은 무시된다.
 *  GridLayout(3,5) 로 설정했으나, 컴포넌트의 수가 12개라면 3행 5열은 무시되거
 *  3행 4열로 만들어진다.
 *  더 큰수를 넣으면 알아서 열의 사이즈를 늘려준다. 행은 고정되고 열의 수가 증가.  
 * */

public class Grid extends JFrame {

	public Grid() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(3,5));
		//for(int i=1; i<=15;i++)
		for(int i=1; i<=21;i++)
		//for(int i=1; i<=12;i++)
		{
			add(new JButton("버튼"+i));
		}
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Grid();
	}

}
