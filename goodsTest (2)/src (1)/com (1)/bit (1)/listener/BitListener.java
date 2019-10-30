package com.bit.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class BitListener
 *
 */
@WebListener
public class BitListener implements HttpSessionListener {
	long start;
	
    /**
     * Default constructor. 
     */
    public BitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("새로운 클라이언트 방문");
    	start = System.currentTimeMillis();
    	System.out.println("요청시간: "+start);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	long end= System.currentTimeMillis();
    	long delay = end-start;
    	System.out.println("머무른시간: "+delay);
    }
	
}
