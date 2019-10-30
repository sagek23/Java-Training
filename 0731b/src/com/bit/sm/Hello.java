package com.bit.sm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.ManagerDao;

/**
 * Servlet implementation class Hello
 */
//@WebServlet("/hello.do") web.xml 사용시 지우기
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManagerDao dao = new ManagerDao();//Dao를 멤버변수로 선언. 멤버변수로 만들면 다른 곳에서 매번 객체를 생성하지않아도 된다.
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao.createManager(); //manager테이블 생성
	//	String id = config.getInitParameter("id");
	//	String pwd = config.getInitParameter("pwd");
		/*
		String fname = config.getInitParameter("fname");
		System.out.println(fname);
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line = null;
			while((line = br.readLine())!=null)
			{
				System.out.println(line);
			}
			br.close();
			line.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
*/
		String fname = config.getInitParameter("fname");
		System.out.println(fname);
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line = null;
			while((line = br.readLine())!=null)
			{
				String []arr = line.split(",");
				String id = arr[0];
				String pwd = arr[1];
				dao.insertManager(id, pwd);
				//dao에게 id와 pwd를 전달하여 레코드를 추가
				
				//System.out.println(id);
				//System.out.println(pwd);
				//System.out.println("----------------------");
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
    
     
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		dao.dropManager();
		//서블릿이 소멸될 때(서버가 종료될 때)
		//manager테이블을 삭제
	}


	/**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>get방식의 관리자 서비스</h2>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>post방식의 관리자 서비스</h2>");
		out.close();
		//doGet(request, response);
	}

}
