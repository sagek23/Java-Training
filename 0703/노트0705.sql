번호
제목
작성자
암호
내용
조회수
등록일

create table bbs (
	num number primary key,
	title varchar2(50),
	writer varchar2(20),
	pwd varchar2(20),
	content varchar2(3000),
	views number,
	creDate date
	);

create sequence seq_board start with 1 increment by 1;
	

select * from (select * from (select * from bbs order by views desc) where rownum <=2);

select title from bbs order by views desc;

prepareStatement like sql문을 프로그래밍에서 사용하여면 ~ where 컬럼명 like '%'||?||'%'"