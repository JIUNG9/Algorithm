
with j as (
    select flavor, sum(total_order) as total_order
    from july
    group by flavor
)

select j.flavor
from j inner join first_half f on f.flavor = j.flavor
order by (j.total_order + f.total_order) desc limit 3

