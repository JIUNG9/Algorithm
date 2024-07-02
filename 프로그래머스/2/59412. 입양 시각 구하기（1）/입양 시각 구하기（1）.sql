-- 코드를 입력하세요
select hour(datetime) as hour, count(*) as count 
from animal_outs
group by hour
having hour >= 9 AND hour < 20
order by 1 asc