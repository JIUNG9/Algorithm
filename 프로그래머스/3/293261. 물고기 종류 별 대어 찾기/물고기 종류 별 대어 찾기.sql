with get_type_max_length as (

    select fish_type, max(length) as length
    from fish_info
    group by fish_type 

)
, get_type_max as (
select id, fi.fish_type, fi.length
from get_type_max_length as ml inner join fish_info as fi on ml.fish_type = fi.fish_type and ml.length = fi.length
    )

select id, fish_name, length
from fish_name_info as fni inner join get_type_max as tm on tm.fish_type = fni.fish_type