# 1 
select e.employee_id, e.first_name, j.job_title
from employees e inner join jobs j
using (job_id)
order by e.employee_id;

# 2
select e.employee_id, e.first_name, e.salary, s.grade
from employees e inner join salgrades s
on e.salary between s.losal and s.hisal
where e.department_id = 80;

# 3
select j.job_title
from employees e inner join jobs j
using (job_id)
where e.department_id is null;

# 4
create table emp90
select e.employee_id, e.first_name, e.salary, d.department_name, l.city
from employees e inner join departments d
using (department_id)
inner join locations l
using (location_id)
where e.department_id = 90;

select * from emp90;

# 5
select e.employee_id, e.first_name, d.department_name, j.job_id, j.start_date, j.end_date
from employees e inner join job_history j
using (employee_id)
inner join departments d
on j.department_id = d.department_id
where employee_id = 200;

# 6
# 6 - 1
select e.employee_id, e.first_name, e.department_id
from employees e inner join departments d
using (department_id)
inner join locations l
using (location_id) 
where l.city = 'toronto';

# 6-2
select e.employee_id, e.first_name, e.department_id
from employees e
where e.department_id in (
							select department_id
                            from departments
                            where location_id = (
													select location_id
                                                    from locations
                                                    where city = 'toronto'
												)
						);