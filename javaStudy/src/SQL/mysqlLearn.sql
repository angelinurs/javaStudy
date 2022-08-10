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

-- ( outer join )
-- 조인 조건이 정확히 일히하는 행과
-- 일치하지 않는 모든 행들을 출력할 때 사용.
    
-- ( self join )
-- 하나의 테이블에서 특정 컬럼과 연결성을 가지는 경우dept_managerdept_managertitles

-- ( natural join )
select * 
from employees natural join dept_emp;

