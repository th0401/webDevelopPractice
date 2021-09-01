select * from all_tables;

select * from BOARD;
drop table board;
create table bmember(
	bmem int primary key,
	userID varchar(20) not null,
	userPW varchar(20) not null,
	userName varchar(20) not null
);
create table board(
	bnum int primary key,
	title varchar(30) not null,
	content varchar(50) not null,
	writer varchar(20) not null,
	bdate date default sysdate,
	bmem int,
	foreign key (bmem) references bmember(bmem) on delete cascade
);

select * from bmember;

insert into bmember values('1','kim','1234','±èÀÚ¹Ù');