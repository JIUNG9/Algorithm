-- 코드를 작성해주세요

with filter_data as (

    
    select id, fish_type, 
    case 
    when length is null then 10
    when length is not null then length
    end 
    as length,time 
    from fish_info
    
)

select round(avg(length),2) as average_length
from filter_data
