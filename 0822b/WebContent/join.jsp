<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<form action="joinOk.do" method="post">
	아이디:<input type="text" name="id"><br>
	비밀번호:<input type="password" name="pwd"><br>
	이름:<input type="text" name="name"><br>
	나이:<input type="number" name="age"><br>
	전화번호:<input type="text" name="addr"><br>
	주소:<input type="text" name="id"><br>
	취미:
	<input type="checkbox" name="hobby" value="독서">독서
	<input type="checkbox" name="hobby" value="영화감상">영화감상
	<input type="checkbox" name="hobby" value="게임">게임
	<input type="checkbox" name="hobby" value="운동">운동
	<br>
	직업:
	<select name="job">
		<option value="학생">학생</option>
		<option value="회사원">회사원</option>
		<option value="주부">주부</option>
		<option value="취업준비생">취업준비생</option>
		<option value="자영업">자영업</option>
		<option value="기타">기타</option>
	</select><br>
	성별:
	<input type="radio" name="sex" value="남자">남자
	<input type="radio" name="sex" value="여자">여자<br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
	</form>
</body>
</html>