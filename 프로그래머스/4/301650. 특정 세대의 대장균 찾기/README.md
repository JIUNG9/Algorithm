# [level 4] 특정 세대의 대장균 찾기 - 301650 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/301650) 

### Approach
- Logically the first generation is parent_id is null, and second generation will be the first_genration id equal with the table row of id iterating three of this time will get the third generation of id.

  1. Use the recursive way
  2. Use the non-recursive way
 

``` sql
WITH RECURSIVE ECOLI_TREE AS (
    -- Non-Recursive
    SELECT 
        ID
        , PARENT_ID
        , 1 GENERATION
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL

    UNION ALL

    -- Recursive
    SELECT 
        A.ID
        , A.PARENT_ID
        , B.GENERATION + 1
    FROM 
        ECOLI_DATA A
        INNER JOIN ECOLI_TREE B 
            ON A.PARENT_ID = B.ID
)

SELECT
    ID
FROM
    ECOLI_TREE
WHERE
    GENERATION = 3
ORDER BY 
    ID

```

``` sql
with get_first_gen as (
    select id
    from ecoli_data
    where parent_id is null
),


 get_second_gen as (
    select id
    from ecoli_data
    where parent_id in (select id  from get_first_gen)
),

 get_third_gen as (
    select id
    from ecoli_data
    where parent_id in (select id from get_second_gen)
)

select id
from get_third_gen
group by 1

```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
