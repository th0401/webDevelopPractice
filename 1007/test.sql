select * from all_tables;

create table board123(
	id int primary key,
	title varchar(30),
	writer varchar(15),
	content varchar(100),
	wdate date default sysdate
);
create table member123(
	id varchar(15) primary key,
	pw varchar(10),
	name varchar(15),
	role varchar(15)
);
insert into member123 values('kim','1234','±è¾¾','USER');
insert into member123 values('admin','1234','°ü¸®ÀÚ','ADMIN');
select * from member123;
insert into board123 (id,title,writer,content) values(1,'Á¦¸ñ','±è¾¾','±Û ³»¿ë');
select * from board123;

delete from board123 where title='Á¦¸ñÀÔ´Ï´Ù!';