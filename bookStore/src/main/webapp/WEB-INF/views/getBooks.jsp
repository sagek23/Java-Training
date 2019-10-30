<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.bit.bookStore.vo.BookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String str = "";
List<BookVo> list =(List<BookVo>)request.getAttribute("list");

int pageNumber= (Integer)request.getAttribute("page");
//int rows = (Integer)request.getAttribute("rows");
int totalPage = (Integer)request.getAttribute("totalPage");
int totalRecord = (Integer)request.getAttribute("totalRecord");

str = "";
str += "<rows>";
str += "<page>"+pageNumber+"</page>";
str += "<total>"+totalPage+"</total>";
str += "<records>"+totalRecord+"</records>";

for(BookVo b:list)
{
	str += "<row>";
	str += "<cell>"+b.getBookid()+"</cell>";		
	str += "<cell>"+b.getBookname()+"</cell>";		
	str += "<cell>"+b.getPublisher()+"</cell>";		
	str += "<cell>"+b.getPrice()+"</cell>";		
	str += "</row>";
}

str += "</rows>";
%>
<%= str %>