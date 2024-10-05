-- 코드를 작성해주세요
with percent_quarter as(
    select id, ntile(4) over(order by size_of_colony desc) as quarter
    from ecoli_data
)

select p.id,
case
when quarter = 1 then 'CRITICAL'
when quarter = 2 then 'HIGH'
when quarter = 3 then 'MEDIUM'
when quarter = 4 then 'LOW'
end as colony_name
from percent_quarter p inner join ecoli_data e on p.id = e.id
order by 1 asc