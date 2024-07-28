-- 음식 종류 별로 즐겨 찾기 수가 가장 많은 식당을 얻어, 해당 식당의 정보를 출력하고 음식의 종류를 기준으로 내림차순 정렬
-- dense rank function을 통해 음식 종류 별 가장 좋아요 개수가 많은 레스토랑 아이디와 rank를 통해 rank가 1이고 음식 종류가 같은 튜플을 얻고 음식 종류를 기준으로 내림차순한다.

with get_rank as(

    select rest_id, dense_rank() over(partition by food_type order by favorites desc) as rnk
    from rest_info

)

select food_type, rest_id, rest_name, favorites
from rest_info as r
where rest_id in (select rest_id from get_rank where rnk = 1)
order by 1 desc
