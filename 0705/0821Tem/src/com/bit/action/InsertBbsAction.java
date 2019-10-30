package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBbsAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = 0;
		if(request.getParameter("num")!=null)
		{
			num = Integer.parseInt(request.getParameter("num"));//파라메터로 num값이 오는 경우는 답글을 다는 경우만 온다.
			//새글 작성시는 num값이 오지 않으므로 num=0이다.
		}
		request.setAttribute("num", num);
		return "insertBbs.jsp";
	}

}
