-- 코드를 입력하세요
-- left outer join
select ao.animal_id, ao.name
from animal_ins as ai right join animal_outs as ao on ai.animal_id = ao.animal_id
where ai.animal_id is null
order by 1,2
