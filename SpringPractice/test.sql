select * from all_tables;

create table board1(
   id int primary key,
   title varchar(30),
   writer varchar(15),
   content varchar(100),
   wdate date default sysdate
);
create table member1(
   id varchar(15) primary key,
   password varchar(10),
   name varchar(15),
   role varchar(15)
);
insert into member1 values('kim','1234','�达','USER');
insert into member1 values('admin','1234','������','ADMIN');
select * from member1;
insert into board1 (id,title,writer,content) values(1,'����','�达','�� ����');
select * from board1;

delete from board1 where title='�����Դϴ�!';