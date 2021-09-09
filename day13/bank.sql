select * from all_tables;

create table bank1(
	b1num int primary key,
	name varchar(30) not null,
	balance int not null	
);

insert into bank1 values(1,'티모',10000);
insert into bank1 values(2,'아리',20000);
select * from bank1;

create table bank2(
	b2num int primary key,
	name varchar(30) not null,
	balance int not null	
);

insert into bank2 values(1,'아무무',5000);
insert into bank2 values(2,'신짜장',15000);
select * from bank2;