-- 코드를 입력하세요


select rr.rest_id, rest_name, food_type, favorites , address, round(avg(review_score) ,2)as score
from rest_info as ri inner join rest_review as rr on ri.rest_id = rr.rest_id
where address like "서울%"
group by rr.rest_id
order by score desc, favorites desc
