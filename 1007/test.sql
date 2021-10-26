CREATE TABLE userInfo(
	id varchar(30) primary key,
	pw varchar(30) not null,
	name varchar(30) not null,
	height number(5,2) default 0
);

CREATE TABLE diet(
	dnum int primary key,
	breakfast varchar(500),
	lunch varchar(500),
	diner varchar(500),
	calorie int default 0,
	another varchar(500),
	ddate date default sysdate,
	d_user varchar(200),	
	foreign key (d_user) references userInfo(id) on delete cascade
);


CREATE TABLE body(

	bnum int primary key,	
	weight number(5,2) default 0,
	l_user varchar(30),
	ldate date default sysdate,
	foreign key (l_user) references userInfo(id) on delete cascade,
);




select*from try1;

create table test1(
   a number(5,2)
);

insert into test1 values(171.143111122222);
select * from test1;
drop table test1;


UPDATE POST SET comCnt = 0;

/* SELECT ALL */
select * from all_tables;
select * from userInfo;
select * from body;
select * from weight;

SELECT NVL(MAX(pnum),0 + 1) FROM post;
/* 테이블 삭제 */
drop table userInfo CASCADE CONSTRAINTS;
drop table body CASCADE CONSTRAINTS;
drop table weight CASCADE CONSTRAINTS;


DELETE FROM post WHERE pnum=5;
/* 테스트용 예시 데이터 */
insert into userInfo (id, pw, name) values('admin','123','관리자');
insert into post (pnum, views, plike, category, title, content, writer, p_user, path)
values(1,0,0, '치킨', '푸라닭', '?', '?', 'admin', '??');

insert into comments (cnum, cwriter, cment, c_user, c_post)
values(1, '?', '1111','1111', 1);

insert into likeInfo (l_user,l_post)values ('1111', 1);

SELECT * from post WHERE title like '%1%';
SELECT * FROM post WHERE title LIKE '%1%' ORDER BY pnum DESC;

CREATE TABLE test(
	name varchar(30),
	secretNum int constraint test_secretNum_CK check(secretNum = 0 or secretNum = 1)
);

select * from test;
drop table test;

insert into test (name,secretNum) values ('kim', 0);
insert into test (name,secretNum) values ('lee', 4);




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
insert into member123 values('kim','1234','김씨','USER');
insert into member123 values('admin','1234','관리자','ADMIN');
select * from member123;
insert into board123 (id,title,writer,content) values(1,'제목','김씨','글 내용');
select * from board123;

delete from board123 where title='제목입니다!';