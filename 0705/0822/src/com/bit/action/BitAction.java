package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BitAction {
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	//어디로 가야할지 view페이지를 문자열로 반환
}
