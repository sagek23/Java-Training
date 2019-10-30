package com.bit.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.action.BitAction;
import com.bit.action.BookDetailAction;
import com.bit.action.InsertDeptAction;
import com.bit.action.InsertDeptOkAction;
import com.bit.action.ListBookAction;
import com.bit.action.ListCustomerAction;
import com.bit.action.ListDeptAction;
import com.bit.action.ListGoodsAction;
import com.bit.action.insertGoodsAction;
import com.bit.action.insertGoodsOkAction;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, BitAction> map;
    
    
	//사용자가 요청할 서비스명과 일처리를 위한 클래스의 객체를 담아두기 위한 map을 선언한다.
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BitController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		map = new HashMap<String, BitAction>();
		//서블릿의 멤버변수 map에 사용자의 요청하는 서비스명을 key로하고 
		//처리할 클래스의 객체를 value로하여 추가한다.
		map.put("lcust.do", new ListCustomerAction());
		map.put("lbook.do", new ListBookAction());
		map.put("ldept.do",new ListDeptAction());
		map.put("idept.do",new InsertDeptAction());
		map.put("ideptOk.do",new InsertDeptOkAction());
		map.put("bdetail.do", new BookDetailAction());
		map.put("lgoods.do", new ListGoodsAction());
		map.put("igoods.do", new insertGoodsAction());
		map.put("igoodsOk.do", new insertGoodsOkAction());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request,response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
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
		proRequest(request,response);
	}

}
