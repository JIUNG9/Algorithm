-- 코드를 입력하세요
with get_rank as (
    select member_id, dense_rank() over(order by count(review_id) desc) as rnk
    from rest_review as rr
    group by member_id
)




select member_name, review_text, date_format(review_date,"%Y-%m-%d") as review_date
from member_profile as mp inner join rest_review as rr on mp.member_id = rr.member_id
where rr.member_id in(select member_id from get_rank where rnk = 1)
order by 3,2


