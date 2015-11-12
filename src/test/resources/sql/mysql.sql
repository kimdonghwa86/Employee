drop table member;

--membertable생성
create table member(
	id				int auto_increment,
	email	 		varchar(255),
	name 			varchar(255),
	password		varchar(255),
	register_date	date,
	constraint Pk_id primary key (id) 
	
);

-- Member CRUD(create, read, update, delete)
--DML
-- 멤버테이블에 데이터를 삽입할때.
insert into member
(email, name, password, register_date)
values
("xxxx@yyy", "송럭키", "1234","2015/11/11")      

--read
select * from member;		

--update  입력한 아이디의 정보를 업데이트한다.
update member
	set name = '럭키짱',
		password = '8888'
	where id = 7;
--delete 입력한 아이디의 정보를 삭제한다. 
delete from member
 where id = 10;

--
-- ******City***** 
--  
 
 --City (select All)
 select id,
		name,
		countrycode,
		district,
		population
   from city

  
  
  --selectByCountrycode(String countryCode)
  select id,
		name,
		countrycode,
		district,
		population
   from city
  where countrycode = 'USA'
   
   
