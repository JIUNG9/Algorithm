-- 코드를 작성해주세요
WITH get_front as 
(
    select category, sc.code
    from skillcodes as sc
    where category like "Front%"
)   


select distinct id, email, first_name, last_name
from DEVELOPERS as d INNER JOIN get_front as gf on gf.code & d.skill_code 
order by id asc