package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

import BE_ShoppingDao.BE_ReViewDao;
import BE_ShoppingVo.BE_ReviewVo;

public class BE_ReviewDetailPanel extends JFrame {
	JLabel jl_renum;
	JLabel jl_renum2 = new JLabel();
	JLabel jl_beuid;
	JLabel jl_beuid2;
	JLabel jl_pname;
	JLabel jl_pname2;
	JLabel jl_retitle;
	JLabel jl_retitle2;
	JLabel jl_re_hits;
	JLabel jl_re_hits2;
	JLabel jl_redate;
	JLabel jl_redate2;
	JTextArea jta_re_con;
	JTextArea jta_re_answer;
	


	public BE_ReviewDetailPanel() {
		// TODO Auto-generated constructor stub
		jl_renum = new JLabel("리뷰번호");
		jl_beuid = new JLabel("회원id");
		jl_pname = new JLabel("상품명");
		jl_retitle = new JLabel("리뷰제목");
		jl_re_hits = new JLabel("조회수");
		jl_redate = new JLabel("등록일");
		jta_re_con = new JTextArea();
		jta_re_answer = new JTextArea();
		
		//System.out.println(jl_renum2.getText().trim());
		//int num = Integer.parseInt(jl_renum2.getText().trim());
		
		BE_ReViewDao dao = new BE_ReViewDao();
		BE_ReviewVo vo = dao.ReViewlist(1);
		jl_beuid2 = new JLabel(vo.getbeUid());
		jl_pname2 = new JLabel(vo.getpNum()+"");
		jl_retitle2 = new JLabel(vo.getReTitle());
		jl_re_hits2 = new JLabel(vo.getRe_Hits()+"");
		jl_redate2 = new JLabel(vo.getReDate()+"");
		
		JPanel jp_review_up = new JPanel();
		jp_review_up.setLayout(new GridLayout(6,2));
		jp_review_up.add(jl_renum);
		jp_review_up.add(jl_renum2);
		jp_review_up.add(jl_beuid);
		jp_review_up.add(jl_beuid2);
		jp_review_up.add(jl_pname);
		jp_review_up.add(jl_pname2);
		jp_review_up.add(jl_retitle);
		jp_review_up.add(jl_retitle2);
		jp_review_up.add(jl_re_hits);
		jp_review_up.add(jl_re_hits2);
		jp_review_up.add(jl_redate);
		jp_review_up.add(jl_redate2);
		
		jta_re_con.setText(vo.getReContent());
		jta_re_con.setSize(100,70);
		JPanel jp_review_b = new JPanel();
		jp_review_b.add(jta_re_con);

		setLayout(new BorderLayout());
		add(jp_review_up, BorderLayout.NORTH);
		add(jp_review_b,BorderLayout.CENTER);
		setSize(400,700);
		setVisible(true);
			
	}
	
	public static void main(String[] args) {
		new BE_ReviewDetailPanel();
	}
}
