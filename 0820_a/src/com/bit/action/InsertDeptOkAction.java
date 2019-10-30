package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.orders.DeptDao;
import com.bit.orders.DeptVo;

public class InsertDeptOkAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		DeptDao dao = new DeptDao();
		DeptVo d = new DeptVo();
		d.setDno(Integer.parseInt(request.getParameter("dno")));
		d.setDname(request.getParameter("dname"));
		d.setDloc(request.getParameter("dloc"));
		int re = dao.insertDept(d);
		request.setAttribute("re", re);
		return "insertDeptOk.jsp";
	}

}
