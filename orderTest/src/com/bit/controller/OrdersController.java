package com.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.BookDao;
import com.bit.orders.BookVo;
import com.bit.orders.CustomerDao;
import com.bit.orders.CustomerVo;
import com.bit.orders.OrdersDao;
import com.bit.orders.OrdersVo;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet("/orders.do")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OrdersController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String view="orders.jsp";
		
		
		CustomerDao cDao = new CustomerDao();
		BookDao bDao = new BookDao();
		OrdersDao oDao = new OrdersDao();
		ArrayList<CustomerVo> clist = cDao.listCust();
		ArrayList<BookVo> blist = bDao.listBookid();

		request.setAttribute("blist",blist);
		request.setAttribute("clist", clist);
		
		
		RequestDispatcher dis = request.getRequestDispatcher(view);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		OrdersVo v = new OrdersVo();
		v.setCustid(Integer.parseInt(request.getParameter("custid")));
		v.setBookid(Integer.parseInt(request.getParameter("bookid")));
		v.setSaleprice(Integer.parseInt(request.getParameter("saleprice")));
		
		OrdersDao dao = new OrdersDao();
		int re = dao.insertOrder(v);
		
		request.setAttribute("re", re);
		
		String view = "ordersOk.jsp";
		RequestDispatcher dis
			= request.getRequestDispatcher(view);
		dis.forward(request, response);
	}

}
