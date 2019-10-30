package goods;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GoodsListFrame extends JFrame {

	Vector<String> colName;
	Vector<Vector<String>> rowData;
	JTable table;
	ArrayList<GoodsVo> list;
	public static GoodsDetailFrame detail;
	public GoodsListFrame() {
		colName = new Vector<String>();
		colName.add("상품번호");
		colName.add("상품명");
		colName.add("가격");
		colName.add("수량");
		
		rowData = new Vector<Vector<String>>();
		table = new JTable(rowData, colName);
		JScrollPane jsp = new JScrollPane(table);
		add(jsp);
		setVisible(true);
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listAll();
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int idx = table.getSelectedRow();
				GoodsVo g= list.get(idx);
				//new GoodsDetailFrame(g);
				if(detail == null)
				{
					detail = new GoodsDetailFrame(g);
					
				}
				else {
					detail.changeGoods(g);
				}
				
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
				
			}
		});
	}
	
	private void listAll() {
		// TODO Auto-generated method stub
		GoodsDao dao = new GoodsDao();
		list = dao.listAll();
		for(GoodsVo g:list)
		{
			Vector<String> v = new Vector<String>();
			v.add(g.getNo()+"");
			v.add(g.getName());
			v.add(g.getPrice()+"");
			v.add(g.getQty()+"");
			rowData.add(v);
		}
		table.updateUI();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GoodsListFrame();
	}

}
