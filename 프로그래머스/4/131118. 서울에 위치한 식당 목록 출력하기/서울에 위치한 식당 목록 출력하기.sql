-- 코드를 입력하세요
select ri.rest_id, rest_name, food_type, favorites as favorites, address, round(avg(review_score),2) as score
from rest_info ri inner join rest_review rr on ri.rest_id = rr.rest_id
where address like '서울%'
group by rest_id
order by 6 desc, 4 desc