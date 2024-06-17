with get_grade as (
    select
    case
    when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C' end as grade,
    emp_no
    from hr_grade
    group by emp_no

)



select emp.emp_no, emp.emp_name, grade, 
case
when grade like 'S' then round(sal*0.2,0)
when grade like 'A' then round(sal*0.15,0)
when grade like 'B' then round(sal*0.1,0)
else 0
end as bonus
from hr_employees as emp inner join get_grade as gg on gg.emp_no = emp.emp_no
order by 1 asc