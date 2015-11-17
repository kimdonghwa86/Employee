select * from dept;

--membertable 생성
--DDL(Data Defindin
create table member(
	id				int,
	email	 		varchar(255),
	name 			varchar(255),
	password		varchar(255),
	register_date	date,
	constraint Pk_id primary key (id) 
	
);


-- Member CRUD(create, read, update, delete)
-- DML(Data Manapulation Language)
-- Create

create sequence member_id_seq        --시퀀스를 만든다.

insert into member
(id, email, name, password, register_date)
values
(member_id_seq.nextval, 'luckySong@yyy', '러키짜앙', '1234','2015/11/11')      

--read (테이블확인)
select * from member;		

--update  입력한 아이디의 정보를 업데이트한다.
update member
	set name = '송럭키',
		password = '8888'
	where id = 1;
--delete 입력한 아이디의 정보를 삭제한다. 
delete fromme mber;
 where id = 1;
 
 
 
-----------------------------------------------------------------------------
--city 

 drop table city
 --테이블만든다.
 create table city (
  id				 numeric(11),
  name			 	char(50),
  countrycode	 	char(3),
  district		 	char(30),
  population	 	numeric(11),
  constraint city_Pk_id primary key (id)
)
 --테이블생성확인
select * from city; 
 
--테이블에 데이터를 삽입한다.
insert into city
(	id,
		name,
		countrycode,
		district,
		population
)
values
(
	1,
	'seoul',
	'KOR',
	'Asia',
	99998	
)
 
--테이블생성확인
select * from city; 
--테이블을 지운다.
delete from city;
 

select * from dept
select * from emp

select d.deptno  as dept_deptno,
	   d.name 	 as dept_dname,
	   d.loc 	 as dept_loc,
	   d.empno	 as dept_empno,
	   d.ename	 as dept_ename,
	   e.job	 as dept_job
from dept d inner join emp e
on d.deptno = e.deptno


select d.deptno  as dept_deptno,
	   d.name 	 as dept_dname,
	   d.loc 	 as dept_loc,
	   d.empno	 as dept_empno,
	   d.ename	 as dept_ename,
	   e.job	 as dept_job,
from dept d inner join emp e
on d.deptno = e.deptno
 
 
 
 
 