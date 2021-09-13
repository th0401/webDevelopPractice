select * from all_tables;

create table userInfo(
   userID varchar(15) primary key,
    name varchar(15),
    userPW varchar(10),
    udate date default sysdate
);
create table mmessage(
   meid int primary key,
    userID varchar(15),
    msg varchar(100),
    favcount int default 0,
    replycount int default 0,
    udate date default sysdate
);
create table reply(
   reid int primary key,
    meid int,
    userID varchar(15),
    udate date default sysdate,
    rmsg varchar(50),
    constraint msgrp foreign key (meid) references mmessage (meid) on delete cascade
);
insert into userInfo values('timo','Æ¼¸ð','1234',sysdate);
insert into mmessage values(1,'timo','±ÛÀÛ¼º111',1,2,sysdate);
insert into reply values(1,1,'timo',sysdate,'´ñ±Û1');
insert into reply values(2,1,'timo',sysdate,'´ñ±Û2');
insert into mmessage values(2,'timo','±ÛÀÛ¼º2222',2,3,sysdate);
insert into reply values(3,2,'timo',sysdate,'´ñ±Û1');
insert into reply values(4,2,'timo',sysdate,'´ñ±Û2');
insert into reply values(5,2,'timo',sysdate,'´ñ±Û3');


select * from reply;
select * from userInfo;
select * from mmessage;


