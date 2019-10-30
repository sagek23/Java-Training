package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BE_EventImg extends JFrame {
	int imagenum;
	
	public BE_EventImg() {
		// TODO Auto-generated constructor stub
		ImageIcon grade_img = new ImageIcon("image/event"+imagenum+".jpg");
		JLabel jl_grade_img = new JLabel(grade_img);
		add(jl_grade_img);
		setSize(500,600);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new BE_EventImg();
	}
}
