package View;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.TabbedPaneUI;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class ShoppingApp extends JPanel{

	public ShoppingApp() {
		// TODO Auto-generated constructor stub

		JTabbedPane tab = new JTabbedPane();
		tab.addTab("shopping", new BE_Shopping());
		
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		int x = res.width;
		int y = res.height;
		setLayout(new BorderLayout());
		add(tab, BorderLayout.CENTER);
		
			
	}

}
