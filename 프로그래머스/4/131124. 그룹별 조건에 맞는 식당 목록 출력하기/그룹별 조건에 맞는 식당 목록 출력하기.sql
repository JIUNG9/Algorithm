-- 코드를 입력하세요
with get_review_rank_memeber as (
    select *, dense_rank() over(order by count(review_id) desc) as rnk
    from rest_review
    group by member_id
)

# select *
# from rest_review
# where rnk = 1;

select member_name, review_text, date_format(review_date,"%Y-%m-%d") as review_date
from member_profile as mp inner join rest_review as rr on mp.member_id = rr.member_id
where mp.member_id in (select member_id from get_review_rank_memeber where rnk = 1)
order by review_date,review_text 