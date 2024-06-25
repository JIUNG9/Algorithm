-- 코드를 입력하세요
with get_first_sum as (
    select flavor, sum(total_order) as t_order
    from first_half
    group by flavor
),
get_half_sum as(
    select flavor, sum(total_order) as t_order
    from july
    group by flavor
)

, total as(
    select * from get_first_sum
    union
    select * from get_half_sum
)
select flavor
from total
group by flavor
order by sum(total.t_order) desc limit 3


