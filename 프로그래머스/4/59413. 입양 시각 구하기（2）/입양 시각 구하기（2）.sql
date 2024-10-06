-- 코드를 입력하세요
with recursive cte as(
    select 0 as hour
    union all
    
    select hour + 1
    from cte
    where hour < 23
)

select hour, count(animal_id) as count
from cte c left join animal_outs ao on c.hour = hour(ao.datetime)
group by hour
order by 1