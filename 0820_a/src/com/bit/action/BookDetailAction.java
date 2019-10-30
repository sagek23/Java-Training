package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.BookDao;
import com.bit.orders.BookVo;

public class BookDetailAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		
		BookVo v = dao.listBookD(Integer.parseInt(request.getParameter("bookid")));
		request.setAttribute("v", v);
		return "bookDetail.jsp";
	}

}
