package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BbsDao;
import com.bit.vo.BbsVo;

public class BbsDetailAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BbsDao dao = new BbsDao();
		BbsVo v= dao.listBbsDetail(Integer.parseInt(request.getParameter("num")));
		request.setAttribute("v", v);
		return "bbsDetail.jsp";
	}

}
