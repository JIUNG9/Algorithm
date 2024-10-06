
-- domain cte에는 존재하지만 해당 outs에 존재하지 않는 시각이 있을 수 있다. 조인 시 outs에 존재하지 않는 시간도 보여야하므로 cte를 기준으로 join한다.


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
# order by hour asc



