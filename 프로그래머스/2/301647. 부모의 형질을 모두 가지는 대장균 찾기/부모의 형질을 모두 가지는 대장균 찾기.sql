select child.id, child.genotype as genotype, parent.genotype as parent_genotype
from ecoli_data as child left join ecoli_data as parent on child.parent_id = parent.id
where child.genotype & parent.genotype = parent.genotype
order by 1 asc