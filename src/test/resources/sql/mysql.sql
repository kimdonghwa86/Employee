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
  
  
  --시티테이블 검색 4079개
 select * from city; 
 
 
 --컨트리코드기준으로 정렬검색 한다
 select id,  
 		name,
 		countrycode,
 		district,
 		population
   from city
  order by countrycode asc, name asc
  limit 40, 10        --20번째부터 5개를 가지고 오겠다. start, length. from 0  
   
   
   
   
