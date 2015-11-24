select * from dept;
select * from emp;

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
(member_id_seq.nextval, luckySong@yyy, 러키짜앙, 1234,2015/11/11)      

--read (테이블확인)
select * from member;		

--update  입력한 아이디의 정보를 업데이트한다.
update member
	set name = 송럭키,
		password = 8888
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

select count(*) from city 
 
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
	seoul,
	KOR,
	Asia,
	99998	
)



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
 
--
select * from dept
 
 select * 
 	from dept d inner join emp e
 	on d.deptno = e.deptno
 	where d.deptno = 82
 
 	
 --테이블중에 countrycode 칼럼을 검색한다.
select * from city
	order by countrycode asc, name asc 

--rownum 의 컬럼을 보여주며 순번을 보여준다. rownum
select rownum, c.*
	from (select * from city order by name asc) c
--	where rownum >= 11
--	and rownum <=20
order by countrycode asc, name asc 	
	

--테이블 전체를 검색한다
select * from city
	

--city 테이블을 지운다.
delete from city;

--시티테이블 컬럼갯수확인
select count(*) from city  	
 	
--중요하다!! 진짜 이거 복잡한쿼리 페이지검색  로우넘을 기반으로 순서지키면서 출력할수있는 방법 	
 select outer.*
   from (select rownum r, inner.* 
 			from ( select * 
 					from city
 					order by countrycode asc, name asc
 				 ) inner
 		 ) outer
 where outer.r >= 21
   and outer.r <= 30
 
   
   
   
 /*
  * country
  */	
  drop table country
 
  create table country (
  code				 char(3),
  name 				 char(52),
  continent			 char(50),
  region			 char(26),
  surfacearea		 numeric(10,2),
  indepyear	  	     numeric(6),
  population 		 numeric(11),
  lifeexpectancy 	 numeric(3,1),
  gnp				 numeric(10,2),
  gnpold			 numeric(10,2),
  localname 		 char(45),
  governmentform	 char(45),
  headofstate 		 char(60),
  capital			 numeric(11),
  code2 			 char(2),
 constraint pk_country_code primary key(code)
) 
  
  
  

