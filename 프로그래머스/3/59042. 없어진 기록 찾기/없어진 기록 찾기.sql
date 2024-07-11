-- 코드를 입력하세요
-- Domain : animal_out에는 있지만 animal_in에는 없는 ao의 animal_id 와 ao의 name
-- Impl : right outer join

select ao.animal_id, ao.name
from animal_ins as ai right join animal_outs as ao on ai.animal_id = ao.animal_id
where ai.animal_id is null
order by 1 asc