-- 분기 별 회사 사람들의 score를 평균 집계하여 해당 데이터를 기준으로 기준 점수가 96점 이상이라면 S, 90이상이라면 A, 80 이상이라면 B 그 이외라면 C를 주는 데이터를 형성하여, 해당 직원의 no, name, 성적, 보너스를 계산하여 반환하여라.

with get_emp_grade as (
    select emp_no,
    case
    when avg(score) >= 96 then 'S'
    when avg(score) >= 90 then 'A'
    when avg(score) >= 80 then 'B'
    else 'C'
    end as grade
    from hr_grade g
    group by g.emp_no, year
)



select e.emp_no, emp_name, grade, 
case 
when grade like 'S' then sal * 0.2
when grade like 'A' then sal * 0.15
when grade like 'B' then sal * 0.1
when grade like 'C' then sal * 0.0
end as bonus
from hr_employees e inner join get_emp_grade g on e.emp_no = g.emp_no
order by emp_no asc