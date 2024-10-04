-- 코드를 작성해주세요

with recursive cte as(
-- parent_id가 null인 0 세대 부터 시작하여, 이전에 존재하던 id와 parent_id가 일치하는 것을 찾아 그것을 다음 세대라고 칭하며 이를 3세대까지 구한다. 
    select id, parent_id, 1 as gen 
    from ecoli_data 
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, gen+1
    from cte as c inner join ecoli_data e on c.id = e.parent_id
    where gen < 3
)
select id
from cte
where gen = 3
order by 1