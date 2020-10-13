# 1 
select e.ENAME, e.EMPNO, e.DEPTNO, d.DNAME
from emp e inner join dept d
using (deptno)
where e.deptno = 30;

# 2
select distinct e.job, d.LOC
from emp e inner join dept d
using(deptno)
where e.deptno = 30;

# 3
select e.ename, d.dname, d.loc
from emp e inner join dept d
using(deptno)
where e.comm is not null and not e.comm = 0;

# 4
select e.ENAME, d.DNAME, d.LOC 
from emp e inner join dept d
using(deptno)
where e.ENAME like '%A%';

# 5 
select e.ENAME, e.JOB, e.DEPTNO, d.DNAME
from emp e inner join dept d
using (deptno)
where d.loc = 'Dallas';

# 6
select e.ENAME as employee, e.EMPNO 'emp#', if(e.MGR is null,'X', e.MGR) manager, if(m.ENAME is null, 'X', m.ENAME )as 'mgr#'
from emp e left outer join emp m
on e.mgr = m.empno;

# 7
select e.ENAME, e.JOB, d.DNAME, e.sal, s.GRADE
from emp e inner join dept d
on e.DEPTNO = d.DEPTNO
inner join salgrade s
on e.sal between s.LOSAL and s.HISAL;

# 8
select e.ENAME, e.HIREDATE
from emp e
where e.HIREDATE > (select HIREDATE from emp where ENAME = 'Smith');

# 9
select e.ENAME as 'Employee', e.HIREDATE as 'EmpHiredate', m.ENAME 'Manager', m.HIREDATE 'MgrHiredate'
from emp e left outer join emp m
on e.MGR = m.EMPNO
where e.HIREDATE < m.HIREDATE;

# 10
select e.ENAME, e.HIREDATE
from emp e
where e.DEPTNO = (select deptno from emp where ename = 'Smith') and ename != 'smith';

# 11
select e.EMPNO, e.ENAME, e.sal
from emp e
where e.sal > (select avg(sal) from emp)
order by sal desc;

# 12
select e.EMPNO, e.ENAME
from emp e
where e.DEPTNO in (select deptno from emp where ename like '%T%');

# 13
select e.EMPNO, e.ENAME, e.SAL
from emp e
where e.sal > (select avg(sal) from emp) and e.DEPTNO in (select deptno from  emp where ename like '%T%');

# 14
select e.EMPNO, e.ENAME, e.SAL
from emp e
where e.sal > all (select sal from emp where job = 'Clerk')
order by e.sal desc;

# 15
select e1.ENAME, e1.DNAME
from (select * from emp e inner join dept d using (deptno)) e1 , (select * from emp e2 inner join dept d2 using (deptno) where d2.DNAME = 'New York') e2
where e1.sal = e2.sal and e1.comm = e2.comm;