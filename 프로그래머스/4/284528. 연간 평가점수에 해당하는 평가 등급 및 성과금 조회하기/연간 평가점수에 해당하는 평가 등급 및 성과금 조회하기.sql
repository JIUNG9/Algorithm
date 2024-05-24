with get_score as 
(
    select emp_no, avg(score) as score
    from hr_grade
    group by emp_no
)


select gs.emp_no, emp_name, 
case 
when score >= 96 then 'S'
when score >= 90 then 'A'
when score >= 80 then 'B'
else 'C'
end as grade , 
case
when score >= 96 then round(sal * 0.2,0)
when score >= 90 then round(sal * 0.15,0)
when score >= 80 then round(sal * 0.1,0)
else 0
end as bonus 
from get_score as gs inner join hr_employees as he on gs.emp_no = he.emp_no
order by gs.emp_no
