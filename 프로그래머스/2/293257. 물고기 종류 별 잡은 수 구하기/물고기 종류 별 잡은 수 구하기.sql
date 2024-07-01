-- 코드를 작성해주세요
select count(id) as fish_count,fni.fish_name
from fish_name_info as fni inner join fish_info as fi on fi.fish_type = fni.fish_type
group by fni.fish_name
order by 1 desc


# select fish_count, fish_name
# from get_count_by_type as gcbt inner join fish_name_info as fni on fni.fish_type = gcbt.fish_type
# order by 1 desc