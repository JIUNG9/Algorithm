with get_max as(
select fish_type, max(length) as length
from fish_info
group by fish_type
)


select id, fish_name,length
from fish_info fi inner join fish_name_info fni on fi.fish_type = fni.fish_type
where (fi.fish_type, length) in (select fish_type,length from get_max)
order by 1 asc