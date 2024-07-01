select dp.dept_id, dept_name_en, round(avg(sal),0)as avg_sal
from hr_employees as emp inner join hr_department as dp on dp.dept_id = emp.dept_id
group by dp.dept_id
order by 3 desc