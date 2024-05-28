with j_total_sales as (

    select j.SHIPMENT_ID,j.flavor, sum(total_order) as total_order
    from july as j
    group by j.flavor
)




SELECT j.flavor
from j_total_sales as j inner join  first_half as fh on fh.flavor = j.flavor
# order by sum(j.total_order) desc limit 3
order by j.total_order + fh.total_order desc limit 3