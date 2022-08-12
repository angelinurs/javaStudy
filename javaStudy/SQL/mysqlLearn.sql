select count(*) from employees.employees;

desc employees.employees;

select emp_no, first_name, last_name, birth_date, hire_date
from employees.employees;

-- What diffence are two way about scheme ( database )
-- Case 1. implicit scheme
select emp_no, concat_ws( '_', first_name, last_name) as Full_Name , birth_date, hire_date
from employees.employees;

-- Case 2. `use` scheme ( database );
use employees;

select * from employees;

-- howto AND operator
select emp_no, concat_ws( "_", first_name, last_name) as Full_Name, hire_date, gender
from employees
where hire_date >= '1999-01-01' AND gender = 'F'
order by hire_date asc;

-- howto BETWEEN operator
select emp_no, concat_ws( "_", first_name, last_name) as Full_Name, hire_date
from employees
where hire_date  between '1997-01-01' and '1997-12-31'
order by hire_date asc;

select emp_no, salary
from salaries
where salary between 70000 and 80000;

-- howto IN operator
select emp_no, salary
from salaries
where salary in ( 75323, 75000, 76000, 76500 );

select emp_no, salary
from salaries
where salary = 75323 or salary = 75000 or salary = 76000 or salary = 76500 ;

select emp_no, concat_ws( '_', first_name, last_name ), hire_date, gender
from employees
where emp_no in ( 20010, 18500, 16700, 20200, 24500 )
order by hire_date asc;

-- howto LIKE operator
select *
from employees
where first_name like 'M%';

select *
from employees
where first_name like '%n';

select *
from employees
where first_name like '%n';

select *
from employees
where first_name like 'M______';

-- Case 01. 
-- use 'LIKE' operator
select *
from employees
where hire_date like '1997%';

-- Case 02.
-- use `BETWEEN` operator
select *
from employees
where hire_date between '1997-01-01' and '1997-12-31';

-- user `ORDER BY` query


select *
from salaries
order by salary desc, from_date asc;

select *
from salaries
order by salary desc, from_date asc;

select *
from salaries
where to_date like '9999%';

select *
from employees
where hire_date like '2000%'
order by hire_date desc, birth_date asc;

desc employees;

-- virtual table
select now() from dual;

-- after 1 year
select now() as now, date_add( now(), interval 1 YEAR ) as AterYear from dual;

-- after 1 month
select date_add( now(), interval 5 month ) as AfterMonth from dual;

select date_add( '2022-12-22', interval 1 month ) as AfterMonth from dual;

-- befor 3 month
-- Case 01.
-- date_sub()
select date_sub( now(), interval 3 month ) as ThreeMonthAgo from dual;

-- Case 02.
-- interval -3 
select date_add( now(), interval -3 month ) as AfterMonth from dual;

-- howto `GROUP BY`
desc dept_emp;

select dept_no, count(*)
from dept_emp
group by dept_no;

select gender, count(*)
from employees
where hire_date between '2000-01-01' and '2000-12-31'
group by gender;

-- focus on 
-- where 절 다음에 오는 조건으로써 그룹형 함수가 올 수 없다. alias 를 해주더라도 안되다.
-- 정말 그룹형 함수를 사용하여면 having 다음에 사용한다. 

-- howto `HAVING`
select dept_no, count(*) as deptCount
from dept_emp
group by dept_no
having deptCount >= 50000
order by deptCount asc;

select emp_no, count(*) as renew_contract, 
			   max( salary ) as maxSalary, 
               min( salary ) as minSalary,
               avg( salary ) as avgSalary
from salaries
group by emp_no
having renew_contract >= 15
order by renew_contract desc;

-- [ exam ] 22_08_09
-- Q. 01
/*
* employees 테이블에서 입사일이 1990 년도 이후에 입사한 사원의 정보를 사원번호,이름,
* 성별,입사일 순으로 출력하는 SELECT 문장을 작성하시오
*/
select emp_no, concat_ws( '_', first_name, last_name ), gender, hire_date
from employees
where hire_date >= '1990-01-01'
order by hire_date asc;

