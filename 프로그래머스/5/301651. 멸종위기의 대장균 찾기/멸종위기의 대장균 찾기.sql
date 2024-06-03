WITH RECURSIVE cte AS (
    SELECT 
        e1.id, 
        1 AS gen
    FROM 
        ecoli_data AS e1 
      
    WHERE 
        e1.parent_id IS NULL

    UNION ALL

    SELECT 
        e1.id, 
        (cte.gen + 1) AS gen
    FROM 
        ecoli_data AS e1 
        INNER JOIN cte ON cte.id = e1.parent_id
)
, get_has_child as (
    SELECT 
    e.parent_id
    From cte  inner join ecoli_data as e on e.parent_id = cte.id

)

select count(*) as count, gen as GENERATION
from cte
where id not in (select parent_id as id from get_has_child)
group by gen
order by gen asc
    
