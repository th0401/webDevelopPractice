-- ���̺� ����
create table member(
    mnum int primary key,
    id varchar(20),
    pw varchar(20)
);
insert into student values(1,'ȫ�浿',100,99);

create table gift(
    mnum int, -- member
    gnum varchar(30),
    gprice int,
    foreign key (mnum) references member(mnum) on delete cascade
);

create table store(
    snum int primary key, -- menu
    sname varchar(30),
    mnum int,
    scall varchar(30),
    foreign key (mnum) references member(mnum) on delete cascade
);
create table menu(
    snum int , -- store
    menunum int primary key,
    menuname varchar(50),
    price int,
    menucnt int,
    foreign key (snum) references store(snum) on delete cascade
);

select * from all_tables;

-- ���̺� ����
drop table member;
drop table menu;
drop table gift;
drop table store;

-- ���̺� �ʱ�ȭ
delete from member;
delete from gift;
delete from menu;
delete from store;

-- ��ü ���
select * from member;
select * from gift;
select * from menu;
select * from store;