select emp_no, concat_ws( '_', first_name, last_name ), gender, hire_date
from employees
where hire_date >= date_format( '1991-01-01', '%y-%m-%d' )
order by hire_date asc;

-- Q. 02
/*
* employees 테이블에서 사원번호가 10010 인 사원의 이름과 생일을 출력하는 
* SELECT 문장을 작성하시오.
*/
select concat_ws( '_', first_name, last_name ), birth_date
from employees
where emp_no = 10010;

-- Q. 03
/*
* employees 테이블에서 입사일이 1995-2-1과 2000-1-10 사이에 입사한 사원의 사번,이름,
* 성별,입사일을 출력하는 SELECT 문장을 작성하시오. 단 입사일이 최근인 사원부터 출력하시오.
*/
select emp_no, concat_ws( '_', first_name, last_name ), gender, hire_date
from employees
where hire_date between '1995-02-01' and '2000-01-10'
order by hire_date desc;

-- Q. 04
/*
* dept_emp 테이블에서 부서번호가 d004,d009,d006 인 사원의 사번, 근무시작일 정보를 
* 출력하는 SELECT 문장을 작성하시오. 단 사번이 빠른순으로 정렬하여라.
*/
select emp_no, from_date
from dept_emp
where dept_no in ( 'd004', 'd009', 'd006' )
order by emp_no asc;

-- Q. 05
/*
* salaries 테이블에서 급여가 150000 이상이고 근무시작일인 2000 년도인 사원의 
* 사번과 급여, 근무시작일을 출력하는 SELECT 문장을 작성하여라. 
* 단 컬럼명을 Employee 와 EmpSalary, StartDay 로 출력하여라.
*/
select emp_no as Employee, salary as EmpSalary, from_date as StartDay
from salaries
where salary >= 150000 and from_date like '2000%';

select emp_no as Employee, salary as EmpSalary, from_date as StartDay
from salaries
where salary >= 150000 and from_date like '2000%';

-- Q. 06
/*
* salaries 테이블에서 15 년이상 근무한 사원의 모든 정보 사번, 근무년수, 급여의 합을
* 출력하는 SELECT 문을 작성하여라.
*/
select emp_no, count(*) as WorkingPeriod, sum( salary ) as TotalOfSalaries
from salaries
group by emp_no
having WorkingPeriod >= 15;

-- Q. 07
/*
* dept_emp 테이블에서 각 부서의 인원수가 5 만명 이상인 부서의 모든 정보를 부서코드,
* 인원수 순으로 출력하는 SELECT 문을 작성하여라.
*/
select dept_no, count(*) as EmpCount
from dept_emp
group by dept_no
order by dept_no asc;

-- Q. 08
/*
* employees 테이블에서 성별인 여자인 사원들의 수를 알아내는 SELECT 문을 작성하여라.
*/
select count( * ) 
from employees
where gender = 'f';

-- 
select user();
select version();

-- sub Query
-- Case 01.
-- + first step 
-- prepare sub query
select min( salary ) as MinSalary
from salaries
where from_date like '2000%';

-- + second step
-- apply to main query
select emp_no, salary, from_date
from salaries
where salary < (
	select min( salary ) as MinSalary
	from salaries
	where from_date like '2000%'
	)
order by salary desc;

-- Case 02. 
-- + first step 
-- prepare sub query
select date_format( from_date, '%Y' ) as StartYear, min( salary ) as MinSalary
from salaries
group by StartYear
having StartYear = 2000
order by StartYear;

-- + second step
-- apply to main query
select emp_no, salary, from_date
from salaries
where salary < (
	select min( salary ) as MinSalary
	from salaries
    where date_format( from_date, '%Y' ) = '2000'
	group by date_format( from_date, '%Y' )
    )
order by salary desc;

