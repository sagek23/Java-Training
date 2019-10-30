package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BitController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println("요청됨");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String cmd =uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);
		
		String view = "";
		if(cmd.equals("lbook.do"))
		{
			view = "listBook.jsp";
		}
		else if(cmd.equals("ibook.do"))
		{
			view = "insertBook.jsp";
		}
		else if(cmd.equals("lcust.do"))
		{
			view = "listCustomer.jsp";
		}
		else if(cmd.equals("insertB.do"))
		{
			view = "insertBookOk.jsp";
		}
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
