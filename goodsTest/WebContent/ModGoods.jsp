<%@page import="com.sun.org.apache.bcel.internal.generic.FNEG"%>
<%@page import="com.oreilly.servlet.MultipartWrapper"%>
<%@page import="goods.GoodsVo"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="goods.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		GoodsDao dao = new GoodsDao();
		GoodsVo vo =  new GoodsVo();
		
		
		String path = request.getRealPath("upload");
		//사진을 저장할 폴더 upload의 실제 경로를 알아온다.
		/*
		사진을 저장할 폴더는 반드시 현재의 프로젝트를 기준으로 만들어야한다.
		만약 사진을 저장할 폴더를 서버의 c:/upload로 만들면 클라이언트는 사진을 볼 숭 없다.
		*/
		System.out.println(path);
		request.setCharacterEncoding("UTF-8");
		
		MultipartRequest multi= new MultipartRequest(request, path, "UTF-8");
		/*클라이언트가 상품수정을 위하여 입력값들과 파일을 동시에 받아오기위한
		MultipartRequest객체를 생성한다. MultipartRequest 객체 생성시에 매개변수로
		request, 파일을 저장할 경로, 인코딩 방식을 전달한다. 따라서 MultipartRequest
		객체 생성시에 파일이 저장된다.
		*/
		int no = Integer.parseInt(multi.getParameter("no"));
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		int qty = Integer.parseInt(multi.getParameter("qty"));
		String fname = null;
		String oldFname = dao.getGoods(no).getFname();
		/*
		상품을 수정하기 전에 원래 가지고 있는 파일명을 저장해둔다.
		만약 상품사진을 수정하지 않는 다면 vo에 이 이름을 다시 설정하고
		수정한다면 수정 완료후 원 파일을 삭제한다.  
		*/
		fname=multi.getOriginalFileName("fname");
		//수정된 파일의 이름을 저장. 수정하지 않으면 값은 null이 된다.
		vo.setNo(no);
		vo.setName(name);
		vo.setPrice(price);
		vo.setQty(qty);
		vo.setFname(oldFname);
		if(fname != null && !fname.equals(""))
		{
			vo.setFname(fname);
		}
		else
		{
			%>
				<font color="red">수정실패</font>
			<%
		}
		
		int re = dao.updateGoods(vo);
		if(re==1)
		{
			if(fname!=null && !fname.equals(""))
			{
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
			response.sendRedirect("ViewList.jsp");
		}
	%>
</body>
</html>