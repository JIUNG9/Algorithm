-- 각 세대 별, 대장균 ID를 구하고, 해당 데이터의 id를 기준으로 parent_id를 조인하여, 해당 id가 존재하지 않는(right join, parent_id), 해당 아이디를 구한여, 해당 세대의 개수를 세대 별로 구한다. 

with recursive cte as (
    select id, 1 as gen
    from ecoli_data
    where parent_id is null 
    
    union all
    
    select e.id, gen+1 as gen
    from cte inner join ecoli_data e on e.parent_id = cte.id
    where gen < 10
)

select count(c.id) as count, gen as generation
from cte c left join ecoli_data e on c.id = e.parent_id
where e.id is null
group by 2
order by 2 asc
