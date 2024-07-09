-- 코드를 작성해주세요

select e.id, e.genotype,p.genotype as parent_genotype
from ecoli_data as e inner join ecoli_data as p on e.id = p.parent_id
where e.genotype & p.parent_id
order by 1 asc