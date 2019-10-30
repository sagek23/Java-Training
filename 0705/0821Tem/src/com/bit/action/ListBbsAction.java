package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BbsDao;
import com.bit.vo.BbsVo;

public class ListBbsAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BbsDao dao = new BbsDao();
		request.setAttribute("list", dao.listBbs());
		return "listBbs.jsp";
	}

}
