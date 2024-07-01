
with filter_null as(
    select 
    case
    when length is null then 10
    when length is not null then fish_info.length
    end as length, id, fish_type
    from fish_info
)


select count(id) as fish_count, max(length) as max_length, fish_type
from filter_null
group by fish_type
having avg(length) >= 33
order by 3