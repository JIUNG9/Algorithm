-- 코드를 작성해주세요
with recursive cte as(
    select id, 1 as gen
    from ecoli_data
    where parent_id is null

    union all
    
    select child.id, (gen+1) as gen
    from cte inner join ecoli_data as child on cte.id = child.parent_id
    where gen < 4

)

select id
from cte
where gen = 3
order by id asc