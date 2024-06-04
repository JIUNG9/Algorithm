-- 코드를 작성해주세요
select count(*) as fish_count, MAX(length) as max_length, fish_type
from fish_info
group by fish_type
having AVG(LENGTH) >= 33
order by fish_type asc