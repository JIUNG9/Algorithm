-- 코드를 입력하세요
with get_not_neuter_when_in as (
    select animal_id
    from animal_ins
    where sex_upon_intake like "Intact%"
)

select ao.animal_id, ao.animal_type, ao.name
from animal_outs as ao inner join get_not_neuter_when_in as ai on ao.animal_id = ai.animal_id
where ao.sex_upon_outcome like "Neutered%" or ao.sex_upon_outcome like "Spayed%"
