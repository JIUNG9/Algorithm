-- 코드를 작성해주세요
-- 평가 점수가 가장 높은 사원의 emp num와 score의 합을 구하여 반환한다.
-- 해당 반환 값을 기준으로 해당 정보를 emp 정보를 반환한다.


with get_most_high_emp as (

    select emp_no, dense_rank() over(order by sum(score) desc) as rnk
    from hr_grade
    group by emp_no

)

, get_most_high_emp_score as(

    select gr.emp_no, sum(score) as score
    from get_most_high_emp as gm inner join hr_grade as gr on gm.emp_no = gr.emp_no
    where rnk = 1
    group by gr.emp_no

)

select score,gm.emp_no, emp_name, position,email
from get_most_high_emp_score as gm inner join hr_employees as emp on gm.emp_no = emp.emp_no

