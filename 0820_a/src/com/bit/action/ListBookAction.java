package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.BookDao;

public class ListBookAction implements BitAction {

	
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		request.setAttribute("list", dao.listBookid());
		return "listBook.jsp";
	}

}
