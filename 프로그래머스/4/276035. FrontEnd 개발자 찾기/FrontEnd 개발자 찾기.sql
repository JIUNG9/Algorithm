-- 코드를 작성해주세요
-- skill code에서 front end만의 스택을 모아, developers 테이블에 skill code와 일치하는 개발자의 id,email,first_name,last_name 출력(id asc)

with get_front_code_sum as(
    select sum(s.code) as code_sum
    from skillcodes as s
    where category like 'Front%'
    group by category
)

select id,email, first_name,last_name
from developers d ,get_front_code_sum su
where skill_code & su.code_sum
order by 1 asc