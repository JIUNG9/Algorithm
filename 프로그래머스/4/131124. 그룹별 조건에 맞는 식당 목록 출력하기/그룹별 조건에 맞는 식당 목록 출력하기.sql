-- 코드를 입력하세요

# with get_rnk as(
#     select rr.member_id, dense_rank() over(partition by rr.member_id order by count(rr.member_id) desc ) as rnk 
#     from member_profile as mp inner join rest_review as rr on mp.member_id = rr.member_id
# )


# select member_name, review_text, DATE_FORMAT(review_date,"%Y-%m-%d") as review_date
# from rest_review r inner join member_profile m on r.member_id = m.member_id
# where r.member_id in (select member_id from get_rnk where rnk = 1)
# order by 3 asc, 2 asc


with get_most_reviewer as (
    select rr.member_id, dense_rank() over (order by count(*) desc) as rnk
    from member_profile as mp inner join rest_review as rr on mp.member_id = rr.member_id
    group by rr.member_id
)


select member_name, review_text, date_format(review_date,"%Y-%m-%d") as review_date
from member_profile as mp inner join rest_review as rr on mp.member_id = rr.member_id 
where rr.member_id in (select member_id from get_most_reviewer where rnk = 1)
order by 3,2