-- multiple subquery 
-- ex 01.
-- Case 01.
select *
from employees
where gender = (
	select gender
    from employees
    where emp_no = 10010
)
and hire_date > (
	select hire_date
    from employees
    where emp_no = 10010
);

-- Case 02.
select e.*
from employees e, 
	( -- table is only emp_no = 10010
		select *
        from employees
        where emp_no = 10010
	) p
where e.gender = p.gender and e.hire_date > p.hire_date;

-- ex 02.
-- Case 01.
select e.*
from employees e, 
	( -- table is only emp_no = 10010
		select *
        from employees
        where emp_no = 10010
	) p
where e.gender = p.gender 
	and e.hire_date > p.hire_date 
    -- and e.birth_date >= '1965-01-01';
    and e.birth_date >= date_format( '1965-01-01', '%Y-%m-%d' );
    
-- gender f
-- hire_date 1989-08-24

select * 
from employees
where gender = 'F' and hire_date > '1989-08-24' and birth_date >= '1965-01-01';

-- Case 02.
-- befor filter
select e.*
from (
	select * from employees
    where birth_date >= date_format( '1965-01-01', '%Y-%m-%d' )
    ) e
where gender = (
			select gender 
			from employees
			where emp_no = 10010
			)
and hire_date > (
			select hire_date
			from employees
			where emp_no = 10010
			);

-- JOIN query
desc dept_emp;
desc departments;

-- Inner Join 
-- ( equijoin )
-- It match exactly correct that join Condition
select e.emp_no, concat_ws( '_', e.first_name, e.last_name ) as FullName, e.birth_date, e.gender, e.hire_date,
	   de.from_date, de.to_date, d.dept_name
from employees e, dept_emp de, departments d
where e.emp_no = 10010
	and e.emp_no = de.emp_no
    and de.dept_no = d.dept_no;

-- Case 01.
-- just dept_no column data
select dept_no, emp_no
from dept_emp
where dept_no = 'd005';

-- dept_no column data and dept_name column
-- * the performance is not good
select de.dept_no, de.emp_no, d.dept_name
from dept_emp de, departments d
where de.dept_no = 'd005'
  and de.dept_no = d.dept_no;
  
-- apply to subquery
-- * the performance is good
-- It's more effective
select de.dept_no, de.emp_no, d.dept_name
from (
	select *
    from dept_emp
    where dept_no = 'd005'
	) de, 
    departments d
where de.dept_no = d.dept_no;

-- ex 1. 
select e.emp_no, concat_ws( '_', first_name, last_name ) as FullName, d.dept_no, d.dept_name
from employees e,
	 (
		select de.emp_no, d.dept_no, d.dept_name
        from dept_emp de, departments d
        where de.dept_no = d.dept_no
     ) d
where e.emp_no = '101000' and e.emp_no = d.emp_no;

-- ex 2. 
-- Case 01.
select e.emp_no, concat_ws( '_', first_name, last_name ) as FullName, d.dept_no, d.dept_name
from employees e,
	 (
		select de.emp_no, d.dept_no, d.dept_name
        from dept_emp de, departments d
        where de.dept_no = d.dept_no
     ) d
where e.emp_no = d.emp_no
order by emp_no asc;

-- ex 3.
-- find that chef of department
-- Case 01.
select concat_ws( '_', first_name, last_name ) as Chief, 
	   d.dept_no, d.dept_name, e.emp_no
from employees e,
	(
    select d.dept_no, d.dept_name, dm.emp_no
	from dept_manager dm, departments d
	where date_format( dm.to_date, '%Y' )  = '9999' and dm.dept_no = d.dept_no
    ) d
where e.emp_no = d.emp_no
order by d.dept_no;

-- Case 02.
select concat_ws( '_', e.first_name, e.last_name ) as Chief, 
	   d.*, e.emp_no
from employees e, 
	 departments d, 
	(
		select * 
		from dept_manager
		where date_format( to_date, '%Y' )  = '9999'
	) dm
