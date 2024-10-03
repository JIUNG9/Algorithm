-- 프론트엔드 개발자의 점수 총합을 구한뒤 비트연산
with get_front_bit as (
    select sum(s.code) as code
    from skillcodes s
    where category like "Front%"
    group by category
)

select id,email, first_name, last_name
from developers d
where skill_code & (select f.code from get_front_bit f)
order by 1 asc