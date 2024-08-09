with recursive cte as(
    select 0 as hour
    
    union all
    
    select hour+1 
    from cte
    where hour < 23
)

select cte.hour, count(animal_id) as count
from animal_outs right join cte on cte.hour = hour(animal_outs.datetime)
group by 1
order by 1 asc