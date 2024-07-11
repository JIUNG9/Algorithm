-- 코드를 입력하세요
select ai.name, ai.datetime
from animal_ins as ai left join animal_outs as ao on ai.animal_id = ao.animal_id
where ao.animal_id is null
order by ai.datetime asc limit 3
-- Impl: 아직 입양을 가지 못한 동물을 구하기 위해 Ins에는 존재하지만 Outs에는 존재하지 않는 row를 조회하기 위해 left outer  join을 통해 입양을 가지 못한 동물을 구하고 ins의 입양 date time을 desc하여 3개의 row를 얻어, 이름과 보호시작을 반환한다.