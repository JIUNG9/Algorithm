with get_max as (
    select fish_type, max(length) as length
    from fish_info
    group by fish_type

)

select id,fish_name,length
from fish_info as fi inner join fish_name_info as fni on fi.fish_type = fni.fish_type
where (fi.fish_type,fi.length) IN (select fish_type, length from get_max)
order by fi.id



# SELECT fi.ID, fn.FISH_NAME, fi.LENGTH
# FROM FISH_INFO AS fi
# INNER JOIN FISH_NAME_INFO AS fn
# ON fi.FISH_TYPE = fn.FISH_TYPE
# WHERE (fi.FISH_TYPE, fi.LENGTH) IN (
# SELECT FISH_TYPE, MAX(LENGTH)
# FROM FISH_INFO
# GROUP BY FISH_TYPE)