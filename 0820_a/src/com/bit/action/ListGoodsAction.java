package com.bit.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.GoodsDao;

public class ListGoodsAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//String view= "listGoods.jsp";
		GoodsDao dao = new GoodsDao();
		String keyword = request.getParameter("keyword");
		String search = request.getParameter("search");
		String oper = request.getParameter("oper");
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("search", search);
		request.setAttribute("oper", oper);
		request.setAttribute("list", dao.listAll(search, oper, keyword));
		//RequestDispatcher dis = request.getRequestDispatcher(view);
		//dis.forward(request, response);
		return "listGood.jsp";
	}

}