where dm.dept_no = d.dept_no and e.emp_no = dm.emp_no
order by d.dept_no asc; 

-- ex 4.
-- Case 01. bad
-- find that employees of department
select d.dept_name, e.emp_no, concat_ws( '_', e.first_name, e.last_name )
from employees e,
	( 
		select de.emp_no, d.*
        from dept_emp de, departments d
		where de.dept_no = d.dept_no
	) d
where e.emp_no = d.emp_no
order by emp_no;

-- Case 02. not bad ( remove duplicate data )
-- * caution : There is working in multiple departments at the same time
-- * solution : Remove record, if is faster than to_date based on day of data collection
-- find that employees of department
select de.emp_no, concat_ws( '_', e.first_name, e.last_name ) as FullName, d.*
from departments d,
	 employees e,
     (
		 select emp_no, max( to_date ) as LatelyDate, dept_no
		 from dept_emp
		 group by emp_no
     ) de
where de.dept_no = d.dept_no and e.emp_no = de.emp_no
order by de.emp_no;

-- 9999 년을 제외한 가장 최근 퇴사일을 현재 시점으로 보고,
-- 현재시점보다 to_date 시점이 늦은 직원들만 검색 ( 현재 근무중인 직원으로 계상함. )
select emp_no, dept_no
from dept_emp
where to_date >= (
				select max( to_date ) as Now_Date
				from dept_emp
				where date_format( to_date, '%Y' ) <> '9999'
				);

-- 위와 같이 검색 했을때 여러부서에 일하는 직원 검색
select emp_no, count( dept_no ) as Count
from dept_emp
where to_date >= (
				select max( to_date ) as Now_Date
				from dept_emp
				where date_format( to_date, '%Y' ) <> '9999'
				)
group by emp_no
having Count > 1;

-- Case 03. so so.
-- 완전히 퇴사한 직원 전부 제거
-- 중복 부서 근무일때 마지막 퇴사한 직원의 퇴사 날짜를 현재 시점으로 간주하여,
-- 퇴사시점이 그보다 느린 사람만 일하는 것으로 간주함. 
-- ( 이 상황을 만족하는 복수부서 근무 역시 허용함. )
select de.emp_no, concat_ws( '_', e.first_name, e.last_name ) as FullName, d.*
from departments d,
	 employees e,
     (
		 select emp_no, dept_no
		 from dept_emp
		 where to_date >= (
				select max( to_date ) as Now_Date
				from dept_emp
				where date_format( to_date, '%Y' ) <> '9999'
				)
     ) de
where de.dept_no = d.dept_no and e.emp_no = de.emp_no
order by de.emp_no;

-- ex 5.
-- present each department max salary
-- preparing
select d.*, s.*, max( s.salary ) MaxSalary
from dept_emp d, salaries s
where d.emp_no = s.emp_no 
	and d.from_date = s.from_date 
    and d.to_date = s.to_date
group by d.dept_no
order by d.dept_no;

-- 
select * 
from dept_emp de,
	 (
     select d.dept_no , max( s.salary ) MaxSalary
	 from dept_emp d, salaries s
	 where d.emp_no = s.emp_no 
		and d.from_date = s.from_date 
		and d.to_date = s.to_date
	 group by d.dept_no
     ) ds
where de.dept_no = ds.dept_no
order by de.dept_no;

-- 
select d.emp_no, d.dept_no ,s.salary
from dept_emp d, salaries s
where d.emp_no = s.emp_no 
	and d.from_date = s.from_date 
	and d.to_date = s.to_date
order by d.emp_no;

-- 
select d.emp_no, d.dept_no , salary
from dept_emp d, salaries s
where d.emp_no = s.emp_no 
	and d.from_date = s.from_date 
	and d.to_date = s.to_date
-- group by d.dept_no 
order by d.dept_no;

-- 
select t.emp_no, t.dept_no, t.salary
from (
	select d.emp_no, d.dept_no , salary
	from dept_emp d, salaries s
	where d.emp_no = s.emp_no 
		and d.from_date = s.from_date 
		and d.to_date = s.to_date
	) t
