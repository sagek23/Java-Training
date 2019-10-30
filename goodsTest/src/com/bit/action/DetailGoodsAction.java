package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDao;
import com.bit.vo.GoodsVo;

public class DetailGoodsAction implements BitAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		GoodsDao dao = new GoodsDao();
		GoodsVo v = dao.detailGoods(Integer.parseInt(request.getParameter("no")));
		request.setAttribute("v", v);
		return "goodsDetail.jsp";
	}

}
