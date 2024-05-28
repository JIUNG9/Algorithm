-- 코드를 작성해주세요
# with recursive tree as(

#     select id , 0 as gen
#     from ecoli_data
#     where parent_id is null
    
#     union all
    
#     select b.id, gen+1 
#     from ecoli_data as a right join ecoli_data as b on a.id = b.parent_id
#     where gen < 3 AND a.id is null
# )

# select id
# from tree
# order by 1 asc

WITH RECURSIVE WR AS (
    SELECT ID , PARENT_ID , 1 AS GENERATION 
    FROM ECOLI_DATA 
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT A.ID , A.PARENT_ID , W.GENERATION +1
    FROM ECOLI_DATA  A INNER JOIN WR W ON A.PARENT_ID = W.ID
    where generation < 4
)
SELECT ID FROM WR WHERE GENERATION = 3 ORDER BY ID