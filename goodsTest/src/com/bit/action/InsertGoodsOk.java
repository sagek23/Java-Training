package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDao;
import com.bit.vo.GoodsVo;
import com.oreilly.servlet.MultipartRequest;

public class InsertGoodsOk implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		GoodsDao dao = new GoodsDao();
		GoodsVo v = new GoodsVo();
		String path = request.getRealPath("/upload");
		MultipartRequest multi = new MultipartRequest(request, path, "UTF-8");
		v.setName(multi.getParameter("name"));
		v.setPrice(Integer.parseInt(multi.getParameter("price")));
		v.setQty(Integer.parseInt(multi.getParameter("qty")));
		v.setFname(multi.getOriginalFileName("fname"));
		int re = dao.insertGoods(v);
		System.out.println(re);
		request.setAttribute("re", re);
		return "insertGoodsOk.jsp";
	}

}