group by t.dept_no
having max( t.salary )
order by t.dept_no;

-- right
SELECT de.dept_no, s.emp_no, MAX(s.salary) as salary 
FROM salaries s, dept_emp de
WHERE de.emp_no = s.emp_no
	-- and de.from_date = s.from_date 
	-- and de.to_date = s.to_date
GROUP BY s.emp_no 
ORDER BY dept_no asc, salary desc; -- 정렬 된 상태로 오지 않으면 않됨.

-- check max salary in `d001` department
select * from departments where dept_no = (
	select dept_no 
	from dept_emp
	where emp_no = (
		select emp_no
		from salaries s
		where s.salary = 145128
	)
);

select *
from dept_emp
where emp_no = 66430;

-- ( outer join )
-- 조인 조건이 정확히 일히하는 행과
-- 일치하지 않는 모든 행들을 출력할 때 사용.
    
-- ( self join )
-- 하나의 테이블에서 특정 컬럼과 연결성을 가지는 경우dept_managerdept_managertitles

-- ( natural join )
select * 
from employees natural join dept_emp;

-- 22_08_11
-- 8. 내장함수
--	SQL문을 효과적으로 지원하기 위해 내부적으로 지원하는 함수들

SELECT abs(-19) FROM dual; -- 절대값 : 19
SELECT ceil(22.2) FROM dual; -- 올림 : 23
SELECT floor(22.8) FROM dual; -- 절삭 : 22
SELECT mod(10, 3) FROM dual; -- 10%3 = 1 : 나머지 값

-- 이 외 length(), concat(), trim() 등 많은 함수들이 존재함!

-- 먼저 테이블 생성해 보자
CREATE TABLE `employees`.`my_sal` (
	`idx` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NULL,
	`dept` VARCHAR(5) NULL,
	`salary` DECIMAL NULL,
	`bonus` DOUBLE NULL,
PRIMARY KEY (`idx`));

-- :: 자원 추가
INSERT INTO my_sal (name, dept, salary, bonus) 
VALUES ('을불', 'd005', '55830', 0.2);

-- idx컬럼은 자동증가( AUTO_INCREMENT) 기능을 부여했으므로 알아서 1씩 증가하면서 대입된다.

-- my_sal테이블에서 각 부서별 급여의 합, 급여의 평균을 구하자!
SELECT dept, SUM(salary), AVG(salary), SUM(bonus), AVG(bonus) 
FROM my_sal
GROUP BY dept;
-- [결과]
-- d001	32000	32000.0000	0.3	0.3
-- d005	216490	72163.3333	0.2	0.2

-- 위의 결과 중 AVG(bonus) 부분은 때에 따라 합에서 인원수를 나눠야 할 때가 있다.
-- 하지만 AVG함수가 null인 것은 연산에서 제외시킨다. null값을 0으로 변경한 후
-- AVG함수를 사용하면 원하는 결과를 얻을 수 있다.

SELECT dept, SUM(salary), AVG(salary), SUM(bonus), AVG(bonus), AVG(IFNULL(bonus, 0)) 
FROM my_sal
GROUP BY dept;

-- IFNULL()은 해당 컬럼에서 NULL값을 찾아 다른 값으로 변경하여 처리할 때 사용한다.
-- 오라클은 NVL()이다.

-- 위의 결과에서 salary가 70000이상이면 '고액연봉자', 그렇지 않으면 '일반'을 출력하려 한다.

SELECT idx, name, salary,
		IF(salary >= 70000,  '고액연봉자', '일반') as "구분"
FROM my_sal;

-- 위의 내용에서 부서코드가 'd001'이면 '기획팀'으로 표현하고, 'd005'이면 '개발팀'이라고 출력하자!

