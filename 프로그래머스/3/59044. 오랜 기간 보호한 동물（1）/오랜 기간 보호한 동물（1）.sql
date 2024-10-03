-- 코드를 입력하세요
-- 입양을 못 간 동물을 이름과 데이트타임을 3개까지 표현 -> in은 했지만 out을 하지 못 한 것, left outer join을 하면 된다.
select ai.name, ai.datetime
from animal_ins as ai left join animal_outs as ao on ai.animal_id = ao.animal_id
where ao.animal_id is null 
order by 2 asc limit 3
