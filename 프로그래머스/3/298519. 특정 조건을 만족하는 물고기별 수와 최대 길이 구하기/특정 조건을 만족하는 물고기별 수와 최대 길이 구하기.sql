with filter_under_10 as(
    select 
    case
    when length is null then 10
    else length
    end as filter_length , id, fish_type, time
    from fish_info
    
)

select count(*) as fish_count, max(filter_length) as max_length, fish_type
from filter_under_10
group by fish_type
having avg(filter_length) >= 33
order by 3