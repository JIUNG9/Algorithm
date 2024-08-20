-- 코드를 작성해주세요
-- 물고기 타입 별로 평균 길이가 33cm 이상인 물고기만을 분류하여 최대 길이, 물고기 종류, 잡은 수를 구하여라

with change_len as (

    select 
    case
    when length is null then 10
    when length <= 10 then 10
    else length
    end as length, id, fish_type
    from fish_info
    
)

select count(*) as fish_count, max(length) as max_length, fish_type
from change_len
group by fish_type
having avg(length) >= 33
order by fish_type asc


