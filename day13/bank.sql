select * from all_tables;

create table bank1(
	b1num int primary key,
	name varchar(30) not null,
	balance int not null	
);

insert into bank1 values(1,'Ƽ��',10000);
insert into bank1 values(2,'�Ƹ�',20000);
select * from bank1;

create table bank2(
	b2num int primary key,
	name varchar(30) not null,
	balance int not null	
);

insert into bank2 values(1,'�ƹ���',5000);
insert into bank2 values(2,'��¥��',15000);
select * from bank2;