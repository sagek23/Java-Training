package View;


import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import BE_SellerVo.BE_VideoVo;
import BE_Sellerdao.BE_VideoDao;
import BE_ShoppingDao.BE_ProductDao;
import BE_ShoppingVo.BE_ProductVo;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;


public class VideoPlayerFrame extends JFrame {
	WebView webview;
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	BE_VideoDao bvao;
	ArrayList<BE_VideoVo> list;
	public VideoPlayerFrame(int num) {
		System.out.println("받아온값 ="+num);
		bvao = new BE_VideoDao();
		com.sun.javafx.application.PlatformImpl.startup(()->{});
		Platform.runLater(() -> {
		webview = new WebView();
		int y = res.height;
		int x = res.width;
		
		JFXPanel fx = new JFXPanel();
		URL url;
		try {
		list = bvao.getVideo(num);
		for (BE_VideoVo po : list) {
			
			url= new URL(po.getVfile());

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
		});
	
	}
}
