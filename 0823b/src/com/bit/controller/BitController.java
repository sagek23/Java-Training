package com.bit.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.FieldPosition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.action.BitAction;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HashMap<String, BitAction> map;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BitController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String, BitAction>();
		String path = config.getServletContext().getRealPath("/WEB-INF");
		try {
			Properties prop = new Properties();
			FileReader fr = new FileReader(path+"/bit.properties");
			prop.load(fr);
			prop.keySet();
			Set keyList = prop.keySet();
			//lbbs.do가 키
			//ibbs.do 
			Iterator iter = keyList.iterator();
			while(iter.hasNext())
			{
				String cmd = (String)iter.next();
				String clsName = (String)prop.get(cmd);
				BitAction obj = (BitAction)Class.forName(clsName).newInstance();
				map.put(cmd, obj);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String cmd= uri.substring(uri.lastIndexOf("/")+1);
		BitAction action = map.get(cmd);
		String view = action.proRequest(request, response);
		RequestDispatcher dis = request.getRequestDispatcher(view);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

}
