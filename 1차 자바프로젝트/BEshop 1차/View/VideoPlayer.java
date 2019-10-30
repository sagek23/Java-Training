package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

import BE_SellerVo.BE_VideoVo;
import BE_Sellerdao.BE_VideoDao;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;


public class VideoPlayer extends JPanel {
	WebView webview;
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	BE_VideoDao bvao;
	ArrayList<BE_VideoVo> list;
	URL url;
	public VideoPlayer(int num) {
		System.out.println("받아온값 ="+num);
		bvao = new BE_VideoDao();
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		Platform.runLater(() -> {
		webview = new WebView();
		int y = res.height;
		int x = res.width;
			
		JFXPanel fx = new JFXPanel();
		try {
			list = bvao.getVideo(num);
			for (BE_VideoVo vo : list) {
				
				url= new URL(vo.getVfile());
				Thread.sleep(500);
				webview.getEngine().load( url.toString());
				System.out.println(url.toString());
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
   	    webview.setPrefSize((x-300),(y-800));
   	    
   	    fx.setScene(new Scene(webview));
   	    setLayout(new BorderLayout());
   	    add(fx,BorderLayout.CENTER);
   	    setSize(x, y);
   	    setVisible(true);
   	    updateUI();
		});
	}
}
