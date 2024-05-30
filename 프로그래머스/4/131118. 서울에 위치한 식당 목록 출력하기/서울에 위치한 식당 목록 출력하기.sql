-- 코드를 입력하세요
with get_avg_score as(
    select rest_id, round(sum(review_score) / count(rest_id),2)as avg_score
    from rest_review
    group by rest_id
)

select ri.rest_id, rest_name, food_type, favorites,address,avg_score as score
from rest_info as ri inner join get_avg_score as gac  on ri.rest_id = gac.rest_id
where address like "서울%"
order by 6 desc, 4 desc