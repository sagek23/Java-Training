package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BbsDao;

public class InsertBbsAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = 0;
		String title="";
		if(request.getParameter("num")!=null)
		{
			num = Integer.parseInt(request.getParameter("num"));
			title = "답글)"+request.getParameter("title");
			//BbsDao dao = new BbsDao();
			//title = "답글)"+dao.listBbsDetail(num).getTitle();	
		}
		request.setAttribute("num", num);
		request.setAttribute("title", title);
		return "insertBbs.jsp";
	}

}
