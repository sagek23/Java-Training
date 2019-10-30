package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.MemberDao;
import com.bit.vo.MemberVo;

public class LoginOkAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDao dao= new MemberDao();
		if(dao.isMember(id, pwd))
		{	
			request.getSession().setAttribute("id", id);
			
		}
		
		return "loginOk.jsp";
	}


}
