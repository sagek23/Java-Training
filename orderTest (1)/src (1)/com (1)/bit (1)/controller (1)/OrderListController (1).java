package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.OrdersDao;

/**
 * Servlet implementation class OrderList
 */
@WebServlet("/olist.do")
public class OrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view = "orderlist.jsp";
		OrdersDao dao = new OrdersDao();
		request.setAttribute("list", dao.listAll(null, null, null));
		RequestDispatcher dis =  request.getRequestDispatcher(view);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrdersDao dao = new OrdersDao();
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		String search = request.getParameter("search");
		String oper = request.getParameter("oper");
		System.out.println("검색컬럼:"+search);
		System.out.println("검색어:"+keyword);
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("search", search);
		request.setAttribute("oper", oper);
		 request.setAttribute("list", dao.listAll(search, keyword, oper));
			RequestDispatcher dis
				= request.getRequestDispatcher("orderlist.jsp");
		dis.forward(request, response);
	}

}
