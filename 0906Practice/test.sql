select * from all_tables;

create table member(
	userID varchar(20) primary key,
	userPW varchar(20) not null,
	userName varchar(20)
);

select * from member;
insert into member values('kim','1234','±èÀÚ¹Ù');
insert into member values('lee','abcd','¹ÙÀÚ±è');

create table post(
	pnum int primary key,
	title varchar(30) not null,
	content varchar(500) not null,
	pdate date default sysdate,
	userID varchar(20),
	 foreign key (userID) references member(userID) on delete cascade
);
select * from post;



drop table post;
