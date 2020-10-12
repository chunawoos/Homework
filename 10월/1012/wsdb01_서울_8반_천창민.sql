use ssafydb;

drop table emp;

CREATE TABLE EMP
(
	EMPNO int(4) not null,
	ENAME VARCHAR(10),
	JOB VARCHAR(9),
	MGR int(4) ,
	HIREDATE date,
	SAL decimal ,
	COMM decimal ,
	DEPTNO int 
);


INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,cast('1980-12-17' as date),800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,cast('1981-02-20' as date),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,cast('1981-02-22' as date),1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,cast('1981-04-02' as date),2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,cast('1981-09-28' as date),1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,cast('1981-04-01' as date),2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,cast('1981-06-01' as date),2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,cast('1982-10-09' as date),3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,cast('1981-11-17' as date),5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,cast('1981-09-08' as date),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,cast('1983-01-12' as date),1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,cast('1981-10-03' as date),950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,cast('1981-10-3' as date),3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,cast('1982-01-23' as date),1300,null,10);

truncate emp;
select *
from emp;
COMMIT;

CREATE TABLE DEPT
(
	DEPTNO int,
	DNAME VARCHAR(14),
	LOC VARCHAR(13) 
);

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;



CREATE TABLE SALGRADE
( 
	GRADE int,
	LOSAL decimal,
	HISAL decimal 
);

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT;


# 1
select *
from dept;

# 2
select job, empno, ename, hiredate
from emp;

# 3을 안쓸 경우
select job
from emp;

# 3
select distinct job
from emp;

# 4
select ename, sal
from emp
where sal >= 2850;

# 5
select ename, deptno
from emp
where empno = 7566;

# 6
select ename, sal
from emp
where not sal >= 1500 or not sal <=2850;
# 6 다른 버전
select ename, sal
from emp
where not sal between 1500 and 2850;
# 7
select ename, job, hiredate
from emp
where hiredate >= 19810220 and hiredate <= 19810501
order by hiredate asc;
# 7 다른 버전
select ename, job, hiredate
from emp
where HIREDATE between 19810220 and 19810501
order by hiredate asc;

# 8
select ename, deptno
from emp
where deptno = 10 or deptno = 30
order by ename;
# 8 다른 버전
select ename, deptno
from emp
where deptno in (10, 30)
order by ename;

# 9
select ename employee, sal as "Monthly Salary"
from emp
where (deptno = 10 or deptno = 30 )and sal >1500;

# 9 다른 버전
select ename employee, sal as "Monthly Salary"
from emp
where deptno in (10, 30)and sal > 1500;

# 10
select ename, job
from emp
where mgr is null;

# 11
select ename, sal, comm
from emp
where comm != 0 and comm is not null 
order by sal asc;

# 12
select ename
from emp
where ename like "__A%";

# 13
select ename
from emp
where ename like "%L%L%" and deptno = 30;

# 14
select ename, job, sal
from emp
where not job in ('Clerk', 'Analyst') and not sal in (1000,3000,5000);

# 15
select deptno, ename, sal, round(sal*1.15) as "New Salary"
from emp;

# 16
select deptno, ename, sal, round(sal*1.15) as "New Salary", abs(sal - round(sal*1.15)) increase
from emp;

# 17
select ename, length(ename) as "Name Length"
from emp;

# 18
select ename, ifnull(if(comm != 0, comm, "no commission"), "no commission")
from emp;
