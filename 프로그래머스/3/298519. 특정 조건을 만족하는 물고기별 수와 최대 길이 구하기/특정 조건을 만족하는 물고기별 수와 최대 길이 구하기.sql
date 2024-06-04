-- 코드를 작성해주세요
with filter_length_under10 as (
    
    select id,fish_type, 
    case 
    when length is null then 10
    else length 
    end as length
    ,time
    from fish_info
)

# select *
# from filter_length_under10


select count(*) as fish_count, MAX(length) as max_length, fish_type
from filter_length_under10
group by fish_type
having AVG(LENGTH) >= 33
order by fish_type asc