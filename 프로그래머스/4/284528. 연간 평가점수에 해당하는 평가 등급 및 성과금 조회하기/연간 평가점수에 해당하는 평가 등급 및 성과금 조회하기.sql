-- 코드를 작성해주세요
-- HR_Grade를 통해 사원 별 등급을 구하고(emp_no와 year로 집계하여, score의 총합의 평균을 구하여 기준 점수에 따르는 평가등급을 정한다.) 해당 등급을 통해 보너스를 계산한다. 보너스는 평가표를 기준으로 해당 직원의 연봉을 기준으로 한다.

with get_grade as (
    select emp_no,
    case 
    when sum(score) / 2 >= 96 then 'S'
    when sum(score) / 2 >= 90 then 'A'
    when sum(score) / 2 >= 80 then 'B'
    else 'C'
    end as rnk
    from hr_grade
    group by emp_no, year
)

select he.emp_no, emp_name, rnk as grade, 
case
when rnk like 'S' then round(sal * 0.2,0)
when rnk like 'A' then round(sal * 0.15,0)
when rnk like 'B' then round(sal * 0.1,0)
when rnk like 'C' then 0
end as bonus
from get_grade as gg inner join hr_employees as he on gg.emp_no = he.emp_no
order by 1 asc