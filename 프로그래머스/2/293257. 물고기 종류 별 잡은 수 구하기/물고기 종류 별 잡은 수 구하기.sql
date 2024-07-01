-- 코드를 작성해주세요
with get_count_by_type as (
select count(id) as fish_count,fni.fish_type
from fish_name_info as fni inner join fish_info as fi on fi.fish_type = fni.fish_type
group by fni.fish_type

)

select fish_count, fish_name
from get_count_by_type as gcbt inner join fish_name_info as fni on fni.fish_type = gcbt.fish_type
order by 1 desc
