with j_total_sales as (

    select j.flavor, sum(total_order) as total_order
    from july as j
    group by j.flavor
)




SELECT j.flavor
from j_total_sales as j inner join first_half as fh on fh.flavor = j.flavor
group by j.flavor
order by (j.total_order + fh.total_order) desc limit 3