SELECT idx, dept, name, CASE WHEN dept = 'd001' THEN '기획팀'
							WHEN dept = 'd005' THEN '개발팀'
							WHEN dept = 'd006' THEN '홍보팀'
							WHEN dept = 'd009' THEN '회계팀' end AS d_name,
	salary, bonus
FROM my_sal;

-- 22_08_11
-- create table
CREATE TABLE book_t(
	b_idx BIGINT AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	author VARCHAR(50),
	brand VARCHAR(50),
	price DECIMAL(6,0),
	CONSTRAINT book_t_pk PRIMARY KEY(b_idx)
);

-- 기본키가 설정된 b_idx와 같은 컬럼은 중복된 값이 저장되지 못하며, NULL값도 허용되지 않는다.
-- 그리고
-- NOT NULL 것을 지정하게 되면 해당 컬럼은 절대로 NULL값을 허용하지 않는 제약조건을 부여한 것이다.

-- add column
ALTER TABLE book_t
ADD reg_date DATE;

-- modify column data type
ALTER TABLE book_t
MODIFY price DECIMAL(8);

-- rename column name 
ALTER TABLE book_t
RENAME COLUMN reg_date TO write_date;

-- delete column
ALTER TABLE  book_t
DROP COLUMN write_date;

-- delete table
DROP TABLE book_t;

-- ex 01.
-- create table `memo_t`
create table `employees`.`memo_t` (
	`m_idx` bigint auto_increment,
    `title` varchar( 256 ) not null,
    `content` longtext,
    `pw` varchar( 256 ) not null,
    `writer` varchar( 256 ) not null,
    `write_date` date,
    constraint memo_t_pk primary key( m_idx )
);

desc memo_t;

drop table memo_t;

alter table memo_t
modify `write_date` datetime;

-- add record 1.
insert into `memo_t` ( `title`, `content`, `pw`, `writer`, `write_date` )
	   values ( 'custom Title', 'hello world\n', 'pw1234', 'author', now() );
       
select * from memo_t;

-- add record 2.
insert into `memo_t` values ( default, 'second Title', 'hi', 'pw1234', 'mavel', now() );
insert into `memo_t` values ( m_idx, 'second Title', 'hi', 'pw1234', 'mavel', now() );

select * from memo_t;

-- update column values 01.
update memo_t
set title = 'trans title';

-- update column values 02.
update memo_t
set writer = 'trans'
where m_idx = 4;

-- delete
delete from memo_t
where m_idx = 1;

delete from memo_t
where m_idx in ( 3, 7, 17, 50 );

select * from memo_t;

-- ex 1.
-- design library scheme
drop database library;
create database library;

use library;

-- books table
drop table `library`.`books`;
create table `library`.`books` (
	book_idx bigint auto_increment,
    book_name varchar( 100 ) not null,
    isbn varchar( 50 ) not null,
    borrowed bool default false not null,
    place varchar( 50 ) not null,
    constraint primary key( book_idx )
);

-- members table
drop table `library`.`members`;
create table `library`.`members` (
	m_idx bigint auto_increment,
    m_name varchar( 100 ) not null,
    m_contact varchar( 100 ) not null,
    m_jumin varchar( 10 ) not null,
    m_birth varchar( 10 ) not null,
    m_address varchar( 256 ) not null,
    m_activate bool default true,
    constraint members_t_pk primary key( m_idx, m_name )
);

-- book_status table
drop table `library`.`book_status`;
create table `library`.`book_status` (
	bs_idx bigint auto_increment,
    book_idx bigint not null,
    borrowed_idx bigint,
    borrowed_name varchar( 100 ) not null,
    borrow_from_date date,
    borrow_to_date date,

	constraint primary key( bs_idx ),
    
    constraint FOREIGN KEY ( borrowed_idx, borrowed_name )
      REFERENCES `library`.`members`( m_idx, m_name ),
    
    constraint members_t_fk foreign key( book_idx ) 
		references `library`.`books`( book_idx )
);

desc employees.employees;

use employees;

select * from employees where gender = 'f';