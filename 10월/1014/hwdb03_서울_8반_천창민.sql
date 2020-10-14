
# 1
select e.employee_id, e.first_name, e.job_id, e.department_id, ifnull(d.department_name,"")
from employees e left outer join departments d
on e.department_id = d.department_id
where e.job_id = (select job_id from employees where first_name = 'Diana');

# 2
select e.employee_id, e.first_name, j.job_title, d.department_name
from ( select manager_id from employees where first_name = 'Bruce') m join employees e
on m.manager_id = e.manager_id
join departments d
on e.department_id = d.department_id
join jobs j
on e.job_id = j.job_id;

# 3
select employee_id, first_name, hire_date
from employees
order by hire_date limit 5, 5;

