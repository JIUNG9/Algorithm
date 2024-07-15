-- 코드를 입력하세요
with total_sum_at_july as (
    select flavor, sum(total_order) as total_order
    from july
    group by flavor
)

select j.flavor
from total_sum_at_july as j inner join first_half as f on j.flavor = f.flavor
group by j.flavor, f.flavor
order by sum(j.total_order + f.total_order) desc limit 3 