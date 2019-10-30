package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.CustomerDao;

public class ListCustomerAction implements BitAction {
	
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		request.setAttribute("list", dao.listCust());
		
		return "listCustomer.jsp";
	}

}
