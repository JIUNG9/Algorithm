-- 코드를 입력하세요
select ao.animal_id, ao.animal_type, ao.name
from animal_ins as ai inner join animal_outs as ao on ai.animal_id = ao.animal_id
where ai.sex_upon_intake like "Intact%" and (ao.sex_upon_outcome like "Neutered%" or ao.sex_upon_outcome like "Spayed%")
order by 1 asc