-- 코드를 작성해주세요


with get_score_with_bonus as(

    select emp_no, 
    case 
    when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C'
    end as grade
    from hr_grade
    group by emp_no
    

)

select emp.emp_no, emp_name, grade, 
case 
when grade like 'S' then sal * 0.2
when grade like 'A' then sal * 0.15
when grade like 'B' then sal * 0.1
else 0
end as bonus
from get_score_with_bonus as gcwb inner join hr_employees as emp on emp.emp_no = gcwb.emp_no
order by 1 asc