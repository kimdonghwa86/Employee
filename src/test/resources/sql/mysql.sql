drop table member;

create table member(
	id				int auto_increment,
	email	 		varchar(255) ,
	name 			varchar(255),
	password		varchar(255),
	register_date	date,
	constraint Pk_id primary key (id) 
	
);

-- Member CRUD(create, read, update, delete)


insert into member
(email, name, password, register_date)
values
("xxx@yyy", "송럭키", "1234","2015/11/11")      --멤버테이블에 데이터를 삽입할때.

--read
select * from member;		--멤버 테이블 검색

--update
update member
	set name = '홍순이',
		password = '8888'
--delete
delete from member;         --모든 데이터 지우기

