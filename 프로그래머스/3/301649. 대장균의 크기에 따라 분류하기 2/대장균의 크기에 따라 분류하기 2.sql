WITH get_rnk AS (
    SELECT 
        id, 
        size_of_colony,
        NTILE(4) OVER (ORDER BY size_of_colony DESC) as quartile
    FROM ecoli_data
)
SELECT 
    id,
    CASE quartile
        WHEN 1 THEN 'CRITICAL'
        WHEN 2 THEN 'HIGH'
        WHEN 3 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS colony_name
FROM get_rnk
ORDER BY id ASC;