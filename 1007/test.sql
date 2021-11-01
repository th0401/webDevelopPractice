CREATE TABLE userInfo(
	id varchar(30) primary key,
	pw varchar(30) not null,
	name varchar(30),
	gender varchar(30)
);

CREATE TABLE diet(
	dnum int primary key,
	breakfast varchar(1500) default null,
	lunch varchar(1500) default null,
	diner varchar(1500) default null,
	breakfastCalorie int default 0,
	lunchCalorie int default 0,
	dinerCalorie int default 0,
	dayCalorie int default 0,
	another varchar(1500),
	anotherCalorie int default 0,
	breakfastDate date default null,
	lunchDate date default null,
	dinerDate date default null,
	ddate date default sysdate,
	d_user varchar(200),	
	foreign key (d_user) references userInfo(id) on delete cascade
);


CREATE TABLE body(

	bnum int primary key,	
	weight number(5,2) default 0,
	height number(5,2) default 0,
	b_user varchar(30),
	bdate date default sysdate,
	foreign key (b_user) references userInfo(id) on delete cascade
);



/* SELECT ALL */
select * from all_tables;
select * from userInfo;
select * from diet;
select * from body;

SELECT NVL(MAX(pnum),0 + 1) FROM post;
/* ���̺� ���� */
drop table userInfo CASCADE CONSTRAINTS;
drop table diet CASCADE CONSTRAINTS;
drop table body CASCADE CONSTRAINTS;

INSERT INTO diet (dnum,breakfast,lunch,diner,another,breakfastCalorie,lunchCalorie,dinerCalorie,anotherCalorie,dayCalorie,ddate,d_user) values(3,'��,����','','ġŲ','����,�ݶ�','',200,2000,600,4300,sysdate,'leeth0401');

DELETE FROM body WHERE bnum=1;
/* �׽�Ʈ�� ���� ������ */
insert into userInfo (id, pw, name) values('admin','123','������');
insert into post (pnum, views, plike, category, title, content, writer, p_user, path)
values(1,0,0, 'ġŲ', 'Ǫ���', '?', '?', 'admin', '??');

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
insert into member123 values('kim','1234','�达','USER');
insert into member123 values('admin','1234','������','ADMIN');
select * from member123;
insert into board123 (id,title,writer,content) values(1,'����','�达','�� ����');
select * from board123;

delete from board123 where title='�����Դϴ�!';