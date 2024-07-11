
-- domain: the date time at the animals_in is the date about protection data from when, otherwise 
-- the date time in animals_out is the date about adapt the animal
-- logical : 빠르다 -> 더 이전이다(past)
-- Impl: join by the animal_id and filter the data which ai.datetime < ao.datetime, order by ai.datetime asc

select ai.animal_id, ai.name
from animal_ins as ai inner join animal_outs as ao on ai.animal_id = ao.animal_id
where ai.datetime > ao.datetime
order by ai.datetime asc