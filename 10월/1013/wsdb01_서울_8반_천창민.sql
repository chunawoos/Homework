create database ssafydb;

use ssafydb;

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

select *
from emp;

# 1
select e.ENAME, e.SAL, d.DNAME
from emp e inner join dept d
using (deptno);

# 2 
select d.DNAME
from emp e inner join dept d
using (deptno)
where e.ename ='KING';

# 3
select d.DEPTNO, d.DNAME, e.ENAME, sal
from emp as e, dept d
where e.DEPTNO = d.DEPTNO;

select e.ENAME, e.DEPTNO, d.DNAME, e.sal
from emp e inner join dept d
using (deptno);

# 4
Select concat(e.ename, '의 매니저는 ', if(e.mgr = null, '없습니다', concat(m.ename,'이다')))
from emp e left outer join emp m
on e.mgr = m.empno;

Select concat(e.ename, '의 매니저는 ', m.ename,'이다')
from emp e inner join emp m
on e.mgr = m.empno;

# 5
select e.ename, d.dname, e.sal, e.job
from emp e inner join dept d
using (deptno)
where e.job = (select job from emp where ename = 'SCOTT') and e.ename != 'SCOTT';

# 6
select e.EMPNO, e.ENAME, e.HIREDATE, e.SAL
from emp e
where e.DEPTNO = (select DEPTNO from emp where ename= 'SCOTT') and e.ename != 'SCOTT';

# 7
select e.EMPNO, e.ENAME, d.DNAME, e.HIREDATE, d.LOC, e.SAL
from emp e inner join dept d
using (deptno)
where e.sal > (select avg(sal) from emp);

# 8
select e.EMPNO, e.ENAME, d.DNAME, d.LOC, e.sal
from emp e inner join dept d
using (deptno)
where e.job in (
					select job from emp where deptno = 30
				)
order by e.sal desc;

# 9
select e.EMPNO, e.ENAME, d.DNAME,e.HIREDATE , d.LOC
from emp e inner join dept d
using (deptno)
where e.job not in (select job from emp where deptno = 30) and e.deptno = 10;

# 10
select e.EMPNO, e.ENAME, e.SAL
from emp e
where e.sal = any (	select sal from emp where ename = 'KING' or ename ='JAMES') and e.ENAME not in ('KING', 'JAMES');


# 11
select e.EMPNO, e.ENAME, e.SAL
from emp e
where e.sal > all (select sal from emp where deptno = 30);

# 13
select e.ENAME, e.SAL
from emp e
where year(e.HIREDATE) = (select year(hiredate) from emp where ename = 'ALLEN');