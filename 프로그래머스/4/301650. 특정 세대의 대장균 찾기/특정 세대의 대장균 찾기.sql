
with recursive cte as(
    select id, 1 as cnt
    from ecoli_data e
    where parent_id is null
    
    UNION ALL
    
    select e.id, cnt+1 as cnt
    from cte  c inner join ecoli_data e on c.id = e.parent_id
    where cnt < 3
)
select id
from cte
where cnt = 3
order by 1 asc


