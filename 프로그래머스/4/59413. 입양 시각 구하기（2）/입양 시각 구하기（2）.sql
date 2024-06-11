-- 코드를 입력하세요
with recursive cte as(

    select 0 as hour
    
    union all
    
    select hour+1 as hour
    from cte
    where hour < 23

)

# select c.hour , count(*) as count
select c.hour, 
case 
when animal_id is null then count(animal_id)
else count(animal_id)
end as count

from cte as c left join animal_outs as ao on c.hour = hour(ao.datetime)
group by hour
order by 1
