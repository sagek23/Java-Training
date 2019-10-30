package com.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.BookDao;
import book.BookVo;

/**
 * Servlet implementation class ListBook
 */
//@WebServlet("/listBook.do")
@WebServlet(urlPatterns = "/listBook.do", 
initParams = {@WebInitParam(name="fname",value ="c:/bit/log.txt")})
public class ListBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String fname = config.getInitParameter("fname");
		System.out.println("파일명:"+fname);
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ListBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		ArrayList<BookVo> list = dao.selectAll();
		
		request.setAttribute("title", "도서목록");
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("bookList2.jsp"); //어디로 가야할 지 갈 곳을 정한다.
		dis.forward(request, response); //상태유지한채 결과를 안고 간다.

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
