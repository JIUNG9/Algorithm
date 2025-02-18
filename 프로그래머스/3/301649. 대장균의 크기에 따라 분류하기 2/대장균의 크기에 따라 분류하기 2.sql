-- 코드를 작성해주세요

with get_rnk as (
    select id, rank() over(order by size_of_colony desc) as rnk
    from ecoli_data
)

# select id, rnk
# from get_rnk

select get_rnk.id, 
case
when rnk <= (count(e.id)/ 4) then 'CRITICAL'
when rnk <= (count(e.id)/ 2) then 'HIGH'
when rnk <= (count(e.id)/ 4 * 3) then 'MEDIUM'
else 'LOW'
end as colony_name
from get_rnk, ecoli_data e
group by get_rnk.id
order by 1 asc

