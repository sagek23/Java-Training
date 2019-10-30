package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.bit.dao.MemberDao;

public class LoginOkAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String view = "login.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.equals("tiger")&&pwd.equals("1234"))
		{
			request.getSession().setAttribute("id", id);
			view = "member/lbbs.do";
		}
		return view;
	}

}
