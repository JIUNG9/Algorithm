-- 코드를 작성해주세요
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