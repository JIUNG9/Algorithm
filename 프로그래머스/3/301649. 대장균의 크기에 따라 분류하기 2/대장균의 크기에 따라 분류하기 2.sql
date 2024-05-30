# -- 코드를 작성해주세요
with get_sum as (
    select count(*) as total
    from ecoli_data
                 )
,sort_asc_by_size as (
    select *
    from ecoli_data
    order by size_of_colony asc 
    
)
                 
# select *
# from sort_asc_by_size

select id,
case
when total /4 * 3 < row_number() over(order by size_of_colony asc) then 'CRITICAL'
when total /4 * 2 < row_number() over(order by size_of_colony asc) then 'HIGH'
when total /4 * 1 < row_number() over(order by size_of_colony asc) then 'MEDIUM'
when total /4 * 0 < row_number() over(order by size_of_colony asc) then 'LOW'
end as colony_name
from ecoli_data, get_sum
order by 1 asc

-- why count(*) doesn't return all of the number of list. -> it is grouped by the id.